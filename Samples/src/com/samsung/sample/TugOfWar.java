package com.samsung.sample;


public class TugOfWar {
	
	int minDelta = 0;
		
	int sumOfSubArr(int[] subArray){
		int sum = 0;
		for(int i = 0; i <subArray.length; i++)
			sum  =  sum + subArray[i];
		
		return sum;
	}
	
	int calMinDelta(int []arr1, int []arr2){
		
		return (sumOfSubArr(arr2) - sumOfSubArr(arr1));

	}
	
	void setMinDelta(int delta){
		
		if(delta < minDelta) minDelta = delta;
	}


	int minDelta(int[] weights){
	
		int length = weights.length/2;
		int odd = weights.length%2;
		int []subAr1;
		int []subAr2;
		//Create 2 arrays of equal length or length/2 +1 depending on odd
		
		subAr1 = new int[length];
		if(odd == 1)
			subAr2 = new int[length +1];
		else
			subAr2 = new int[length];
		for(int i=0; i < length/2; i++)
			subAr1[i] = weights[i];

		for(int i=length/2; i < length; i++)
			subAr2[i] = weights[i];

		
		minDelta = calMinDelta(subAr1, subAr2);
		
		for(int i = 0; i <subAr1.length; i++){
			for(int j = 0; j <subAr2.length; j++){
				//Swap each of subAr2 with elements in subAr1
				int temp = subAr2[j];
				subAr2[j] = subAr1[i];
				subAr1[i] = temp;
				
				int delta = calMinDelta(subAr1, subAr2);
				setMinDelta(delta);
								
			}
		}
		
				
		return minDelta;
	}

	public static void main(String args){
		int weights[] = {20,30, 40, 50};
		TugOfWar tow = new TugOfWar();
		int minDelta = tow.minDelta(weights);
		
		System.out.println("min Delta = " +minDelta);
		
	}
	
}
