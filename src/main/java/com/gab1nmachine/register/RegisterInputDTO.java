package com.gab1nmachine.register;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class RegisterInputDTO {
        private UUID id;
        private String name;
        private String surname;
        private String email;
        private String password;
        private String confirmPassword;
}
