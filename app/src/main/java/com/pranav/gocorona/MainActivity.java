package com.pranav.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    Button btnSymptom, btnPrevention, btnResource, btnHelpline,btnAbout;
    Button btnGlobal;
    TextView tvTotal, tvActive, tvDeath, tvRecovered,tvrrate,tvddrate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSymptom = findViewById(R.id.btnSymptoms);
        btnPrevention = findViewById(R.id.btnPreventions);
        btnResource = findViewById(R.id.btnResources);
        btnHelpline = findViewById(R.id.btnHelpline);
        btnGlobal = findViewById(R.id.btnGlobal);
        tvTotal = findViewById(R.id.inTotal);
        tvActive = findViewById(R.id.inActive);
        tvDeath = findViewById(R.id.inDeath);
        tvRecovered = findViewById(R.id.inRecovered);
        tvrrate=findViewById(R.id.inRecoveryrate);
        tvddrate=findViewById(R.id.inDeathrate);
        btnAbout=findViewById(R.id.btnFinal);


        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,com.pranav.gocorona.about.class);
                startActivity(intent);
            }
        });
        btnSymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,com.pranav.gocorona.symptoms.class);
                startActivity(intent);

            }
        });
        btnHelpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,com.pranav.gocorona.helplinenumbers.class);
                startActivity(intent);

            }
        });

        btnResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,com.pranav.gocorona.resources.class);
                startActivity(intent);
            }
        });
        btnPrevention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,com.pranav.gocorona.preventcorona.class);
                startActivity(intent);

            }
        });

        btnGlobal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,com.pranav.gocorona.stats.class);
                startActivity(intent);
            }
        });

        fetchdata();

    }

    private void fetchdata() {

        String url = "http://covid19-india-adhikansh.herokuapp.com/summary";

        StringRequest request = new StringRequest(Request.Method.GET, url,

                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response.toString());
                            tvActive.setText(jsonObject.getString("Total Confirmed cases"));
                            tvTotal.setText(jsonObject.getString("Total Cases"));
                            tvDeath.setText(jsonObject.getString("Death"));
                            tvRecovered.setText(jsonObject.getString("Cured/Discharged/Migrated"));

                            String r=jsonObject.getString("Cured/Discharged/Migrated");
                            String d=jsonObject.getString("Death");
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



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error In Fetching Data From the server", Toast.LENGTH_SHORT).show();
            }
        }


        );

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


}
