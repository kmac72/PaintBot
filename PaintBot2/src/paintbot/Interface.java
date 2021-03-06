/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbot;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.*;
import java.util.Timer;
import java.util.*;
import javax.swing.*;
import java.lang.Math;

/**
 *
 * @author Brian
 */
public class Interface extends javax.swing.JFrame{
    
    private Kinematics kin;
    private final Vector<Double> paintdots;
    private final Vector<Color> color;
    
    Timer timer;
    TimerTask a1_pos_task;
    TimerTask a1_neg_task;
    TimerTask a2_pos_task;
    TimerTask a2_neg_task;
    TimerTask a3_pos_task;
    TimerTask a3_neg_task;
    TimerTask head_up_task;
    TimerTask head_left_task;
    TimerTask head_right_task;
    TimerTask head_down_task;
    
    Color selectedColor;
    
    /**
     * Creates new form Interface
     */
    public Interface() { 
        kin = new Kinematics();
        paintdots = new Vector();
        color = new Vector();
        timer = new Timer();
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

        jDialog1 = new javax.swing.JDialog();
        jColorChooser1 = new javax.swing.JColorChooser();
        RobotFrame = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        axis1_negative = new javax.swing.JButton();
        axis1_positive = new javax.swing.JButton();
        axis2_negative = new javax.swing.JButton();
        axis2_positive = new javax.swing.JButton();
        axis3_negative = new javax.swing.JButton();
        axis3_positive = new javax.swing.JButton();
        paint_button = new javax.swing.JButton();
        cont_paint = new javax.swing.JCheckBox();
        reset = new javax.swing.JButton();
        color_pick_button = new javax.swing.JButton();
        head_up = new javax.swing.JButton();
        head_left = new javax.swing.JButton();
        head_down = new javax.swing.JButton();
        head_right = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        follow_mouse = new javax.swing.JCheckBox();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jColorChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PaintBot - Gig'em Robotics");

        RobotFrame = new RobotWorkspace();
        RobotFrame.setBackground(new java.awt.Color(255, 255, 255));
        RobotFrame.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Sliding Axis");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Rotating Axis 1");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Rotating Axis 2");

        axis1_negative.setText("<-");
        axis1_negative.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                axis1_negativeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                axis1_negativeMouseReleased(evt);
            }
        });
        axis1_negative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                axis1_negativeActionPerformed(evt);
            }
        });

        axis1_positive.setText("->");
        axis1_positive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                axis1_positiveMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                axis1_positiveMouseReleased(evt);
            }
        });
        axis1_positive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                axis1_positiveActionPerformed(evt);
            }
        });

        axis2_negative.setText("<-");
        axis2_negative.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                axis2_negativeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                axis2_negativeMouseReleased(evt);
            }
        });
        axis2_negative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                axis2_negativeActionPerformed(evt);
            }
        });

        axis2_positive.setText("->");
        axis2_positive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                axis2_positiveMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                axis2_positiveMouseReleased(evt);
            }
        });
        axis2_positive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                axis2_positiveActionPerformed(evt);
            }
        });

        axis3_negative.setText("<-");
        axis3_negative.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                axis3_negativeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                axis3_negativeMouseReleased(evt);
            }
        });
        axis3_negative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                axis3_negativeActionPerformed(evt);
            }
        });

        axis3_positive.setText("->");
        axis3_positive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                axis3_positiveMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                axis3_positiveMouseReleased(evt);
            }
        });
        axis3_positive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                axis3_positiveActionPerformed(evt);
            }
        });

        paint_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        paint_button.setText("Paint");
        paint_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paint_buttonActionPerformed(evt);
            }
        });

        cont_paint.setText("Continuous Paint");

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        color_pick_button.setText("Choose Color");
        color_pick_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                color_pick_buttonActionPerformed(evt);
            }
        });

        head_up.setText("^");
        head_up.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                head_upMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                head_upMouseReleased(evt);
            }
        });
        head_up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                head_upActionPerformed(evt);
            }
        });

        head_left.setText("<-");
        head_left.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                head_leftMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                head_leftMouseReleased(evt);
            }
        });
        head_left.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                head_leftActionPerformed(evt);
            }
        });

        head_down.setText("v");
        head_down.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                head_downMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                head_downMouseReleased(evt);
            }
        });
        head_down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                head_downActionPerformed(evt);
            }
        });

        head_right.setText("->");
        head_right.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                head_rightMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                head_rightMouseReleased(evt);
            }
        });
        head_right.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                head_rightActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Paint Head Control");

        follow_mouse.setText("Follow Mouse");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RobotFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(axis1_negative, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(axis1_positive, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(axis2_negative, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(axis2_positive, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(axis3_negative, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(axis3_positive, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(cont_paint)
                                        .addGap(23, 23, 23))
                                    .addComponent(paint_button, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(head_left, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(head_up, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(head_down, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(head_right, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(37, 37, 37))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(51, 51, 51)
                                            .addComponent(follow_mouse)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(color_pick_button, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(reset)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(axis1_positive, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(axis1_negative, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(axis2_negative, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(axis2_positive, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(axis3_negative, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(axis3_positive, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(head_up, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(head_down, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(head_right, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(head_left, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(follow_mouse)
                        .addGap(64, 64, 64)
                        .addComponent(paint_button, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cont_paint)
                        .addGap(18, 18, 18)
                        .addComponent(color_pick_button, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(reset))
                    .addComponent(RobotFrame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Events to move robot arm
    
    private void axis1_negativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_axis1_negativeActionPerformed
        kin.axis1_slide(false);
        RobotFrame.repaint();
    }//GEN-LAST:event_axis1_negativeActionPerformed

    private void axis1_positiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_axis1_positiveActionPerformed
        kin.axis1_slide(true);
        RobotFrame.repaint();
    }//GEN-LAST:event_axis1_positiveActionPerformed

    private void axis2_negativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_axis2_negativeActionPerformed
        kin.axis2_rotate(false);
        RobotFrame.repaint();
    }//GEN-LAST:event_axis2_negativeActionPerformed

    private void axis2_positiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_axis2_positiveActionPerformed
        kin.axis2_rotate(true);
        RobotFrame.repaint();
    }//GEN-LAST:event_axis2_positiveActionPerformed

    private void axis3_positiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_axis3_positiveActionPerformed
        kin.axis3_rotate(true);
        RobotFrame.repaint();
    }//GEN-LAST:event_axis3_positiveActionPerformed

    private void axis3_negativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_axis3_negativeActionPerformed
        kin.axis3_rotate(false);
        RobotFrame.repaint();
    }//GEN-LAST:event_axis3_negativeActionPerformed
    
    //Event to paint dot
    private void paint_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paint_buttonActionPerformed
        paintdots.add(kin.a4_x - 5);
        paintdots.add(kin.a4_y - 5);
        color.add(selectedColor);
        RobotFrame.repaint();
    }//GEN-LAST:event_paint_buttonActionPerformed

    
    //Events to handle held down mouse
    private void axis1_negativeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis1_negativeMousePressed
        timer.scheduleAtFixedRate(a1_neg_task = new axis1_negTimerTask(), 400, 50);
    }//GEN-LAST:event_axis1_negativeMousePressed

    private void axis1_negativeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis1_negativeMouseReleased
        a1_neg_task.cancel();
    }//GEN-LAST:event_axis1_negativeMouseReleased

    private void axis1_positiveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis1_positiveMousePressed
        timer.scheduleAtFixedRate(a1_pos_task = new axis1_posTimerTask(), 400, 50);
    }//GEN-LAST:event_axis1_positiveMousePressed

    private void axis1_positiveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis1_positiveMouseReleased
        a1_pos_task.cancel();
    }//GEN-LAST:event_axis1_positiveMouseReleased

    private void axis2_negativeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis2_negativeMousePressed
        timer.scheduleAtFixedRate(a2_neg_task = new axis2_negTimerTask(), 400, 50);
    }//GEN-LAST:event_axis2_negativeMousePressed

    private void axis2_negativeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis2_negativeMouseReleased
        a2_neg_task.cancel();
    }//GEN-LAST:event_axis2_negativeMouseReleased

    private void axis2_positiveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis2_positiveMousePressed
        timer.scheduleAtFixedRate(a2_pos_task = new axis2_posTimerTask(), 400, 50);
    }//GEN-LAST:event_axis2_positiveMousePressed

    private void axis2_positiveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis2_positiveMouseReleased
        a2_pos_task.cancel();
    }//GEN-LAST:event_axis2_positiveMouseReleased

    private void axis3_negativeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis3_negativeMousePressed
        timer.scheduleAtFixedRate(a3_neg_task = new axis3_negTimerTask(), 400, 50);
    }//GEN-LAST:event_axis3_negativeMousePressed

    private void axis3_negativeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis3_negativeMouseReleased
        a3_neg_task.cancel();
    }//GEN-LAST:event_axis3_negativeMouseReleased

    private void axis3_positiveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis3_positiveMousePressed
        timer.scheduleAtFixedRate(a3_pos_task = new axis3_posTimerTask(), 400, 50);
    }//GEN-LAST:event_axis3_positiveMousePressed

    private void axis3_positiveMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_axis3_positiveMouseReleased
        a3_pos_task.cancel();
    }//GEN-LAST:event_axis3_positiveMouseReleased
    
    //reset action
    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        kin = new Kinematics();
        paintdots.clear();
        color.clear();
        RobotFrame.repaint();
    }//GEN-LAST:event_resetActionPerformed
    
    //Bring up color dialog
    private void color_pick_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_color_pick_buttonActionPerformed
        selectedColor = JColorChooser.showDialog(this, "Pick a Color", Color.RED);
    }//GEN-LAST:event_color_pick_buttonActionPerformed

    //Paint head controls
    private void head_upMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_head_upMousePressed
        timer.scheduleAtFixedRate(head_up_task = new head_upTimerTask(), 400, 50);
    }//GEN-LAST:event_head_upMousePressed

    private void head_upMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_head_upMouseReleased
        head_up_task.cancel();
    }//GEN-LAST:event_head_upMouseReleased

    private void head_upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_head_upActionPerformed
        kin.head_move(kin.a4_x, kin.a4_y - 1);
        RobotFrame.repaint();
    }//GEN-LAST:event_head_upActionPerformed

    private void head_leftMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_head_leftMousePressed
        timer.scheduleAtFixedRate(head_left_task = new head_leftTimerTask(), 400, 50);
    }//GEN-LAST:event_head_leftMousePressed

    private void head_leftMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_head_leftMouseReleased
        head_left_task.cancel();
    }//GEN-LAST:event_head_leftMouseReleased

    private void head_leftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_head_leftActionPerformed
        kin.head_move(kin.a4_x - 1, kin.a4_y);
        RobotFrame.repaint();
    }//GEN-LAST:event_head_leftActionPerformed

    private void head_downMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_head_downMousePressed
        timer.scheduleAtFixedRate(head_down_task = new head_downTimerTask(), 400, 50);
    }//GEN-LAST:event_head_downMousePressed

    private void head_downMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_head_downMouseReleased
        head_down_task.cancel();
    }//GEN-LAST:event_head_downMouseReleased

    private void head_downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_head_downActionPerformed
        kin.head_move(kin.a4_x, kin.a4_y + 1);
        RobotFrame.repaint();
    }//GEN-LAST:event_head_downActionPerformed

    private void head_rightMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_head_rightMousePressed
        timer.scheduleAtFixedRate(head_right_task = new head_rightTimerTask(), 400, 50);
    }//GEN-LAST:event_head_rightMousePressed

    private void head_rightMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_head_rightMouseReleased
        head_right_task.cancel();
    }//GEN-LAST:event_head_rightMouseReleased

    private void head_rightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_head_rightActionPerformed
        kin.head_move(kin.a4_x + 1, kin.a4_y);
        RobotFrame.repaint();
    }//GEN-LAST:event_head_rightActionPerformed
       
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interface().setVisible(true);
            }
        });
    }
    
    //Class to draw robot arm and paint dots
    class RobotWorkspace extends JPanel implements MouseMotionListener{
        
        public RobotWorkspace(){
            RobotFrame.addMouseMotionListener(this);
            addMouseMotionListener(this);
        }
        
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            
            //Draw robot arm and slide
            double xpoints[] = {kin.a1_x, kin.a2_x, kin.a3_x, kin.a4_x};
            double ypoints[] = {kin.a1_y, kin.a2_y, kin.a3_y, kin.a4_y};

            GeneralPath robotarm = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xpoints.length);
            robotarm.moveTo(xpoints[0], ypoints[0]);
            for (int i = 1; i < xpoints.length; i++) {
                robotarm.lineTo(xpoints[i], ypoints[i]);
            }
            
            g2.setPaint(Color.gray);
            g2.fill(new Rectangle2D.Double(kin.base_x, kin.base_y, 300, 15));
            g2.setPaint(Color.black);
            g2.setStroke(new BasicStroke(5.0f));
            g2.draw(robotarm);
               
            if(cont_paint.isSelected()){
                paintdots.add(kin.a4_x - 5);
                paintdots.add(kin.a4_y - 5);
                color.add(selectedColor);
            }
            
            //Draw paint dots
            g2.setStroke(new BasicStroke(0f));
            for(int i = 0, j = 0; i < paintdots.size()-1; i+=2, j++){
                g2.setColor(color.elementAt(j));
                g2.fill(new Ellipse2D.Double(paintdots.elementAt(i), paintdots.elementAt(i+1), 10, 10));
            }
            
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if(follow_mouse.isSelected()){
                kin.head_move(e.getPoint().x, e.getPoint().y);
                RobotFrame.repaint();
            }
            
            if(follow_mouse.isSelected() && !cont_paint.isSelected()){
                paintdots.add(kin.a4_x - 5);
                paintdots.add(kin.a4_y - 5);
                color.add(selectedColor);
                RobotFrame.repaint();
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if(follow_mouse.isSelected()){
                kin.head_move(e.getPoint().x, e.getPoint().y);
                RobotFrame.repaint();
            }
        }
        
    }
    
    //Classes to handle timers for button hold down repeat action   
    class axis1_posTimerTask extends TimerTask{
        @Override
        public void run(){
            kin.axis1_slide(true);
            RobotFrame.repaint();
        }
    }
    
    class axis1_negTimerTask extends TimerTask{
        @Override
        public void run(){
            kin.axis1_slide(false);
            RobotFrame.repaint();
        }
    }
    
    class axis2_posTimerTask extends TimerTask{
        @Override
        public void run(){
            kin.axis2_rotate(true);
            RobotFrame.repaint();
        }
    }
    
    class axis2_negTimerTask extends TimerTask{
        @Override
        public void run(){
            kin.axis2_rotate(false);
            RobotFrame.repaint();
        }
    }
    
    class axis3_posTimerTask extends TimerTask{
        @Override
        public void run(){
            kin.axis3_rotate(true);
            RobotFrame.repaint();
        }
    }
    
    class axis3_negTimerTask extends TimerTask{
        @Override
        public void run(){
            kin.axis3_rotate(false);
            RobotFrame.repaint();
        }
    }
    
    class head_upTimerTask extends TimerTask{
        @Override
        public void run(){
            kin.head_move(kin.a4_x, kin.a4_y - 1);
            RobotFrame.repaint();
        }
    }
    
    class head_leftTimerTask extends TimerTask{
        @Override
        public void run(){
            kin.head_move(kin.a4_x - 1, kin.a4_y);
            RobotFrame.repaint();
        }
    }
    
    class head_downTimerTask extends TimerTask{
        @Override
        public void run(){
            kin.head_move(kin.a4_x, kin.a4_y + 1);
            RobotFrame.repaint();
        }
    }
    
    class head_rightTimerTask extends TimerTask{
        @Override
        public void run(){
            kin.head_move(kin.a4_x + 1, kin.a4_y);
            RobotFrame.repaint();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel RobotFrame;
    private javax.swing.JButton axis1_negative;
    private javax.swing.JButton axis1_positive;
    private javax.swing.JButton axis2_negative;
    private javax.swing.JButton axis2_positive;
    private javax.swing.JButton axis3_negative;
    private javax.swing.JButton axis3_positive;
    private javax.swing.JButton color_pick_button;
    private javax.swing.JCheckBox cont_paint;
    private javax.swing.JCheckBox follow_mouse;
    private javax.swing.JButton head_down;
    private javax.swing.JButton head_left;
    private javax.swing.JButton head_right;
    private javax.swing.JButton head_up;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton paint_button;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables
}
