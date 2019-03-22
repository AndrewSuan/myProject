package play;
/*
 * 1.乒乓球和篮球运动员
 * 2.乒乓球和篮球教练
 * 3。篮球教练和运动员会说英语*/
public class PlayCoach {
	public static void main(String[] args) {
		PingC den =new PingC();
		den.age=22;
		den.play();
		den.eat();
		BasketballC yao =new BasketballC();
		yao.eat();
		yao.play();
		yao.seng();
		BasketballP lin =new BasketballP();
		lin.eat();
		lin.play();
		lin.seng();
	}
}
abstract class Person{
	String name;
	int age;
	String gender;
	
	abstract void eat();
	void sleep() {
		System.out.println("人都要睡觉");
	}
}
abstract class Player extends Person{
	abstract void play();
	@Override
	void eat() {
		System.out.println("运动员爱吃肉");
		
	}
	
}
abstract class Coach extends Person{
	abstract void play();
	@Override
	void eat() {
		System.out.println("教练爱吃菜");
		
	}
	
}

class PingP extends Player{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("打乒乓");
	}
	
}

class BasketballP extends Player{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("打篮球");
	}
	void seng() {
		System.out.println("讲英语");
	}
	
}
class PingC extends Coach{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("教乒乓");
	}
	
}

class BasketballC extends Coach{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("教篮球");
	}
	void seng() {
		System.out.println("讲英语");
	}
	
}

interface SpeakE{
	void seng();
}

