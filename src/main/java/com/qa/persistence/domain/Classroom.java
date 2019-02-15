package com.qa.persistence.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSROOMS")
public class Classroom {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long classroomID;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "trainerID", referencedColumnName = "trainerID")
	private Trainer trainer;
	
	@OneToMany(mappedBy = "classroomID")
	private Set<Trainee> trainees;

	public Classroom() {
		super();
	}

	public Classroom(Long id, Trainer trainer) {
		super();
		this.classroomID = id;
		this.trainer = trainer;
	}

	public Long getId() {
		return classroomID;
	}

	public void setId(Long id) {
		this.classroomID = id;
	}

	public Trainer getTrainerID() {
		return trainer;
	}

	public void setTrainerID(Trainer trainerID) {
		this.trainer = trainerID;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}

}
