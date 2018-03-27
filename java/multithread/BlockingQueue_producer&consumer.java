package eeeeeee;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

class producer implements Runnable {
	BlockingQueue bq;

	public producer(BlockingQueue bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			bq.offer(1);
			System.out.println("+1 " + bq.size() + " " + Thread.currentThread().getId());
			try {
				Thread.sleep((int) (Math.random() * 200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

class consumer implements Runnable {
	BlockingQueue bq;

	public consumer(BlockingQueue bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				bq.take();
				System.out.println("-1 " + bq.size() + " " + Thread.currentThread().getId());
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

class zhao {
	public static void main(String[] args) {

		BlockingQueue<Integer> bq = new LinkedBlockingQueue(10);
		
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=0;i<5;i++) {
			es.execute(new producer(bq));
			es.execute(new consumer(bq));
		}

				

	}
}
