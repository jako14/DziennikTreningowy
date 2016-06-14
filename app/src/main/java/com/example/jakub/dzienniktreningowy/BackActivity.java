package com.example.jakub.dzienniktreningowy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Jakub on 2016-06-07.
 */
public class BackActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back);

        final DBHandler db = new DBHandler(this);
        Intent msg = getIntent();
        final String dbName = msg.getStringExtra("message");

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0)//Ławka płaska
                {
                    if(db.checkExercise("Martwy ciąg",dbName)) {
                        db.insertExercise("Martwy ciąg", "MARTWY", dbName);
                        db.organizeList(dbName);
                        addToast();
                    }
                    else sameToast();
                } else if (position == 1)// Ławka dodatnia
                {
                    if (db.checkExercise("Wisołowanie",dbName)) {
                        db.insertExercise("Wisołowanie", "WIOSLO", dbName);
                        db.organizeList(dbName);
                        addToast();
                    }
                    else sameToast();
                } else if (position == 2)// Dipsy
                {
                    if(db.checkExercise("Podciąganie",dbName)) {
                        db.insertExercise("Podciąganie", "PODCIAG", dbName);
                        db.organizeList(dbName);
                        addToast();
                    }
                    else sameToast();
                } else if (position == 3)// Rozpiętki
                {
                    if(db.checkExercise("Przyciąganie drążka za głowę",dbName)) {
                        db.insertExercise("Przyciąganie drążka za głowę", "PRZYCIAG", dbName);
                        db.organizeList(dbName);
                        addToast();
                    }
                    else sameToast();
                }

            }
        };

        ListView listView = (ListView) findViewById(R.id.backList);
        listView.setOnItemClickListener(itemClickListener);
    }

    private void addToast()
    {
        Context context = getApplicationContext();
        CharSequence text = "Ćwiczenie dodane";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    private void sameToast()
    {
        Context context = getApplicationContext();
        CharSequence text = "To ćwiczenie się powtarza";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
