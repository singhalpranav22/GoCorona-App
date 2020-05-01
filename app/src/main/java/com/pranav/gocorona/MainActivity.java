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

public class MainActivity extends AppCompatActivity {


    Button btnSymptom, btnPrevention, btnResource, btnHelpline;
    Button btnGlobal;
    TextView tvTotal, tvActive, tvDeath, tvRecovered;

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
        btnSymptom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnHelpline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnResource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnPrevention.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
