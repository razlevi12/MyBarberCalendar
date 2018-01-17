package com.raz.app.mybarbercalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarActivity extends AppCompatActivity {

    Button btnOK;
    CalendarView calendarView;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public static GregorianCalendar date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        /////
        //Ref
        btnOK = findViewById(R.id.btnOK);
        calendarView = findViewById(R.id.simpleCalendarView);
        /////

        calendarView.setFirstDayOfWeek(1);


        final String currentDate = sdf.format(new Date(calendarView.getDate()));


        /////
        //Listeners
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                month = month + 1;

                System.out.println(currentDate);
                System.out.println("new " + dayOfMonth + "/" + month + "/" + year);

                date = new GregorianCalendar( year, month, dayOfMonth );
                String dateSTR = date.toString();
                Toast.makeText(getApplicationContext(), dateSTR,Toast.LENGTH_LONG).show();
            }
        });


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(CalendarActivity.this, MainActivity.class);
                myIntent.putExtra("date", date); //Optional parameters
                CalendarActivity.this.startActivity(myIntent);
            }
        });
        /////





    }
}
