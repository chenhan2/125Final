package com.example.a3;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {

    static BitmapBank bitmapBank; // Bitmap object reference
    static GameEngine gameEngine; // GameEngine object reference
    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int gravity;
    static int VELOCITY_WHEN_JUMPED;
    static int gapBetweenTopAndBottomBricks;
    static int numberOfBricks;
    static int brickVelocity;
    static int minBrickOffsetY;
    static int maxBrickOffsetY;
    static int distanceBetweenBricks;
    static SoundBank soundBank;
    static Context gameActivityContext;

    public static void initialization(Context context){
        setScreenSize(context);
        bitmapBank = new BitmapBank(context.getResources());
        setGameConstants();
        gameEngine = new GameEngine();
        soundBank = new SoundBank(context);
    }

    public static SoundBank getSoundBank(){
        return soundBank;
    }

    public static void setGameConstants(){
        gravity = -3;
        VELOCITY_WHEN_JUMPED = 40;
        gapBetweenTopAndBottomBricks = 800;
        numberOfBricks = 4;
        brickVelocity = 18;
        minBrickOffsetY = (int)(gapBetweenTopAndBottomBricks / 2.0);
        maxBrickOffsetY = SCREEN_HEIGHT - minBrickOffsetY - gapBetweenTopAndBottomBricks;
        distanceBetweenBricks = SCREEN_WIDTH * 3 /4;
    }

    // Return BitmapBank instance
    public static BitmapBank getBitmapBank(){
        return bitmapBank;
    }

    // Return GameEngine instance
    public static GameEngine getGameEngine(){
        return gameEngine;
    }

    private static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;
    }

}
