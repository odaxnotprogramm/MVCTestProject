package org.sab1maru.web.mvctestproject.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegistrationDto {
    private Long id;
    private String username;
    private String email;
    private String password;
}
