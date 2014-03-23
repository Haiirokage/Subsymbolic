package oving3;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	static Flatland fl;
	public static void main(String[] args){
		fl = new Flatland(8, 0.5, 0.5);
		fl.print();
		
	}
	
}
