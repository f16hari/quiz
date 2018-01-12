package com.h.h.aa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        int c=getIntent().getExtras().getInt("score");
        TextView t;
        t=(TextView) findViewById(R.id.textView2);
        t.setText(""+c);
        Toast.makeText(this,"QUIZ OVER",Toast.LENGTH_SHORT).show();
    }

}
