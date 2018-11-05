package com.samsung.test;


public class Permutations {
	/* 
	 * non repeated permutations
	 * */

	public void displayCharPermutations(){
		//char str[]={'a', 'b', 'c', 'd', 'e' };
		char str[]={'1', '2', '3', '4', '5' };
		System.out.println(str);

		char strdup[] = str;
		System.out.println(strdup);
		
		for(int i = 0; i < str.length; i++){
			for(int j = 0; j < str.length; j++)
				if(strdup[j] != str[i]){
				
					String s1 = Character.toString(str[i]);
					String s2 = Character.toString(strdup[j]);
					
					String s3 = s1+s2;
					System.out.println(s3);
				}
					
		}
		
	}
	void printPermutation(int x[][], int i, int j, int l, int m){
		System.out.println("");
		
	}
	/*
	 * Display 2 dimensional Integer permutations
	 */
	public void displayIntPermutations(){
		int []intArr = {1, 2, 3 };
		
		for(int i = 0; i<intArr.length; i++){
			for(int j = 0; j < intArr.length; j++){
				if(j!=i){
					
				}
				
			}
			
		}

	}
	
	public static void main(String[] args){
		System.out.println("");
		
		Permutations perm = new Permutations();
		
		perm.displayCharPermutations();
		
		perm.displayIntPermutations();
		
		
	}

}
