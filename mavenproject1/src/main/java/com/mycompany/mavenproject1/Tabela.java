/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 *
 * @author lucas
 */
public class Tabela {
    
    private JogoMain jogoMain;
    
    public Tabela(JogoMain jogoMain){
        this.jogoMain = jogoMain;
    }
    
    GLUT glut = new GLUT();
    
    private int MAX_TRANS = 40;
    
    private double inc = 0.1, pos = 0;

    public double getPos() {
        return pos;
    }

    public void setPos(double pos) {
        this.pos = pos;
    }
    
    public void drawTabela(GL2 gl) {
        pos += inc;
        if(pos > MAX_TRANS) {
            inc = -1 * 0.1;
        }
        else if(pos < -MAX_TRANS) {
            inc = 1 * 0.1;
        }
        
        gl.glPushMatrix();
            gl.glTranslated(pos, 0, 0);
            gl.glColor3f(getColor().getR(), getColor().getG(), getColor().getB());
            glut.glutSolidTorus(1, 8, 20, 20);
        gl.glPopMatrix();
    }

    private Color getColor() {
        if(jogoMain.gol == 1)
            return new Color(0,1f,0);
        else if(jogoMain.gol == 2)
            return new Color(1f,0,0);
        return new Color(1f,1f,1f);
    }
}
