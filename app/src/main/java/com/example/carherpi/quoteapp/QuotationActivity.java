package com.example.carherpi.quoteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class QuotationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String user = " "+getString(R.string.current_user);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quotation);

        String str = ((TextView)findViewById(R.id.textView4)).getText().toString();
        String replaced = str.replaceAll("%1s",user);
        ((TextView)findViewById(R.id.textView4)).setText(replaced);


        ImageButton refresh = (ImageButton)findViewById(R.id.imageButton2);
        refresh.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                String quote = getString(R.string.sample_quotation);
                String author = getString(R.string.sample_author);
                ((TextView)findViewById(R.id.textView4)).setText(quote);
                ((TextView)findViewById(R.id.textView2)).setText(author);
            }
        });

    }

}
