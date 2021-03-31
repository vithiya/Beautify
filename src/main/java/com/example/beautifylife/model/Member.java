package com.example.beautifylife.model;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
@Table( name = "member")
public class Member {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;

    @Column( name = "last_name")
    private String lastName;

    @Column( name = "first_name")
    private String firstName;

    @Column( name = "job")
    private String job;

    @Column( name = "age")
    private int age;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
