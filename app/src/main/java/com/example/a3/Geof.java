package com.example.a3;

public class Geof {

    private int geofX, geofY, velocity;

    public Geof(){
        geofX = AppConstants.SCREEN_WIDTH/2 - AppConstants.getBitmapBank().getGeofWidth()/2;
        geofY = AppConstants.SCREEN_HEIGHT/2 - AppConstants.getBitmapBank().getGeofHeight()/2;
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
