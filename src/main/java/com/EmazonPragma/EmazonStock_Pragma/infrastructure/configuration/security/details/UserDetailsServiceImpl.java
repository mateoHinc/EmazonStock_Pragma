package com.EmazonPragma.EmazonStock_Pragma.infrastructure.configuration.security.details;

import com.EmazonPragma.EmazonStock_Pragma.infrastructure.configuration.security.exceptions.NotAuthorizedException;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.feigns.AuthorizationFeign;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.feigns.DTO.request.AuthorizationRequest;
import com.EmazonPragma.EmazonStock_Pragma.infrastructure.output.feigns.DTO.response.AuthorizationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AuthorizationFeign authorizationFeign;

    @Override
    public UserDetails loadUserByUsername(String token) throws UsernameNotFoundException {
        AuthorizationRequest authorizationRequest = AuthorizationRequest.builder().token(token).build();
        AuthorizationResponse authorizationResponse = authorizationFeign.authorize(authorizationRequest);

        if(!authorizationResponse.isAuthorized()) {
            throw new NotAuthorizedException(authorizationResponse.getEmail());
        }

        Collection<?extends  GrantedAuthority> authorities = Set.of(new SimpleGrantedAuthority(authorizationResponse.getRole()));

        return new User(authorizationResponse.getEmail(), token, authorities);
    }
}
