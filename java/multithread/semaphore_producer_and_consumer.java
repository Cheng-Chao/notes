
	static class zzzzzz {
		Semaphore full = new Semaphore(10, true);
		Semaphore empty = new Semaphore(0, true);
		Lock lock = new ReentrantLock();
		int count = 10;
		public void put() throws InterruptedException {
			empty.acquire();
			try {
				lock.lock();
				count++;
				System.out.println(
						"producer put a obj, count = " + count + " current_id + " + Thread.currentThread().getId());

			} catch (Exception e) {
			} finally {
				lock.unlock();
				full.release();
			}

		}

		public void take() throws InterruptedException {
			full.acquire();
			try {

				lock.lock();
				count--;
				System.out.println(
						"consumer del a obj, count = " + count + " current_id + " + Thread.currentThread().getId());
			} catch (Exception e) {
			} finally {
				lock.unlock();
				empty.release();
			}

		}

	}

	static class produ implements Runnable {
		zzzzzz zz = null;
		produ(zzzzzz input) {
			zz = input;
		}

		public void run() {
			try {
				while (true)
					zz.put();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	static class consu implements Runnable {
		zzzzzz zz = null;

		consu(zzzzzz input) {
			zz = input;
		}

		public void run() {
			try {
				while (true)
					zz.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
