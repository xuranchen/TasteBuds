package com.hackgteeny.tastebuds.Model;

import java.io.Serializable;

/**
 * Created by Xuran on 1/21/2017.
 */

public class User implements Serializable {
    private String name;
    private String email;
    private String password;
    private String faveFood;
    private User[] friends;
    private Group[] groups;

    public String getName() {
        return name;
    }

    public String getFaveFood() {
        return faveFood;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User[] getFriends() {
        return friends;
    }

    public Group[] getGroups() {
        return groups;
    }

    public User(String aName, String aEmail, String aPassword, String aFaveFood) {
        name = aName;
        email = aEmail;
        faveFood = aFaveFood;
        password = aPassword;
    }
}
