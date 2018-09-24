package com.example.manasatpc.appguide.model;


/**
 * Created by ManasatPC on 26/05/18.
 */

public class SourceData {

    //variables for save values
    private String name_object, phone_object, address_object;
    //variable for check_drawable_left
    private int check_drawable = -1;
    //variable for Image View
    private int image_show;

    public SourceData(String name_object, String phone_object, String address_object, int image_show, int check_drawable) {
        this.name_object = name_object;
        this.phone_object = phone_object;
        this.address_object = address_object;
        this.image_show = image_show;
        this.check_drawable = check_drawable;
    }


    public SourceData(String name_object, String phnoe_restaurant, String address_object, int image_show) {
        this.name_object = name_object;
        this.phone_object = phnoe_restaurant;
        this.address_object = address_object;
        this.image_show = image_show;
    }

    public int getImage_show() {
        return image_show;
    }

    public int getCheck_drawable() {
        return check_drawable;
    }

    public String getName_object() {
        return name_object;
    }


    public String getphone_restaurant() {
        return phone_object;
    }


    public String getAddress_object() {
        return address_object;
    }


}
