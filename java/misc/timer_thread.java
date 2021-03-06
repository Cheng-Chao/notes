/*
 * after reading the class Timer
 * I write a simple example to explain what a timer does.* 
 *
 *  
 * Of course, a timer is much more complicated. It has a minimum heap - priority queue, which sort all task by the time. 
 * Every time, the timer will let the queue wait least time, and then notify the first task,and execute it.  
 *  
 */
package zhaojinzhou;

public class zhaojinzhou {

	static class Task implements Runnable {
		public void run() {
			System.out.println("zhaozhaozhao");
		}
	}

	static class TimerThread extends Thread {

		Runnable task;
		int period;
		int times;
		
		
		
		public void setTask(Runnable task) {
			this.task = task;
		}

		public void setPeriod(int period) {
			this.period = period;
		}

		public void setTimes(int times) {
			this.times = times;
		}

		
		
		public void run() {
			for (int i = 0; i < this.times; i++) // to do the task for n times

				synchronized (task) {
					task.run();

					try {
						task.wait(this.period); // wait for period time millisecond;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

		}

	}
	
	
	static class Timer{
		TimerThread tt = new TimerThread();
		Timer(Task input, int period, int times){
			tt.setTask(input);
			tt.setTimes(times);
			tt.setPeriod(period);
			tt.start();
		}
		
		
	}

	public static void main(String[] args) {
		new Timer(new Task(), 100, 10); // execute the task for 10 times, every 100 milliseconds.
	}
}
