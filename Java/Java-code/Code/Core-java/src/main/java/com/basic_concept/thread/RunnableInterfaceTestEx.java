package com.basic_concept.thread;

class RunnableInterfaceTestEx {
	
	public static void main(String[] args) throws InterruptedException {
		TableCal obj=new TableCal();
		
		Thread t1=new Thread(obj,"t1");
		Thread t2=new Thread(obj,"t2");
		t1.start();
		t2.start();
		t2.join();
		System.out.println(obj.count);
		
		
	}

}



class TableCal implements Runnable {
	volatile int count;
	
	public void run() {
		for (int i = 1; i <= 10; i++) {
			count++;
			System.out.println("for loop"+count);
		}
		
	}
}
 