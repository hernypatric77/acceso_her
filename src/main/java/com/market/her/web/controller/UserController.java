package com.market.her.web.controller;


import com.market.her.domain.dto.User;
import com.market.her.domain.dto.AuthenticationResponse;
import com.market.her.domain.dto.LoginRequest;
import com.market.her.domain.service.HerUserDetailsService;
import com.market.her.domain.service.UserService;
import com.market.her.web.security.JWTUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private HerUserDetailsService herUserDetailsService;

//    @GetMapping("/authenticate")
//    @ApiOperation("Obtenre todos los usuarios")
//    @ApiResponse(code = 200, message = "OK")
//    public ResponseEntity<List<User>> getAll() {
//        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
//    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse>  createLogin(@RequestBody LoginRequest request) {
      try{
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken("hernan", "iniciotok"));
        UserDetails userDetails = herUserDetailsService.loadUserByUsername(request.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
            Optional<User> resp = userService.userLogin(request.getUsername(),request.getPassword());
        return new ResponseEntity<>(new AuthenticationResponse(jwt, resp.get()), HttpStatus.OK);
    } catch (
              BadCredentialsException | NoSuchElementException e) {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    }

}
