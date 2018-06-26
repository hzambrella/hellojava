package testAndtry;

public class TestEnum {
	
	enum Animal{
		Dog,Cat,Bird,Fish
	}
	
	public static void main(String[] args) {
		System.out.println(Animal.Dog);
		Animal[] testArray=Animal.values();
		int length=testArray.length;
		for (int i=0;i<length;i++){
			System.out.println(testArray[i].name()+":"+testArray[i].ordinal());
		}
		
		@SuppressWarnings("unused")
		Animal t=Animal.valueOf(TestEnum.Animal.class, "Dog");
		
		Enum<?> e=Animal.Dog;
		Class<?> c=e.getDeclaringClass();
		System.out.println(c.getName());

	}
}
