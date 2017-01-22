package com.hackgteeny.tastebuds.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Xuran on 1/21/2017.
 */

public class User implements Serializable{
    private String username;
    private String email;
    private String password;
    private List<User> friends;
    private List<Group> groups;
    private String faveFood;

    public String getFaveFood() {
        return faveFood;
    }

    public String getUsername() {
        return username;
    }

    public User(String aName, String aEmail, String aPassword) {
        username = aName;
        email = aEmail;
        password = aPassword;
        this.faveFood = "";
        this.groups = new ArrayList<>();
        this.friends = new ArrayList<>();
    }



    public String getEmail() {
        return email;
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public String getPassword() {
        return password;
    }




    public void addToGroup() {
        //idk
    }
}
