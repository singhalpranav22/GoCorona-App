package com.pranav.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class resources extends AppCompatActivity {

    Button btWho,btMohfw,btJohn,btMygov;
    YouTubePlayerView v1,v2,v3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        btWho=findViewById(R.id.btWho);
        btMohfw=findViewById(R.id.btMohfw);
        btJohn=findViewById(R.id.btJohn);
        btMygov=findViewById(R.id.btMygov);
        v1=findViewById(R.id.video1);
        v2=findViewById(R.id.video2);
        v3=findViewById(R.id.video3);

        getLifecycle().addObserver(v1);
        getLifecycle().addObserver(v2);
        getLifecycle().addObserver(v3);



      btWho.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.who.int/emergencies/diseases/novel-coronavirus-2019"));
              startActivity(intent);
          }
      });

      btMohfw.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mohfw.gov.in"));
              startActivity(intent);
          }
      });

      btMygov.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.mygov.in"));
              startActivity(intent);
          }
      });

      btJohn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://coronavirus.jhu.edu/map.html"));
              startActivity(intent);
          }
      });
    }
}
