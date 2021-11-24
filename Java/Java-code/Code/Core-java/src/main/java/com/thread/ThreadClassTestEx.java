package com.thread;

class ThreadClassTestEx extends Thread {
	
	int num=5;
	static int count=0;
	ThreadClassTestEx(){
		
	}
	
	ThreadClassTestEx(String threadName){
		super(threadName);
	}
	
	public static void main(String[] args) throws InterruptedException {
		ThreadClassTestEx t1=new ThreadClassTestEx("t1");
		ThreadClassTestEx t2=new ThreadClassTestEx("t2");
		t1.start();
		//t1.join();
		t2.start();
		
		//ThreadClassTestEx o=new ThreadClassTestEx();
		
		System.out.println(count);
		
	}
	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			//System.out.println(i*5+"----"+Thread.currentThread());
			count++;
		}
	}

}


/*
 * class TableCal extends Thread{
 * 
 * TableCal(String name){ super(name); }
 * 
 * 
 * @Override public void run() { for(int i=1;i<10;i++) {
 * System.out.println(i+"--"+Thread.currentThread()); } }
 * 
 * }
 */