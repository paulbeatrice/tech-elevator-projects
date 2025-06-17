package com.techelevator.controller;

import com.techelevator.model.dto.LoginDto;
import com.techelevator.model.dto.LoginResponseDto;
import com.techelevator.model.dto.RegisterUserDto;
import com.techelevator.model.User;
import jakarta.validation.Valid;

import java.util.List;

import com.techelevator.exception.DaoException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.techelevator.dao.UserDao;
import com.techelevator.security.jwt.TokenProvider;
import org.springframework.web.server.ResponseStatusException;

/**
 * AuthenticationController is a class used for handling requests to authenticate Users.
 *
 * It depends on an instance of a UserDao for retrieving and storing user data. This is provided
 * through dependency injection.
 */
@RestController
@CrossOrigin
public class AuthenticationController {

    private final TokenProvider tokenProvider;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private UserDao userDao;

    public AuthenticationController(TokenProvider tokenProvider, AuthenticationManagerBuilder authenticationManagerBuilder, UserDao userDao) {
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public LoginResponseDto login(@Valid @RequestBody LoginDto loginDto) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());

            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

            if(authentication.isAuthenticated()){
                String jwt = tokenProvider.createToken(authentication, false);
                User user = userDao.getUserByUsername(loginDto.getUsername());
                return new LoginResponseDto(jwt, user);
            }

            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO error - " + e.getMessage());
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public User register(@Valid @RequestBody RegisterUserDto newUser) {

        if(!newUser.isPasswordsMatch()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "password and confirm password do not match");
        }

        try {
            if (userDao.getUserByUsername(newUser.getUsername()) != null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists.");
            }

            // Clear any role passed in from the client
            newUser.setRoleRaw(null);

            // Admin Whitelist
            List<String> adminUsernames = List.of("paulascend", "testadmin");

            // Assign role based on whitelist
            String assignedRole = adminUsernames.contains(newUser.getUsername().toLowerCase())
                    ? "ROLE_ADMIN"
                    : "ROLE_USER";

            // Create user with assigned role
            User user    = userDao.createUser(
                    new User(newUser.getUsername(), newUser.getPassword(), assignedRole, newUser.getName())
            );
            return user;
        }
        catch (DaoException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "DAO error - " + e.getMessage());
        }
    }

}
