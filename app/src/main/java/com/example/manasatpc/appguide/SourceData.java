package com.example.manasatpc.appguide;


/**
 * Created by ManasatPC on 26/05/18.
 */

public class SourceData {

    //variables for save values
    private String name_restaurant, phone_restaurant, address_restaurant;
    //variable for check_drawable_left
    private int check_drawable = -1;
    //variable for Image View
    private int image_show;

    public SourceData(String name_restaurant, String phone_restaurant, String address_restaurant, int image_show, int check_drawable) {
        this.name_restaurant = name_restaurant;
        this.phone_restaurant = phone_restaurant;
        this.address_restaurant = address_restaurant;
        this.image_show = image_show;
        this.check_drawable = check_drawable;
    }


    public SourceData(String name_restaurant, String phnoe_restaurant, String address_restaurant, int image_show) {
        this.name_restaurant = name_restaurant;
        this.phone_restaurant = phnoe_restaurant;
        this.address_restaurant = address_restaurant;
        this.image_show = image_show;
    }

    public int getImage_show() {
        return image_show;
    }

    public int getCheck_drawable() {
        return check_drawable;
    }

    public String getName_restaurant() {
        return name_restaurant;
    }


    public String getphone_restaurant() {
        return phone_restaurant;
    }


    public String getAddress_restaurant() {
        return address_restaurant;
    }


}
