package src;
import java.awt.*;
import java.util.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.lang.Math;
/**
 * Write a description of class SetFrame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SetFrame implements ActionListener
{
    private final int HEIGHT = 500;
    private final int WIDTH = 500;
    ArrayList<Point> points = new ArrayList<Point>();
    Ellipse[] particles;
    private final int PARTICLE_SIZE = 10;
    private int delay = 0;
    private int initDelay = 5000;
    Random generator;
    private int sizeOfWindow = 650;
    
    /**
     * Constructor for objects of class SetFrame
     */
    public SetFrame(int number)
    {        
        generator = new Random();
        Timer time = new Timer(delay, this);
        time.setInitialDelay(initDelay);
        particles = new Ellipse[number];
        for(int i = 0; i < number; i++)
        {
            int xPos = generator.nextInt(sizeOfWindow - 9);
            int yPos = generator.nextInt(sizeOfWindow - 9);
            points.add(new Point(xPos,yPos));
        }
        for(int i = 0; i < number; i++)
        {
            int xDirect = generator.nextInt(3) - 1;
            int yDirect = generator.nextInt(3) - 1;
            particles[i] = new Ellipse(points.get(i).getX(), points.get(i).getY(), 
                PARTICLE_SIZE, PARTICLE_SIZE, xDirect, yDirect);
        }
        for(Ellipse e : particles)
        {
            if(e.getX() > sizeOfWindow / 2)
            {
                e.setColor(new Color(0, 255, 0));
            }
            e.fill();
        }    
        time.start();
    }

    public void actionPerformed(ActionEvent evt)
    {
        int counter = 0;
        for (Ellipse e : particles)
        {
            getDistance(e,counter);
            e.translate(e.getXDirection(),e.getYDirection());
            if (e.getX() > sizeOfWindow - 10 || e.getX() < 0)
            {
                if(e.getX() > sizeOfWindow - 10){e.xDirection = -1;}
                else{e.xDirection = 1;}
            }
            if (e.getY() < 0 || e.getY() > sizeOfWindow - 10)
            {
                if(e.getY() > sizeOfWindow - 10){e.yDirection = -1;}
                else{e.yDirection = 1;}
            }
            counter++;
        }
    }    
    /**
    * An example of a method - replace this comment with your own
    * 
    * @param  y   a sample parameter for a method
    * @return     the sum of x and y 
    */
    private void getDistance(Ellipse e, int counter)
    {
        for (int i = 0; i < particles.length; i++)
        {
            if (i == counter)
            {
                
            }
            else
            {
                if(10 >= Math.abs(Math.sqrt(Math.pow(particles[i].getX() - e.getX(),2) 
                            + Math.pow(particles[i].getY() - e.getY(),2))))
                {
                    changeXDirection(i,counter);
                    changeYDirection(i,counter);  
                }
            }
        }
    }    
    
    private void changeXDirection(int one, int two)
    {
        Ellipse i = particles[one];
        Ellipse j = particles[two];
        int iXDir = i.getXDirection();
        int jXDir = j.getXDirection();
        
        if(iXDir == 0 && jXDir == 0)
        {
            if(i.getX() < j.getX())
            {
                i.xDirection = -1;
                j.xDirection = 1;
            }
            else
            {
                i.xDirection = 1;
                j.xDirection = -1;
            }
        }
        
        else if (iXDir == 1 || jXDir == 1)
        {
            if(iXDir == 1 && jXDir == 0)
            {
                i.xDirection = 0;
                j.xDirection = 1;
            }
            else if(iXDir == 0 && jXDir == 1)
            {
                i.xDirection = 1;
                i.xDirection = 0;
            }
            else if(iXDir == 1 && jXDir == 1)
            {
            }
            else
            {
                i.xDirection = 0;
                j.xDirection = 0;
            }
        }
        
        else
        {
            if(iXDir == -1 && jXDir == 0)
            {
                i.xDirection = 0;
                j.xDirection = -1;
            }
            else if(iXDir == 0 && jXDir == -1)
            {
                i.xDirection = -1;
                j.xDirection = 0;
            }
            else if(iXDir == -1 && jXDir == -1)
            {
            }
            else
            {
                i.xDirection = 0;
                j.xDirection = 0;
            }
        }
    }
    
    private void changeYDirection(int one, int two)
    {
        Ellipse i = particles[one];
        Ellipse j = particles[two];
        int iYDir = i.getYDirection();
        int jYDir = j.getYDirection();
        
        if(iYDir == 0 && jYDir == 0)
        {
            if(i.getY() < j.getY())
            {
                i.yDirection = -1;
                j.yDirection = 1;
            }
            else
            {
                i.yDirection = 1;
                j.yDirection = -1;
            }
        }
        
        else if (iYDir == 1 || jYDir == 1)
        {
            if(iYDir == 1 && jYDir == 0)
            {
                i.yDirection = 0;
                j.yDirection = 1;
            }
            else if(iYDir == 0 && jYDir == 1)
            {
                i.yDirection = 1;
                i.yDirection = 0;
            }
            else if(iYDir == 1 && jYDir == 1)
            {
            }
            else
            {
                i.yDirection = 0;
                j.yDirection = 0;
            }
        }
        
        else
        {
            if(iYDir == -1 && jYDir == 0)
            {
                i.yDirection = 0;
                j.yDirection = -1;
            }
            else if(iYDir == 0 && jYDir == -1)
            {
                i.yDirection = -1;
                j.yDirection = 0;
            }
            else if(iYDir == -1 && jYDir == -1)
            {
            }
            else
            {
                i.yDirection = 0;
                j.yDirection = 0;
            }
        }
    }
}
