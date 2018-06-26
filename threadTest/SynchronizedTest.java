package threadTest;

public class SynchronizedTest {
    private Object lock = new Object();

    public void synchronizedBlockOnObject(long executeTime) {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " -> start synchronizedBlockOnObject");
            doSomething(executeTime);
            System.out.println(Thread.currentThread().getName() + " -> end synchronizedBlockOnObject");
        }
    }

    public void synchronizedBlockOnThis(long executeTime) {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " -> start synchronizedBlockOnThis");
            doSomething(executeTime);
            System.out.println(Thread.currentThread().getName() + " -> end synchronizedBlockOnThis");
        }
    }

    public void synchronizedBlockOnClass(long executeTime) {
        synchronized (SynchronizedTest.class) {
            System.out.println(Thread.currentThread().getName() + " -> start synchronizedBlockOnClass");
            doSomething(executeTime);
            System.out.println(Thread.currentThread().getName() + " -> end synchronizedBlockOnClass");
        }
    }

    public synchronized void synchronizedMethodOnThis(long executeTime) {
        System.out.println(Thread.currentThread().getName() + " -> start synchronizedMethodOnThis");
        doSomething(executeTime);
        System.out.println(Thread.currentThread().getName() + " -> end synchronizedMethodOnThis");
    }

    public static synchronized void synchronizedMethodOnClass(long executeTime) {
        System.out.println(Thread.currentThread().getName() + " -> start synchronizedMethodOnClass");
        doSomething(executeTime);
        System.out.println(Thread.currentThread().getName() + " -> end synchronizedMethodOnClass");
    }

    private static void doSomething(long executeTime) {
        try {
            Thread.sleep(executeTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
         final SynchronizedTest s= new SynchronizedTest();
         final SynchronizedTest s1= new SynchronizedTest();
         final SynchronizedTest s2= new SynchronizedTest();

/*        new Thread(new Runnable() {
            @Override
            public void run() {
                s.synchronizedMethodOnThis(3000);
            }
        }, "Thread non-static synchronized method").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                SynchronizedTest.synchronizedMethodOnClass(2000);
            }
        }, "Thread static sybchronized method").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                s.synchronizedBlockOnObject(4000);
            }
        }, "Thread sybchronized block on other Object").start();*/
        
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                s1.synchronizedBlockOnThis(3000);
            }
        }, "1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                s2.synchronizedBlockOnThis(2000);
            }
        }, "2").start();

    }
}
