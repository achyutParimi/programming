package com.java.practise;

public class TugOfWar {
	
	int minDelta = 0;
	int []fArr1;
	int []fArr2;
		
	int sumOfSubArr(int[] subArray){
		int sum = 0;
		for(int i = 0; i <subArray.length; i++)
			sum  =  sum + subArray[i];
		
		return sum;
	}
	
	int calMinDelta(int []arr1, int []arr2){
		int sA1 = sumOfSubArr(arr1);
		int sA2 = sumOfSubArr(arr2);
		int diff = sA1 - sA2;		
		return Math.abs(diff);

	}
	
	void setMinDelta(int delta, int []arr1, int []arr2){
		
		if(delta < minDelta){
			minDelta = delta;

			fArr1 = new int[arr1.length];
			fArr2 = new int[arr2.length];
			
			for(int i=0; i < arr1.length; i++)
				fArr1[i] = arr1[i];
			
			for(int i=0; i < arr2.length; i++)
				fArr2[i] = arr2[i];
	
			
		}
	}


	int minDelta(int[] weights){
	
		int length = weights.length;
		int odd = weights.length%2;
		int []subAr1;
		int []subAr2;
		//Create 2 arrays of equal length or length/2 +1 depending on odd
		
		subAr1 = new int[length/2];
		if(odd == 1)
			subAr2 = new int[length/2 +1];
		else
			subAr2 = new int[length/2];
		for(int i=0; i < length/2; i++)
			subAr1[i] = weights[i];

		for(int i=length/2, j=0; i < length; i++, j++)
			subAr2[j] = weights[i];

		
		minDelta = calMinDelta(subAr1, subAr2);
		int temp =0;
		for(int i = 0; i <subAr1.length; i++){
			for(int j = 0; j <subAr2.length; j++){
				//Swap each of subAr2 with elements in subAr1
				temp = subAr2[j];
				subAr2[j] = subAr1[i];
				subAr1[i] = temp;
				
				int delta = calMinDelta(subAr1, subAr2);
				
				setMinDelta(delta, subAr1, subAr2);
			
				temp = subAr2[j];
				subAr2[j] = subAr1[i];
				subAr1[i] = temp;
								
			}
			
		}
		
				
		return minDelta;
	}	
	
	public static void main(String[] args) {
		/*int weights[] = {10
		,1
		,1
		,2
		,3
		,3};*/
		//int weights[] = {20,30, 40, 50};
		
		//int weights[] = {120, 111, 111, 101, 20, 11, 11, 1};
		//int weights[] = {120, 101, 20, 1, 11, 11, 111, 111};
		
		int weights[] = {23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4};
		
		TugOfWar tow = new TugOfWar();
		int minDelta = tow.minDelta(weights);		
		System.out.println("min Delta = " +minDelta);	
	

		for(int i=0; i < tow.fArr1.length; i++)
			System.out.println("..." +tow.fArr1[i]);
		
		System.out.println(".......................");
		
		for(int i=0; i < tow.fArr2.length; i++)
			System.out.println("..." +tow.fArr2[i]);
	
	}
	
}
