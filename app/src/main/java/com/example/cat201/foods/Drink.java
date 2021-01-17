package com.example.cat201.foods;

public class Drink {

    private String drink_ID;
    private String drink_code;
    private String drink_name;
    private String drink_food;
    private Boolean drink_status;

    public Drink() {
    }

    public Drink(String drink_ID, String drink_code, String drink_name, String drink_food, Boolean drink_status) {
        this.drink_ID = drink_ID;
        this.drink_code = drink_code;
        this.drink_name = drink_name;
        this.drink_food = drink_food;
        this.drink_status = drink_status;
    }

    public String getDrink_ID() {
        return drink_ID;
    }

    public void setDrink_ID(String drink_ID) {
        this.drink_ID = drink_ID;
    }

    public String getDrink_code() {
        return drink_code;
    }

    public void setDrink_code(String drink_code) {
        this.drink_code = drink_code;
    }

    public String getDrink_name() {
        return drink_name;
    }

    public void setDrink_name(String drink_name) {
        this.drink_name = drink_name;
    }

    public String getDrink_food() {
        return drink_food;
    }

    public void setDrink_food(String drink_food) {
        this.drink_food = drink_food;
    }

    public String getDrink_status() {
        String available;
        if(this.drink_status)
            available="provided";
        else
            available="not available";

        return available;
    }

    public void setDrink_status(Boolean drink_status) {
        this.drink_status = drink_status;
    }
}
