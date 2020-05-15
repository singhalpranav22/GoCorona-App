package com.pranav.gocorona;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class DetailActivity extends AppCompatActivity {

    TextView tvCountry,tvCases,tvRecovered,tvCritical,tvActive,tvTodayCases,tvTotalDeaths,tvTodayDeaths,tvrrate,tvddrate,tvTests;
    Button btdDetail,btdHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
         btdDetail=findViewById(R.id.btdDetail);
         btdHome=findViewById(R.id.btdHome);
        Intent intent = getIntent();
        int positionCountry = intent.getIntExtra("position", 0);

//        getSupportActionBar().setTitle("Details of "+AffectedCountries.countryModelsList.get(positionCountry).getCountry());
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);


tvTests=findViewById(R.id.tvTests);
        tvCountry = findViewById(R.id.tvCountry);
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvrrate=findViewById(R.id.tvrrate);
        tvddrate=findViewById(R.id.tvddrate);

        tvCountry.setText(AffectedCountries.countryModelsList.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.countryModelsList.get(positionCountry).getCases());
        tvRecovered.setText(AffectedCountries.countryModelsList.get(positionCountry).getRecovered());
        tvCritical.setText(AffectedCountries.countryModelsList.get(positionCountry).getCritical());
        tvActive.setText(AffectedCountries.countryModelsList.get(positionCountry).getActive());
        tvTodayCases.setText(AffectedCountries.countryModelsList.get(positionCountry).getTodayCases());
        tvTotalDeaths.setText(AffectedCountries.countryModelsList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(AffectedCountries.countryModelsList.get(positionCountry).getTodayDeaths());
         tvTests.setText(AffectedCountries.countryModelsList.get(positionCountry).getTests());
          String r= (String) tvRecovered.getText();
          String d= (String) tvTotalDeaths.getText();




        float re=Float.parseFloat(r);
        float de=Float.parseFloat(d);
        float total=re+de;
        float rep=((re)*100)/total;
        float dep=((de)*100)/total;
        DecimalFormat df = new DecimalFormat("#.##");


        r=df.format(rep);
        d=df.format(dep);
        r=r+" %";
        d=d+" %";


        tvrrate.setText(r);
        tvddrate.setText(d);

        btdHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(DetailActivity.this,com.pranav.gocorona.MainActivity.class);
                startActivity(intent);
            }
        });

        btdDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(DetailActivity.this,com.pranav.gocorona.AffectedCountries.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
