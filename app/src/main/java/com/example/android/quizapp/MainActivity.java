package com.example.android.quizapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // MARK: - Properties
    TextView titleTextView;
    TextView question1TextView;
    TextView question2TextView;
    TextView question3TextView;
    TextView question4TextView;
    TextView question5TextView;
    TextView question6TextView;
    EditText question1EditText;
    EditText question3EditText;
    EditText question6EditText;
    RadioGroup question2RadioGroup;
    RadioGroup question5RadioGroup;
    Button validateButton;
    String question1Answer = "10/22/08";
    String question2Answer = "HTC Dream";
    String question3Answer = "Andy Rubin";
    String question4Answer = "Pixel 3 and Pixel 3 XL";
    String question5Answer = "Pie";
    String question6Answer = "9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTextView = findViewById(R.id.title);
        question1TextView = findViewById(R.id.question1Title);
        question2TextView = findViewById(R.id.question2Title);
        question3TextView = findViewById(R.id.question3Title);
        question4TextView = findViewById(R.id.question4Title);
        question5TextView = findViewById(R.id.question5Title);
        question6TextView = findViewById(R.id.question6Title);
        question1EditText = findViewById(R.id.question1Response);
        question2RadioGroup = findViewById(R.id.question2RadioGroup);
        question3EditText = findViewById(R.id.question3Response);
        question6EditText = findViewById(R.id.question6Response);
        validateButton = findViewById(R.id.validate);
        titleTextView.setText(getString(R.string.app_title));
        question1TextView.setText("When was the first Android phone released?");
        question2TextView.setText("What was the first Android phone model?");
        question3TextView.setText("Who was the creator of Android?");
        question4TextView.setText("What are Google’s most recently released Android Phones?");
        question5TextView.setText("What is the most current version of the Android operating system?");
        question6TextView.setText("What version number is the current version of the android OS?");
        validateButton.setText("Check your answers!");

        setupViews();
    }

    // MARK: - Setup
    private void setupViews() {
        setupQuestion2();
    }

    private void setupQuestion2() {
        for (int i = 0; i <  question2RadioGroup.getChildCount(); i++) {
            String textToSet = "";
            if (i == 0) {
                textToSet = getString(R.string.question2_choice1);
            } else if (i == 1) {
                textToSet = getString(R.string.question2_choice2);
            } else if (i == 2) {
                textToSet = getString(R.string.question2_choice3);
            } else if (i == 3) {
                textToSet = getString(R.string.question2_choice4);
            }
            ((RadioButton) question2RadioGroup.getChildAt(i)).setText(textToSet);
        }
    }

    // MARK: - Actions
    public void validateAnswers(View v) {
        dismissKeyboard();
        validateQuestion1();
        validateQuestion2();
        validateQuestion3();
//        validateQuestion4();
//        validateQuestion5();
//        validateQuestion6();
    }

    private void dismissKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(question1EditText.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(question3EditText.getWindowToken(), 0);
        imm.hideSoftInputFromWindow(question6EditText.getWindowToken(), 0);
    }

    private void validateQuestion1() {
        if (question1EditText.getText().toString().equals(question1Answer)) {
            question1EditText.setBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            question1EditText.setBackgroundColor(Color.parseColor("#B00020"));
        }
    }

    private void validateQuestion2() {
        int selectedRadioButtonID = question2RadioGroup.getCheckedRadioButtonId();
        RadioButton selectedRadioButton = findViewById(selectedRadioButtonID);
        if (selectedRadioButton.getText().equals(question2Answer)) {
            question2RadioGroup.setBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            question2RadioGroup.setBackgroundColor(Color.parseColor("#B00020"));
        }
    }

    private void validateQuestion3() {
        if (question3EditText.getText().toString().equals(question3Answer)) {
            question3EditText.setBackgroundColor(Color.parseColor("#4CAF50"));
        } else {
            question3EditText.setBackgroundColor(Color.parseColor("#B00020"));
        }
    }

    private void validateQuestion4() {

    }

    private void validateQuestion5() {

    }

    private void validateQuestion6() {

    }
}
