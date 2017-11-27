package practice.concurrent;


public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {

	public BoundedBuffer() {
		super();
	}
	public BoundedBuffer(int capacity) {
		super(capacity);
	}

	public synchronized void put(V v) throws InterruptedException {
		while (isFull())
		wait();
		doPut(v);
		notifyAll();
	}
	
	public synchronized V get() throws InterruptedException{
		while(isEmpty())
			wait();
		V v=doGet();
		notifyAll();
		return v;
		
	}
	

}

// ʹ�ü򵥵�˯��ʵ���н绺��
class SleepBoundedBuffer<V> extends BaseBoundedBuffer<V> {

	public SleepBoundedBuffer() {
		super();
	}

	public SleepBoundedBuffer(int capacity) {
		super(capacity);
	}

	public void put(V v) throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (!isFull()) {
					doPut(v);
					return;
				}
			}
			Thread.sleep(100);
		}
	}

	public V get() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (!isEmpty()) {
					return doGet();
				}
			}
			Thread.sleep(100);

		}

	}

}

// ������н绺�������
abstract class BaseBoundedBuffer<V> {
	private final V[] buf;
	private int tail;// ĩ�ڵ�
	private int head;// ͷ���ڵ�
	private int count;

	@SuppressWarnings("unchecked")
	public BaseBoundedBuffer(int capacity) {
		this.buf = (V[]) new Object[capacity];
	}

	@SuppressWarnings("unchecked")
	public BaseBoundedBuffer() {
		this.buf = (V[]) new Object[16];
	}

	protected synchronized final void doPut(V v) {
		if (++tail == buf.length)
			tail = 0;
		buf[tail] = v;
		count++;
	}

	protected synchronized final V doGet() {
		if (++head == buf.length)
			head = 0;
		count--;
		return buf[head];
	}

	public synchronized final boolean isFull() {
		return count == buf.length;
	}

	public synchronized final boolean isEmpty() {
		return count == 0;

	}

}
