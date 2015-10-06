package com.phonelost.phonelost.model;

import com.orm.SugarRecord;

/**
 * Created by ujjwal on 5/10/15.
 */
public class Pin extends SugarRecord<Pin>{
    String pincode;

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {

        this.pincode = pincode;
    }

    public Pin() {


    }
    public Pin(String pincode) {
        this.pincode = pincode;
    }
}
