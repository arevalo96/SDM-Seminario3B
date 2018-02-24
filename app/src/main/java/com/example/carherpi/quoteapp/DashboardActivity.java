package com.example.carherpi.quoteapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //((Button)findViewById(R.id.getquotes)).setOnClickListener(listener);
        //((Button)findViewById(R.id.favoritequotes)).setOnClickListener(listener);
        //((Button)findViewById(R.id.settings)).setOnClickListener(listener);
        //((Button)findViewById(R.id.about)).setOnClickListener(listener);

    }

    public void clickAbout(View view) {
        Intent aboutIntent = new Intent(this, AboutActivity.class);
        startActivity(aboutIntent);
    }

    public void clickSettings(View view) {
        Intent settingsIntent = new Intent(this, SettingsActivity.class);
        startActivity(settingsIntent);
    }
    public void clickFavourite(View view) {
        Intent favouriteIntent = new Intent(this, FavouriteActivity.class);
        startActivity(favouriteIntent);
    }

    public void clickQuotation(View view) {
        Intent quotationIntent = new Intent(this, QuotationActivity.class);
        startActivity(quotationIntent);
    }





    /*
    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case(R.id.getquotes): Intent startNewActivity = new Intent(this, AboutActivity.class);
                case(R.id.favoritequotes) //Intent startNewActivity = new Intent(this,X.class);
                case(R.id.getquotes) //Intent startNewActivity = new Intent(this,X.class);
                case(R.id.getquotes) //Intent startNewActivity = new Intent(this,X.class);
            }

        }
    }

    */

}
