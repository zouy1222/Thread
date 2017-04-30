package com.awiatech.www;

/**
 * 互斥使用synchronized关键字,后面检查锁对象.多个线程实现同步,必须使用同一把锁.
 * 
 * @author Chicago
 *
 */
public class TraditionalThreadSychronized {

	public static void main(String[] args) {
		new TraditionalThreadSychronized().init();
	}

	private void init() {
		final Outputer outputer = new Outputer();
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("zhangxiaoxiang");
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output3("lihuoming");
				}
			}
		}).start();
	}

	static class Outputer {

		public void output(String name) {
			int len = name.length();
			synchronized (Outputer.class) {// this,表示和output2方法同步;此时,表示和output3方法同步;
				for (int i = 0; i < len; i++) {
					System.out.print(name.charAt(i));
				}
				System.out.println();
			}
		}

		public synchronized void output2(String name) {
			int len = name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}

		public static synchronized void output3(String name) {
			int len = name.length();
			for (int i = 0; i < len; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}
	}
}
