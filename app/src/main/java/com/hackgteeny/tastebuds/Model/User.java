package com.hackgteeny.tastebuds.Model;

/**
 * Created by Xuran on 1/21/2017.
 */

public class User {
    private String name;
    private String email;
    private String password;
    private User[] friends;
    private Group[] groups;

    public User(String aName, String aEmail, String aPassword) {
        name = aName;
        email = aEmail;
        password = aPassword;
    }
}
