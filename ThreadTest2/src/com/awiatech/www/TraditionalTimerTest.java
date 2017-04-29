package com.awiatech.www;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {
	private static int count = 0;

	public static void main(String[] args) {
		// 10秒后开始执行任务;或者之后每隔3秒执行一次任务
		// new Timer().schedule(new TimerTask() {
		// @Override
		// public void run() {
		// System.out.println(Thread.currentThread().getName() + " : bomb!!!");
		// }
		// }, 10000, 3000);

		// 每隔两秒执行一次任务
		// class MyTimerTask extends TimerTask {
		// @Override
		// public void run() {
		// System.out.println(Thread.currentThread().getName() + " : bomb!!!");
		// new Timer().schedule(new MyTimerTask(), 2000);
		// }
		// }
		// new Timer().schedule(new MyTimerTask(), 2000);

		/*
		 * 间隔为两秒或4秒切换执行一次任务
		 * 
		 * 思路：
		 * 
		 * 1.一个任务对象由static变量控制切换.
		 * 
		 * 2.两个任务对象相互切换.
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
