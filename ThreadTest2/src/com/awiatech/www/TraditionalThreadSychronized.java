package com.awiatech.www;

/**
 * ����ʹ��synchronized�ؼ���,������������.����߳�ʵ��ͬ��,����ʹ��ͬһ����.
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
			synchronized (Outputer.class) {// this,��ʾ��output2����ͬ��;��ʱ,��ʾ��output3����ͬ��;
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
