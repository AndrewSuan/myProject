package play;
/*
 * 1.ƹ����������˶�Ա
 * 2.ƹ������������
 * 3������������˶�Ա��˵Ӣ��*/
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
		System.out.println("�˶�Ҫ˯��");
	}
}
abstract class Player extends Person{
	abstract void play();
	@Override
	void eat() {
		System.out.println("�˶�Ա������");
		
	}
	
}
abstract class Coach extends Person{
	abstract void play();
	@Override
	void eat() {
		System.out.println("�������Բ�");
		
	}
	
}

class PingP extends Player{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("��ƹ��");
	}
	
}

class BasketballP extends Player{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
	void seng() {
		System.out.println("��Ӣ��");
	}
	
}
class PingC extends Coach{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("��ƹ��");
	}
	
}

class BasketballC extends Coach{

	@Override
	void play() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
	void seng() {
		System.out.println("��Ӣ��");
	}
	
}

interface SpeakE{
	void seng();
}

