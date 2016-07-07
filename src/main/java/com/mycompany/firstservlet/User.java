package com.mycompany.firstservlet;

import java.util.Date;

public class User {

    private int userid;
    private String firstname;
    private String lastName;
    
    private String email;
    public int getUserid() {
        return userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String firstName) {
        this.firstname = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return "User [userid=" + userid + ", name=" + firstname
                + ", lastName=" + lastName + ", email="
                + email + "]";
    }    
}