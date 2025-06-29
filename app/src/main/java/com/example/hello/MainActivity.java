package com.example.hello;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import java.lang.Object;
//import java.util.logging.Handler;
import android.os.Handler;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onClick(View v){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this,Slide1.class));
                finish();
            }
        },3000);

    }


}