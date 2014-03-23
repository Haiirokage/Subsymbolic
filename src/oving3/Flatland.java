package oving3;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Flatland {
	int[] map;
	int size = 0;
	int agentLoc = 0;
	int agentDir = 0;
	int fitness = 0;
	public Flatland(int size, double f, double p){
		this.size = size;
		map = new int[size*size];
		for(int i = 0; i < map.length; i++){
			if(Math.random() < f){
				map[i] = 1;
			}
			else if(Math.random() < p){
				map[i] = -1;
			}
		}
		while(true){
			int loc = (int)(Math.random()*size*size);
			if(map[loc] == 0){
				agentLoc = loc;
				break;
			}
		}
		agentDir = (int)(Math.random()*4);
		
	}
	public void move(int command){
		agentLoc = dirToLoc(command);
		fitness += map[agentLoc];
//		map[agentLoc] = 0;
		//map[x(command)] = 0; //TODO Set the previous position to 0
		agentDir = (agentDir - (command-1))%4;
		if(agentDir < 0)agentDir = 3;
	}
	public int[] getSensors(){
		int[] sensors = new int[3];
		for(int i = 0; i < 3; i++){
			sensors[i] = map[dirToLoc(i)];
		}
		return sensors;
	}
	private int dirToLoc(int x){
		int dir = (agentDir-(x-1))%4;
		if(dir <0)dir=3;
		switch(dir){
		case(0):
			agentLoc -= size;
			if(agentLoc < 0){
				agentLoc = size*size -agentLoc;
			}
			break;
		case(1):
			if(agentLoc%size == size-1){
				agentLoc -= size-1;
			}
			else{
				agentLoc+= 1;
			}
			break;
		case(2):
			agentLoc+= size;
			if(agentLoc > size*size){
				agentLoc = agentLoc%size;
			}
			break;
		case(3):
			if(agentLoc%size == 0){
				agentLoc += size-1;
			}
			else{
				agentLoc-= 1;
			}
			break;
		}
		return 0;
	}
	public void print(){
		JFrame frame = new JFrame("TopLevelDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon foodIcon = createImageIcon("/food.gif", null);
		ImageIcon emptyIcon = createImageIcon("/empty.gif", null);
		ImageIcon poisonIcon = createImageIcon("/poison.gif", null);
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				JLabel label;
				if(i*size+j == agentLoc){
					label = new JLabel();
				}
				else if(map[i*size+j] == 1){
					label = new JLabel(foodIcon);
				}
				else if(map[i*size + j] == 0){
					label = new JLabel(emptyIcon);
				}
				else{
					label = new JLabel(poisonIcon);
				}
				label.setBounds(j*32, i*32, 32, 32);
				label.setOpaque(true);
				frame.getContentPane().add(label);
			}
		}
        frame.pack();
        frame.setSize(new Dimension(size*32*2-16, size*32*2+8));
        frame.setVisible(true);
	}
	protected ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}
