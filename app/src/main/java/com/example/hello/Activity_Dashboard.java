package com.example.hello;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.widget.Toast;

public class Activity_Dashboard extends AppCompatActivity {

     ImageView create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Button create = findViewById(R.id.btn_Create);

        create.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v){
                Toast.makeText(Activity_Dashboard.this, "added", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        /*
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_Dashboard.this, ActivityIntro.class);
                startActivity(intent);
            }
        });*/



    }

   /* private void initview (){
        create =  findViewById(R.id.btn_Create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }*/


}