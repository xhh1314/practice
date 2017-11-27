package practice.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A B C三个线程顺序打印出A B C ,10次
 * @author lh
 *
 */
public class ABCThreadCondition {
	
	public static void main(String[] args){
		final PrintClassV p=new PrintClassV();
		Thread A =new Thread(new Runnable(){
			public void run(){
				int i=0;
				while(i<10){
				p.printA(++i);	
				}
			}
		},"A");
		
		Thread B =new Thread(new Runnable(){
			public void run(){
				int i=0;
				while(i<10){
				p.printB(++i);	
				}
			}
		},"B");
		Thread C =new Thread(new Runnable(){
			public void run(){
				int i=0;
				while(i<10){
				p.printC(++i);	
				}
			}
		},"C");
		
		A.start();
		B.start();
		C.start();
		
	}

	

}
//lock 和tryLock()区别
class PrintClass {
	private final Lock lock=new ReentrantLock();
	private final Condition CA=lock.newCondition();
	private final Condition CB=lock.newCondition();
	private final Condition CC=lock.newCondition();
	private volatile String flag="A";
	public void printA(int i){
		if(lock.tryLock()){
		try{
			while(!flag.equals("A"))
				CA.await();
			System.out.println("当前线程:"+Thread.currentThread().getName()+"第"+i+"次输出");
			flag="B";
			CB.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
		
		}else{
			System.out.println("线程"+Thread.currentThread().getName()+"第"+i+"次try失败");
		}
		
	}
	public void printB(int i){
		if(lock.tryLock()){
		try{
			while(!flag.equals("B")){
				System.out.println("线程:"+Thread.currentThread().getName()+"第"+i+"次try");
				CB.await();
				
			}
			System.out.println("当前线程:"+Thread.currentThread().getName()+"第"+i+"次输出");
			flag="C";
			CC.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
		}else
		{
			System.out.println("线程"+Thread.currentThread().getName()+"第"+i+"次try失败");
		}
		
		
	}
	public void printC(int i){
		if(lock.tryLock()){
		try{
			while(!flag.equals("C")){
				System.out.println("线程:"+Thread.currentThread().getName()+"第"+i+"次try");
				CC.await();
			}
				
			System.out.println("当前线程:"+Thread.currentThread().getName()+"第"+i+"次输出");
			flag="A";
			CA.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
		}else{
			System.out.println("线程"+Thread.currentThread().getName()+"第"+i+"次try失败");
		}
		
		
		
	}
	
	
}

class PrintClassV {
	private final Lock lock=new ReentrantLock();
	private final Condition CA=lock.newCondition();
	private final Condition CB=lock.newCondition();
	private final Condition CC=lock.newCondition();
	private volatile String flag="A";
	public void printA(int i){
		lock.lock();
		try{
			while(!flag.equals("A"))
				CA.await();
			System.out.println("当前线程:"+Thread.currentThread().getName()+"第"+i+"次输出");
			flag="B";
			CB.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
		
		
		
	}
	public void printB(int i){
		lock.lock();
		try{
			while(!flag.equals("B")){
				System.out.println("线程:"+Thread.currentThread().getName()+"第"+i+"次try");
				CB.await();
				
			}
			System.out.println("当前线程:"+Thread.currentThread().getName()+"第"+i+"次输出");
			flag="C";
			CC.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
		
		
		
	}
	public void printC(int i){
		lock.lock();
		try{
			while(!flag.equals("C")){
				System.out.println("线程:"+Thread.currentThread().getName()+"第"+i+"次try");
				CC.await();
			}
				
			System.out.println("当前线程:"+Thread.currentThread().getName()+"第"+i+"次输出");
			flag="A";
			CA.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			lock.unlock();
		}
	
		
		
		
	}
	
	
}