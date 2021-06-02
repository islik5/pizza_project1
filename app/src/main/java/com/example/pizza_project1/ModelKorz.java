package com.example.pizza_project1;

public class ModelKorz {

    static String firstName;
    String frName;
    String lastName;
    String job;
    String key;
    String imageId;
    String age;
    String count;



    public ModelKorz(){}

    public ModelKorz(String firstName, String frName, String lastName, String job, String age, String key, String imageId, String count) {
        this.firstName = firstName;
        this.frName = frName;
        this.lastName = lastName;
        this.job = job;
        this.age = age;
        this.key = key;
        this.imageId = imageId;
        this.count = count;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) { this.age = age; }

    public static String getFirstName() {return firstName;}

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getJob() {return job;}

    public void setJob(String job) { this.job = job;}

    public String getKey() {return key;}

    public void setKey(String key) { this.key = key; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getImageId() { return imageId; }

    public void setImageId(String imageId) {this.imageId = imageId;}

    public void setFrName(String frName) {
        this.frName = frName;
    }

    public String getFrName() {
        return frName;
    }


}