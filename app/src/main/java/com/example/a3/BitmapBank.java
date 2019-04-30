package com.example.a3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap geof;
    Bitmap[] tubeTop, tubeBottom;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.main_background);
        tubeTop = new Bitmap[4];
        tubeBottom = new Bitmap[4];
        geof = BitmapFactory.decodeResource(res, R.drawable.geof);
        tubeTop[0] = BitmapFactory.decodeResource(res, R.drawable.tube_top1);
        tubeTop[1] = BitmapFactory.decodeResource(res, R.drawable.tube_top2);
        tubeTop[2] = BitmapFactory.decodeResource(res, R.drawable.tube_top3);
        tubeTop[3] = BitmapFactory.decodeResource(res, R.drawable.tube_top4);
        tubeBottom[0] = BitmapFactory.decodeResource(res, R.drawable.tube_bottom1);
        tubeBottom[1] = BitmapFactory.decodeResource(res, R.drawable.tube_bottom2);
        tubeBottom[2] = BitmapFactory.decodeResource(res, R.drawable.tube_bottom3);
        tubeBottom[3] = BitmapFactory.decodeResource(res, R.drawable.tube_bottom4);
    }



    // Return Tube-Top Bitmap
    public Bitmap getTubeTop1(){
        return tubeTop[0];
    }
    public Bitmap getTubeTop2(){
        return tubeTop[1];
    }
    public Bitmap getTubeTop3(){
        return tubeTop[2];
    }
    public Bitmap getTubeTop4(){
        return tubeTop[3];
    }
    // Return Tube-Bottom Bitmap
    public Bitmap getTubeBottom1(){
        return tubeBottom[0];
    }
    public Bitmap getTubeBottom2(){
        return tubeBottom[1];
    }
    public Bitmap getTubeBottom3(){
        return tubeBottom[2];
    }
    public Bitmap getTubeBottom4(){
        return tubeBottom[3];
    }

    //Return Tube-width
    public int getTubeWidth(){
        return tubeTop[0].getWidth();
    }

    //Return Tube-height
    public int getTubeHeight(){
        return tubeTop[0].getHeight();
    }

    // Return geof bitmap of frame
    public Bitmap getGeof(){
        return geof;
    }

    public int getGeofWidth(){
        return geof.getWidth();
    }

    public int getGeofHeight(){
        return geof.getHeight();
    }

    //Return background bitmap
    public Bitmap getBackground(){
        return background;
    }

    //Return background width
    public int getBackgroundWidth(){
        return background.getWidth();
    }
}
