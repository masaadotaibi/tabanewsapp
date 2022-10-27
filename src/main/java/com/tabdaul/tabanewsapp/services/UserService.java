package com.tabdaul.tabanewsapp.services;

import com.tabdaul.tabanewsapp.Entities.User;
import com.tabdaul.tabanewsapp.error.NotFoundException;
import com.tabdaul.tabanewsapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Bean
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new User("Mosaed",  passwordEncoder().encode("password"), AuthorityUtils.NO_AUTHORITIES);
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new NotFoundException("User not found");
        }

        return user;
    }

    public void save(User user) {
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        this.userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
