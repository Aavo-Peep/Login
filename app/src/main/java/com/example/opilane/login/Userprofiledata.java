package com.example.opilane.login;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by opilane on 14.03.2018.
 */

public class Userprofiledata {
    public String eesNimi;
    public String pereNimi;
    public String epost;


    public Userprofiledata(String eesNimi, String pereNimi, String epost) {
        this.eesNimi = eesNimi;
        this.pereNimi = pereNimi;
        this.epost = epost;
    }

    public Userprofiledata(){
    }

    public String getEesNimi() {
        return eesNimi;
    }

    public void setEesNimi(String eesNimi) {
        this.eesNimi = eesNimi;
    }

    public String getPereNimi() {
        return pereNimi;
    }

    public void setPereNimi(String pereNimi) {
        this.pereNimi = pereNimi;
    }

    public String getEpost() {
        return epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }
}
