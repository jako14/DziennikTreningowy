package com.example.jakub.dzienniktreningowy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * Created by Jakub on 2016-06-13.
 */
public class CustomListView extends BaseAdapter {

    String[] mDate;
    String[] mReps;
    String[] mWeight;
    Context context;
    private static LayoutInflater inflater=null;

    public CustomListView(ExeActivity exeActivity, String[] date, String[] reps, String[] weight)
    {
        mDate = date;
        context = exeActivity;
        mReps = reps;
        mWeight = weight;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return mDate.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv1;
        TextView tv2;
        TextView tv3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_layout, null);
        holder.tv1 = (TextView) rowView.findViewById(R.id.listTV1);
        holder.tv2 = (TextView) rowView.findViewById(R.id.listTV2);
        holder.tv3 = (TextView) rowView.findViewById(R.id.listTV3);

        holder.tv1.setText(mDate[position]);
        holder.tv2.setText(mReps[position]);
        holder.tv3.setText(mWeight[position]);

        rowView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, "You Clicked ", Toast.LENGTH_LONG).show();
                return true;
            }
        });


        return rowView;
    }
}