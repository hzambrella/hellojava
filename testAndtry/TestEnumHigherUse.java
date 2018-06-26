package testAndtry;

public class TestEnumHigherUse {
	
	enum Animal{
		//���Կ���ʵ����
		Dog("��"),Cat("��"),Bird("jijizhazha"),Fish("Bubble");
		//��Ա
		private String sound;
		//�Զ���˽�й��캯��
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
	
	//���г��󷽷���enum
	enum AnimalWithAbstractMethod{
		//ע�ⶺ�źͷֺ�
		//�����ö��Ԫ�ر���ʵ�ֳ��󷽷�
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
	
	//�̳нӿڵ�enum
	public interface Pet{
		String food();
	}
	
	enum AnimalPetImpt implements Pet{
		//���Կ���ʵ����
		Dog,Cat
		//��Ա
;

		@Override
		public String food() {
			return this.name()+" food";
		}
	}
	
	
	//ö�ٺ�switch
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
