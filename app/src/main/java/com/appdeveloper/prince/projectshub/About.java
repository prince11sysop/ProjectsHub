package com.appdeveloper.prince.projectshub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("About ");
        setContentView(R.layout.about_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);    //For back button
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
