package com.beatles;

import javax.persistence.*;


@Entity
@Table(name= "users")

public class TUsers {
    private String uname,password;

    @Id
    private String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Column(name="username")
    public void setUname(String users){
        this.uname = users;
    }

    public String getUname(){
        return uname;
    }

    @Column(name = "password")
    public void setPassword(String pass){
        this.password=pass;
    }

    public String getPassword() {
        return password;
    }
}
