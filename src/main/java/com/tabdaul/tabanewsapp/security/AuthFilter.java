package com.tabdaul.tabanewsapp.security;

import com.tabdaul.tabanewsapp.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MOSAED ALOTAIBI (MASAAD)
 * @created 10/26/2022 at 00:12
 */
public class AuthFilter extends OncePerRequestFilter {

    @Value("${auth.header}")
    private String TOKEN_HEADER;

    @Autowired
    private TokenUtil tokenUtil;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

    // we need the following
        // fetch token from the header
        // make sure the token is valid

        // fetch token ...
        final String header = request.getHeader(TOKEN_HEADER);
        final SecurityContext securityContext = SecurityContextHolder.getContext();

        if(header != null && securityContext.getAuthentication() == null) {
            String token = header.substring("Bearer ".length());

            // token fetched

            // now begin checking the validity of the token
            String username = tokenUtil.getUsernameFromToken(token);

            if(username != null) {
                UserDetails userDetails = userServiceImpl.loadUserByUsername(username);

                if(tokenUtil.isTokenValid(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
