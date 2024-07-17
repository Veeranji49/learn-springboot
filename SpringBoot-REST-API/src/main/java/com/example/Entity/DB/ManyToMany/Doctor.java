package com.example.Entity.DB.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String category;
    private int age;
    private String hospital_name;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="patient_doctor", joinColumns ={
            @JoinColumn(name="doctor_id",referencedColumnName = "id",
                    nullable = false, updatable = false)}, inverseJoinColumns ={
            @JoinColumn(name="patient_id",referencedColumnName = "id",
                    nullable = false, updatable = false)})
    private Set<Patient> patients = new HashSet<>();

    public Doctor() {

    }

    public Doctor(long id, String name, String category, int age, String hospital_name, Set<Patient> patients) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.age = age;
        this.hospital_name = hospital_name;
        this.patients = patients;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", hospital_name='" + hospital_name + '\'' +
                ", patients=" + patients +
                '}';
    }
}

