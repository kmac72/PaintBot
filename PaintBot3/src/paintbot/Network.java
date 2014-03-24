/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbot;

import java.awt.Color;
import java.util.Vector;

/**
 *
 * @author Brian
 */
public class Network {
    
    boolean master;
    String ip;
    
    Slave slave;
    
    /**
     * 
     * @param m - if instance should be master or slave
     * @param i - IP address if slave choice given
     */
    public Network(boolean m, String i){
        master = m;
        ip = i;
        
        //If Slave, run Slave interface
        if(!m){
            slave = new Slave();
            slave.setVisible(true);
        }
        
        //Setup sockets based on master or slave
    }
    
    /**
     * Update from master, send to clients
     * @param xpoints - x coords of axis
     * @param ypoints - y coords of axis
     * @param paintdots - coords of painted dots
     * @param color - color for painted dots
     */
    public void MasterUpdate(double[] xpoints, double[] ypoints, Vector<Double> paintdots, Vector<Color> color){
        //send data to clients
    }
    
    /**
     * Update slave frame with coords, paint dots, and colors
     */
    private void UpdateSlave(){
        //slave.Update(xpoints, ypoints, paintdots, color);
    }
}
