import java.util.ArrayList;
import java.util.Iterator;

class Student{
	
}

public class ArrayListDemo {

	public static void main(String[] args) {
		
		int num[] = {10,4,5,6};
		
		ArrayList list1 = new ArrayList();
		
		ArrayList<String> list2 = new ArrayList<String>();
		
		Student s1 = new Student();
		
		list1.add(10);
		list2.add("John");
		list1.add("Sam");
		list1.add(s1);
		
		list2.add("Tommy");
		list2.add("Harry");
		
		System.out.println("list2  "+list2);
		System.out.println("list1  "+list1);
		
		System.out.println("list2  "+list2.get(1));
		System.out.println("Updated list  ");
		System.out.println("list2[1]  "+list2.set(1, "Gilbert"));
		System.out.println("list2  "+list2);
		
		System.out.println("Remove from list");
		list1.remove(1);
		System.out.println(list1);
		
		ArrayList<String> moreNames = new ArrayList<String>();
		moreNames.add("Johnny");
		moreNames.add("Angelina");
		list2.addAll(moreNames);
		
		System.out.println("list2  "+list2);
		System.out.println("size of list2  "+list2.size());
		
//		for (int i=0;i<list2.size();i++) {
//			System.out.println(list2.get(i));
//		}
		
		for(Object o :list2) {
			System.out.println(o);
		}
		
		Iterator itr = list1.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
