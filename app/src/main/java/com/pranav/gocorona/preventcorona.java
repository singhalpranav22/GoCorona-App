package com.pranav.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class preventcorona extends AppCompatActivity {

    Button btHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventcorona);
        btHome=findViewById(R.id.btHome);


        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(preventcorona.this,com.pranav.gocorona.MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
