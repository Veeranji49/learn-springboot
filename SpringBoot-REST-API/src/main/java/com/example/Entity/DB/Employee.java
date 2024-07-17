package com.example.Entity.DB;

import org.jsondoc.core.annotation.ApiObject;
import org.jsondoc.core.annotation.ApiObjectField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//@Getter // avoiding getter methods
//@Setter // avoiding setter methods
//@AllArgsConstructor //avoiding public parameterized constructor
//@NoArgsConstructor  //avoiding public default constructor
//@ToString  //avoiding toString method
//@Data  //avoiding setter and getter methods

@Entity
@Table(name="employees")
@ApiObject
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiObjectField(name="Employee id", description = "Auto generated Id")
    private long id;

    @Column(name="e_name")
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @ApiObjectField(name="Employee name", description = "To get Employee name")
    private String name;

    @Column(name="e_salary")
    @ApiObjectField(name="Employee Salary", description = "To get Employee Salary")
    private double salary;

    @Column(name="e_age")
    @ApiObjectField(name="Employee age", description = "To get Employee age")
    private int age;

    @Column(name="e_email")
    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    @ApiObjectField(name="Employee email", description = "To get Employee email")
    private String email;

    @Column(name="e_health")
    @ApiObjectField(name="Employee health", description = "To checking employee health")
    private boolean is_healthy;

    @Column(name="e_location")
    @ApiObjectField(name="Employee address", description = "To get Employee address")
    private String location;


    //Public Default Constructor ( PDC )
    public Employee()
    {

    }

    //Public Parameterized Constructor (PPC)
    public Employee(long id, String name, double salary, int age, String email, boolean is_healthy, String location) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.email = email;
        this.is_healthy = is_healthy;
        this.location = location;
    }

    //Public Setter Methods & Public Getter Methods

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIs_healthy() {
        return is_healthy;
    }

    public void setIs_healthy(boolean is_healthy) {
        this.is_healthy = is_healthy;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    //toString method
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", is_healthy=" + is_healthy +
                ", location='" + location + '\'' +
                '}';
    }
}
