package com.app.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO 
{
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
	private double fees;
	private int minscore;
}
