package testAndtry;

public class TestEnumHigherUse {
	
	enum Animal{
		//可以看成实例化
		Dog("汪"),Cat("喵"),Bird("jijizhazha"),Fish("Bubble");
		//成员
		private String sound;
		//自定义私有构造函数
		private Animal(String sound){
			this.sound=sound;
		}
		public String getSound(){
			return sound;
		}
		public String toString(){
			return this.name()+":"+this.getSound();
		}
	}
	
	//带有抽象方法的enum
	enum AnimalWithAbstractMethod{
		//注意逗号和分号
		//定义的枚举元素必须实现抽象方法
		Dog{
			@Override
			public String makeSound() {
				return "wang";
			}
		},Cat{
			@Override
			public String makeSound() {
				return "miao";
			}
		};
		public abstract String makeSound();
	}
	
	//继承接口的enum
	public interface Pet{
		String food();
	}
	
	enum AnimalPetImpt implements Pet{
		//可以看成实例化
		Dog,Cat
		//成员
;

		@Override
		public String food() {
			return this.name()+" food";
		}
	}
	
	
	//枚举和switch
	public static void printAnimal(Animal animal){
		switch(animal){
		case Dog:
			System.out.println("Dog");
			break;
		case Cat:
			System.out.println("Cat");
			break;
		default:
			System.out.println("I dont know");
			break;
		}
	}
	
	
	
	public static void main(String[] args) {
		System.out.println(AnimalPetImpt.Dog.food());
		System.out.println(AnimalWithAbstractMethod.Dog.makeSound());
		System.out.println(Animal.Dog);
		printAnimal(Animal.Dog);
	}
}
