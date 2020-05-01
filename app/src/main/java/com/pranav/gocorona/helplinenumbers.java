package com.pranav.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class helplinenumbers extends AppCompatActivity {
    TextView tvTollfree,tvhelpline,tvSurvey,tvEmailid;
    ImageView btToll,btHelp,btSurvey,btEmail;
    Button btHelphome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helplinenumbers);

        tvTollfree=findViewById(R.id.tvtollfree);
        tvhelpline=findViewById(R.id.tvHelpline);
        tvSurvey=findViewById(R.id.tvSurvey);
        tvEmailid=findViewById(R.id.tvEmail);
        btHelphome=findViewById(R.id.btHelphome);


        tvTollfree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1075"));
                startActivity(intent);


            }
        });

        btHelphome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(helplinenumbers.this,com.pranav.gocorona.MainActivity.class);
                startActivity(intent);
            }
        });

        tvhelpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+91-11-23978046"));
                startActivity(intent);


            }
        });

        tvSurvey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:1921"));
                startActivity(intent);



            }
        });


        tvEmailid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_SEND,Uri.parse("mailto:ncov2019@gov.in"));
                startActivity(intent);
            }
        });

    }
}
