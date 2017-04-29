package com.awiatech.www;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {
	private static int count = 0;

	public static void main(String[] args) {
		// 10���ʼִ������;����֮��ÿ��3��ִ��һ������
		// new Timer().schedule(new TimerTask() {
		// @Override
		// public void run() {
		// System.out.println(Thread.currentThread().getName() + " : bomb!!!");
		// }
		// }, 10000, 3000);

		// ÿ������ִ��һ������
		// class MyTimerTask extends TimerTask {
		// @Override
		// public void run() {
		// System.out.println(Thread.currentThread().getName() + " : bomb!!!");
		// new Timer().schedule(new MyTimerTask(), 2000);
		// }
		// }
		// new Timer().schedule(new MyTimerTask(), 2000);

		/*
		 * ���Ϊ�����4���л�ִ��һ������
		 * 
		 * ˼·��
		 * 
		 * 1.һ�����������static���������л�.
		 * 
		 * 2.������������໥�л�.
		 */
		class MyTimerTask extends TimerTask {
			@Override
			public void run() {
				count = (count + 1) % 2;
				System.out.println(Thread.currentThread().getName() + " : bomb!!!");
				new Timer().schedule(new MyTimerTask(), 2000 + 2000 * count);
			}
		}
		new Timer().schedule(new MyTimerTask(), 2000);

		while (true) {
			System.out.println(Thread.currentThread().getName() + " : " + new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
