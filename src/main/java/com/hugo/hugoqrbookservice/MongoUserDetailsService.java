package com.hugo.hugoqrbookservice;

import com.hugo.hugoqrbookservice.model.Users;
import com.hugo.hugoqrbookservice.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MongoUserDetailsService implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username);
        if (users == null) {
            throw new UsernameNotFoundException(
                    String.format("Username %s not found", username)
            );
        }
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("editor"));
        return new User(users.getUsername(), users.getPassword(), authorities);
    }

}
