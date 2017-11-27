package practice.designmode.factory;

public class OperationFactory {

	public static Operation getOperationInstance(char operate) {

		Operation oper = null;
		switch (operate) {
		case '+':
			oper = new AdditionOperation();
			break;
		case '*':
			oper=new MultiplicationOperation();
			break;

		}
		return oper;
	}

}
