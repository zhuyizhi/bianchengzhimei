package design.Pattern;

public class Singleton {
	public static int count = 0;
	private static Singleton s = new Singleton();
	private String str;
	private Singleton(String  str){
		this.str = str;
		count++;
	}
	
	private Singleton(){
		this("this is singleton mode");
	}
	
	public Singleton getInstance(){
		return s;
	}
}
