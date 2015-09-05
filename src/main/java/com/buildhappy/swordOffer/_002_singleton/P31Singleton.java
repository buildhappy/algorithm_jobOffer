package com.buildhappy.swordOffer._002_singleton;

/**
 * 单例设计模式
 * @author buildhappy
 *
 */
public class P31Singleton {
    public static void main( String[] args ){
        Singleton4.instance.say();
    }
}
/************************* 懒汉模式 ********************************/
/**
 * 只适用于单线程的单例模式--not good
 * @author buildhappy
 *
 */
class Singleton1{
	private static Singleton1 instance = null;

	private Singleton1(){
		
	}
	
	public static Singleton1 getInstance(){
		if(instance == null){
			instance = new Singleton1();
		}
		return instance;
	}
}

/**
 * 多线程情况下能工作，但效果不好
 * @author buildhappy
 *
 */
class Singleton2{
	private static Singleton2 instance = null;
	private Singleton2(){
		
	}
	public static Singleton2 getInstance(){
		synchronized(Singleton2.class){
			if(instance == null){
				instance = new Singleton2();
			}
		}
		return instance;
	}
	/**
	 * 双重校验锁
	 * 相对于getInstance()，该方法效率能高一点
	 * @return
	 */
	public static Singleton2 getInstance2(){
		if(instance == null){
			synchronized(Singleton2.class){
				if(instance == null){
					instance = new Singleton2();
				}
			}
		}
		return instance;
	}
}

/************************* 饿汉模式 ********************************/

/**
 * 比较推荐的做法
 * @author Administrator
 *
 */
class Singleton3{
	private static Singleton3 instance = new Singleton3();
	private Singleton3(){
		
	}
	public static Singleton3 getInstance(){
		return instance;
	}
}

/************************* 枚举方式 ********************************/
/**
 * 
 * @author buildhappy
 *
 */
enum Singleton4{
	instance;
	public void say(){
		System.out.println("hello");
	}
}
