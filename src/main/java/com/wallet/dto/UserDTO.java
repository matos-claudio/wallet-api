package com.wallet.dto;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

import com.sun.istack.NotNull;

import lombok.Data;

@Data
public class UserDTO {
	private Long id;
	@Email(message = "Email inváido")
	private String email;
	@Length(min=3, max=50, message="O nome deve conter entre 3 e 50 caracteres")
	private String name;
	@NotNull
	@Length(min=6, message="A senha deve conter ao menos 6 caracteres")
	private String password;
}
