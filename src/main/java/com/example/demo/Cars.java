package com.example.demo;

import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Cars {

    @NotNull
    @Min(3)
    private int year;

    @NotNull
    @Size(min=10)
    private String make;

    @NotNull
    @Size(min=10)
    private String model;

    public Cars(@NotNull @Min(3) int year, @NotNull @Size(min = 10) String make, @NotNull @Size(min = 10) String model) {
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public Cars() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
