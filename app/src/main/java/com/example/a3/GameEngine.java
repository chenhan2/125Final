package com.example.a3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {

    BackgroundImage backgroundImage;
    Geof geof;
    static int gameState;
    ArrayList<Tube> tubes;
    Random random;
    int score; // Stores the score
    int scoringTube; // Keeps track of scoring tube
    Paint scorePaint;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        geof = new Geof();
        // 0 = Not started
        //1 = Playing
        //2 = GameOver
        gameState = 0;
        tubes = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < AppConstants.numberOfTubes; i++) {
            int tubeX = AppConstants.SCREEN_WIDTH + i * AppConstants.distanceBetweenTubes;
            // Get topTubeOffsetY
            int topTubeOffsetY = AppConstants.minTubeOffsetY +
                    random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
            // Now create Tube objects
            Tube tube = new Tube(tubeX, topTubeOffsetY);
            tubes.add(tube);
        }
        score = 0;
        scoringTube = 0;
        scorePaint = new Paint();
        scorePaint.setColor(Color.RED);
        scorePaint.setTextSize(100);
        scorePaint.setTextAlign(Paint.Align.LEFT);
    }

    public void updateAndDrawTubes(Canvas canvas) {
        if (gameState == 1) {
            if ((tubes.get(scoringTube).getTubeX() < geof.getX() + AppConstants.getBitmapBank().getGeofWidth())
                    && (tubes.get(scoringTube).getTopTubeOffsetY() > geof.getY()
                    || tubes.get(scoringTube).getBottomTubeY() < (geof.getY() +
                    AppConstants.getBitmapBank().getGeofHeight()))) {
                // Go to GameOver screen
                gameState = 2;
                //Log.d("Game", "Over");
                AppConstants.getSoundBank().playHit();
                Context context = AppConstants.gameActivityContext;
                Intent intent = new Intent(context, GameOver.class);
                intent.putExtra("score", score);
                context.startActivity(intent);
                ((Activity) context).finish();
            } else if (tubes.get(scoringTube).getTubeX() < geof.getX() - AppConstants.getBitmapBank().getTubeWidth()) {
                score++;
                scoringTube++;
                if (scoringTube > AppConstants.numberOfTubes - 1) {
                    scoringTube = 0;
                }
                AppConstants.getSoundBank().playPoint();
            }
            for (int i = 0; i < AppConstants.numberOfTubes; i++) {
                if (tubes.get(i).getTubeX() < -AppConstants.getBitmapBank().getTubeWidth()) {
                    tubes.get(i).setTubeX(tubes.get(i).getTubeX() +
                            AppConstants.numberOfTubes * AppConstants.distanceBetweenTubes);
                    int topTubeOffsetY = AppConstants.minTubeOffsetY +
                            random.nextInt(AppConstants.maxTubeOffsetY - AppConstants.minTubeOffsetY + 1);
                    tubes.get(i).setTopTubeOffsetY(topTubeOffsetY);
                    tubes.get(i).setTubeWord();
                }
                tubes.get(i).setTubeX(tubes.get(i).getTubeX() - AppConstants.tubeVelocity);
                if (tubes.get(i).getTubeWord() == 0) {
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop1(), tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom1(), tubes.get(i).getTubeX(), tubes.get(i).getBottomTubeY(), null);
                } else if (tubes.get(i).getTubeWord() == 1) {
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop2(), tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom2(), tubes.get(i).getTubeX(), tubes.get(i).getBottomTubeY(), null);
                } else if (tubes.get(i).getTubeWord() == 2) {
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop3(), tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom3(), tubes.get(i).getTubeX(), tubes.get(i).getBottomTubeY(), null);
                } else if (tubes.get(i).getTubeWord() == 3) {
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeTop4(), tubes.get(i).getTubeX(), tubes.get(i).getTopTubeY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getTubeBottom4(), tubes.get(i).getTubeX(), tubes.get(i).getBottomTubeY(), null);
                }
            }
            canvas.drawText("Pt: " + score, 0, 110, scorePaint);
        }
    }

    public void updateAndDrawBackgroundImage(Canvas canvas) {
        backgroundImage.setX(backgroundImage.getX() - backgroundImage.getVelocity());
        if (backgroundImage.getX() < -AppConstants.getBitmapBank().getBackgroundWidth()) {
            backgroundImage.setX(0);
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX(), backgroundImage.getY(), null);
        if (backgroundImage.getX() < -(AppConstants.getBitmapBank().getBackgroundWidth() - AppConstants.SCREEN_WIDTH)) {
            canvas.drawBitmap(AppConstants.getBitmapBank().getBackground(), backgroundImage.getX() +
                    AppConstants.getBitmapBank().getBackgroundWidth(), backgroundImage.getY(), null);
        }
    }

    public void updateAndDrawGeof(Canvas canvas) {
        if (gameState == 1) {
            if (geof.getY() < (AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getGeofHeight()) || geof.getVelocity() < 0) {
                geof.setVelocity(geof.getVelocity() + AppConstants.gravity);
                geof.setY(geof.getY() + geof.getVelocity());
            }
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getGeof(), geof.getX(), geof.getY(), null);
    }
}
