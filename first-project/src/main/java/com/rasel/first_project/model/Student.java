package com.rasel.first_project.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "student_sb")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String clazz;
	private int age;
	private String address;
	private LocalDate dob;

	public Student() {

	}

	public Student(int id, String name, String clazz, int age, String address, LocalDate dob) {
		this.id = id;
		this.name = name;
		this.clazz = clazz;
		this.age = age;
		this.address = address;
		this.dob = dob;
	}

}
