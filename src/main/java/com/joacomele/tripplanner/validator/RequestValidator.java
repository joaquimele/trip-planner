package com.joacomele.tripplanner.validator;

import com.joacomele.tripplanner.domain.dto.RegisterRequest;
import com.joacomele.tripplanner.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class RequestValidator {

    public void validateRequest(RegisterRequest registerRequest) throws ValidationException {

        if (registerRequest.getUsername() == null) {
            throw new ValidationException("Username cannot be null.");
        }

        if (registerRequest.getEmailAddress() == null) {
            throw new ValidationException("Email address cannot be null.");
        }

        if (registerRequest.getPassword() == null) {
            throw new ValidationException("Password cannot be null.");
        }
    }
}
