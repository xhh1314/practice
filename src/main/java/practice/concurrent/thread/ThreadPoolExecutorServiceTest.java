package practice.concurrent.thread;

import java.util.concurrent.*;

public class ThreadPoolExecutorServiceTest {
	
	public static void main(String[] args){
		Executors dd;
		ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(2, 4, 1, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
		threadPoolExecutor.execute(new PullImage());
		threadPoolExecutor.execute(new PullImage());
		threadPoolExecutor.execute(new PullImage());
		threadPoolExecutor.execute(new PullImage());
		threadPoolExecutor.execute(new PullImage());
		threadPoolExecutor.execute(new PullImage());

	}

}
class PullImage implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub

		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+":downloading image!");
		}
	}
	
	
	
}
