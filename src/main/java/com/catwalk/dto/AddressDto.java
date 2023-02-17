package com.catwalk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

	private String street;
	private String city;
	private String state;
	private String zip;
}