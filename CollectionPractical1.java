import java.util.Collection;
import java.util.LinkedList;

public class CollectionPractical1{
	
	int size;
	
	public CollectionPractical1(){
		Collection<Integer> c = new LinkedList();
		c.add(5);
		c.add(4);
		c.add(1);
		c.add(8);
		c.add(9);
		
		boolean isEmpty = c.isEmpty();
		System.out.println(isEmpty);
		
		System.out.println(c);
		
		size = c.size();
		System.out.println(size);
		
		boolean contains = c.contains(5);
		System.out.println(contains);
		
		c.remove(1);
		System.out.println(c);
		
		
	}
	
	public static void main(String[] args){
		new CollectionPractical1();

	}
}
