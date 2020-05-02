package com.pranav.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class about extends AppCompatActivity {

    Button btGit,btHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        btGit=findViewById(R.id.btGIt);
        btHome=findViewById(R.id.btHome);


        btGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com//singhalpranav22"));
                startActivity(intent);
            }
        });


        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(about.this,com.pranav.gocorona.MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
