package com.samsung.test;

public class TowersOfHanoi {
	
	public void TOH(int size, int srcTower, int usingTower, int destTower){
		
		if(size > 0){
			TOH(size-1, srcTower, destTower, usingTower);
			System.out.println("Move a disc from: "+srcTower +"to: " +destTower);
			TOH(size-1, usingTower, srcTower, destTower);
		}
		
	}
	
	public static void main(String[] args){
		
		TowersOfHanoi toh = new TowersOfHanoi();
		
		toh.TOH(10, 1,2,3);
		
	}

}
