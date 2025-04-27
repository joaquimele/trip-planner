package com.joacomele.tripplanner.service.auth;

import com.joacomele.tripplanner.domain.dto.AuthRequest;
import com.joacomele.tripplanner.domain.dto.RegisterRequest;
import com.joacomele.tripplanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;

    private void register(RegisterRequest registerRequest) {

    }

    private void authenticate(AuthRequest authRequest) {}
}
