/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author lucas
 */
public class Bola{

    GLUT glut = new GLUT();
    
    private JogoMain jogoMain;
    
    public Bola(JogoMain jogoMain){
        this.jogoMain = jogoMain;
    }
    
    private boolean arremessado = false;
    
    private double z = 0, y = 0, x = 0;

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public void drawBola(GL2 gl){
        gl.glPushMatrix();
            moverArremesso(gl);
            gl.glColor3f(1f, .27f, 0);
            glut.glutSolidSphere(3, 50, 50);
        gl.glPopMatrix();
    }
    
    private void moverArremesso(GL2 gl) {
        if(arremessado) {
            z -= 0.1;
            
            if(z >= -40) {
                y += 0.1;
            }
            
            else {
                y -= 0.1;
                
                if(z <= -220)
                {               
                    arremessado = false;
                    jogoMain.gol = 0;
                    gl.glTranslated(0, -5, -8);
                    y = 0;
                    z = 0;
                }
            }
            
            gl.glTranslated(0, y, z);
        }
    }
    
    public void arremessar() {
        arremessado = true;
    }
}