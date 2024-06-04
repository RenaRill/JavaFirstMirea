package com.example.Java2_14.configuration;


import com.example.Java2_14.models.User;
import com.example.Java2_14.repositories.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class MyUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private final UserRepository userRepository;
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserDetails(user);
    }
}
