package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateResults(View view) {
        EditText weightPounds = (EditText) findViewById(R.id.userWeight);
        EditText heightFeet = (EditText) findViewById(R.id.userFeet);
        EditText heightInches = (EditText) findViewById(R.id.userInches);
        Double weight = Double.parseDouble(weightPounds.getText().toString());
        Double heightFt = Double.parseDouble(heightFeet.getText().toString());
        Double heightIn = Double.parseDouble(heightInches.getText().toString());
        Double bmi = 0.0;
        Double inches = heightFt * 12;
        inches += heightIn;
        bmi = weight / Math.pow(inches, 2) * 703;
        String message = findMessage(bmi);
        String improve = improveMessage(message);
        TextView result = (TextView) findViewById(R.id.results);
        result.setText("Your Body Mass Index is " + String.format("%.2f", bmi) +". " + message + improve);
        changeImage(message);
    }


    public String findMessage(Double bmi) {
        String message = "";
        if(bmi < 18.5) {
            message = "You are underweight. ";
        } else if(bmi >= 18.5 && bmi < 25) {
            message = "You are normal weight. ";
        } else if(bmi >= 25 && bmi < 30) {
            message = "You are overweight. ";
        } else if(bmi >= 30) {
            message = "You are obese. ";
        }
        return message;
    }

    public String improveMessage(String message) {
        String improve = "";
        if(message.contains("underweight")) {
            improve = "In order to improve your BMI, try adding healthy calories to your diet, " +
                    "like nuts, cheese, and healthy side dishes.";
        } else if(message.contains("normal")) {
            improve = "In order to maintain your BMI, eat a well-balanced, calorie-dense diet and" +
                    " exercise frequently.";
        } else if(message.contains("overweight")) {
            improve = "In order to improve your BMI, try reducing how many calories you eat. Avoid " +
                    "high sugar foods and snacks, and exercise more frequently.";
        } else if(message.contains("obese")) {
            improve = "In order to improve your BMI, try reducing the number of calories you consume. " +
                    "Additionally, consider consulting a doctor.";
        }
        return improve;
    }

    public void changeImage(String message) {
        ImageView image = (ImageView)findViewById(R.id.imageIcon);
        if(message.contains("underweight")) {
            image.setImageResource(R.drawable.cheese);
        } else if(message.contains("normal")) {
            image.setImageResource(R.drawable.healthy);
        } else if(message.contains("overweight")) {
            image.setImageResource(R.drawable.sugar);
        } else if(message.contains("obese")) {
            image.setImageResource(R.drawable.exercise);
        }
    }


}
