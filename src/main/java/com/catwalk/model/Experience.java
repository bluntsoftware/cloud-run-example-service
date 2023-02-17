package com.catwalk.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Experience {

	private String company;
	private String title;
	private String start_date;
	private String end_date;
}