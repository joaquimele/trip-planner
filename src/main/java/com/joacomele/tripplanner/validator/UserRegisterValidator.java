package com.joacomele.tripplanner.validator;

import com.joacomele.tripplanner.domain.dto.AuthRequest;
import com.joacomele.tripplanner.domain.dto.RegisterRequest;
import com.joacomele.tripplanner.exception.ValidationException;
import com.joacomele.tripplanner.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRegisterValidator {

    private final UserRepository userRepository;

    @Autowired
    public UserRegisterValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateRegister(RegisterRequest registerRequest) throws ValidationException {

       if (userRepository.existsByUsername(registerRequest.getUsername())) {
           throw new ValidationException("Username already exists!");
       }

       if (userRepository.existsByEmailAddress(registerRequest.getEmailAddress())) {
           throw new ValidationException("Email address already exists!");
       }
    }

    public void validateUsernameAuth(AuthRequest authRequest) throws ValidationException {
        if (!userRepository.existsByUsername(authRequest.getUsername())) {
            throw new ValidationException("Username does not exist!");
        }
    }
}
