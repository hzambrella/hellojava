package TestJavaLang;

import java.lang.ref.*;

//����
public class TestRef {
	public static void main(String[] args) {
		String test="hardRef";
		String test2="hardRe"+new String("f");
		String hardRef = new String("hardRef");
		String test31="hard";
		String test32="hard";
		String test3=test31+test32;
		System.out.println(test==hardRef);
		System.out.println(test==test2);
		System.out.println(test==test3);
		
		System.out.println(hardRef);
		SoftReference<String> softRef = new SoftReference<String>(new String(
				"softRef"));
		System.out.println(softRef.get());
		System.gc();
		System.out.println(softRef.get());// ��һ����null
		WeakReference<String> weakRef = new WeakReference<String>(new String(
				"weakRef"));
		System.out.println(weakRef.get());
		System.gc();
		System.out.println(weakRef.get());// null

		// �����á���������get���������ģ�Դ����get����null�����������ö�����������ٶ�����������״̬��
		ReferenceQueue<String> refQueue = new ReferenceQueue<String>();
		PhantomReference<String> referent = new PhantomReference<String>(
				new String("T"), refQueue);
		System.out.println(referent.get());// null
		System.out.println(refQueue.poll() == referent);//false
		System.gc();
		System.runFinalization();
		//�������������ö����������պ������ûᱻ��ӵ����������
		System.out.println(refQueue.poll() == referent); // true
	}
}
