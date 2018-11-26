package com.mathiap.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView scoreViewA;
    TextView scoreViewB;
    Button oneA;
    Button twoA;
    Button threeA;
    Button fourA;
    Button sixA;
    Button outA;
    Button oneB;
    Button twoB;
    Button threeB;
    Button fourB;
    Button sixB;
    Button outB;
    Button reset;
    Team teamA;
    Team teamB;
    int ttlRunA = 0;
    int ttlRunB = 0;
    int ttlOutA = 0;
    int ttlOutB = 0;

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
        teamA = new Team();
        teamB = new Team();
        ttlRunA = 0;
        ttlRunB = 0;
        ttlOutA = 0;
        ttlOutB = 0;
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.oneRun1) {
            teamA.addScore(1);
        } else if (id == R.id.twoRun1) {
            teamA.addScore(2);
        } else if (id == R.id.threeRun1) {
            teamA.addScore(3);
        } else if (id == R.id.fourRun1) {
            teamA.addScore(4);
        } else if (id == R.id.sixRun1) {
            teamA.addScore(6);
        } else if (id == R.id.out1) {
            teamA.out();
        } else if (id == R.id.oneRun2) {
            teamB.addScore(1);
        } else if (id == R.id.twoRun2) {
            teamB.addScore(2);
        } else if (id == R.id.threeRun2) {
            teamB.addScore(3);
        } else if (id == R.id.fourRun2) {
            teamB.addScore(4);
        } else if (id == R.id.sixRun2) {
            teamB.addScore(6);
        } else if (id == R.id.out2) {
            teamB.out();
        } else if (id == R.id.reset) {
            teamA.reset();
            teamB.reset();
        }
        scoreViewA.setText(teamA.getScore());
        scoreViewB.setText(teamB.getScore());
    }
}
