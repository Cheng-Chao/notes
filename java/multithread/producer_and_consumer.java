
class boundedbuffer {
	Lock lock = new ReentrantLock();
	Condition notfull = lock.newCondition();
	Condition notempty = lock.newCondition();
	static volatile int count = 0;
	final int SIZE = 10;

	public void put() throws InterruptedException {
		lock.lock();
		try {
			while (count == SIZE)
				notfull.await();
			count++;
			System.out.println(
					"producer input a obj, count = " + count + " current_id + " + Thread.currentThread().getId());

			notempty.signal();
		} finally {
			lock.unlock();
		}
	}

	public void take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notempty.await();
			count--;
			System.out.println(
					"producer input a obj, count = " + count + " current_id + " + Thread.currentThread().getId());

			notfull.signal();
		} finally {
			lock.unlock();
		}
	}
}

class producer implements Runnable {
	boundedbuffer bbf = null;

	public producer(boundedbuffer input) {
		bbf = input;
	}

	public void run() {
		try {
			while (true) {
				bbf.put();
				Thread.sleep((int) (Math.random() * 4));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class consumers implements Runnable {
	boundedbuffer bbf = null;

	public consumers(boundedbuffer input) {
		bbf = input;
	}

	public void run() {
		try {
			while (true) {

				bbf.take();
				Thread.sleep((int) (Math.random() * 4));
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
