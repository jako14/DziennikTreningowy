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
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

/**
 * Created by Jakub on 2016-06-07.
 */
public class TuesdayActivity extends AppCompatActivity
{
    private SQLiteDatabase db;
    private Cursor cursor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuesday);

        final ListView listExercises = (ListView)findViewById(R.id.tuesdayList);
        final DBHandler dB = new DBHandler(this);
        final String dbName = "TUEEXEC";

        refreshList(dbName,dB,listExercises);
        ImageButton addButton = (ImageButton)findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(TuesdayActivity.this, ExercisesActivity.class);
                intent.putExtra("message", dbName);
                startActivity(intent);

            }
        });

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                System.out.println(dB.getDbName(dbName,position+1));
                System.out.println(dB.getExeDate(dbName));
                Intent intent = new Intent(TuesdayActivity.this, ExeActivity.class);
                intent.putExtra("message", dB.getDbName(dbName,position+1));
                startActivity(intent);

            }
        };

        listExercises.setOnItemClickListener(itemClickListener);

        AdapterView.OnItemLongClickListener itemLongClickListener = new AdapterView.OnItemLongClickListener()
        {

            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                dB.deleteExercise(position + 1, dbName);
                Context context = getApplicationContext();
                CharSequence text = "Ćwiczenie usunięte";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                dB.organizeList(dbName);
                refreshList(dbName,dB,listExercises);

                return true;
            }
        };
        listExercises.setOnItemLongClickListener(itemLongClickListener);

    }


    public void refreshList(String dbName, DBHandler dB, ListView listExercises)
    {
        try
        {
            SQLiteOpenHelper dbHelper = new DBHandler(this);

            db = dbHelper.getReadableDatabase();
            cursor = db.query(dbName, new String[]{"_id", "EXECNAME", "CLASSNAME"}, null, null, null, null, null);

            CursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cursor, new String[]{"EXECNAME"}, new int[]{android.R.id.text1},0);

            listExercises.setAdapter(listAdapter);
        } catch (SQLiteException e)
        {
            Toast toast = Toast.makeText(this,"Baza danych niedostępna", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

}
