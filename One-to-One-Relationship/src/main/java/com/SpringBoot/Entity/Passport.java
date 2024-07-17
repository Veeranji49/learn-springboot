package com.SpringBoot.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="passport")
public class Passport {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int pp_number;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy="passport")
	private Person persons;
	
	public Passport() {}

	public Passport(int pp_number) {
		super();
		this.pp_number = pp_number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPp_number() {
		return pp_number;
	}

	public void setPp_number(int pp_number) {
		this.pp_number = pp_number;
	}

	public Person getPersons() {
		return persons;
	}

	public void setPersons(Person persons) {
		this.persons = persons;
	}
	
	
}
