
	class BoundedBuffer {
		   final Lock lock = new ReentrantLock();
		   final Condition notFull  = lock.newCondition(); 
		   final Condition notEmpty = lock.newCondition(); 

		   final Object[] items = new Object[10];
		   int putptr, takeptr, count;

		   public void put(Object x) throws InterruptedException {
		     lock.lock();
		     try {
		       while (count == items.length)
		         notFull.await();
		       items[putptr] = x;
		       if (++putptr == items.length) putptr = 0;
		       ++count;
		       System.out.println("producer input a obj, count = "+count+" current_id + "+Thread.currentThread().getId());
		       notEmpty.signal();
		     } finally {
		       lock.unlock();
		     }
		   }

		   public Object take() throws InterruptedException {
		     lock.lock();
		     try {
		       while (count == 0)
		         notEmpty.await();
		       Object x = items[takeptr];
		       if (++takeptr == items.length) takeptr = 0;
		       --count;
		       System.out.println("consumer del a obj, count = "+count+" current_id + "+Thread.currentThread().getId());

		       notFull.signal();
		       return x;
		     } finally {
		       lock.unlock();
		     }
		   }
		 }
	
	
	class produce implements Runnable{
		BoundedBuffer jin= null;
		
		produce(BoundedBuffer input ){
			jin = input;
			
		}
		@SuppressWarnings("deprecation")
		public void run() {
			try {
				while(true) {
					jin.put(new Integer(1));
					Thread.sleep((int)(Math.random()*10));
				}				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	class consumer implements Runnable{
		BoundedBuffer jin= null;
		
		consumer(BoundedBuffer input ){
			jin = input;
			
		}
		@SuppressWarnings("deprecation")
		public void run() {
			try {
				while(true) {
					jin.take();
					Thread.sleep((int)(Math.random()*10));
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
