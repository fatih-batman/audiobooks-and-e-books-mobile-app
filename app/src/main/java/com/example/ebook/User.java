package com.example.ebook;

public class User {
    String fname,lname,email,contactno;

    public User() {
    }

    public User(String fname, String lname, String email, String contactno) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.contactno = contactno;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactno() {
        return contactno;
    }

    public void setContactno(String contactno) {
        this.contactno = contactno;
    }
}
