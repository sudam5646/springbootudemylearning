package com.kafka.springboot_kafka_tutorial.payload;

public class User {
    private int id;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String toString(){
        return "Person { " + "Id = " + getId() + ", firstname = " + getFirstName() + ", lastname = " + getLastName() + "}";
    }
}
