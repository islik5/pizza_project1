package com.example.pizza_project1;

public class PizzaModel {

    String firstName, lastName, job, key, imageId;
    String age;



    public PizzaModel(){}

    public PizzaModel(String firstName, String lastName, String job, String age, String key, String imageId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.job = job;
        this.age = age;
        this.key = key;
        this.imageId = imageId;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) { this.age = age; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getJob() {
        return job;
    }

    public void setJob(String job) { this.job = job; }

    public String getKey() {
        return key;
    }

    public void setKey(String key) { this.key = key; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getImageId() { return imageId; }

    public void setImageId(String imageId) {this.imageId = imageId;}


}
