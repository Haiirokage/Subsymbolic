package oving3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public abstract class EAProblem {
	ArrayList<Phenotype> children = new ArrayList<Phenotype>();
	ArrayList<Phenotype> adults = new ArrayList<Phenotype>();
	int adultCount;
	int childrenCount;
	int eliteCount;
	public abstract void initChildren();
	public abstract void evaluateChildren();
	public void adultSelection(){
		sortChildren();
		
	}
	public void parentSelection(){
		//TODO
	}
	public void sortChildren(){
		Collections.sort(children, new Comparator<Phenotype>() {
		        @Override
		        public int compare(Phenotype  p1, Phenotype  p2)
		        {
		        	return Double.compare(p1.fitness, p2.fitness);
		        }
		    });
	}
}
