package com.qa.persistence.domain;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSROOMS")
public class Classroom {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long room_id;
	
	@OneToOne(mappedBy = "room")
	private Long trainerID;
	
	@OneToMany(mappedBy = "room")
	private Set<Trainee> trainees;

	public Classroom() {
		super();
	}

	public Classroom(Long id, Long trainerID) {
		super();
		this.room_id = id;
		this.trainerID = trainerID;
	}

	public Long getId() {
		return room_id;
	}

	public void setId(Long id) {
		this.room_id = id;
	}

	public Long getTrainerID() {
		return trainerID;
	}

	public void setTrainerID(Long trainerID) {
		this.trainerID = trainerID;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}

}
