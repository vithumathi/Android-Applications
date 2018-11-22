package com.mathiap.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView scoreViewA;
    TextView scoreViewB;
    Button oneA, twoA, threeA, fourA, sixA, outA, oneB, twoB, threeB, fourB, sixB, outB, reset;

    int ttlRunA = 0, ttlRunB = 0, ttlOutA = 0, ttlOutB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreViewA = (TextView) findViewById(R.id.scoreView1);
        scoreViewB = (TextView) findViewById(R.id.scoreView2);
        oneA = (Button) findViewById(R.id.oneRun1);
        twoA = (Button) findViewById(R.id.twoRun1);
        threeA = (Button) findViewById(R.id.threeRun1);
        fourA = (Button) findViewById(R.id.fourRun1);
        sixA = (Button) findViewById(R.id.sixRun1);
        outA = (Button) findViewById(R.id.out1);
        oneB = (Button) findViewById(R.id.oneRun2);
        twoB = (Button) findViewById(R.id.twoRun2);
        threeB = (Button) findViewById(R.id.threeRun2);
        fourB = (Button) findViewById(R.id.fourRun2);
        sixB = (Button) findViewById(R.id.sixRun1);
        outB = (Button) findViewById(R.id.out2);
        reset = (Button) findViewById(R.id.reset);
        int ttlRunA = 0, ttlRunB = 0, ttlOutA = 0, ttlOutB = 0;
    }

    public void displayScoreA(int ttlRunA, int ttlOutA) {
        scoreViewA.setText(ttlRunA + "/" + ttlOutA);
    }

    public void displayScoreB(int ttlRunB, int ttlOutB) {
        scoreViewB.setText(ttlRunB + "/" + ttlOutB);
    }

    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.oneRun1) {
            ttlRunA += 1;
            displayScoreA(ttlRunA, ttlOutA);
        } else if (id == R.id.twoRun1) {
            ttlRunA += 2;
            displayScoreA(ttlRunA, ttlOutA);
        } else if (id == R.id.threeRun1) {
            ttlRunA += 3;
            displayScoreA(ttlRunA, ttlOutA);
        } else if (id == R.id.fourRun1) {
            ttlRunA += 4;
            displayScoreA(ttlRunA, ttlOutA);
        } else if (id == R.id.sixRun1) {
            ttlRunA += 6;
            displayScoreA(ttlRunA, ttlOutA);
        } else if (id == R.id.out1) {
            ttlOutA += 1;
            displayScoreA(ttlRunA, ttlOutA);
        } else if (id == R.id.oneRun2) {
            ttlRunB += 1;
            displayScoreB(ttlRunB, ttlOutB);
        } else if (id == R.id.twoRun2) {
            ttlRunB += 2;
            displayScoreB(ttlRunB, ttlOutB);
        } else if (id == R.id.threeRun2) {
            ttlRunB += 3;
            displayScoreB(ttlRunB, ttlOutB);
        } else if (id == R.id.fourRun2) {
            ttlRunB += 4;
            displayScoreB(ttlRunB, ttlOutB);
        } else if (id == R.id.sixRun2) {
            ttlRunB += 6;
            displayScoreB(ttlRunB, ttlOutB);
        } else if (id == R.id.out2) {
            ttlOutB += 1;
            displayScoreB(ttlRunB, ttlOutB);
        } else if (id == R.id.reset){

            ttlRunA = 0;
            ttlOutA = 0;
            ttlRunB = 0;
            ttlOutB = 0;
            displayScoreA(ttlRunA, ttlOutA);
            displayScoreB(ttlRunB, ttlOutB);
        }


    }
}
