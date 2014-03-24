/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbot;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Brian
 */
public class PaintBot extends JApplet {
    
    public void init(){
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    Interface frame = new Interface();
                    frame.setVisible(true);
                }
            });
        } catch (Exception e) {
            System.err.println("Could not run PaintBot Applet");
        }
    }
    
}
