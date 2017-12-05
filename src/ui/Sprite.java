package ui;

import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;

public class Sprite
{
    private Image image;
    private double ppX;
    private double ppY;  
    private double positionX;
    private double positionY; 
    private double prevX;
    private double prevY;    
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;
    private int speed;
    
    public Sprite()
    {
    	ppX = 0;
    	ppY = 0;
    	prevX = 0;
    	prevY = 0;
        positionX = 0;
        positionY = 0;    
        velocityX = 0;
        velocityY = 0;
    }

    public void setImage(Image i)
    {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    public void setImage(String filename)
    {
        Image i = new Image(filename);
        setImage(i);
    }

    public void setPosition(double x, double y)
    {	
    	
    	if((x<0 || x>1200) || (y<0 || y>800)) {return;}
        positionX = x;
        positionY = y;
    }

    public void setVelocity(double x, double y)
    {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y)
    {
        velocityX += x;
        velocityY += y;
    }
    
    public void setSpeed(int s) {this.speed = s;}
    public int getSpeed() {return this.speed;}

    public void update(double time)
    {
    	ppX = prevX;
    	ppY = prevY;
    	prevX = positionX;
    	prevY = positionY;
        positionX += velocityX * time;
        positionY += velocityY * time;
    }
    
    public void rebound() {
    	setVelocity(0,0);
    	setPosition(ppX,ppY);
    }

    public void render(GraphicsContext gc)
    {
        gc.drawImage( image, positionX, positionY );
    }

    public Rectangle2D getBoundary()
    {
        return new Rectangle2D(positionX,positionY,width,height);
    }

    public boolean intersects(Sprite s)
    {
        return s.getBoundary().intersects( this.getBoundary() );
    }
    
    public String toString()
    {
        return " Position: [" + positionX + "," + positionY + "]" 
        + " Velocity: [" + velocityX + "," + velocityY + "]";
    }
}