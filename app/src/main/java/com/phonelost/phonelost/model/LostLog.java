package com.phonelost.phonelost.model;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by ujjwal on 5/10/15.
 */
public class LostLog extends SugarRecord<LostLog>{

    Date date;
    Pin pincode;
    Double latitude, longitude;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Pin getPincode() {
        return pincode;
    }

    public void setPincode(Pin pincode) {
        this.pincode = pincode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LostLog() {


    }
    public LostLog(Date date, Pin pincode) {

        this.date = date;
        this.pincode = pincode;
    }

}
