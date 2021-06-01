package com.java.practise;

public class EditWord {
	
	public boolean checkDiffOne(String ShortStr, String str){
		int ctr=0;
		for(int i = 0; i< ShortStr.length(); i++){
			if(ShortStr.charAt(i) != str.charAt(i)) {
				ctr++;
				if(ctr >1) return false;
			}
		}
		
		return true;
		
	}
	//if 2 words differ by more than one char, it is not required to check
	public boolean isValid(String str1, String str2){
		int s1length = str1.length();
		int s2length = str2.length();
		
		if(s1length > s2length){
			if(s1length -s2length >= 2) return false;
			
			return checkDiffOne(str2, str1);
			
		}else{
			if(s2length -s1length >= 2) return false;
			
			return checkDiffOne(str1, str2);
		}
		
		
	}
	public String replace(String str, int index, char replace){     
	    if(str==null){
	        return str;
	    }else if(index<0 || index>=str.length()){
	        return str;
	    }
	    char[] chars = str.toCharArray();
	    chars[index] = replace;
	    return String.valueOf(chars);       
	}
	public boolean compareAll(String []words, String str){
		for(int i=0; i< words.length; i++){
			if(words[i].compareTo(str) == 0) return true;
		}
		return false;
	}
	public int editCheck(String []str1, String str2, int k){
		
		int wordCount = 1;
		for(int i = k; i < str1.length; i++) {
			
			if(isValid(str1[i], str2) == false) return wordCount;
			
			if(str1[i].equals(str2) == true) continue;
		

			
		if(str1[i].compareTo(str2) != 0){
	        if(str1[i].length() > str2.length()){
	        	if(str1[i].contains(str2) == true){ 
	        		wordCount++;
	        		str2 = str1[i];
	        	}
	        	
	        }
	        else if(str1[i].length() < str2.length() ){
	        	if(str2.contains(str1[i]) == true) wordCount++;
	        } 
	        else {
				String found=str2;
				for(int j = 0; j < str2.length(); j++){
					char c = str2.charAt(j);

					while(++c <= 'z'){
												
						str2 = replace(str2, j, c);
						if(compareAll(str1, str2) == true) {
							found = str2;
							wordCount++;
							//break;
						}
						
						
					}
					str2 = found;
				}

	        } // end of else
		}
		
	}
		
		return wordCount;
	}
	
	int maxCount = 0;
	public static void main(String []args){

		EditWord ew = new EditWord();
		int count = 1;
		String[] words = {"dig","fig","dog", "fin"}; // not working	
/*		
 * String[] words = {"dog","fig", "fin", "fine", "wine"}; // working
 * String[] words = {"dig","fig", "fin", "fine", "wine"}; // working
		String[] words = { "cat", "dig", "dog", "fig", "fin",
                "fine", "fog", "log", "wine" };
		*/
		for(int i = 0; i<words.length; i++){
			
			count = ew.editCheck(words, words[i], i+1);
			
			System.out.println("wordCount : for :" +words[i]+" is: " +count);
			if(count > ew.maxCount) 
				ew.maxCount = count;

		}
		
		System.out.println("Max Steps ..."+ew.maxCount);
		
	}
	
}
