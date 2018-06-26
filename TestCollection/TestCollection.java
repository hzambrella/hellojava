package TestCollection;

import java.util.*;
import java.util.Map.Entry;

import TestCollection.TestCollection.testEnum;

public class TestCollection {
	// Comparator
	public static class Staff {
		private int age;
		private String name;

		public Staff(int age, String name) {
			this.age = age;
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public String getName() {
			return name;
		}

		public String toString() {
			return this.name + "(" + this.age + ")";
		}
	}

	// 比较器，让比较更加灵活。
	public static class StaffComparator implements Comparator<Staff> {
		@Override
		public int compare(Staff o1, Staff o2) {
			return o1.getAge() - o2.getAge();
		}
	}

	public static void main(String[] args) {
		testLinkedList();
		testSet();
		testQueue();
		testMap();
		testEnumSetMap();
		testCollectionToArrat();
		testView();
		
	}
	
	private static void testView() {
		System.out.println("=======testView=========");
		Staff peter = new Staff(20, "peter");
		Staff mary = new Staff(22, "mary");
		Staff ben = new Staff(40, "ben");
		Staff li = new Staff(30, "li");
		
//		List<Staff>list1=Arrays.asList(new Staff[]{peter,mary,ben});
//		List<Staff>list2=Arrays.asList(new Staff[]{peter,ben,li});
//		list1.retainAll(list2);//报错 java.lang.UnsupportedOperationException
//		System.out.println(list1);
		List<Staff>list1=new ArrayList();
		list1.add(peter);
		list1.add(mary);
		list1.add(ben);
		
		List<Staff>list2=new ArrayList();
		list2.add(peter);
		list2.add(ben);
		list2.add(li);
		list1.retainAll(list2);
		System.out.println(list1+"---"+list2);
		list2.removeAll(list1);
		System.out.println(list1+"---"+list2);
	}

	private static void testCollectionToArrat() {
		System.out.println("=======testCollectionToArrat=========");
		Staff peter = new Staff(20, "peter");
		Staff mary = new Staff(22, "mary");
		Staff ben = new Staff(40, "ben");
		Staff li = new Staff(30, "li");
		Staff[] staffs=new Staff[]{peter,mary,ben,li};
		//arrayTo collection
		List<Staff>staffsList=Arrays.asList(staffs);
		//collection to array
		Staff[] staffsFromList=staffsList.toArray(new Staff[0]);
		System.out.println(Arrays.toString(staffsFromList));
	}

	enum testEnum{
		Dog,Cat,Bird,Fish,Pig
	}
	
	private static void testEnumSetMap() {
		System.out.println("=======testEnumSetMap=========");
		EnumMap<testEnum,String> em=new EnumMap<>(testEnum.class);
		em.put(testEnum.Dog,"wangwang");
		em.put(testEnum.Cat,"miao");
		System.out.println(em);
		
		EnumSet<testEnum> esAllOf=EnumSet.allOf(testEnum.class);
		EnumSet<testEnum> esNoneOf=EnumSet.noneOf(testEnum.class);
		EnumSet<testEnum> esRangeOf=EnumSet.range(testEnum.Cat,testEnum.Fish);
		EnumSet<testEnum> esOf=EnumSet.of(testEnum.Cat,testEnum.Fish);
		System.out.println(esAllOf);
		System.out.println(esNoneOf);
		System.out.println(esRangeOf);
		System.out.println(esOf);
	}

	private static void testMap() {
		System.out.println("========map========");
		Staff peter = new Staff(20, "peter");
		Staff mary = new Staff(22, "mary");
		Staff ben = new Staff(40, "ben");
		Staff li = new Staff(30, "li");
		
		Map<String,Staff> hmap=new HashMap<>();
		hmap.put(peter.getName(), peter);
		hmap.put(mary.getName(), mary);
		hmap.put(ben.getName(), ben);
		hmap.put(li.getName(), li);
		Set<String> keySet=hmap.keySet();
		Collection<Staff> valueSet=hmap.values();
		Set<Entry<String, Staff>> entry=hmap.entrySet();
//		keySet.add("hafdas");报错UnsupportedOperationException
		keySet.remove("peter");//peter的键和值都被删掉
		valueSet.remove(ben);//ben的键和值都被删掉
		System.out.println("keyset:"+keySet);
		System.out.println("values:"+valueSet);
		System.out.println("entry:"+entry);
	}

	private static void testQueue() {
		System.out.println("========queue========");
		Staff peter = new Staff(20, "peter");
		Staff mary = new Staff(22, "mary");
		Staff ben = new Staff(40, "ben");
		Staff li = new Staff(30, "li");
		
		Queue<Staff> queue=new LinkedList<>();
		queue.add(peter);
		queue.add(mary);
		System.out.println(queue.poll());//peter
		queue.add(ben);
		queue.add(li);
		System.out.println(queue);
		
		System.out.println("---deque双端队列---");
		Deque<Staff>dueue=new  LinkedList<>();
		dueue.add(peter);
		dueue.add(mary);
		dueue.add(ben);
		dueue.addFirst(li); 
		System.out.println(dueue);
		System.out.println(dueue.pollFirst());
		
		System.out.println("---优先级队列---");
		PriorityQueue<Staff> pqueue=new PriorityQueue<>(11,new StaffComparator());
		
		pqueue.add(mary);
		pqueue.add(ben);
		pqueue.add(li); 
		pqueue.add(peter);
		System.out.println(pqueue);
	}

	private static void testSet() {
		System.out.println("========testSet========");
		Staff peter = new Staff(20, "peter");
		Staff mary = new Staff(22, "mary");
		Staff ben = new Staff(40, "ben");
		Staff li = new Staff(30, "li");

		HashSet<Staff> hashSet = new HashSet<Staff>();
		hashSet.add(peter);
		hashSet.add(mary);
		hashSet.add(li);
		hashSet.add(ben);
		System.out.println(hashSet.contains(new Staff(12, "han")));
		System.out.println(hashSet);

		NavigableSet<Staff> ts = new TreeSet<Staff>(new StaffComparator());
		ts.add(peter);
		ts.add(mary);
		ts.add(li);
		ts.add(ben);
		System.out.println(ts);
		System.out.println(ts.floor(new Staff(30, null)));// 大于等于的一个元素。
	}

	public static void testLinkedList() {
		System.out.println("========testLinkedList========");
		List<String> linkList = new LinkedList<String>();
		linkList.add("123");
		linkList.add("1231");
		linkList.add("12322");
		linkList.add("12331223");
		System.out.println(linkList);
		// listIterator
		ListIterator<String> listIterator1 = linkList.listIterator();
		@SuppressWarnings("unused")
		ListIterator<String> listIterator2 = linkList.listIterator();
		// 链表加一个元素

		listIterator1.next();
		System.out.println(listIterator1.nextIndex());// 1
		listIterator1.add("hao");
		System.out.println(listIterator1.nextIndex());// 2
		System.out.println(linkList);
		System.out.println(listIterator1.previousIndex());
		// listIterator2.next();//抛出ConcurrentModificationException
	}
}
