package ru.example.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.example.model.entities.Users;
import ru.example.model.repositories.UsersRepository;

@Service
public class UsersService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
        bCryptPasswordEncoder = passwordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(email);
        if (user == null) return null;

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getGrantedAuthorities()
        );
    }

    public Users findUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

    public boolean isPasswordCorrect(Users user, String password) {
        return bCryptPasswordEncoder.matches(password, user.getPassword());
    }


    public String encodePassword(String password) {
        return bCryptPasswordEncoder.encode(password);
    }


    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}