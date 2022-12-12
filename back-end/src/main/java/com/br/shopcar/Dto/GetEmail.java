package com.br.shopcar.Dto;

import lombok.Data;

import javax.validation.constraints.Email;

@Data
public class GetEmail {

    @Email
    private String email;
}
