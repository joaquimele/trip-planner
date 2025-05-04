package com.joacomele.tripplanner.service.user;

import com.joacomele.tripplanner.domain.Roles;
import com.joacomele.tripplanner.domain.User;
import com.joacomele.tripplanner.domain.dto.RegisterRequest;
import com.joacomele.tripplanner.exception.ValidationException;
import com.joacomele.tripplanner.repository.UserRepository;
import com.joacomele.tripplanner.service.auth.AuthenticationService;
import com.joacomele.tripplanner.validator.RequestValidator;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);

    private final RequestValidator requestValidator;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Autowired
    public UserService(RequestValidator requestValidator, UserRepository userRepository) {
        this.requestValidator = requestValidator;
        this.userRepository = userRepository;
    }

    public Optional<User> createUserFromRequest(RegisterRequest registerRequest) {

        try {
            logger.info("Proceeding to create user from request {}", registerRequest);
            requestValidator.validateRequest(registerRequest);

            User user = User.builder()
                    .username(registerRequest.getUsername())
                    .emailAddress(registerRequest.getEmailAddress())
                    .password(registerRequest.getPassword())
                    .role(Roles.valueOf(registerRequest.getRole()))
                    .build();

            logger.info("Created user {}", user);

            return Optional.of(userRepository.save(user));

        } catch (ValidationException e) {
            logger.error("Error validating register request: {}", e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Unexpected error creating user: {}", e.getMessage(), e);
        }

        return Optional.empty();
    }
}
