package com.mathiap.howcanadianareyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final int TOTAL_QUESTIONS = 5;
    static final String Q_ONE_ANS = "Village";
    static final String Q_THREE_ANS = "True";
    static final String Q_FOUR_ANS = "nunavut";
    static final String Q_FIVE_ANS = "Five";
    double ttlScr;
    int correctAns = 0;
    int atmptQue = 0;
    int incAns = 0;
    int unAtmptQue = 0;
    RadioGroup queOneGrp;
    RadioGroup queThreeGrp;
    RadioGroup queFiveGrp;
    RadioButton queOneBttn;
    RadioButton queThreeBttn;
    RadioButton queFiveBttn;
    CheckBox chcOne;
    CheckBox chcTwo;
    CheckBox chcThree;
    CheckBox chcFour;
    EditText queFourAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queOneGrp = (RadioGroup) findViewById(R.id.radioGroup1);
        queThreeGrp = (RadioGroup) findViewById(R.id.radioGroup3);
        queFiveGrp = (RadioGroup) findViewById(R.id.radioGroup5);
        chcOne = (CheckBox) findViewById(R.id.q2c1);
        chcTwo = (CheckBox) findViewById(R.id.q2c2);
        chcThree = (CheckBox) findViewById(R.id.q2c3);
        chcFour = (CheckBox) findViewById(R.id.q2c4);
        queFourAns = (EditText) findViewById(R.id.q4);
    }

    public void setScoreCard() {
        ttlScr = (((double) correctAns / TOTAL_QUESTIONS) * 100);
        String tstMsg = "Your score: " + ttlScr + "% You've attempted " + atmptQue + " out of the " + TOTAL_QUESTIONS + " questions. Unattempted question " + unAtmptQue + " .Incorrect answers: " + incAns;
        Toast.makeText(MainActivity.this, tstMsg,
                Toast.LENGTH_LONG).show();
        ttlScr = 0.0;
        atmptQue = 0;
        unAtmptQue = 0;
        correctAns = 0;
        incAns = 0;
    }

    public void onClick(View v) {
        // Logic of question 1
        int radioButtonId = queOneGrp.getCheckedRadioButtonId();
        if (radioButtonId == -1) {
            unAtmptQue++;
        } else {
            queOneBttn = (RadioButton) findViewById(radioButtonId);
            if (queOneBttn.getText().equals(Q_ONE_ANS)) {
                correctAns++;
                atmptQue++;
            } else {
                incAns++;
                atmptQue++;
            }
        }
        // Logic of question 2
        if (!chcOne.isChecked() && !chcTwo.isChecked() && !chcThree.isChecked() && !chcFour.isChecked()) {
            unAtmptQue++;
        } else {
            if (!chcOne.isChecked() && chcTwo.isChecked() && !chcThree.isChecked() && chcFour.isChecked()) {
                correctAns++;
                atmptQue++;
            } else {
                incAns++;
                atmptQue++;
            }
        }
        // Logic of question 3
        int radioButtonId1 = queThreeGrp.getCheckedRadioButtonId();
        if (radioButtonId1 == -1) {
            unAtmptQue++;
        } else {
            queThreeBttn = (RadioButton) findViewById(radioButtonId1);
            if (queThreeBttn.getText().equals(Q_THREE_ANS)) {
                correctAns++;
                atmptQue++;
            } else {
                incAns++;
                atmptQue++;
            }
        }
        // Logic of question 4
        String ans = queFourAns.getText().toString().toLowerCase();
        if (ans.equals("")) {
            unAtmptQue++;
        } else {
            if (ans.equals(Q_FOUR_ANS)) {
                correctAns++;
                atmptQue++;
            } else {
                incAns++;
                atmptQue++;
            }
        }
        // Logic of question 5
        int radioButtonId2 = queFiveGrp.getCheckedRadioButtonId();
        if (radioButtonId2 == -1) {
            unAtmptQue++;
        } else {
            queFiveBttn = (RadioButton) findViewById(radioButtonId2);
            if (queFiveBttn.getText().equals(Q_FIVE_ANS)) {
                correctAns++;
                atmptQue++;
            } else {
                incAns++;
                atmptQue++;
            }
        }
        setScoreCard();
    }
}
