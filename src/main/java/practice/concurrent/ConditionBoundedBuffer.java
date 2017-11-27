package practice.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author lh
 *
 * @param <V>
 */
public class ConditionBoundedBuffer<V> {
	private int tail,head,count;
	private final V[] buff;
	private final ReentrantLock lock=new ReentrantLock();
	private final Condition notFull=lock.newCondition();
	private final Condition notEmpty=lock.newCondition();

	public ConditionBoundedBuffer(int capacity) {
		// TODO Auto-generated constructor stub
		this.buff=(V[])new Object[capacity];
	}
	public ConditionBoundedBuffer() {
		// TODO Auto-generated constructor stub
		this.buff=(V[])new Object[16];
	}
	public V get() throws InterruptedException{
		lock.lock();
		try{
			while(count==0)
				notEmpty.await();
			V v=buff[head];
			buff[head]=null;
			if(++head==buff.length)
				head=0;
			count--;
			notFull.signal();
			return v;
		}finally{
			lock.unlock();
		}
	}
	
	public void put(V v) throws InterruptedException{
		lock.lock();
		try{
			while(count==buff.length)
				notFull.await();
			buff[tail]=v;
			if(++tail==buff.length)
				tail=0;
			count++;
			notEmpty.signal();
		}finally{
			lock.unlock();
		}
		
	}
	
	

}
