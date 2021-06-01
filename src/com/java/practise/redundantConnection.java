package com.java.practise;

import java.util.*;
public class redundantConnection {
	 public int[] findRedundantConnection(int[][] edges) {	
	    HashSet<Integer> hs = new HashSet<Integer>();
	    int[] outArr = new int[2];
	    for(int i = 0; i < edges.length; i++){
	        if(hs.contains(edges[i][0] ) && hs.contains(edges[i][1]) ) {
	
	            outArr[0] = edges[i][0];
	            outArr[1] = edges[i][1];
	            System.out.println("answer = " +outArr[0] +"  " +outArr[1]);
	
	        }else {	
	            hs.add(edges[i][0]);
	            hs.add(edges[i][1]);                   
	        }
	    }
	    return outArr;
	    
	 }

	 public static void main(String args){
		 redundantConnection rc = new redundantConnection();
		 rc.findRedundantConnection(null);
	 }
}
