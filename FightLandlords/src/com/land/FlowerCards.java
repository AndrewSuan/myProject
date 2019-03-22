package com.land;

public class FlowerCards {
	String flowerc;
	int value;
	
	@Override
	public String toString() {
		return flowerc;			//重写toString 输出牌号
	}

	public FlowerCards(String flowerc) {   //传入牌号自动赋值value,value用来排序
		this.flowerc = flowerc;
		this.value=calculval(flowerc);
	}

	static int calculval(String flowerc) {
		char flower = flowerc.charAt(0);
		char card = flowerc.charAt(1);
		int value=0;
		
		if(flower=='♠') {					//花色权重
			value+=1;
		}
		else if(flower=='♥'){
			value+=2;
		}
		else if(flower=='♣') {
			value+=3;
		}
		else if(flower=='♦'){
			value+=4;
		}
		else {		//大小鬼
			value+=100;
		}
		
		
		if(card=='3') {						//牌值权重
			value+=10;
		}
		else if(card=='4'){
			value+=20;
		}
		else if(card=='5') {
			value+=30;
		}
		else if(card=='6'){
			value+=40;
		}
		else if(card=='7') {
			value+=50;
		}
		else if(card=='8'){
			value+=60;
		}
		else if(card=='9') {
			value+=70;
		}
		else if(card=='1'){				//这个代表10
			value+=80;
		}
		else if(card=='J') {
			value+=90;
		}
		else if(card=='Q'){
			value+=100;
		}
		else if(card=='K'){
			value+=110;
		}
		else if(card=='A'){
			value+=120;
		}
		else if(card=='2'){
			value+=130;
		}
		else if(card=='鬼') {
			value+=1000;
		}
		return value;
	}
}
