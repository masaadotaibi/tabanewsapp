package com.tabdaul.tabanewsapp.services;

import com.tabdaul.tabanewsapp.Entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @author MOSAED ALOTAIBI (MASAAD)
 * @created 10/30/2022 at 02:58
 */
public interface UserService extends UserDetailsService {

    void save(User user);
    List<User> findAll();
}
