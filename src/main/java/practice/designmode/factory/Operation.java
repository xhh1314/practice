package practice.designmode.factory;

/**
 * 
 * @author lh
 *
 */
public abstract class Operation {
	protected  double frist,second;
	public abstract double calculate();
	
	public double getFrist() {
		return frist;
	}


	public void setFrist(double frist) {
		this.frist = frist;
	}


	public double getSecond() {
		return second;
	}


	public void setSecond(double second) {
		this.second = second;
	}
}
