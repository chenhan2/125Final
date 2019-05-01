package com.example.a3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background;
    Bitmap geof;
    Bitmap[] brickTop, brickBottom;

    public BitmapBank(Resources res) {
        background = BitmapFactory.decodeResource(res, R.drawable.main_background);
        brickTop = new Bitmap[4];
        brickBottom = new Bitmap[4];
        geof = BitmapFactory.decodeResource(res, R.drawable.geof);
        brickTop[0] = BitmapFactory.decodeResource(res, R.drawable.tube_top1);
        brickTop[1] = BitmapFactory.decodeResource(res, R.drawable.tube_top2);
        brickTop[2] = BitmapFactory.decodeResource(res, R.drawable.tube_top3);
        brickTop[3] = BitmapFactory.decodeResource(res, R.drawable.tube_top4);
        brickBottom[0] = BitmapFactory.decodeResource(res, R.drawable.tube_bottom1);
        brickBottom[1] = BitmapFactory.decodeResource(res, R.drawable.tube_bottom2);
        brickBottom[2] = BitmapFactory.decodeResource(res, R.drawable.tube_bottom3);
        brickBottom[3] = BitmapFactory.decodeResource(res, R.drawable.tube_bottom4);
    }



    // Return Brick-Top Bitmap
    public Bitmap getBrickTop1(){
        return brickTop[0];
    }
    public Bitmap getBrickTop2(){
        return brickTop[1];
    }
    public Bitmap getBrickTop3(){
        return brickTop[2];
    }
    public Bitmap getBrickTop4(){
        return brickTop[3];
    }
    // Return Brick-Bottom Bitmap
    public Bitmap getBrickBottom1(){
        return brickBottom[0];
    }
    public Bitmap getBrickBottom2(){
        return brickBottom[1];
    }
    public Bitmap getBrickBottom3(){
        return brickBottom[2];
    }
    public Bitmap getBrickBottom4(){
        return brickBottom[3];
    }

    //Return Brick-width
    public int getBrickWidth(){
        return brickTop[0].getWidth();
    }

    //Return Brick-height
    public int getBrickHeight(){
        return brickTop[0].getHeight();
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
