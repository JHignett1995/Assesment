package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="TRAINEES")
public class Trainee {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long traineeID;
	
	@ManyToOne @JoinColumn(name="classroomID", nullable = false)
	private Classroom classroom;
	
	private String firstName;
	private String lastName;

	public Trainee() {
		super();
	}

	public Trainee(Long id, String firstName, String lastName) {
		super();
		this.traineeID = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return traineeID;
	}

	public void setId(Long id) {
		this.traineeID = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
