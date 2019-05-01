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
    ArrayList<Brick> bricks;
    Random random;
    int score; // Stores the score
    int scoringBrick; // Keeps track of scoring brick
    Paint scorePaint;

    public GameEngine() {
        backgroundImage = new BackgroundImage();
        geof = new Geof();
        // 0 = Not started
        //1 = Playing
        //2 = GameOver
        gameState = 0;
        bricks = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < AppConstants.numberOfBricks; i++) {
            int brickX = AppConstants.SCREEN_WIDTH + i * AppConstants.distanceBetweenBricks;
            // Get topBrickOffsetY
            int topBrickOffsetY = AppConstants.minBrickOffsetY +
                    random.nextInt(AppConstants.maxBrickOffsetY - AppConstants.minBrickOffsetY + 1);
            // Now create Brick objects
            Brick brick = new Brick(brickX, topBrickOffsetY);
            bricks.add(brick);
        }
        score = 0;
        scoringBrick = 0;
        scorePaint = new Paint();
        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(100);
        scorePaint.setTextAlign(Paint.Align.LEFT);
    }

    public void updateAndDrawBricks(Canvas canvas) {
        if (gameState == 1) {
            if ((bricks.get(scoringBrick).getBrickX() < geof.getX() + AppConstants.getBitmapBank().getGeofWidth())
                    && (bricks.get(scoringBrick).getTopBrickOffsetY() > geof.getY()
                    || bricks.get(scoringBrick).getBottomBrickY() < (geof.getY() +
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
            } else if (bricks.get(scoringBrick).getBrickX() < geof.getX() - AppConstants.getBitmapBank().getBrickWidth()) {
                score++;
                scoringBrick++;
                if (scoringBrick > AppConstants.numberOfBricks - 1) {
                    scoringBrick = 0;
                }
                AppConstants.getSoundBank().playPoint();
            }
            for (int i = 0; i < AppConstants.numberOfBricks; i++) {
                if (bricks.get(i).getBrickX() < -AppConstants.getBitmapBank().getBrickWidth()) {
                    bricks.get(i).setBrickX(bricks.get(i).getBrickX() +
                            AppConstants.numberOfBricks * AppConstants.distanceBetweenBricks);
                    int topBrickOffsetY = AppConstants.minBrickOffsetY +
                            random.nextInt(AppConstants.maxBrickOffsetY - AppConstants.minBrickOffsetY + 1);
                    bricks.get(i).setTopBrickOffsetY(topBrickOffsetY);
                    bricks.get(i).setBrickWord();
                }
                bricks.get(i).setBrickX(bricks.get(i).getBrickX() - AppConstants.brickVelocity);
                if (bricks.get(i).getBrickWord() == 0) {
                    canvas.drawBitmap(AppConstants.getBitmapBank().getBrickTop1(), bricks.get(i).getBrickX(), bricks.get(i).getTopBrickY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getBrickBottom1(), bricks.get(i).getBrickX(), bricks.get(i).getBottomBrickY(), null);
                } else if (bricks.get(i).getBrickWord() == 1) {
                    canvas.drawBitmap(AppConstants.getBitmapBank().getBrickTop2(), bricks.get(i).getBrickX(), bricks.get(i).getTopBrickY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getBrickBottom2(), bricks.get(i).getBrickX(), bricks.get(i).getBottomBrickY(), null);
                } else if (bricks.get(i).getBrickWord() == 2) {
                    canvas.drawBitmap(AppConstants.getBitmapBank().getBrickTop3(), bricks.get(i).getBrickX(), bricks.get(i).getTopBrickY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getBrickBottom3(), bricks.get(i).getBrickX(), bricks.get(i).getBottomBrickY(), null);
                } else if (bricks.get(i).getBrickWord() == 3) {
                    canvas.drawBitmap(AppConstants.getBitmapBank().getBrickTop4(), bricks.get(i).getBrickX(), bricks.get(i).getTopBrickY(), null);
                    canvas.drawBitmap(AppConstants.getBitmapBank().getBrickBottom4(), bricks.get(i).getBrickX(), bricks.get(i).getBottomBrickY(), null);
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
