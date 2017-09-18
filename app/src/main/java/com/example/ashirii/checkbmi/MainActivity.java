package com.example.ashirii.checkbmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //This method responds when the user clicks on the result button
    //
    public void calculateBMI (View view){
        //This gets the user input from the weight field
        EditText weightFilled = (EditText) findViewById(R.id.weight_value);
        String weightGiven = weightFilled.getText().toString();
        int weightValue = Integer.parseInt(weightGiven);
        //This gets the user input from the height field
        EditText heightFilled = (EditText) findViewById(R.id.height_value);
        String heightGiven = heightFilled.getText().toString();
        int heightValue = Integer.parseInt(heightGiven);
        //This does the arithmetic calculation from the information provided...
        //....by the user
        double heightValueSquare = Math.pow(heightValue, 2.0);
        int heightValue1 = (int)heightValueSquare;
        int answer = weightValue/heightValue1;
        String answer1 = Integer.toString(answer);
        String answer2 = checkStatus(answer) + ':' + answer1;
        displayResult(answer2);
    }
    //This method check compares the value of a user BMI to the standard BMI Values
    private String checkStatus(int answerToBeChecked){
        if (answerToBeChecked >= 15 && answerToBeChecked <= 19){
            return "Your Weight is NORMAL";
        }
        else if (answerToBeChecked >=20 && answerToBeChecked <= 25){
            return "You are OVERWEIGHT";
        }
        else if (answerToBeChecked >=26){
            return "You are OBESE";
        }
        else{
            return "You weight is less than NORMAL";
        }
    }
    //This is a display method.
    //It displays the result of the BMI calculation to the user
    private void displayResult(String answer) {
        TextView resultView = (TextView) findViewById(R.id.result_value);
        resultView.setText(answer);
    }


}
