package com.example.a3;

public class Geof {

    private int geofX, geofY, currentFrame, velocity;
    public static int maxFrame;

    public Geof(){
        geofX = AppConstants.SCREEN_WIDTH/2 - AppConstants.getBitmapBank().getGeofWidth()/2;
        geofY = AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank().getGeofHeight()/2;
        currentFrame = 0;
        maxFrame = 3;
        velocity = 0;
    }

    // Getter method for velocity
    public int getVelocity(){
        return velocity;
    }

    // Setter method for velocity
    public void setVelocity(int velocity){
        this.velocity = velocity;
    }


    // Getter method for getting X-coordinate of the Geof
    public int getX(){
        return geofX;
    }

    // Getter method for getting the Y-coordinate of the Geof
    public int getY(){
        return geofY;
    }


    // Setter method for setting the Y-coordinate
    public void setY(int geofY){
        this.geofY = geofY;
    }
}
