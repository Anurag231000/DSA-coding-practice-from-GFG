package Basic.geeksforgeeks.Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

/*LOGIC : Whenever there is a collision [more than 1 element at the same index(location)] we are using the 
 * single LL in order to insert the new element in the same index. 
 * 
 * LOAD FACTOR : Alpha(load factor) directly proportional to number of n keys inserted/ number of slots in 
 * hash table.
 * 
 * NOTE : Not a cache friendly.
 * */
public class Chaining {
	static int Bucket;
	ArrayList<LinkedList<Integer>> table;
	Chaining(int b){
		Bucket=b;
		table = new ArrayList<LinkedList<Integer>>();
		
		for(int i=0; i<b; i++)
			table.add(new LinkedList<Integer>());
	}
	public Chaining() {
		
	}
	public static void main(String[] args) {
		Chaining p = new Chaining(7);

		int[] arr ={70,71,56,9,72};
		for(int i=0; i<arr.length; i++)
			p.insert(arr[i],Bucket);
		
		int key=56;
		System.out.println(p.search(key,Bucket));
		p.delete(key,Bucket);
		System.out.println(p.search(key,Bucket));
	}
	private void delete(int key, int bucket2) {
		int i = key%bucket2;
		//table.get(i).remove((Integer)i);	
		table.get(i).remove(i);
	}
	private boolean search(int key, int bucket2) {
		int i=key%bucket2;
		return table.get(i).contains(key);
	}
	private void insert(int key, int bucket2) {
		int i=key%bucket2;
		table.get(i).add(key);
	}

}
