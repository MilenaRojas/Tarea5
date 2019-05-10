/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threadsandgraphics;

import visual.LandFrame;
import threads.RepaintLandThread;
import threads.SquareThread;
import domain.Point;
import domain.Square;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author root
 */
public class ThreadsAndGraphics {

    static int valorX=80;
    static int valorY=80;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create the domain squares
        
        Square square1 = new Square("Thread-1", new Point(valorX, valorY), 50);
//        Square square2 = new Square("Thread-2", new Point(10, 10), 75);
//        Square square3 = new Square("Thread-3", new Point(151, 151), 100);
        
        //create the array list for the frame to paint
        ArrayList<Square> squareList = new ArrayList<>();
        squareList.add(square1);
//        squareList.add(square2);
//        squareList.add(square3);
        
        //create the new frame and send the square list
        LandFrame myLand = new LandFrame(squareList);
        myLand.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //thread for repainting
        RepaintLandThread repaintThread = new RepaintLandThread(myLand, 200);
        repaintThread.start();
        
        //thread for controlling the movement of the squares
        SquareThread squareThread1 = new SquareThread(square1, 100);
//        SquareThread squareThread2 = new SquareThread(square2, 1500);
//        SquareThread squareThread3 = new SquareThread(square3, 2000);
        squareThread1.start();
//        squareThread2.start();
//        squareThread3.start(); 
    }//end main
}
