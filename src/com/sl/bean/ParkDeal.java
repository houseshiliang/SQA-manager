package com.sl.bean;

public class ParkDeal {
    String hardware_id;
    String licence_plate;
    String start_time;
    String end_time;
    double price;
    public String getHardware_id() {
        return hardware_id;
    }
    public void setHardware_id(String hardware_id) {
        this.hardware_id = hardware_id;
    }
    public String getLicence_plate() {
        return licence_plate;
    }
    public void setLicence_plate(String licence_plate) {
        this.licence_plate = licence_plate;
    }
    public String getStart_time() {
        return start_time;
    }
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }
    public String getEnd_time() {
        return end_time;
    }
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
