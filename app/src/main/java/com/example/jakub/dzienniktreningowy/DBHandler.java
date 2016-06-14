package com.example.jakub.dzienniktreningowy;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.github.mikephil.charting.data.Entry;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Jakub on 2016-06-08.
 */
public class DBHandler extends SQLiteOpenHelper
{
    private static final String DB_NAME = "Trening";
    private static final int DB_VERSION = 6;

    DBHandler(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE MONEXEC (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "EXECNAME TEXT, " + "CLASSNAME TEXT); ");
        db.execSQL("CREATE TABLE TUEEXEC (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "EXECNAME TEXT, " + "CLASSNAME TEXT); ");
        db.execSQL("CREATE TABLE WEDEXEC (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "EXECNAME TEXT, " + "CLASSNAME TEXT); ");
        db.execSQL("CREATE TABLE THUEXEC (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "EXECNAME TEXT, " + "CLASSNAME TEXT); ");
        db.execSQL("CREATE TABLE FRIEXEC (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "EXECNAME TEXT, " + "CLASSNAME TEXT); ");
        db.execSQL("CREATE TABLE SATEXEC (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "EXECNAME TEXT, " + "CLASSNAME TEXT); ");
        db.execSQL("CREATE TABLE SUNEXEC (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "EXECNAME TEXT, " + "CLASSNAME TEXT); ");
        db.execSQL("CREATE TABLE PLASKA (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE NUMERIC, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE DODATNIA (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE DIPSY (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE ROZPIETKI (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE MARTWY (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE WIOSLO (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE PODCIAG (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE PRZYCIAG (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE CHWMLOT (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE BICKOL (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE HANMOD (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE SCIGOR (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE PRZYSIAD (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE WYKROKI (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE ZAKROKI (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE SUWNICA (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE WYCZOL (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE HANPRZ (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE FACEPULLS (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE MOTYLKI (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE WYCFRAN (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE BRAMGLOW (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE DIPSYW (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE HANGLOW (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("CREATE TABLE DODATNIA (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE DIPSY (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE ROZPIETKI (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE MARTWY (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE WIOSLO (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE PODCIAG (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE PRZYCIAG (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE CHWMLOT (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE BICKOL (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE HANMOD (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE SCIGOR (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE PRZYSIAD (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE WYKROKI (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE ZAKROKI (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE SUWNICA (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE WYCZOL (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE HANPRZ (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE FACEPULLS (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE MOTYLKI (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE WYCFRAN (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE BRAMGLOW (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE DIPSYW (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");
        db.execSQL("CREATE TABLE HANGLOW (_id INTEGER PRIMARY KEY AUTOINCREMENT, " + "_DATE TEXT, " + "REPS INTEGER, " + "WEIGHT REAL); ");

    }

    public void insertExercise( String name, String className, String dbName)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues exeValues = new ContentValues();
        exeValues.put("EXECNAME", name);
        exeValues.put("CLASSNAME", className);
        db.insert(dbName, null, exeValues);
        db.close();
    }
    public void insertSet( int rep, double weight, String dbName)
    {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String date = dateFormat.format(c.getTime());

        SQLiteDatabase db = getWritableDatabase();
        ContentValues exeValues = new ContentValues();
        exeValues.put("_DATE", date);
        exeValues.put("REPS", rep);
        exeValues.put("WEIGHT", weight);
        db.insert(dbName, null, exeValues);
        db.close();
    }
    public String getDbName(String dbName, Integer id)
    {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);
        if(cursorCount.moveToFirst())
        {
            System.out.println(cursorCount.getInt(0));
            if (cursorCount.getInt(0)==id)
            {
                String dataName = cursorCount.getString(2);
                db.close();
                cursorCount.close();
                return dataName;
            }

        }
        int i=2;
        while (i!=(cursorCount.getCount()+1)&&i<=cursorCount.getCount()+1)
        {
            if(cursorCount.moveToNext())
            {
                if (cursorCount.getInt(0)==id)
                {
                    String dataName = cursorCount.getString(2);
                    cursorCount.close();
                    db.close();
                    return dataName;
                }
                i++;
            }
        }
        cursorCount.close();
        db.close();
        return "0";
    }
    public String getExeDate(String dbName)
    {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);

        if(cursorCount.moveToLast())
        {
            String ret = cursorCount.getString(1);
            cursorCount.close();
            db.close();
            return ret;
        }
        else {
            cursorCount.close();
            db.close();
            return "TEEEEEST";
        }
    }

    public String[] getRowDate(String dbName)
    {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);
        String[] ret = new String[cursorCount.getCount()];

        int i = 0;

        if(cursorCount.getCount()>0) {
            if (cursorCount.moveToLast()) {
                ret[i] = cursorCount.getString(1);
                i++;
            }

            int j = 2;

            while (j != (cursorCount.getCount() + 1) && j <= cursorCount.getCount() + 1)
                if (cursorCount.moveToPrevious()) {
                    ret[i] = cursorCount.getString(1);
                    i++;
                    j++;
                }
            cursorCount.close();
            db.close();
            return ret;
        }
        else {
            String[] ret2 = new String[1];
            ret2[0] = " ";
            cursorCount.close();
            db.close();
            return ret2;
        }
    }
    public String[] getRowRep(String dbName)
    {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);
        String[] ret = new String[cursorCount.getCount()];


        int i = 0;

        if(cursorCount.getCount()>0) {
            if (cursorCount.moveToLast()) {
                ret[i] = cursorCount.getString(2);
                i++;
            }

            int j = 2;

            while (j != (cursorCount.getCount() + 1) && j <= cursorCount.getCount() + 1)
                if (cursorCount.moveToPrevious()) {
                    ret[i] = cursorCount.getString(2);
                    i++;
                    j++;
                }
            cursorCount.close();
            db.close();
            return ret;
        }
        else {
            String[] ret2 = new String[1];
            ret2[0] = " ";
            cursorCount.close();
            db.close();
            return ret2;
        }
    }
    public String[] getRowWeight(String dbName)
    {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);
        String[] ret = new String[cursorCount.getCount()];

        int i = 0;

        if(cursorCount.getCount()>0) {
            if (cursorCount.moveToLast()) {
                ret[i] = cursorCount.getString(3);
                i++;
            }

            int j = 2;

            while (j != (cursorCount.getCount() + 1) && j <= cursorCount.getCount() + 1)
                if (cursorCount.moveToPrevious()) {
                    ret[i] = cursorCount.getString(3);
                    i++;
                    j++;
                }
            cursorCount.close();
            db.close();
            return ret;
        }
        else {
            String[] ret2 = new String[1];
            ret2[0] = " ";
            cursorCount.close();
            db.close();
            return ret2;
        }
    }

    public Integer getRep(String dbName)
    {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);

        if(cursorCount.moveToLast())
        {
            Integer ret = cursorCount.getInt(2);
            db.close();
            return ret;
        }

            else
        {
            cursorCount.close();
            db.close();
            return 0;
        }


    }

    public double getWeight(String dbName)
    {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);

        if(cursorCount.moveToLast())
        {
            double ret = cursorCount.getDouble(3);
            cursorCount.close();
            db.close();
            return ret;
        }

        else
        {
            db.close();
            cursorCount.close();
            return 0.0;
        }

    }

    public void deleteExercise (Integer id, String dbName)
    {
        SQLiteDatabase db = this.getWritableDatabase();
         db.delete(dbName,
                 "_id = ? ",
                 new String[]{Integer.toString(id)});

    }

    public int getCount(String dbName)
    {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);
        int i = cursorCount.getCount();
        cursorCount.close();
        db.close();
        return i;
    }

    public ArrayList<Entry> getRepWeight(String dbName)
    {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);
        ArrayList<Entry> repWeight = new ArrayList<>();
        float out=0;
        int j = 0;
        String date = " ";

        if(cursorCount.moveToFirst())
        {
            System.out.println(cursorCount.getInt(0));

            date = cursorCount.getString(1);
            out = Float.valueOf(cursorCount.getString(2))*Float.valueOf(cursorCount.getString(3));

        }
        int i=2;
        while (i!=(cursorCount.getCount()+1)&&i<=cursorCount.getCount()+1)
        {
            if(cursorCount.moveToNext())
            {
                if (cursorCount.getString(1).equals(date))
                {
                    out = out + Float.valueOf(cursorCount.getString(2))*Float.valueOf(cursorCount.getString(3));
                }
                else
                {
                    date = cursorCount.getString(1);
                    repWeight.add(new Entry(out,j));
                    j++;
                    out = Float.valueOf(cursorCount.getString(2))*Float.valueOf(cursorCount.getString(3));
                }
                i++;
            }
            else repWeight.add(new Entry(out,j));
        }
        repWeight.add(new Entry(out,j));
        cursorCount.close();
        db.close();
        return repWeight;
    }

    public ArrayList<String> getDateList (String dbName)
    {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);
        ArrayList<String> dates = new ArrayList<String>();
        String temp = " ";


        if(cursorCount.moveToFirst())
        {

            temp=cursorCount.getString(1);
            dates.add(temp);
            System.out.println(temp);
        }
        int i=2;
        while (i!=(cursorCount.getCount()+1)&&i<=cursorCount.getCount()+1)
        {
            if(cursorCount.moveToNext())
            {
                if (!cursorCount.getString(1).equals(temp))
                {
                    temp=cursorCount.getString(1);
                    dates.add(temp);
                    System.out.println(temp);
                }
                i++;
            }
        }
        cursorCount.close();
        db.close();
        return dates;
    }

    public void organizeList(String dbName) {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);
        if(cursorCount.moveToFirst())
        {
            System.out.println(cursorCount.getInt(0));
            int temp = cursorCount.getInt(0);
            ContentValues values = new ContentValues();
            values.put("_id", 1);
            values.put("EXECNAME", cursorCount.getString(1));
            values.put("CLASSNAME", cursorCount.getString(2));
            db.update(dbName, values, "_id=" + temp, null);
        }
        int i=2;
        while (i!=(cursorCount.getCount()+1)&&i<=cursorCount.getCount()+1)
        {
            if(cursorCount.moveToNext())
            {
                System.out.println(cursorCount.getInt(0));
                int temp = cursorCount.getInt(0);
                ContentValues values = new ContentValues();
                values.put("_id", i);
                values.put("EXECNAME", cursorCount.getString(1));
                values.put("CLASSNAME", cursorCount.getString(2));
                db.update(dbName, values, "_id=" + temp, null);
                i++;
            }
        }
        cursorCount.close();
        db.close();
    }

    public boolean checkExercise(String name, String dbName)
    {
        String countQuery = "SELECT * FROM " + dbName;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCount = db.rawQuery(countQuery, null);
        if(cursorCount.moveToFirst())
        {
            System.out.println(cursorCount.getInt(0));
            if (cursorCount.getString(1).equals(name))
            {
                cursorCount.close();
                db.close();
                return false;
            }

        }
        int i=2;
        while (i!=(cursorCount.getCount()+1)&&i<=cursorCount.getCount()+1)
        {
            if(cursorCount.moveToNext())
            {
                if (cursorCount.getString(1).equals(name))
                {
                    cursorCount.close();
                    db.close();
                    return false;
                }
                i++;
            }
        }
        cursorCount.close();
        db.close();
        return true;
    }

}
