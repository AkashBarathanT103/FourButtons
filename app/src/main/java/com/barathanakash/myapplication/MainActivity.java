package com.barathanakash.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int a = 0;
    int b = 0;
    int c = 0;
    int d = 0;
    EditText ed;
    TextView tV;
    SeekBar sb;
    int seekValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView one = findViewById(R.id.text_view1);
        TextView two = findViewById(R.id.text_view2);
        TextView three = findViewById(R.id.text_view3);
        TextView four = findViewById(R.id.text_view4);

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);


        tV=findViewById(R.id.text_view1);
        sb=findViewById(R.id.seekBar);
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE);
        //SharedPreferences.Editor editor = sharedPreferences.edit();
        a=sharedPreferences.getInt("idTV1", a);
        b=sharedPreferences.getInt("idTV2", b);
        c=sharedPreferences.getInt("idTV3", c);
        d=sharedPreferences.getInt("idTV4", d);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekValue=progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                String temp = "Hello World!";
                tV.setText(temp);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tV.setTextSize(seekValue );
            }
        });

    }


    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences("Settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch(v.getId()){
            case R.id.text_view1:
                a+=1;
                editor.putInt("idTV1", a);
                editor.apply();
                int setting = sharedPreferences.getInt("idTV1", a);
                Toast.makeText(this, "Button 1 Clicked:"+" "+setting+" times", Toast.LENGTH_SHORT).show();


                break;
            case R.id.text_view2:

                b+=1;
                editor.putInt("idTV2", b);
                editor.apply();
                int setting1 = sharedPreferences.getInt("idTV2", b);

                Toast.makeText(this, "Button 2 Clicked"+" "+setting1+" times", Toast.LENGTH_SHORT).show();

                break;
            case R.id.text_view3:
                c+=1;
                editor.putInt("idTV3", c);
                editor.apply();
                int setting2 = sharedPreferences.getInt("idTV3", c);
                Toast.makeText(this, "Button 3 Clicked"+" "+setting2+" times", Toast.LENGTH_SHORT).show();

                break;
            case R.id.text_view4:
                d+=1;
                editor.putInt("idTV4", d);
                editor.apply();
                int setting3 = sharedPreferences.getInt("idTV4", d);
                Toast.makeText(this, "Button 4 Clicked"+" "+setting3+" times", Toast.LENGTH_SHORT).show();

                break;

        }


    }
}

