
package com.halima.userservice.service.implementations;

import com.halima.userservice.dto.UserDTO;
import com.halima.userservice.model.User;
import com.halima.userservice.repository.UserRepository;
import com.halima.userservice.service.interfaces.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService implements IUserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private static final String USER_NOT_FOUND = "User not found with this id : ";

    @Override
    public UserDTO save(UserDTO userDTO) {
        userDTO.setCreatedAt(LocalDateTime.now());
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userRepository.save(modelMapper.map(userDTO, User.class));
        return modelMapper.map(user, UserDTO.class);
    }


    @Override
    public String generateToken(Long id, String username, String email) {
        return jwtService.generateToken(id,username, email);

    }

    @Override
    public void validateToken(String token)
    {
        jwtService.validateToken(token);
    }

    public boolean delete(Long userId) {
        Optional<User> deletedUser = userRepository.findById(userId);
        if (deletedUser.isPresent()) {
            userRepository.deleteById(userId);
            return true;
        } else {
            throw new RuntimeException(USER_NOT_FOUND + userId);
        }
    }

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDTO.class)).toList();
    }
}
