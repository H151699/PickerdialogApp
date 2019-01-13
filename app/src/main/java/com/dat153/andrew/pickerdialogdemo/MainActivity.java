package com.dat153.andrew.pickerdialogdemo;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; // create TAG
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener; // date picker dialog

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayDate = (TextView)findViewById(R.id.theDate);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // create calendar object >> get current date
                Calendar cal = Calendar.getInstance();
                int y = cal.get(Calendar.YEAR);
                int m = cal.get(Calendar.MONTH);
                int d = cal.get(Calendar.DAY_OF_MONTH); // different days of month


                // create datepicker dialog obj
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Holo_Light_DarkActionBar,
                        mDateSetListener,
                        y, m, d);
                // make bg transparent
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;

                // Test print out
                // Log.d(TAG,"onDateSet: date: " + year + " " + month +" " + day);
                String date = day + "/"+ month +"/" + year;
                mDisplayDate.setText(date);

            }
        };//mDateSetListener



    }
}
