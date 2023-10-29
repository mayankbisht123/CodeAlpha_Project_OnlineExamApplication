package com.example.codealpha_project_onlineexamapplication.model;

public class Details {
    private int id;



    private String name;
    private String email;
    private String password;
    private String Cpassword;

    public Details(int id, String name, String email,String password,String Cpassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password=password;
        this.Cpassword=Cpassword;
    }

    public Details(String name, String email,String password,String Cpassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password=password;
        this.Cpassword=Cpassword;
    }
    public Details(){

    }
    public void setId(int id)
    {
        this.id=id;
    }
    public int getId()
    {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return Cpassword;
    }

    public void setCpassword(String cpassword) {
        Cpassword = cpassword;
    }
}
