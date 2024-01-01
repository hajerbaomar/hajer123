package com.example.a19f19285hajerclass;

public class Helperclass {

    String username,enteremail,password,conformpassword;

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username= username;
    }
    public String getEnteremail(){
        return enteremail;
    }
    public void setEnteremail(String enteremail){
        this.enteremail=enteremail;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getConformpassword(){
        return conformpassword;
    }
    public void setConformpassword(String conformpassword){
        this.conformpassword=conformpassword;
    }

   public Helperclass(String username,String enteremail,String password,String conformpassword){
       this.username=username;
       this.enteremail=enteremail;
       this.password=password;
       this.conformpassword=conformpassword;
   }

    public Helperclass() {
    }
}
