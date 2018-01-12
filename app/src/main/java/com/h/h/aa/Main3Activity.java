package com.h.h.aa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    private Button showa;
    private Boolean b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        b=getIntent().getExtras().getBoolean("answer");
        showa=(Button) findViewById(R.id.button);
        showa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main3Activity.this,b.toString(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
