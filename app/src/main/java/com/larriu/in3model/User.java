package com.larriu.in3model;

public class User {

    private String name, surname, email;
    private int moneyDonated;
    private boolean admin, normalApp;

    public User(String name, String email, boolean admin) {
        this.name = name;
        this.email = email;
        this.admin = admin;
        surname = "Fernandez";
        moneyDonated = 0;
        normalApp = true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public int getMoneyDonated() {
        return moneyDonated;
    }

    public boolean isAdmin() {
        return admin;
    }

    public boolean isNormalApp(){return normalApp;}

    public void changeApp(){normalApp = !normalApp;}

}
