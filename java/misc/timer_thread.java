/*
 * after reading the class TimerThread
 * I write a simple example to explain what a timer_thread does.* 
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

		TimerThread(Runnable task, int period, int times) {
			this.task = task;
			this.period = period;
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

	public static void main(String[] args) {
		new TimerThread(new Task(), 100, 10).start(); // execute the task for 10 times, every 100 milliseconds.
	}
}
