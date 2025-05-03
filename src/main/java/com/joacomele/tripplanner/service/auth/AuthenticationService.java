package com.joacomele.tripplanner.service.auth;

import com.joacomele.tripplanner.domain.dto.AuthRequest;
import com.joacomele.tripplanner.domain.dto.AuthResponse;
import com.joacomele.tripplanner.domain.dto.RegisterRequest;
import com.joacomele.tripplanner.exception.ValidationException;
import com.joacomele.tripplanner.validator.RegisterValidator;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    private RegisterValidator regValidator;

    public AuthResponse register(RegisterRequest registerRequest) {
        try {
            logger.info("Processing register request: {}", registerRequest);
            regValidator.validateRegister(registerRequest);
        } catch (ValidationException e) {
            logger.error("Error validating register request: {}", e.getMessage(), e);
        }
    }

    public AuthResponse authenticate(AuthRequest authRequest) {}
}
