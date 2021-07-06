package com.practical.jwt.controller;

import com.practical.jwt.dto.TokenResponse;
import com.practical.jwt.dto.User;
import com.practical.jwt.dto.UserResponse;
import com.practical.jwt.service.JwtUserDetailsService;
import com.practical.jwt.utils.JwtUtils;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/token")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @ApiOperation(
            value = "Authenticates and returns token",
            response = TokenResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = TokenResponse.class)
    })
    @PostMapping(
            value = "/token",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<TokenResponse> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {

        final UserDetails userDetails = userDetailsService.loadUser(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new TokenResponse(token, "Bearer"));
    }

    @ApiOperation(
            value = "Authenticates and returns token",
            response = UserResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = UserResponse.class)
    })
    @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserResponse> saveUser(@RequestBody User user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

}
