package com.pranav.gocorona;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;

public class GlobalStats extends AppCompatActivity {

    TextView tvCases,tvRecovered,tvCritical,tvActive,tvToday,tvDeaths,tvtodayDeaths,tvAffected,tvTests,tvRep,tvDep;
    ScrollView scrollView;
//    SimpleArcLoader simpleArcLoader;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRep=findViewById(R.id.tvRep);
        tvDep=findViewById(R.id.tvDep);
        tvCases=findViewById(R.id.tvCases);
        tvRecovered=findViewById(R.id.tvRecovered);
        tvCritical=findViewById((R.id.tvCritical));
        tvActive=findViewById(R.id.tvActive);
        tvToday=findViewById(R.id.tvToday);
        tvDeaths=findViewById(R.id.tvDeaths);
        tvtodayDeaths=findViewById(R.id.tvtodayDeaths);
        tvTests=findViewById(R.id.tvTests);
        tvAffected=findViewById(R.id.tvAffected);
        scrollView=findViewById(R.id.scrollStats);
        pieChart=findViewById(R.id.piechart);
//        simpleArcLoader=findViewById(R.id.loader);
        fetchData();

    }
    // Function will call a Rest API toh mujhe kuch nhi karna :P
    private void fetchData() {
        String url="https://corona.lmao.ninja/v2/all/";
//        simpleArcLoader.start();
        StringRequest request= new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject=new JSONObject(response.toString());

                            tvCases.setText(jsonObject.getString("cases"));
                            tvRecovered.setText(jsonObject.getString("recovered"));
                            tvActive.setText(jsonObject.getString("active"));
                            tvAffected.setText(jsonObject.getString("affectedCountries"));
                            tvCritical.setText(jsonObject.getString("critical"));
                            tvDeaths.setText(jsonObject.getString("deaths"));
                            tvtodayDeaths.setText(jsonObject.getString("todayDeaths"));
                            tvToday.setText(jsonObject.getString("todayCases"));
                            tvTests.setText(jsonObject.getString("tests"));
                            String r=jsonObject.getString("recovered");
                            String d=jsonObject.getString("deaths");
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
                            tvRep.setText(r);
                            tvDep.setText(d);
                            pieChart.addPieSlice(new PieModel("cases",Integer.parseInt(tvCases.getText().toString()), Color.parseColor("#FFA726")));
                            pieChart.addPieSlice(new PieModel("recoveries",Integer.parseInt(tvRecovered.getText().toString()), Color.parseColor("#66BB6A")));
                            pieChart.addPieSlice(new PieModel("deaths",Integer.parseInt(tvDeaths.getText().toString()), Color.parseColor("#EF5350")));
                            pieChart.addPieSlice(new PieModel("active",Integer.parseInt(tvActive.getText().toString()), Color.parseColor("#29B6F6")));
                            pieChart.startAnimation();
//                            simpleArcLoader.stop();
//                            simpleArcLoader.setVisibility(View.GONE);
//                            scrollView.setVisibility(View.VISIBLE);







                        } catch (JSONException e) {
                            e.printStackTrace();
//                            simpleArcLoader.stop();
//                            simpleArcLoader.setVisibility(View.GONE);
                            scrollView.setVisibility(View.VISIBLE);


                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                simpleArcLoader.stop();
//                simpleArcLoader.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);

                Toast.makeText(GlobalStats.this, "Error in Getting data !!", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(request);

    }
}
