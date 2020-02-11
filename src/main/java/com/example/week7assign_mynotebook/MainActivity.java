package com.example.week7assign_mynotebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    // Used to get the sent message from other activities.
    public static final String messageKey = "MESSAGE_KEY";

    // Objects to hold info from GUI elements
    private EditText inputText;
    private Switch darkModeSwitch;
    private ConstraintLayout cLayout;

    //Fields
    private String message = "";
    private int count = 0;


    // builds app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connects elements from GUI to backEnd code
        inputText = (EditText) findViewById(R.id.editText);
        darkModeSwitch = (Switch) findViewById(R.id.switch1);
        cLayout = (ConstraintLayout) findViewById(R.id.mainBackground);
    }

    // Gets String element from GUI and sends to M2A while changing page
    public void saveText(View view){
        message = inputText.getText().toString();
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        Log.i("Change Activity", "Went to M2A");
        Log.i("msg", message);
        intent.putExtra(messageKey, message);

        startActivity(intent);
    }

    // switches from background to dark mode
    public void darkMode(View view){
        if(darkModeSwitch.isChecked()){
            cLayout.setBackgroundColor(Color.DKGRAY);
        }else{
            cLayout.setBackgroundResource(R.drawable.p2);
        }
    }




}
