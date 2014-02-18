/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbot;

/**
 *
 * @author Brian
 */
public class Kinematics {
    
    public double a1_x;
    public double a1_y;
    public double a2_x;
    public double a2_y;
    public double a3_x;
    public double a3_y;
    public double a4_x;
    public double a4_y;
    
    public  Kinematics(){
        a1_x = 228;
        a1_y = 400;
        a2_x = a1_x;
        a2_y = a1_y - 150;
        a3_x = a2_x + 100;
        a3_y = a2_y;
        a4_x = a3_x;
        a4_y = a3_y + 75;
    }
    
}
