package practice.spring;

import practice.designmode.factory.CashChargeFactoryPattern;
import practice.lang.StringTest;

public class UserTest {
	
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public UserTest(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public UserTest(){}
	@Override
	public int hashCode(){
		return this.name.hashCode();
	}
	
	public static void main(String[] args){
		//System.out.println(new UserTest().hashCode());
		System.out.println(new StringTest().hashCode());
		System.out.println(new CashChargeFactoryPattern().hashCode());
		System.out.println(new UserTest("lihao",22).hashCode());
		System.out.println(new UserTest("xrr",22).hashCode());
		
	}
	

}
