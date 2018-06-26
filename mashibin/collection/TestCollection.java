package mashibin.collection;

import java.util.*;
//������
//һ��ͼ
//һ����
//����֪ʶ�㣨enhance for,generic,auto-boxing/unboxing��
//�����ӿڣ�collection list map  set iterator comparable��

//�ӿ�Ҫʵ��comparaTo����
class Dog implements Comparable<Dog>{
	String name;
	String color; 
	Double weight;
	
	Dog(){
		this.name="̩��";
		this.color="��ɫ";
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
		return "����:"+this.name+" ëɫ��"+this.color+" ����:"+this.weight;

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
		//final  �Զ����
		//final Integer One=new Integer(1);
		//Integer h=(Integer)One.intValue();
		final int One=1;
		Integer h=(Integer)One;
		System.out.println(h);
		
		//set�÷��������ظ�������
		Collection <String> c=new HashSet<String>();
		for (String i:args){
			c.add(i);
		}
		System.out.println(c);
		
		//array�÷����д������ţ����ظ��������������
		@SuppressWarnings("rawtypes")
		Collection a=new ArrayList();
		a.add(new String("hello"));
		a.add(new Integer(1));
		a.add(new Dog());
		System.out.println(a);
		
		//list�÷����д������ţ����ظ����������Ŀ죩
		Collection<Dog> dog=new LinkedList<Dog>();
		dog.add(new Dog("�ǹ�","��ɫ",1.2));
		dog.add(new Dog());
		dog.add(new Dog("����","��ɫ",3.0));
		dog.add(new Dog("��ʿ��","��ɫ",1.1));
		Collections.sort((List<Dog>)dog);//Collections���򷽷�,Ҫʵ�� comparable�ӿ�
		System.out.println(dog);
		System.out.println(dog.remove(new Dog("����","��ɫ",2.1)));//remove������Ҫʵ��equals����
		System.out.println(dog);
		for (Iterator<Dog> i=dog.iterator();i.hasNext();){
			Dog d=i.next();
			System.out.println("����interator:"+d);//iterator������
			if (d.name.equals(new String("��ʿ��"))){
				i.remove();//��ȷ�ĵ�����ɾ��������
			}
			
			//c.remove(new Dog("��ʿ��","��ɫ",1.1));//ɾ����Ч
		}
		System.out.println("dog:"+dog);
		
		//map���÷�
		Map<Integer,Dog> map =new HashMap<Integer,Dog>();
		map.put(new Integer(1), new Dog("��ë","��ɫ",1.3));
		map.put(new Integer(2), new Dog("���͹�","��ɫ",1.5));
		map.put(3,new Dog("�ߵ㹷","�ڰ�",2.3));//�з��͵Ĵ���
		System.out.println(map);
		if (map.containsValue(new Dog("�ߵ㹷","�ڰ�",2.3))){
			System.out.println("yes");
		}
		System.out.println(map);
		map.put(new Integer(1), new Dog("����","��",5.3));
		System.out.println(map);
	}
}


