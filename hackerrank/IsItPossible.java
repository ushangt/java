package com.zappos.interview;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class IsItPossible {
	
	// Creating a static bean class Points to hold the x and y co-ordinates
	static class Points{
		private int x;
		private int y;
		
		Points(int x, int y){
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
					
	}

	    // Creating a staic arraylist of points which will help us traverse
	    static ArrayList<Points> points = new ArrayList<Points>();

	    static String isitpossible(int a, int b, int c, int d) {
	        
	        //Add the first point as the start point (a,b)
			points.add(new Points(a, b));
	        
	        /* We iterate through the list till it is empty. If we reach the end co-ordinate while looping
	           through the list we return a "Yes" else we return a "No" after the loop.
	        */
			while(!points.isEmpty()){
				Points p = points.remove(0);
				if(p.getX() == c && p.getY() == d)
					return "Yes";
				int sum = p.getX() + p.getY();
	            /* Check if the sum of x and y is less then or equal to c (ie the X co-ordinate of destination point).
	               If so add the (sum,y) to the list and iterate back
	            */
				if(sum <= c)
					points.add(new Points(sum, p.getY()));
	            /* Check if the sum of x and y is less then or equal to d (ie the Y co-ordinate of destination point).
	               If so add the (x,sum) to the list and iterate back
	            */
				if(sum <= d)
					points.add(new Points(p.getX(), sum));
			}
			
			return "No";

	    }

	
	public static void main(String[] args) throws IOException{
        System.out.println(isitpossible(1,4,15,9));
    }

	

}
