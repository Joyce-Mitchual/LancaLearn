package com.example.grpwork.models;

public class Module {

    private String name;
    private String image;
    private String year;
    private String code;
    private String program;

    public Module(){

    }
    
    public Module(String name, String image, String year, String code, String program) {
        this.name = name;
        this.image = image;
        this.year = year;
        this.code = code;
        this.program = program;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
