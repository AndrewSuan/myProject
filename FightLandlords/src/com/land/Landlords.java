package com.land;
/*
 * 1.有一副54张牌
 * 2.把牌洗了
 * 3.抽取三张作为底牌，定义一张翻牌
 * 4.51张牌分发给三个人（还要创建三个人）
 * 5.拿到翻牌则为地主，获取另外三张底牌
 * 6.将每个人的牌按照顺序排列*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Landlords {
	public static void main(String[] args) {
//		FlowerCards fc =new FlowerCards("♥K");
//		System.out.println(fc.value);
		List<FlowerCards> pockValue =new ArrayList<FlowerCards>();		//保存带权值的扑克牌的集合

		
		Person array[]=new Person[3];				//保存三个人的数组
		List<String> pock=new ArrayList<String>();	//保存一副牌的集合
		getpock(pock);								//得到扑克
		String bottomc[] =new String[3];			//保存三张底牌的数组
		String landc = null;								//保存地主牌
		List<String> person1c=new ArrayList<String>();	//保存发牌后三幅牌
		List<String> person2c=new ArrayList<String>();
		List<String> person3c=new ArrayList<String>();
		

		

		
//		System.out.println(pock);
					while(true) {
							menu();
							Scanner sc =new Scanner(System.in);
							String choice = sc.nextLine();
							switch(choice) {
							case "1":						//展示玩家
								array=ShowPlay();
								break;
							case "2":
								Collections.shuffle(pock);	//洗牌
								System.out.println("洗牌后："+pock);
//								System.out.println(pock.size());
								break;
							case "3":
								List<String> copyli =new ArrayList<String>();	    //将pock copy进一个集合，对新的集合操作，可以让3操作反复运行不出错
								copyli.addAll(pock);
								bottomCards(copyli,bottomc);						//抽取三张底牌	
								landc =landcard(copyli);							//定义一张地主牌
								System.out.println("地主牌："+landc);
								break;
							case "4":
								pock.remove(0);
								pock.remove(0);
								pock.remove(0);										//pock 同步成抽取三张牌后
//								System.out.println(pock);					
								pockOut(pock,person1c,person2c,person3c,array);		//将pock分发给三个人
								break;
							case "5":
								selectland(person1c,person2c,person3c,landc,array,bottomc);				//选出地主并把底牌给地主
								break;
							case "6":
								pockSort(pockValue, person1c, person2c, person3c,array);				//将三个人的牌从小到大排列
								break;
							case "7":
								
							default:
								System.exit(0);
							
							}
					}
	}

	private static void pockSort(List<FlowerCards> pockValue, List<String> person1c, List<String> person2c,
			List<String> person3c,Person[] array) {
		pockCal(pockValue,person1c);
		sortPock(pockValue);//将牌从小到大理顺
		System.out.println(array[0].getName()+":"+pockValue);
		pockValue.clear();
		pockCal(pockValue,person2c);
		sortPock(pockValue);//将牌从小到大理顺
		System.out.println(array[1].getName()+":"+pockValue);
		pockValue.clear();
		pockCal(pockValue,person3c);
		sortPock(pockValue);//将牌从小到大理顺
		System.out.println(array[2].getName()+":"+pockValue);
	}

	static void getpock(List<String> pock) {
		//定义两个集合各自遍历组合
		String cards[] = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		char flowers[] = {'♠','♥','♣','♦'};
		for(int i=0;i<flowers.length;i++) {
			for(int j=0;j<cards.length;j++) {
				pock.add(flowers[i]+cards[j]);
			}
		}
		pock.add("大鬼");
		pock.add("小鬼");
		
	}
			public static void menu() {
				System.out.println("-------------欢迎来到斗地主-------------");
				System.out.println("1.玩家呈现");
				System.out.println("2.洗牌");
				System.out.println("3.抽牌");//最后提示哪张是翻牌
				System.out.println("4.发牌");
				System.out.println("5.地主");
				System.out.println("6.顺牌");
				System.out.println("7.退出");
				System.out.println("请输入你的选择：");
		}
			public static void bottomCards(List<String> pock,String[] bottomc) {	//抽底牌
				bottomc[0]=pock.remove(0);
				bottomc[1]=pock.remove(0);
				bottomc[2]=pock.remove(0);
				System.out.print("底牌：[");
				for(int i=0;i<bottomc.length;i++) {
					if(i==2)
						System.out.print(bottomc[i]);
					else
						System.out.print(bottomc[i]+",");
				}
				System.out.println("]");
			}
			public static String landcard(List<String> pock) {		//定义地主牌
				Random random =new Random();
				int cho= random.nextInt(51);
				return pock.get(cho);
			}
			public static void pockOut(List<String> pock,List<String> person1c,List<String> person2c,List<String> person3c,Person[] array) {//发牌
				String pok;
				for(int i=0;i<pock.size();i++) {
					pok=pock.get(i);
					if(i%3==0) {
						person1c.add(pok);
					}
					else if(i%3==1) {
						person2c.add(pok);
					}
					else {
						person3c.add(pok);
					}
				}
				System.out.println(array[0].getName()+":"+person1c);
				System.out.println(array[1].getName()+":"+person2c);
				System.out.println(array[2].getName()+":"+person3c);
			}
			
			private static void selectland(List<String> person1c, List<String> person2c, List<String> person3c, String landc,Person[] array,String bottomc[]) {
				System.out.print("地主：");
				List<String> botc=new ArrayList<String>();
				botc= Arrays.asList(bottomc);
				if(person1c.contains(landc)) {
					System.out.print(array[0].getName());
					person1c.addAll(botc);
					System.out.println(person1c);
				}
				else if(person2c.contains(landc)) {
					System.out.print(array[1].getName());
					person2c.addAll(botc);
					System.out.println(person2c);
				}
				else {
					System.out.print(array[2].getName());
					person3c.addAll(botc);
					System.out.println(person3c);
				}
				
				
			}
			public static void pockCal(List<FlowerCards> pockValue,List<String> personc) {//把集合中String牌   变为牌权重对象   放入集合pockValue
					String pock;
				for(int i=0;i<personc.size();i++) {
					pock=personc.get(i);
					pockValue.add(new FlowerCards(pock));
				}
			}
			public static void sortPock(List<FlowerCards> pockValue){
				Collections.sort(pockValue,new Comparator<FlowerCards>() {

					@Override
					public int compare(FlowerCards o1, FlowerCards o2) {
						// TODO Auto-generated method stub
						return o1.value-o2.value;
					}

				
				});
			}
			
			public static Person[] ShowPlay() {							//展示玩家
				Person array[]=new Person[3];
				for(int i=0;i<array.length;i++) {
					Person per =new Person();
					per.setName(getRandomString(3));
					per.setAge(new Random().nextInt(40)+18);   //18-57岁
					array[i]=per;
					System.out.println(array[i]);
				}
				return array;
			
			
			}	  
			static String getRandomString(int length){				//名字随机
				     String str="赵钱孙李周吴郑王 冯陈褚卫蒋沈韩杨 朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁";
				     Random random=new Random();
				     StringBuilder sb=new StringBuilder();
				     for(int i=0;i<length;i++){
				       int number=random.nextInt(128);
				       sb.append(str.charAt(number));
				     }
				     return sb.toString();
			}
			
}


