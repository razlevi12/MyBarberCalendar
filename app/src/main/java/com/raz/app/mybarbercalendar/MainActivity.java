package com.raz.app.mybarbercalendar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle, tvQueueStatus, tvTimeLeft;

    Button btnOrder, btnAlarm;

    String userName = "Raz";
    String date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String intentDate = intent.getStringExtra("date");

        /////
        //Ref
        tvTitle = findViewById(R.id.tvTitle);
        tvQueueStatus = findViewById(R.id.tvQueueStatus);
        tvTimeLeft = findViewById(R.id.tvTimeLeft);

        btnOrder = findViewById(R.id.btnOrder);
        btnAlarm = findViewById(R.id.btnAlarm);
        /////

        /////
        //Listener
        btnOrder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent myIntent = new Intent(MainActivity.this, CalendarActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        btnAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO make timer
            }
        });
        /////

        tvTitle.setText("Welcome, " + userName);

        if(intentDate == null){
            tvQueueStatus.setText("Select Date");
        }else{
            tvQueueStatus.setText(intentDate.toString());
        }




    }


}
