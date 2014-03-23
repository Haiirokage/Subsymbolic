package oving3;

public abstract class Phenotype{
	boolean[] genotype;
	double fitness = 0;
	public Phenotype(boolean[] genotype){
		this.genotype = genotype;
	}
}
