package com.example.harsh.mp3;

/**
 * Created by bhaVYa on 11/03/17.
 */

public class News {
    public String userName;
    public String firstName;
    public String lastName;

    public News() {
    }

    public News(String content) {
        System.out.println("In User=" + userName);
        System.out.println("In User=" + firstName);
        System.out.println("In User=" + lastName);
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;

    }


}
