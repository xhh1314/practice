package practice.collection;



import org.junit.Test;

import practice.spring.UserTest;

public class HashMapTest {
	
	
	public static void main(String[] args){
		@SuppressWarnings("unused")
		HashMap1<String,UserTest> map=new HashMap1<String,UserTest>();
		HashMap1<String,Integer> map1=new HashMap1<String,Integer>();
		int i=0;
		while(i<100){
			map1.put(++i+"key",i);
		}
		
		//map.put("lihao",new UserTest("lihao",4));
	  //	map.put("xrr",new UserTest("lihao",34));
		//System.out.println(map.getValue("lihao").getAge());
		//System.out.println(map.getValue("xrr").getAge());
		
	}
	//测试传值问题
	@Test
	public void test2(){
		int a,b;
		a=b=0;
		b=3;
		System.out.println(a);
		
		
	}

}
