package practice.designmode.factory;


public class OperationTest {

	public static void main(String[] args){
		double frist=NumberInput.captureNumber();
		System.out.println(frist);
		char operate=NumberInput.captureOperate();
		System.out.println(operate);
		double second=NumberInput.captureNumber();
		System.out.println(second);
		Operation oper=OperationFactory.getOperationInstance(operate);
		oper.setFrist(frist);
		oper.setSecond(second);
		System.out.println("the resulte is:"+oper.calculate());
		
	}
	
	

}
