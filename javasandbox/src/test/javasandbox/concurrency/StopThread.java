package test.javasandbox.concurrency;

import java.util.concurrent.TimeUnit;

public class StopThread {
	private static volatile boolean stop;

	public static void main(String[] args) {
		new Thread(new Runnable() {
			public void run() {
				while (!stop) {
					System.out.println("In while ...");
				}
			}
		}).start();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		stop = true;
	}
}
