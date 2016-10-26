package TestAnimal;

// ��̬
public class TestAnimal {
	// showAnimal(Cat);
	// showAnimal(Dog);

	public static void main(String[] args) {
		showAnimal(new Cat());
		showAnimal(new Dog());
		Animal a = new Cat();
		a.eat();
		Cat c = (Cat) a; // ����ת��
		c.work(); // ���õ��� Cat �� catchMouse
	}

	public static void showAnimal(Animal a) {
		a.eat();
		if (a instanceof Cat) {
			// Cat c=Cat(a);
			Cat c = (Cat) a;
			c.work();
		}
		if (a instanceof Dog) {
			// Dog c=Dog(a);
			Dog c = (Dog) a;
			c.work();
		}
	}
}

abstract class Animal {
	// eat();
	abstract void eat();
}

class Dog extends Animal implements workAnimal {
	Dog(){
	System.out.println("dog come");
	}
	public void eat() {
		System.out.println("dog eat meat");
	}

	public void work() {
		System.out.println("����");
	}

	public void bark() {
		System.out.println("wangwang");
	}
}

class Cat extends Animal implements workAnimal {
	Cat(){
		System.out.println("cat come");
	}
	public void eat() {
		System.out.println("cat eat fish");
	}

	public void work() {
		System.out.println("ץ����");
	}
}

interface workAnimal {
public void work();
}

