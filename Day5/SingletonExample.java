package Day5;

class SingletonEager {
	private static SingletonEager instance = new SingletonEager();

	private SingletonEager() {
	}

	public static SingletonEager getInstance() {
		return instance;
	}
}

class SingletonLazy {
	private static SingletonLazy instance1;

	private SingletonLazy() {
	}
// not thread safe as multiple user can access at the same time
	public static SingletonLazy getInstance() {
		if (instance1 == null) {
			instance1 = new SingletonLazy();
		}
		return instance1;
	}
}
//one way of making it synchronized is by directly making the m/d synchronised
class SingletonSynchronizedMethod{
	private static SingletonSynchronizedMethod instance;
	private SingletonSynchronizedMethod() {}
	
	public static synchronized SingletonSynchronizedMethod getInstance() {
		if(instance==null) {
			instance=new SingletonSynchronizedMethod();
		}
		return instance;
	}
}
class SingletonSynchronized{
	private static SingletonSynchronized instance;
	private SingletonSynchronized() {};
	public static SingletonSynchronized getInstance() {
		if(instance==null) {
			//putting the obj of class as an argument in synchronised block
			synchronized (SingletonSynchronized.class) {
				if(instance==null) {
					instance=new SingletonSynchronized();
				}
			}
		}
		return instance;
	}
		
}
public class SingletonExample {

	public static void main(String[] args) {

		// eager
		SingletonEager instance1 = SingletonEager.getInstance();
		System.out.println(instance1);
		SingletonEager instance2 = SingletonEager.getInstance();
		System.out.println(instance2);

		// lazy
		SingletonLazy lazy1 = SingletonLazy.getInstance();
		SingletonLazy lazy2 = SingletonLazy.getInstance();
		System.out.println(lazy1);
		System.out.println(lazy2);

		//synchronised using synchronised method
		SingletonSynchronizedMethod s1=SingletonSynchronizedMethod.getInstance();
		SingletonSynchronizedMethod s2=SingletonSynchronizedMethod.getInstance();
		System.out.println(s1);
		System.out.println(s2);
		
		///synchronised using synchronised block
		SingletonSynchronized ss1=SingletonSynchronized.getInstance();
	    SingletonSynchronized ss2 =SingletonSynchronized.getInstance();
	    System.out.println(ss1+", "+ss2);
		
		
	}

}
