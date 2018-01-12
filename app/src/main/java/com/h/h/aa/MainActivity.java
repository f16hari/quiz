package com.h.h.aa;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private Button truebutton;
    private Button falsebutton;
    private Button nextbutton;
    private Button previousbutton;
    private Button showbutton;
    private TextView qtv;
    private ViewFlipper vf;
    private question[] qb=new question[]{new question(R.string.q1,true),new question(R.string.q2,false),new question(R.string.q3,true)};
    private int c=0;
    private int count=0;
    private int score=0;
    private static final String key="index";
    private static final String key2="score";
    private static final String key3="count";


    public void checkans(boolean x) {
        boolean a = qb[c].isAnswerTrue();
        if (x == a) {
            Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();
            c = (c + 1) % qb.length;
            int q1 = qb[c].getTextResId();
            qtv.setText(q1);
            vf.showNext();
            score++;
        } else {
            Toast.makeText(this, "INCORRECT", Toast.LENGTH_SHORT).show();
            c = (c + 1) % qb.length;
            int q1 = qb[c].getTextResId();
            qtv.setText(q1);
            vf.showNext();

        }
    }
    public void updatequestion(int x)
    {
        int q1=qb[x].getTextResId();
        qtv.setText(q1);

    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d("TAG", "onStart() called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d("TAG", "onPause() called");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d("TAG", "onResume() called");
    }
    @Override
    public void onStop() {
        super.onStop();
        Log.d("TAG", "onStop() called");
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("TAG", "onDestroy() called");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.d("TAG","on create(Bundle) called");


        truebutton=(Button) findViewById(R.id.true_button);
        falsebutton=(Button) findViewById(R.id.false_button);
        previousbutton=(Button)findViewById(R.id.prev_button);
        showbutton=(Button)findViewById(R.id.show_button);
        qtv=(TextView) findViewById(R.id.questionv);
        vf=(ViewFlipper)findViewById(R.id.view);





        truebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkans(true);
                count++;
                if(count==3) {
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("score", score);
                    startActivity(i);
                    count=0;
                    score=0;

                }




            }

        });
        falsebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkans(false);
                count++;
                if(count==3) {
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);
                    i.putExtra("score", score);
                    startActivity(i);
                    count=0;
                    score=0;
                }

            }
        });
        nextbutton=(Button) findViewById(R.id.next_button);
        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c=(c+1)%qb.length;
                updatequestion(c);
                vf.showNext();
            }
        });
        previousbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(c==0)
                    c=qb.length;
                c=(c-1)%qb.length;
                updatequestion(c);
                vf.showPrevious();
            }
        });
        showbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                boolean a = qb[c].isAnswerTrue();
                intent.putExtra("answer",a);
                startActivity(intent);

            }
        });
        if(savedInstanceState!=null)
        {
            c=savedInstanceState.getInt(key,0);
            score=savedInstanceState.getInt(key2,0);
            count=savedInstanceState.getInt(key3,0);
            for(int i=0;i<c;i++)
            {
                vf.showNext();
            }

        }
        updatequestion(c);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i("TAG", "onsavedinstance");
        savedInstanceState.putInt(key, c);
        savedInstanceState.putInt(key2,score);
        savedInstanceState.putInt(key3,count);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
