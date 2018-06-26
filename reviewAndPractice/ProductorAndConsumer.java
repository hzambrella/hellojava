package reviewAndPractice;

import java.util.ArrayList;
import java.util.List;

public class ProductorAndConsumer {
	int maxOfSize = 10;
	boolean flag = true;
	List<Product> list = new ArrayList<Product>();
	
	public static void main(String[] args) {
		ProductorAndConsumer pc=new ProductorAndConsumer();
		Productor p1=pc.new Productor("p1");
		Productor p2=pc.new Productor("p2");
		Productor p3=pc.new Productor("p3");
		Consumer c1=pc.new Consumer("c1");
		Consumer c2=pc.new Consumer("c2");
		Thread tp1=new Thread(p1,"p1");
		Thread tp2=new Thread(p2,"p2");
		Thread tp3=new Thread(p3,"p3");
		Thread tc1=new Thread(c1,"c1");
		Thread tc2=new Thread(c2,"c1");
		
		tp1.start();
		tp2.start();
		tp3.start();
		tc1.start();
		tc2.start();
	}
	

	class Product {
		private String productorName;

		Product(String productorName) {
			System.out.println("生产者" + productorName + "生产了产品");
			this.productorName = productorName;
		}

		public String getProductorName() {
			return productorName;
		}

		public void setProductorName(String productorName) {
			this.productorName = productorName;
		}
	}

	class Productor implements Runnable {
		String name;
		Productor(String name){
			this.name=name;
		}
		@Override
		public void run() {
			while (flag) {
				synchronized (list) {
					if (list.size() >= maxOfSize) {
						try {
							list.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						list.add(new Product(this.name));
						try {
							Thread.sleep(20);
							list.notifyAll();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}

	}

	class Consumer implements Runnable {
		String name;
		Consumer(String name){
			this.name=name;
		}
		@Override
		public void run() {
			while (flag) {
				synchronized (list) {
					if (list.size() <=0) {
						try {
							list.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						Product p=list.get(0);
						String pname=p.getProductorName();
						System.out.println("消费者"+name+"消费了" + pname + "生产的产品");
						list.remove(0);
						try {
							Thread.sleep(20);
							list.notifyAll();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}

	}

}
