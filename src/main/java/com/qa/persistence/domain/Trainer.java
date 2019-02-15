package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TRAINERS")
public class Trainer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne @JoinColumn(name="room_id",nullable = false)
	private Classroom room;
	
	private String firstName;
	private String lastName;

	public Trainer() {
		super();
	}

	public Trainer(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return room;
	}

	public void setRoom(Classroom room) {
		this.room = room;
	}
	

}
