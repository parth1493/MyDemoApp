package com.krishna.mydemoapp.example.espresso;

/**
 * Created by parthdesai on 2017-09-04.
 */

public class EspressoModel {
    private String firstName;
    private String secondName;

    public EspressoModel(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

}
