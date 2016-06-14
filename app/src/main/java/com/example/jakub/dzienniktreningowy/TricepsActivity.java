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
public class TricepsActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triceps);

        final DBHandler db = new DBHandler(this);
        Intent msg = getIntent();
        final String dbName = msg.getStringExtra("message");

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0)//Ławka płaska
                {
                    if(db.checkExercise("Wyciskanie francuskie",dbName))
                    {
                        db.insertExercise("Wyciskanie francuskie", "WYCFRAN", dbName);
                        db.organizeList(dbName);
                        addToast();
                    }
                    else sameToast();

                } else if (position == 1)// Ławka dodatnia
                {
                    if(db.checkExercise("Wyciskanie na bramie za głowę",dbName))
                    {
                        db.insertExercise("Wyciskanie na bramie za głowę", "BRAMGLOW", dbName);
                        db.organizeList(dbName);
                        addToast();
                    }
                    else sameToast();

                } else if (position == 2)// Dipsy
                {
                    if(db.checkExercise("Pompki szwedzkie wąsko",dbName))
                    {
                        db.insertExercise("Pompki szwedzkie wąsko", "DIPSYW", dbName);
                        db.organizeList(dbName);
                        addToast();
                    }
                    else sameToast();

                } else if (position == 3)// Rozpiętki
                {
                    if(db.checkExercise("Hantlem za głową",dbName))
                    {
                        db.insertExercise("Hantlem za głową", "HANGLOW", dbName);
                        db.organizeList(dbName);
                        addToast();
                    }
                    else sameToast();

                }

            }
        };

        ListView listView = (ListView) findViewById(R.id.tricepsList);
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
