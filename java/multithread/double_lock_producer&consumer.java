package eeeeeee;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BQ {
	final int count = 10;
	public volatile AtomicInteger ai = new AtomicInteger(0);
	Lock putlock = new ReentrantLock();
	Condition not_full = putlock.newCondition();
	Lock takelock = new ReentrantLock();
	Condition not_empty = putlock.newCondition();

	public void offer() {
		try {
			putlock.lock();
			while (ai.get() == count)
				not_full.await();
			ai.incrementAndGet();
			System.out.println("+1 " + ai + " " + Thread.currentThread().toString());
		} catch (Exception e) {
		} finally {
			not_empty.signal();
			putlock.unlock();
		}

	}

	public void poll() {
		try {
			putlock.lock();
			while (ai.get() == 0)
				not_empty.await();
			ai.decrementAndGet();
			System.out.println("-1 " + ai + " " + Thread.currentThread().toString());
		} catch (Exception e) {
		} finally {
			not_full.signal();
			putlock.unlock();
		}

	}
}

class producer implements Runnable {
	BQ bq;

	public producer(BQ bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			bq.offer();
//			System.out.println("+1 " + bq.ai + " " + Thread.currentThread().toString());
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}

class consumer implements Runnable {
	BQ bq;

	public consumer(BQ bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				bq.poll();
//				System.out.println("-1 " + bq.ai + " " + Thread.currentThread().toString());
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

		BQ bq = new BQ();

		ExecutorService es = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 5; i++) {
			es.execute(new producer(bq));
			es.execute(new consumer(bq));
		}

	}
}
