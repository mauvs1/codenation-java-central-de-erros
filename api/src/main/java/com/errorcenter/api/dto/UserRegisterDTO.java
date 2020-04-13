package com.errorcenter.api.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {

    @NotNull(message = "Não pode ser nulo")
    @NotEmpty(message = "Deve conter um valor")
    @Size(max = 100)
    private String userName;

    @NotNull(message = "Não pode ser nulo")
    @NotEmpty(message = "Deve conter um valor")
    @Size(min = 3, max = 255)
    private String password;

    @Email
    @Size(max = 100)
    @NotNull(message = "Não pode ser nulo")
    @NotEmpty(message = "Deve conter um valor")
    private String email;
}
