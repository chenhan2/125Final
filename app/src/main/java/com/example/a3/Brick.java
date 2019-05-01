package com.example.a3;

import java.util.Random;

public class Brick {
    // tubeX = Brick X-coordinate, topTubeOffsetY = top tube bottom edge coordinate
    private int tubeX, topTubeOffsetY;
    private Random random;
    private int tubeWord;

    public Brick(int tubeX, int topTubeOffsetY){
        this.tubeX = tubeX;
        this.topTubeOffsetY = topTubeOffsetY;
        random = new Random();
    }

    public void setBrickWord(){
        tubeWord = random.nextInt(4);
    }

    public int getBrickWord(){
        return tubeWord;
    }

    public int getTopBrickOffsetY(){
        return topTubeOffsetY;
    }

    public int getBrickX(){
        return tubeX;
    }

    public int getTopBrickY(){
        return topTubeOffsetY - AppConstants.getBitmapBank().getBrickHeight();
    }

    public int getBottomBrickY(){
        return topTubeOffsetY + AppConstants.gapBetweenTopAndBottomBricks;
    }

    public void setBrickX(int tubeX){
        this.tubeX = tubeX;
    }

    public void setTopBrickOffsetY(int topTubeOffsetY){
        this.topTubeOffsetY = topTubeOffsetY;
    }
}
