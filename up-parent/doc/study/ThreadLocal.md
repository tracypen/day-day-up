### ThreadLocal 用法
>* ThreadLocal为解决多线程程序的并发问题提供了一种新的思路。使用这个工具类可以很简洁地编写出优美的多线程程序。
>* 当使用ThreadLocal维护变量时，ThreadLocal为每个使用该变量的线程提供独立的变量副本，所以每一个线程都可以独立地改变自己的副本，而不会影响其它线程所对应的副本。
>* 如果你定义了一个单实例的java bean，它有若干属性，但是有一个属性不是线程安全的，比如说HashMap。并且碰巧你并不需要在不同的线程中共享这个属性，也就是说这个属性不存在跨线程的意义。那么你不要sychronize这么复杂的东西，ThreadLocal将是你不错的选择。

 
先看一个简单的示例：


	package com.hp.up.test.ThreadLocal;

	import java.util.HashMap;
	/**
	 * Created by haopeng on 2017/12/27 16:45
		 */

	public class Test2 {

    static ThreadLocal<HashMap> map0 = new ThreadLocal<HashMap>(){
        @Override
        protected HashMap initialValue() {
            System.out.println(Thread.currentThread().getName()+"initialValue");
            return new HashMap();
        }
    };
    public void run(){
        Thread[] runs = new Thread[3];
        for(int i=0;i<runs.length;i++){
            runs[i]=new Thread(new T1(i));
        }
        for(int i=0;i<runs.length;i++){
            runs[i].start();
        }
    }
    public static class T1 implements Runnable{
        int id;
        public T1(int id0){
            id = id0;
        }
        public void run() {
            System.out.println(Thread.currentThread().getName()+":start");
            HashMap map = map0.get();
            for(int i=0;i<10;i++){
                map.put(i, i+id*100);
                try{
                    Thread.sleep(100);
                }catch(Exception ex){
                }
            }
            System.out.println(Thread.currentThread().getName()+':'+map);
        }
    }
    /**
     * Main
     * @param args
     */
    public static void main(String[] args){
        Test2 test = new Test2();
        test.run();
    }

	}

控制台打印
![](http://upload-images.jianshu.io/upload_images/8387919-b4387e5ba7977df3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
可以看到map0 虽然是个静态变量，但是initialValue被调用了三次，通过debug发现，initialValue是从map0.get处发起的。而且每个线程都有自己的map，虽然他们同时执行。

查看Theadlocal源码，可以发现get()方法：

    /**
     * Returns the value in the current thread's copy of this
     * thread-local variable.  If the variable has no value for the
     * current thread, it is first initialized to the value returned
     * by an invocation of the {@link #initialValue} method.
     *
     * @return the current thread's value of this thread-local
     */
    public T get() {
        Thread t = Thread.currentThread();
        ThreadLocalMap map = getMap(t);
        if (map != null) {
            ThreadLocalMap.Entry e = map.getEntry(this);
            if (e != null) {
                @SuppressWarnings("unchecked")
                T result = (T)e.value;
                return result;
            }
        }
        return setInitialValue();
    }
这说明ThreadLocal确实只有一个变量，但是它内部包含一个map，针对每个thread保留一个entry，如果对应的thread不存在则会调用initialValue。