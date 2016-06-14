package com.example.jakub.dzienniktreningowy;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.data.Entry;

/**
 * Created by Jakub on 2016-06-13.
 */
public class ExeActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private Cursor cursor;
    ListView lv;
    Context context;
    private int i=1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exe);

        final DBHandler dB = new DBHandler(this);
        Intent msg = getIntent();
        final String dbName = msg.getStringExtra("message");

        initList();


        final EditText tvRep = (EditText) findViewById(R.id.nrRepET);
        final EditText tvWeight = (EditText) findViewById(R.id.nrWeightET);
        Button chartButton = (Button)findViewById(R.id.chartButton);

        chartButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(ExeActivity.this, ChartActivity.class);
                intent.putExtra("message", dbName);
                startActivity(intent);

            }
        });


        tvRep.setText(String.valueOf(dB.getRep(dbName)));
        tvWeight.setText(String.valueOf(dB.getWeight(dbName)));

        Button addExe = (Button)findViewById(R.id.addExeButton);

        addExe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                dB.insertSet(Integer.valueOf(tvRep.getText().toString()),Double.valueOf(tvWeight.getText().toString()),dbName);
                i++;
                initList();

            }
        });
    }

void initList()
{
    final DBHandler dB = new DBHandler(this);
    Intent msg = getIntent();
    final String dbName = msg.getStringExtra("message");

    String [] dateList=dB.getRowDate(dbName);
    String [] repList=dB.getRowRep(dbName);
    String [] weightList=dB.getRowWeight(dbName);

    TextView tvSet = (TextView)findViewById(R.id.nrSetTV);
    tvSet.setText(String.valueOf(i));

    lv = (ListView)findViewById(R.id.exeList);
    lv.setAdapter(new CustomListView(this,dateList,repList,weightList));
}

}


