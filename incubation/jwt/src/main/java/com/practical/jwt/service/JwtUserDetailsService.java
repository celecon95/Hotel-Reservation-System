package com.practical.jwt.service;

import com.practical.jwt.dao.UserDao;
import com.practical.jwt.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class JwtUserDetailsService {

    @Autowired
    private UserDao userDao;

    public UserDetails loadUser(String username) throws UsernameNotFoundException {
        com.practical.jwt.entity.User user = userDao.fetchUser(username);
        if (Objects.nonNull(user)) {
            return new User(username, user.getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public UserResponse save(com.practical.jwt.dto.User user) throws Exception {
        com.practical.jwt.entity.User newUser = new com.practical.jwt.entity.User();
        newUser.setUserName(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser = userDao.saveUser(newUser);
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(newUser.getUserName());
        userResponse.setPassword(newUser.getPassword());
        return userResponse;
    }

}
