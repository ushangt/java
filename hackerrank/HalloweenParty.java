package com.zappos.interview;

import java.util.Scanner;

public class HalloweenParty {
	
	static void max_Chocolates(int[] arr) {
        
        for(int i=0;i<arr.length;i++)   
            System.out.println(getMaxChocolatesForTestCase(arr[i]));

    }

    /*  Maximum chocolates can only be possible if we cut the giant bar into two halfs such that 
        their product is maximum, but we have only k cuts for this.
        So we cut the chocolates when the cuts are equal to K/2 when K is even and K/2 + 1 when
        K is odd.        
    */
    static long getMaxChocolatesForTestCase(long k){
        if(k%2 == 0)
            return (k/2) * (k/2);
        else
            return (k/2) * (k/2 + 1);
    }
	 
	public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        
        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine());
            _arr[_arr_i] = _arr_item;
        }
        
        max_Chocolates(_arr);
        
    }

}
