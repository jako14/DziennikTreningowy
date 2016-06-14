package com.example.jakub.dzienniktreningowy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;

/**
 * Created by Jakub on 2016-06-14.
 */
public class ChartActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        Intent msg = getIntent();
        final String dbName = msg.getStringExtra("message");

        DBHandler dB = new DBHandler(this);

        LineChart lineChart = (LineChart)findViewById(R.id.chart);

        ArrayList<Entry> entries = dB.getRepWeight(dbName);

        LineDataSet dataset = new LineDataSet(entries, "Objętość treningu");

        ArrayList<String> labels = dB.getDateList(dbName);



        LineData data = new LineData(labels, dataset);
        lineChart.setData(data); // set the data and list of lables into chart
        dataset.setDrawFilled(true);


        lineChart.setDescription("Wykres objętości treningowej");
    }
}
