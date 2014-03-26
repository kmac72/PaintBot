/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbot;

import java.lang.Math;

/**
 *
 * @author Brian
 */
public class Kinematics {
    
    public final int base_x = 228;
    public final int base_y = 500;
    
    public double a1_x;
    public double a1_y;
    public double a2_x;
    public double a2_y;
    public double a3_x;
    public double a3_y;
    public double a4_x;
    public double a4_y;
    
    public double a2_th;
    public double a3_th;
    public double d1;
    
    public double alpha;
    
    /**
     * Set all axis coordinates to default positions
     */
    public Kinematics(){
        a1_x = base_x;
        a1_y = base_y;
        a2_x = a1_x;
        a2_y = a1_y - 150;
        a3_x = a2_x + 100;
        a3_y = a2_y;
        a4_x = a3_x;
        a4_y = a3_y + 75;
        a2_th = -90;
        a3_th = -90;
        d1 = 0;
    }
    
    /**
     * 
     * @param positive if axis 1 should slide in the positive direction
     */
    public void axis1_slide(boolean positive){
        
        int d1_change;
        
        if(positive == true && d1 < 300) {
            d1 = d1 + 1;
            d1_change = 1;
        } else if (positive == false && d1 > 0) {
            d1 = d1 - 1;
            d1_change = -1;
        }
        else
        {
            d1_change = 0;
        }
        
        a1_x = a1_x + d1_change;
        a2_x = a2_x + d1_change;
        a3_x = a3_x + d1_change;
        a4_x = a4_x + d1_change;  
    }
    
    /**
     * 
     * @param positive if axis 2 should rotate in the positive direction
     */
    public void axis2_rotate(boolean positive){
        
        if(positive == true)
            a2_th = a2_th + 1;  
        else
            a2_th = a2_th - 1;

        //Y has inversed values due to coordinate system of the frame
        a3_y = -100 * Math.cos(a2_th * (Math.PI/180)) - 150 + base_y;
        a3_x = -100 * Math.sin(a2_th * (Math.PI/180)) + d1 + base_x;
        
        a4_y = -75 * (Math.cos(a2_th * (Math.PI/180)) * Math.cos(a3_th * (Math.PI/180)) 
                - Math.sin(a2_th * (Math.PI/180)) * Math.sin(a3_th * (Math.PI/180)))
                - 100 * Math.cos(a2_th * (Math.PI/180)) - 150 + base_y;
        
        a4_x = 75 * (-Math.sin(a2_th * (Math.PI/180)) * Math.cos(a3_th * (Math.PI/180)) 
                - Math.cos(a2_th * (Math.PI/180)) * Math.sin(a3_th * (Math.PI/180)))
                - 100 * Math.sin(a2_th * (Math.PI/180)) + d1 + base_x;
    }
    
    /**
     * 
     * @param positive if axis 3 should rotate in the positive direction
     */
    public void axis3_rotate(boolean positive){
        
        if(positive == true)
            a3_th = a3_th + 1;  
        else
            a3_th = a3_th - 1;        
        
        a4_y = -75 * (Math.cos(a2_th * (Math.PI/180)) * Math.cos(a3_th * (Math.PI/180)) 
                - Math.sin(a2_th * (Math.PI/180)) * Math.sin(a3_th * (Math.PI/180)))
                - 100 * Math.cos(a2_th * (Math.PI/180)) - 150 + base_y;
        
        a4_x = 75 * (-Math.sin(a2_th * (Math.PI/180)) * Math.cos(a3_th * (Math.PI/180)) 
                - Math.cos(a2_th * (Math.PI/180)) * Math.sin(a3_th * (Math.PI/180)))
                - 100 * Math.sin(a2_th * (Math.PI/180)) + d1 + base_x;
    }
    
    /**
     * Function to move paint head to given coordinates
     * @param x 
     * @param y
     */
    public void head_move(double x, double y){
        
        double dist = Math.sqrt(Math.pow(x-a2_x,2)+Math.pow(y-a2_y,2));
        
        if((dist >= 175) && (a1_x >= base_x && a1_x <= base_x+300))
            d1 = d1 + (x-a4_x);
        
        else if(dist >= 175) {
         
            if(x <= base_x+300 && x >= base_x) {
                d1 = d1 + (x-a4_x);

            }
            else
                return;
        }
            
        if((dist >= 175)&&(a4_x > a1_x)&&((y > a4_y)||(y < a4_y)))
            d1 = d1 + 1;
        else if((dist >= 175)&&(a4_x < a1_x)&&((y > a4_y)||(y < a4_y)))
            d1 = d1 - 1;
        
        double b1 = Math.sqrt(Math.pow(x-(d1+base_x), 2)+Math.pow(y-(base_y-150),2));
        double b2 = Math.sqrt(Math.pow(x-(d1+base_x), 2)+Math.pow((base_y-y), 2));
       
        if(Double.isNaN(b1) || Double.isNaN(b2))
            return;
        
        double p1 = Math.acos((Math.pow(100, 2)+Math.pow(b1, 2)-(75*75))/(2*100*b1))*(180/Math.PI);
        double p2 = Math.acos(((150*150)+(b1*b1)-(b2*b2))/(2*150*b1))*(180/Math.PI);
        
        if(Double.isNaN(p1) || Double.isNaN(p2))
            return;
        
        if(((a4_x > a1_x) && (a3_x > a1_x)) || ((a4_x > a1_x) && (a3_x < a1_x)))
            a3_th = (Math.acos(((100*100)+(75*75)-Math.pow(b1,2))/(2*75*100)))*(180/Math.PI)-180;  
        else if(((a4_x < a1_x) && (a3_x < a1_x)) || ((a4_x < a1_x) && (a3_x > a1_x)))
            a3_th = 180-(Math.acos(((100*100)+(75*75)-Math.pow(b1,2))/(2*75*100)))*(180/Math.PI); 
        
        if((a4_x > a1_x) && (a3_x > a1_x)) 
            a2_th = -180 + p1 + p2;
        else if((a4_x < a1_x) && (a3_x < a1_x))
            a2_th = 180-p1-p2;
        
        if((a4_x < a1_x) && (a3_x > a1_x))      
            a2_th = -p1+180-p2;
        else if((a4_x > a1_x) && (a3_x < a1_x))
            a2_th = p1-180+p2;
        
        //mirrors the angle when moving across the axis of robot
        if((x>a4_x)&&((Math.ceil(x) == a1_x) || (Math.floor(x) == a1_x))) {
            a2_th = -a2_th;
            a3_th = (Math.acos(((100*100)+(75*75)-Math.pow(b1,2))/(2*75*100)))*(180/Math.PI)-180;
        } else if((x<a4_x)&&((Math.floor(x) == a1_x) || (Math.ceil(x) == a1_x))) {
            a2_th = -a2_th;
            a3_th = -(Math.acos(((100*100)+(75*75)-Math.pow(b1,2))/(2*75*100)))*(180/Math.PI)+180;
        }
        
        a1_x = base_x + d1;
        a2_x = a1_x;
        a3_y = -100 * Math.cos(a2_th * (Math.PI/180)) - 150 + base_y;
        a3_x = -100 * Math.sin(a2_th * (Math.PI/180)) + d1 + base_x;
        a4_y = -75 * (Math.cos(a2_th * (Math.PI/180)) * Math.cos(a3_th * (Math.PI/180)) 
                - Math.sin(a2_th * (Math.PI/180)) * Math.sin(a3_th * (Math.PI/180)))
                - 100 * Math.cos(a2_th * (Math.PI/180)) - 150 + base_y;
        
        a4_x = 75 * (-Math.sin(a2_th * (Math.PI/180)) * Math.cos(a3_th * (Math.PI/180)) 
                - Math.cos(a2_th * (Math.PI/180)) * Math.sin(a3_th * (Math.PI/180)))
                - 100 * Math.sin(a2_th * (Math.PI/180)) + d1 + base_x;
    }
    
}
