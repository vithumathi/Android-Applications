package com.mathiap.scorekeeper;

/**
 * This class represent a team and its score
 * Created by Vithu on 2018-11-26.
 */

public class Team {

    // State
    int ttlScore;
    int ttlOut;

    // Constructor
    public Team(){
        this.ttlScore = 0;
        this.ttlOut = 0;
    }

    // Methods
    public int getTtlScore() {
        return ttlScore;
    }

    public void addScore(int score) {
        this.ttlScore += score;
    }

    public int getTtlOut() {
        return ttlOut;
    }

    public void out() {
        this.ttlOut += 1;
    }

    public void reset(){
        this.ttlScore = 0;
        this.ttlOut = 0;
    }

    public String getScore(){
        return ttlScore + "/" + ttlOut;
    }
}
