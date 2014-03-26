/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author Brian
 */
public class Slave extends javax.swing.JFrame {
        
    double xpoints[] = {228, 228, 328, 328};
    double ypoints[] = {500, 350, 350, 425};
    Vector<Double> paintdots;
    Vector<Color> color;
    
    /**
     * Creates new form Slave
     */
    public Slave() {
        paintdots = new Vector();
        color = new Vector();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RobotFrame = new javax.swing.JPanel();
        delayBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        RobotFrame = new RobotWorkspace();
        RobotFrame.setBackground(new java.awt.Color(255, 255, 255));
        RobotFrame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        RobotFrame.setPreferredSize(new java.awt.Dimension(756, 735));

        javax.swing.GroupLayout RobotFrameLayout = new javax.swing.GroupLayout(RobotFrame);
        RobotFrame.setLayout(RobotFrameLayout);
        RobotFrameLayout.setHorizontalGroup(
            RobotFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        RobotFrameLayout.setVerticalGroup(
            RobotFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );

        delayBox.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        delayBox.setText("2 Second Delay");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RobotFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(delayBox)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RobotFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(delayBox, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RobotFrame;
    private javax.swing.JCheckBox delayBox;
    // End of variables declaration//GEN-END:variables
    
    public void Update(double[] x, double[] y, Vector<Double> paint, Vector<Color> c){
        xpoints = x;
        ypoints = y;
        paintdots = paint;
        color = c;
        RobotFrame.repaint();
    }
    
    class RobotWorkspace extends JPanel{
    
        public RobotWorkspace(){}
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            

            GeneralPath robotarm = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xpoints.length);
            robotarm.moveTo(xpoints[0], ypoints[0]);
            for (int i = 1; i < xpoints.length; i++) {
                robotarm.lineTo(xpoints[i], ypoints[i]);
            }
            
            g2.setPaint(Color.gray);
            g2.fill(new Rectangle2D.Double(228, 500, 300, 15));
            g2.setPaint(Color.black);
            g2.setStroke(new BasicStroke(5.0f));
            g2.draw(robotarm);
               
            //Draw paint dots
            g2.setStroke(new BasicStroke(0f));
            for(int i = 0, j = 0; i < paintdots.size()-1; i+=2, j++){
                g2.setColor(color.elementAt(j));
                g2.fill(new Ellipse2D.Double(paintdots.elementAt(i), paintdots.elementAt(i+1), 10, 10));
            }
        }
        
    }


}
