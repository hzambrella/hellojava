package threadTest;

import java.util.concurrent.atomic.AtomicReference;

public class TestAtomicReference {
	public static void main(String[] args) {
		final AtomicReference<Integer> money=new AtomicReference<Integer>();
		// �����˻���ʼֵС��20����Ȼ����һ����Ҫ����ֵ���˻�
		money.set(19);

		new Thread(){
			public void run(){
				while(true){
					Integer m=money.get();
					if (m>10){
						money.compareAndSet(m, m-10);
						 System.out.println("�ɹ�����10Ԫ�����:"+money.get());
					}else{
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
		
		
		new Thread(){
			public void run(){
				while(true){
					Integer m=money.get();
					if (m<20){
						money.compareAndSet(m, m+20);
						 System.out.println("�ɹ���ֵ20Ԫ�����:"+money.get());
					}else{
						break;
					}
				}
			}
		}.start();
	}
}
