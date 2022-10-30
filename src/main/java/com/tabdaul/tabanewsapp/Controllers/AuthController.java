package com.tabdaul.tabanewsapp.Controllers;

import com.tabdaul.tabanewsapp.security.JwtResponse;
import com.tabdaul.tabanewsapp.security.LoginRequest;
import com.tabdaul.tabanewsapp.security.TokenUtil;
import com.tabdaul.tabanewsapp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MOSAED ALOTAIBI (MASAAD)
 * @created 10/25/2022 at 23:45
 */

@RestController
public class AuthController {

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody LoginRequest loginRequest) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = userServiceImpl.loadUserByUsername(loginRequest.getUsername());

        String token = tokenUtil.generateToken(userDetails);

        JwtResponse response = new JwtResponse(token);
        return response;
    }
}
