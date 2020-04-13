package com.errorcenter.api.services.impl;

import com.errorcenter.api.dto.UserRegisterDTO;
import com.errorcenter.api.models.User;
import com.errorcenter.api.repositories.UserRepository;
import com.errorcenter.api.services.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserRegisterDTO save(UserRegisterDTO dto) {
        User user = userRepository.save(new User(dto.getUserName(), dto.getEmail(), dto.getPassword()));
        return new UserRegisterDTO(user.getName(), user.getPassword(), user.getEmail());
    }
}
