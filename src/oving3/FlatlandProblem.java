package oving3;

public class FlatlandProblem extends EAProblem{
	public void solve(){
		initChildren();
		while(true){
			evaluateChildren();
			adultSelection();
			parentSelection();
		}
	}
	@Override
	public void initChildren() {
		for(int i = 0; i < childrenCount; i++){
			children.add(new FlatlandPheno(new boolean[0]));
		}
	}
	@Override
	public void evaluateChildren() {
	}
}
