/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package labtask;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.ButtonGroup;

public class Graphics extends javax.swing.JFrame {

    ButtonGroup bg=new ButtonGroup();
    public void  draw()
    {
        
        for(int i=0;i<line.size();i++)
            {
            g.draw(line.get(i));
            }
    }
    public void button()
    {
        bg.add(Line);
        bg.add(Circle);
        bg.add(Rectangle);
    }
   
    public Graphics() {
        initComponents();
        button();
    }
    private Graphics2D g;
    private int x1,x2,y1,y2;
ArrayList <Line2D> line=new ArrayList<Line2D>();
Line2D lineBuffer;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Line = new javax.swing.JRadioButton();
        Circle = new javax.swing.JRadioButton();
        Rectangle = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 244, Short.MAX_VALUE)
        );

        Line.setText("Line");

        Circle.setText("Circle");

        Rectangle.setText("Rectangle");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Line)
                .addGap(29, 29, 29)
                .addComponent(Circle)
                .addGap(27, 27, 27)
                .addComponent(Rectangle)
                .addGap(0, 175, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Line)
                    .addComponent(Circle)
                    .addComponent(Rectangle))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        Graphics2D g; 
        g = (Graphics2D)jPanel1.getGraphics();
        if(Line.isSelected())
        {
           // g.drawLine(0, 0, 100, 100);
            //g.draw(new Line2D.Double((double)50.5,(double)50.5,(double)(100.10),(double)(100.50)));
            
        }
        else if(Circle.isSelected())
        {
           // g.drawOval(0, 0, 50, 50);
           // g.setColor(Color.red);
            //g.fillOval(70, 70, 100, 100);
        }
        else if(Rectangle.isSelected())
        {
          //  g.drawRect(50, 50, 150, 150);
           // g.setColor(Color.green);
           // g.fillRect(50, 50, 150, 150);
        }
    
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
      g=(Graphics2D) jPanel1.getGraphics();
      x1=evt.getX();
      y1=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
         if(Line.isSelected())
        {
            jPanel1.update(g);
            x2=evt.getX();
            y2=evt.getY();
            lineBuffer=new Line2D.Double((double)x1,(double)y1,(double)x2,(double)y2);
            line.add(lineBuffer);
            draw();
        
        }
         //for(int i=0;i<)
         
          
          
         
      
         
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        if(Line.isSelected())
        {
            jPanel1.update(g);
            x2=evt.getX();
            y2=evt.getY();
            draw();
            g.draw(new Line2D.Double((double)(x1),(double)(y1),(double)(x2),(double)(y2)));
        
        }
         for(int i=0;i<line.size();i++)
            {
            draw();
            
            }
    }//GEN-LAST:event_jPanel1MouseDragged

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
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graphics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Graphics().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Circle;
    private javax.swing.JRadioButton Line;
    private javax.swing.JRadioButton Rectangle;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

   
}
