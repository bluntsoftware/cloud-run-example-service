package com.catwalk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {

	private String id;
	private String name;
	private Integer age;
	private AddressDto address;
	private PhoneDto phone;
	private String email;
	private Integer salary;
	private String position;
	private List<String> skills;
	private List<ExperienceDto> experience;
	private EmployeeDto employee;
}