package jedis;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class LinkedBlockingQueue<T> implements BlockingQueue<Integer> {
	Queue<Integer> buffer = new LinkedList<>();
	int size;
	Lock lock = new ReentrantLock();
	Condition not_empty = lock.newCondition();
	Condition not_full = lock.newCondition();

	public LinkedBlockingQueue(int size) {
		super();
		this.size = size;
	}

	@Override
	public Integer element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer poll() {
		// TODO Auto-generated method stub
		lock.lock();
		Integer ret;
		while (buffer.size() == 0) {
			try {
				not_full.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ret = buffer.poll();
		not_empty.signal();

		lock.unlock();
		return ret;

	}

	@Override
	public Integer remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addAll(Collection<? extends Integer> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return buffer.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(Integer arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int drainTo(Collection<? super Integer> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int drainTo(Collection<? super Integer> arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean offer(Integer arg0) {
		// TODO Auto-generated method stub
		lock.lock();
		boolean ret;
		while (buffer.size() == size) {
			try {
				not_empty.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ret = buffer.offer(arg0);
		not_full.signal();

		lock.unlock();
		return true;
	}

	@Override
	public boolean offer(Integer arg0, long arg1, TimeUnit arg2) throws InterruptedException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer poll(long arg0, TimeUnit arg1) throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(Integer arg0) throws InterruptedException {
		// TODO Auto-generated method stub

	}

	@Override
	public int remainingCapacity() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer take() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}

}

class producer implements Runnable {
	BlockingQueue<Integer> bq;

	public producer(BlockingQueue<Integer> bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			bq.offer(Integer.valueOf(1));
			try {
				Thread.sleep((int)(Math.random()*200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("size == " + bq.size() + "      " + Thread.currentThread().getId() + "     put one int");
		}
	}

}

class consumer implements Runnable {
	BlockingQueue<Integer> bq;

	public consumer(BlockingQueue<Integer> bq) {
		super();
		this.bq = bq;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			bq.poll();
			try {
				Thread.sleep((int)(Math.random()*200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out
					.println("size == " + bq.size() + "      " + Thread.currentThread().getId() + "     take one int");
		}

	}

}

public class test {
	public static void main(String[] args) {
		BlockingQueue<Integer> bq = new LinkedBlockingQueue<Integer>(10);
		for (int i = 0; i < 5; i++) {
			new Thread(new producer(bq)).start();
			new Thread(new consumer(bq)).start();
		}
	}
}
