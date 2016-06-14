package com.example.jakub.dzienniktreningowy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Jakub on 2016-06-07.
 */
public class ExercisesActivity extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        Intent msg = getIntent();
        final String dbName = msg.getStringExtra("message");

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0)//Poniedziałek
                {
                    Intent intent = new Intent(ExercisesActivity.this, ChestActivity.class);
                    intent.putExtra("message", dbName);
                    startActivity(intent);
                }
                else if (position==1)// Wtorek
                {
                    Intent intent = new Intent(ExercisesActivity.this, ShouldersActivity.class);
                    intent.putExtra("message", dbName);
                    startActivity(intent);
                }
                else if (position==2)// środa
                {
                    Intent intent = new Intent(ExercisesActivity.this, BicepsActivity.class);
                    intent.putExtra("message", dbName);
                    startActivity(intent);
                }
                else if (position==3)// czwartek
                {
                    Intent intent = new Intent(ExercisesActivity.this, TricepsActivity.class);
                    intent.putExtra("message", dbName);
                    startActivity(intent);
                }
                else if (position==4)// piątek
                {
                    Intent intent = new Intent(ExercisesActivity.this, LegsActivity.class);
                    intent.putExtra("message", dbName);
                    startActivity(intent);
                }
                else if (position==5)// sobota
                {
                    Intent intent = new Intent(ExercisesActivity.this, BackActivity.class);
                    intent.putExtra("message", dbName);
                    startActivity(intent);
                }

            }
        };

        ListView listView = (ListView) findViewById(R.id.exercisesList);
        listView.setOnItemClickListener(itemClickListener);
    }

}
