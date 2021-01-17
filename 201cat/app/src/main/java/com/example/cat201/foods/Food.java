package com.example.cat201.foods;

public class Food {


    private String food_code;
    private String food_name;

    public Food( String food_code, String food_name) {

        this.food_code = food_code;
        this.food_name = food_name;
    }

    public Food() {
    }



    public String getFood_code() {
        return food_code;
    }

    public void setFood_code(String food_code) {
        this.food_code = food_code;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }
}
