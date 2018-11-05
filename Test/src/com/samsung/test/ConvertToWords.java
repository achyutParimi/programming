package com.samsung.test;

import java.util.*;
public class ConvertToWords {
	HashMap<Integer, String>hMap;
	TestStack st;
	
	public void constructHMap(){
		
		st = new TestStack(10);
		
		hMap =  new HashMap<Integer, String>();
	
		hMap.put(0, "zero");
		hMap.put(1, "one");
		hMap.put(2, "two");
		hMap.put(3, "three");
		hMap.put(4, "four");
		hMap.put(5, "five");
		hMap.put(6, "six");
		hMap.put(7, "seven");
		hMap.put(8, "eight");
		hMap.put(9, "nine");
		hMap.put(10, "ten");
		hMap.put(11, "eleven");
		hMap.put(12, "twelve");
		hMap.put(13, "thirteen");
		hMap.put(14, "fourteen");
		hMap.put(15, "fifteen");
		hMap.put(16, "sixteen");
		hMap.put(17, "seventeen");
		hMap.put(18, "eighteen");
		hMap.put(19, "nineteen");
		hMap.put(20, "twenty");
		hMap.put(30, "thirty");
		hMap.put(40, "forty");
		hMap.put(50, "fifty");
		hMap.put(60, "sixty");
		hMap.put(70, "seventy");
		hMap.put(80, "eighty");
		hMap.put(90, "ninety");
		hMap.put(100, "hundred");
		hMap.put(1000, "thousand");

	}
	public void convertNumToWords(int num){

		constructHMap();
		while(num > 0){
			int rem = num%10;
			st.push(rem);
			num = num/10;
		}
		StringBuilder word = new StringBuilder();
		boolean skip = false;
		while(st.top >= 0){
			switch(st.top +1){
				case 1:// Case to handle units
				{
					int val = st.pop();
					if((val!=0)&& skip !=true){
						word.append(hMap.get(val));
					}else{
						skip = false;
					}
					
					
					
					break;
				}
				case 2://Case to handle 10 to 99
				{
					int val = st.pop();
					if(val!=0){
						if(st.arr[st.top] == 1){
							word.append(hMap.get(val*10 + st.arr[st.top]));
							skip = true;
						}else
							word.append(hMap.get(val*10));
//					word.append(" ");
					}
					break;
				}
				case 3://Case to handle 100 to 999
				{
					int val = st.pop();
					if(val!=0){
						word.append(hMap.get(val));
						word.append("hundred");						
					}


					break;
				}
				case 4://Case to handle 1000 to 9999
				{
					int val = st.pop();
					if((val!=0)&& skip !=true){
						word.append(hMap.get(val));
						word.append("thousand");
					}else{
						word.append("thousand");
						//skip = false;
						}

					break;
				}
				case 5://Case to handle 10000 to 99999
				{
					int sVal = st.arr[st.top];
					int val = st.pop();

					if(val!=0){
						if((sVal >= 2)&& (sVal <= 9)){
							
							word.append(hMap.get(val*10));
							word.append(hMap.get(st.arr[st.top]));
							skip = true;
						}else{
							if(sVal == 1){
								word.append(hMap.get(val*10 + st.arr[st.top]));	
							}else
								word.append(hMap.get(val*10));
							skip = true;
						}
							
						
						//word.append("thousand");
					}
					break;
				}
				case 6://Case to handle 100000 to 999999
				{
					int sVal = st.arr[st.top - 1];
					int val = st.pop();

					if(val!=0){
						if((sVal >= 2)&& (sVal <= 9)){
							word.append(hMap.get(val));
							word.append(hMap.get(100));
							//word.append(hMap.get(sVal*10));
							//word.append(hMap.get(st.arr[st.top]));
							skip = true;
						}else{
							if(sVal == 1){
								word.append(hMap.get(val*100 + st.arr[st.top]));	
							}else{
								word.append(hMap.get(val));
								word.append(hMap.get(100));
								//word.append("thousand");
							}
								
							//skip = true;
						}
							
						
						word.append("thousand");
					}
					break;
				}

			}
			word.append(" ");
		}
			System.out.println(".."+ word);
		}
		

	public static void main(String args[]){
		ConvertToWords ctw = new ConvertToWords();
		//for(int i = 1; i < 100000; i++)
		ctw.convertNumToWords(987654);
		//ctw.convertNumToWords(900000);
		//ctw.convertNumToWords(909000);
		
		
		
	}
}
