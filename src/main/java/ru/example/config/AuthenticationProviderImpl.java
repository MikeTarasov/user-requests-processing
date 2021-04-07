package ru.example.config;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import ru.example.services.UsersService;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final UsersService usersService;

    public AuthenticationProviderImpl(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (usersService == null) {
            throw new InternalAuthenticationServiceException("UserService is null");
        }

        UserDetails user = usersService.loadUserByUsername(login);

        if (user == null) {
            throw new AuthenticationCredentialsNotFoundException("Not found");
        }

        if (usersService.isPasswordCorrect(usersService.findUserByEmail(login), password)) {
            return new UsernamePasswordAuthenticationToken(
                    user,
                    usersService.encodePassword(password),
                    user.getAuthorities());
        } else {
            throw new AuthenticationServiceException("Unable to auth against third party systems");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
