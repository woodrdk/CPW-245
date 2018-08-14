/*
 * File OverLappedRectangles.java
 *
 * Author Ken Meerdink
 * TODO: Robert Wood Jr
*/

import java.awt.*;
import java.util.*;

/**
 *
 * This class keeps track of the z-order of the rectangles in
 * a graphics window. The class is able to reorder the rectangles
 * as needed when one is clicked to bring it to the front.
 * It has a method to draw itself in the graphics window.
 *
 * @author Ken Meerdink
 * @version CPW 245 Winter 2017 Programming Assignment 5
 *
 * @author Robert Wood Jr
 * @version CPW 245 Summer 2018 Programming Assignment 5
 *
 */

public class OverLappedRectangles {
    /**
     * bottom is the lowest of all the rectangles in the graphics window.
     * It acts as the list of rectangles via linking.
     * The objects contained are rectangles, each with its own color.
     */
    private RectangleNode bottom;
   
    /**
     *
     * The default constructor is the only constructor.
     * It allocates an empty linked list.
     * Code provided for Programming Assignment 8
     *
     */
    public OverLappedRectangles() {
        bottom = null;
    }
   
    /**
     *
     * Point p was clicked, move the correct rectangle to the top.
     * Note that, in order to tell which rectangle was clicked,
     * we must examine all the rectangles from lowest index to highest index
     * to find the rectangle clicked. That's because of the z-order in the 
     * linked list.
     *
     * @param p the point clicked by the mouse. Move the clicked rectangle to the top.
     
     */
    public void moveToTop( Point p ) {

        RectangleNode current = bottom;
        
        if(isInside( current.rect, p )){
           bottom = current.next;
           add(current.rect);
        }
            

        // TODO: Your code goes here.
        // You can use the ideas from Chpater 16, in particular the index code can be adapted to this problem by adding some methods to this OverLappedRectangles class. 
        
        // See page 990 for add/remove methods you can add to this class and call from this moveToTop method.

        // Or you can do the following: You get 10% extra credit if you do this method entirely by manipulating pointers as we did in the Lab. 
        
    }
   
    /**
     * Add r to top of z-list.
     * Code provided for Programming Assignment 8
     *
     * @param r The rectangle to be added to the z-list.
     */
    public void addRect( ColorRectangle r ) {
        if( bottom == null ) {
            bottom = new RectangleNode( r );
        }
        else {
        RectangleNode current = bottom;
            while( current.next != null ) {
                current = current.next;
            }
            current.next = new RectangleNode( r );
        }
    }
   
    /**
     * Draw the rectangles.
     * Code provided for Programming Assignment 8
     *
     * @param g The graphics object in the client code.
     */
    public void drawOn( Graphics g ) {
        RectangleNode current = bottom;
        while( current != null ) {
            g.setColor( current.get().getColor() );
            g.fillRect( current.get().getX(),  
                        current.get().getY(),
                        current.get().getWidth(),
                        current.get().getHeight() );
            g.setColor( Color.BLACK );
            g.drawRect( current.get().getX(),  
                        current.get().getY(),
                        current.get().getWidth(),
                        current.get().getHeight() );
            current = current.next;
        }
    }
    
    private class RectangleNode {
        public ColorRectangle rect;
        public RectangleNode next;
    
        public RectangleNode( ColorRectangle rect, RectangleNode next ) {
            this.rect = rect;
            this.next = next;
        }
        public RectangleNode( ColorRectangle rect ) {
            this( rect, null );
        }
        public ColorRectangle get() {
            return rect;
        }
    }
    
    
    ///////////////////////////////////////////////////////////
    
    public boolean isInside( ColorRectangle r , Point p ) {
      return r.getX() <= p.getX()&& p.getX()
          <= r.getX() + r.getWidth()&& r.getY() 
          <= p.getY()&& p.getY() 
          <= r.getY() + r.getHeight();
    }
    
    
    public void add(ColorRectangle rect){
        if( bottom == null){
            bottom = new RectangleNode(rect);
        }
        else{
            RectangleNode current = bottom;
            while(current.next != null){
               current = current.next;
            }
            current.next = new RectangleNode(rect);
        }
    }
    
    public void remove(int index){
        if(index == 0){
            bottom = bottom.next;
        }
        else{
            RectangleNode current = nodeAt(index-1);
            current.next = current.next.next;
        }
    }
    
    public RectangleNode nodeAt(int index){
         RectangleNode current = bottom;
         for(int i = 0; i < index; i++){
            current= current.next;
         }
         return current;
    }
    
    public int size(){
      int count = 0;
      RectangleNode current= bottom;
      while(current != null){
         current = current.next;
         count++;
      }
      return count;
    }
}