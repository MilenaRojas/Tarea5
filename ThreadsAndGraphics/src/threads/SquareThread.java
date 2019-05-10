/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threads;

import domain.Point;
import domain.Square;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import sun.awt.image.VSyncedBSManager;
import threadsandgraphics.ThreadsAndGraphics;


public class SquareThread extends Thread{
    
    //variables
    private Square mySquare;
    private int delayTime;

    public SquareThread(Square mySquare, int delayTime) {
        super(mySquare.identification);
        this.mySquare = mySquare;
        this.delayTime = delayTime;
    }
    
    static int valorX=90;
    static int valorY=80;
    
    
    @Override
    public void run() {
        try {
            //sleep for the animation
            sleep(delayTime);
            
            //move the object
            Random random = new Random();
//            int newX = (int)(random.nextDouble() * 500);
            int newX= 81;
            System.out.println("X "+newX);
//            int newY = (int)(random.nextDouble() * 500);
            int newY=80;
            System.out.println("Y "+newY);
            mySquare.setPointPosition(new Point(newX, newY));
            sleep(delayTime);
            
            while(newX<330){
                          mySquare.setPointPosition(new Point(newX, newY)); 
                          sleep(delayTime);
                          newX++;
                System.out.println("Entro");
            }
           // mySquare.setPointPosition(new Point(newX, newY));
                      
        } catch (InterruptedException ex) {
            Logger.getLogger(SquareThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//end run

    
   
    
}
