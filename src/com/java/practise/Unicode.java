package com.java.practise;
import java.awt.*;
public class Unicode {
	int x;
	public static void main(String[] args){
		
		Frame f=new Frame();
		
		TextField l= new TextField("Telugu "+ '\u0C1C'+'\u0C3E'+'\u0C35');
		f.add(l);
		f.setSize(200,200);
		f.setVisible(true);
	}

}
