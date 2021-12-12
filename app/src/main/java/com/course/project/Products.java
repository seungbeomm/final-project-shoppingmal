package com.course.project;

public class Products {
    String Name;
    String Cost;
    String Note;
    int ID;

    public Products (String name, String cost, String note, int id) {
        this.Name=name;
        this.Cost=cost;
        this.Note=note;
        this.ID = id;
    }
    public String getName(){
        return Name;
    }
    public void setName(String name){
        Name=name;
    }
    public int getID(){
        return ID;
    }
    public void setID(int id){
        ID=id;
    }
    public String getCost(){
        return Cost;
    }
    public void setCost(String cost){
        Cost=cost;
    }
    public String getNote(){
        return Note;
    }
    public void setNote(String note){
        Note=note;
    }

}

