package com.example.demo.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationRequest {

	private String username;
	private String password;
	private String name;
	private String lastname;
	private String dateOfBirth;
	private String cin;
	private String tel;
	private String address;
	private String photo;

}
