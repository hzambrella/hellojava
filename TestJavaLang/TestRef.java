package TestJavaLang;

import java.lang.ref.*;

//引用
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
		System.out.println(softRef.get());// 不一定是null
		WeakReference<String> weakRef = new WeakReference<String>(new String(
				"weakRef"));
		System.out.println(weakRef.get());
		System.gc();
		System.out.println(weakRef.get());// null

		// 虚引用。虚引用是get不到东西的（源码中get返回null）。它和引用队列配合来跟踪对象垃圾回收状态。
		ReferenceQueue<String> refQueue = new ReferenceQueue<String>();
		PhantomReference<String> referent = new PhantomReference<String>(
				new String("T"), refQueue);
		System.out.println(referent.get());// null
		System.out.println(refQueue.poll() == referent);//false
		System.gc();
		System.runFinalization();
		//当虚引用所引用对象被垃圾回收后，虚引用会被添加到这个队列中
		System.out.println(refQueue.poll() == referent); // true
	}
}
