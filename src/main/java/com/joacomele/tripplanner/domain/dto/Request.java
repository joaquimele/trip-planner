package com.joacomele.tripplanner.domain.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Request {

    private String username;
    private String password;
}
