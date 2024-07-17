package com.example.Entity.DB.OneToOne;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id", referencedColumnName = "id")
    private StudentAddress address;

    public Student(){

    }

    public Student(StudentAddress address, int age, long id, String name) {
        this.address = address;
        this.age = age;
        this.id = id;
        this.name = name;
    }

    public StudentAddress getAddress() {
        return address;
    }

    public void setAddress(StudentAddress address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
}
