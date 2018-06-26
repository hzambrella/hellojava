package mashibin.collection;

import java.util.*;
//集合类
//一张图
//一个类
//三个知识点（enhance for,generic,auto-boxing/unboxing）
//六个接口（collection list map  set iterator comparable）

//接口要实现comparaTo方法
class Dog implements Comparable<Dog>{
	String name;
	String color; 
	Double weight;
	
	Dog(){
		this.name="泰迪";
		this.color="黄色";
		this.weight=0.9;
	}
	
	Dog(String name,String color,Double weight){
		this.name=name;
		this.color=color;
		this.weight=weight;
	}
	
	//equals
	public boolean equals(Object obj){
		if (obj instanceof Dog){
			Dog dog =(Dog) obj;
			if (name.equals(dog.name)&&dog.color.equals(this.color)){
				return true;
			}
		}
		return false;
	}
	
	
	public int hashCode(){
		return this.name.hashCode();
	}

	public String toString(){
		return "种类:"+this.name+" 毛色："+this.color+" 体重:"+this.weight;

	}
	
	//iterator
	public Iterator<Dog> iterator(){
		return this.iterator();
	}
	
	public int compareTo(Dog dog){
		
		/*
		if (this.weight>dog.weight){
			return 1;
		}else if (this.weight<dog.weight){
			return -1;
		}else{
			return 0;
		}
		*/
		return this.weight.compareTo(dog.weight);
	}
}

class TestCollection {	
	public static void main(String[] args){
		//final  自动打包
		//final Integer One=new Integer(1);
		//Integer h=(Integer)One.intValue();
		final int One=1;
		Integer h=(Integer)One;
		System.out.println(h);
		
		//set用法（不可重复，无序）
		Collection <String> c=new HashSet<String>();
		for (String i:args){
			c.add(i);
		}
		System.out.println(c);
		
		//array用法（有次序和序号，可重复）（读快改慢）
		@SuppressWarnings("rawtypes")
		Collection a=new ArrayList();
		a.add(new String("hello"));
		a.add(new Integer(1));
		a.add(new Dog());
		System.out.println(a);
		
		//list用法（有次序和序号，可重复）（读慢改快）
		Collection<Dog> dog=new LinkedList<Dog>();
		dog.add(new Dog("狼狗","黑色",1.2));
		dog.add(new Dog());
		dog.add(new Dog("藏獒","黑色",3.0));
		dog.add(new Dog("哈士奇","白色",1.1));
		Collections.sort((List<Dog>)dog);//Collections排序方法,要实现 comparable接口
		System.out.println(dog);
		System.out.println(dog.remove(new Dog("藏獒","黑色",2.1)));//remove方法，要实现equals方法
		System.out.println(dog);
		for (Iterator<Dog> i=dog.iterator();i.hasNext();){
			Dog d=i.next();
			System.out.println("测试interator:"+d);//iterator迭代器
			if (d.name.equals(new String("哈士奇"))){
				i.remove();//正确的迭代器删除方法。
			}
			
			//c.remove(new Dog("哈士奇","白色",1.1));//删除无效
		}
		System.out.println("dog:"+dog);
		
		//map的用法
		Map<Integer,Dog> map =new HashMap<Integer,Dog>();
		map.put(new Integer(1), new Dog("金毛","金色",1.3));
		map.put(new Integer(2), new Dog("哈巴狗","金色",1.5));
		map.put(3,new Dog("斑点狗","黑白",2.3));//有泛型的存在
		System.out.println(map);
		if (map.containsValue(new Dog("斑点狗","黑白",2.3))){
			System.out.println("yes");
		}
		System.out.println(map);
		map.put(new Integer(1), new Dog("藏獒","黑",5.3));
		System.out.println(map);
	}
}


