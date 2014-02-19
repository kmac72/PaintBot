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
    public final int base_y = 400;
    
    public double a1_x;
    public double a1_y;
    public double a2_x;
    public double a2_y;
    public double a3_x;
    public double a3_y;
    public double a4_x;
    public double a4_y;
    
    public double a2_th;
    public double d1;
    
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
        d1 = 0;
    }
    
    /**
     * 
     * @param positive if axis 1 should slide in the positive direction
     */
    public void axis1_slide(boolean positive){
        
        if(positive == true) {
            d1 = d1 + 1;
            a1_x = a1_x + 1;
            a2_x = a2_x + 1;
            a3_x = a3_x + 1;
            a4_x = a4_x + 1;
        } else {
            d1 = d1 + 1;
            a1_x = a1_x - 1;
            a2_x = a2_x - 1;
            a3_x = a3_x - 1;
            a4_x = a4_x - 1;          
        }    
    }
    
    /**
     * 
     * @param positive if axis 2 should rotate in the positive direction
     */
    public void axis2_rotate(boolean positive){
        
        if(positive == true) {
            a2_th = a2_th + 1;
            //Y has inversed values due to coordinate system of the frame
            a3_y = -100 * Math.cos(a2_th * (Math.PI/180)) /*+ Math.sin(a2_th * (Math.PI/180))*/ - 150 + base_y;
            a3_x = -100 * Math.sin(a2_th * (Math.PI/180)) /*- Math.cos(a2_th * (Math.PI/180))*/ + d1 + base_x;
        }
    }
    
    /**
     * 
     * @param positive if axis 3 should rotate in the positive direction
     */
    public void axis3_rotate(boolean positive){

    }
    
}
