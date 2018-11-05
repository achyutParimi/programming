package com.samsung.test;

public class WaysToDecode {

	public int nOfWays(String str, int strLength){
		
		int index =0;
		if(str.length() == 1) return 1;
		
		nOfWays(str.substring(index+1),strLength-1);
		if(str.length() > 2 && checkValidity(str.substring(index, index+2))) {
			
			nOfWays(str.substring(index+2),strLength-2);
		}
		return 0;
		
	}
	
	public boolean checkValidity(String str) { // assume that you get 2digits only
		if (Integer.getInteger(str).intValue() > 26)
			return false;
		return true;
	}
	public static void main(){
		//WaysToDecode decode = new WaysToDecode();
		//int ways = decode.nOfWays("1234", 4);
		//System.out.println("ways :"+ways);
		
	}
}
