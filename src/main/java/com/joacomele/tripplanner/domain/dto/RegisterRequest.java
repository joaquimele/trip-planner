package com.joacomele.tripplanner.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest extends Request{

    private String emailAddress;
    private String role;
}
