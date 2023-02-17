package com.catwalk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Employee {

	@Id
	private String id;
	private String name;
	private Integer age;
	private Address address;
	private Phone phone;
	private String email;
	private Integer salary;
	private String position;
	private List<String> skills;
	private List<Experience> experience;
	private Employee employee;
}