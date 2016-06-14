package com.example.jakub.dzienniktreningowy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position==0)//Poniedziałek
                {
                    Intent intent = new Intent(MainActivity.this, MondayActivity.class);
                    startActivity(intent);
                }
                else if (position==1)// Wtorek
                {
                    Intent intent = new Intent(MainActivity.this, TuesdayActivity.class);
                    startActivity(intent);
                }
                else if (position==2)// środa
                {
                    Intent intent = new Intent(MainActivity.this, WednesdayActivity.class);
                    startActivity(intent);
                }
                else if (position==3)// czwartek
                {
                    Intent intent = new Intent(MainActivity.this, ThursdayActivity.class);
                    startActivity(intent);
                }
                else if (position==4)// piątek
                {
                    Intent intent = new Intent(MainActivity.this, FridayActivity.class);
                    startActivity(intent);
                }
                else if (position==5)// sobota
                {
                    Intent intent = new Intent(MainActivity.this, SaturdayActivity.class);
                    startActivity(intent);
                }
                else // niedziela
                {
                    Intent intent = new Intent(MainActivity.this, SundayActivity.class);
                    startActivity(intent);
                }

            }
        };

        ListView listView = (ListView) findViewById(R.id.weekList);
        listView.setOnItemClickListener(itemClickListener);
    }
}
