package practice.normal;

public class InheritanceTest {

	public InheritanceTest() {
		// TODO Auto-generated constructor stub
	}

}

/**
 * 测试属性方法会不会被多重继承 
 * @author lh
 * @date 2017年10月16日
 * @version 
 */
class A {
	
	int A;
	 void printA(){}
}
class B extends A{
	int B;
	public void printB(){};
}

class C extends B{
	int C;
	public void printC(){
		printA();
	}
}