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
    protected double ttlScr;
    protected int correctAns = 0;
    protected int atmptQue = 0;
    protected int incAns = 0;
    protected int unAtmptQue = 0;
    protected static final int TOTAL_QUESTIONS = 5;
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
    TextView scoreCard;

    EditText queFourAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queOneGrp = (RadioGroup) findViewById(R.id.radioGroup1);
        queThreeGrp = (RadioGroup) findViewById(R.id.radioGroup3);
        queFiveGrp = (RadioGroup) findViewById(R.id.radioGroup5);

        scoreCard = (TextView) findViewById(R.id.scoreView);

        chcOne = (CheckBox) findViewById(R.id.q2c1);
        chcTwo = (CheckBox) findViewById(R.id.q2c2);
        chcThree = (CheckBox) findViewById(R.id.q2c3);
        chcFour = (CheckBox) findViewById(R.id.q2c4);

        queFourAns = (EditText) findViewById(R.id.q4);

    }

    public void setScoreCard() {
        ttlScr = (((double) correctAns / TOTAL_QUESTIONS) * 100);
        scoreCard.setText("Your score: " + ttlScr + "% You've attempted " + atmptQue + " out of the " + TOTAL_QUESTIONS + " questions. Unattempted question " + unAtmptQue);
        ttlScr = 0.0;
        atmptQue = 0;
        unAtmptQue = 0;
        correctAns = 0;
        incAns = 0;
    }

    public void onClick(View v) {
        int radioButtonId = queOneGrp.getCheckedRadioButtonId();

        if (radioButtonId == -1) {
            unAtmptQue++;
        } else {
            queOneBttn = (RadioButton) findViewById(radioButtonId);
            if (queOneBttn.getText().equals("Village")) {
                correctAns++;
                atmptQue++;
            } else {
                incAns++;
                atmptQue++;
            }
        }
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

        int radioButtonId1 = queThreeGrp.getCheckedRadioButtonId();
        if (radioButtonId1 == -1) {
            unAtmptQue++;
        } else {
            queThreeBttn = (RadioButton) findViewById(radioButtonId1);
            if (queThreeBttn.getText().equals("True")) {
                correctAns++;
                atmptQue++;
            } else {
                incAns++;
                atmptQue++;
            }
        }


        String ans = queFourAns.getText().toString().toLowerCase();

        if (ans.equals("nunavut")){
            correctAns++;
            atmptQue++;
        }else{
            incAns++;
            atmptQue++;
        }

        int radioButtonId2 = queFiveGrp.getCheckedRadioButtonId();
        if (radioButtonId2 == -1) {
            unAtmptQue++;
        } else {
            queFiveBttn = (RadioButton) findViewById(radioButtonId2);
            if (queFiveBttn.getText().equals("Five")) {
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
