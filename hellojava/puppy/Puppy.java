// Ã¶¾Ù³õ²½Ì½Ë÷
package hellojava.puppy;

// package Puppy 
public class Puppy {
	// enum PuppyFrom={china,american,japan};
	public int age;
	enum puppyFrom {
		China, American, Japan
	}

	puppyFrom country;

	Puppy(String name) {
		System.out.println("name is: " + name);
	}
	
	public void setAge(int age){
		this.age=age;
	}

	
	public int getAge(){
		return age;
	}

	public static void main(String[] args) {
		Puppy myPuppy = new Puppy("hz");
		// myPuppy.country()
		// myPuppy.PuppyFrom.china;
		myPuppy.country = Puppy.puppyFrom.China;
		myPuppy.setAge(20);
		System.out.println(myPuppy.getAge());
		}
}