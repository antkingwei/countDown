
package com.example.countdownapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends Activity {
    
    Button startButton;
    EditText minuteText;
    EditText secondText;
    int minute;
    int second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        startButton = (Button)findViewById(R.id.buttton_start);
        minuteText = (EditText)this.findViewById(R.id.minute);
        secondText = (EditText)this.findViewById(R.id.second);
        
        startButton.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(!minuteText.getText().toString().equals("")){
                    minute= Integer.parseInt(minuteText.getText().toString());
                }
                if(!secondText.getText().toString().equals("")){
                    second = Integer.parseInt(secondText.getText().toString());
                }
                
                if(minute !=0||second !=0){
                    System.out.println(minute+":"+second);
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(minute);
                    list.add(second);
                    
                    Intent intent = new Intent(MainActivity.this,StartActivity.class);
//                    intent.setAction("com.example.countdownapp.StartActivity");
                    intent.putIntegerArrayListExtra("times", list);
                    startActivity(intent);
                }
                
            }
        });
    }
    @Override
    protected void onResume(){
        minute = 0;
        second = 0;
        super.onResume();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

