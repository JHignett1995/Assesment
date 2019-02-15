package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TRAINERS")
public class Trainer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainerID;
	
	
	@OneToOne(mappedBy = "classroom")
	private Classroom classroom;
	
	private String firstName;
	private String lastName;

	public Trainer() {
		super();
	}

	public Trainer(Long id, String firstName, String lastName) {
		super();
		this.trainerID = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return trainerID;
	}

	public void setId(Long id) {
		this.trainerID = id;
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

	public Classroom getRoom() {
		return classroom;
	}

	public void setRoom(Classroom room) {
		this.classroom = room;
	}
	

}
