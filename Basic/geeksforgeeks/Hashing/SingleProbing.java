package Basic.geeksforgeeks.Hashing;

import java.util.ArrayList;

/*Linear Probing is one of the techniques for the Open Addressing concept.
 * 
 * Here we are using an array to implement single probing.
 * 
 * NOTE : It is cache friendly.
 * 
 * LOAD FACTOR : Alpha(load factor) directly proportional to number of n keys inserted/ number of slots in 
 * hash table.
 * 
 * load factor <= 1.
 * */

public class SingleProbing {
	static int Bucket,size;
	int table[];
	SingleProbing(int b){
		Bucket=b;
		table=new int[9];
	}
	
	public static void main(String[] args) {
		SingleProbing sp = new SingleProbing(7);
		int[] arr={48,42,50,55,53,68,131,194,257};
		
		for(int i=0; i<arr.length; i++)
			sp.insert(arr[i],Bucket);
		
		int key=257;
		sp.remove(key,Bucket);
		System.out.println(sp.search(64,Bucket));
	}
	
	/*T.C : O(n)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : We compute the hash function for the key first. We stop our search if the below criteria meets
	 * 1.The element is found at the index, if not linearly traverse.
	 * 2.We encountered an empty slot.
	 * 3.If the whole hash table is full, then we traverse whole hash table until we reach the index from where
	 * we had started in beginning.
	 */
	private boolean search(int key, int bucket2) {
		int index=key%Bucket;
		int val=index;
		
		do{
			if(table[index]==key){
				return true;
			}else
				index++; // OR index=(index+1)%Bucket;
			
			if(table[index]==key) //1
				return true;
			else if(table[index]==0) //2
				return false;
			
			if(index>table.length-1)
				index-=table.length;
		}
		while(size<table.length-1 && index!=val && table[index]!=0);
		
		return false;
	}

	/*T.C : O(n)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : We delete the key from an array at its position, position we get from the hash function, if the
	 * position is already occupied we just moved index by 1, we do it linearly until we find the empty
	 * space or reach the same element again full circle.
	 * 
	 * NOTE : If we reach the end of the array we search from the beginning again.
	 * */
	private void remove(int key, int bucket2) {
		int index=key%bucket2,i=0;
		int val=index;
		
		if(size==0)
			return;
		
		while(size<=table.length){
			if(table[index]==key){
				table[index]=-1;  /*We don't mark the position as empty so that in search operation it doesn't stop
				when it reaches the deleted position.*/
				size--;
				break;
			}
			else{
				i++;
				index=(index+i)%bucket2; // This line executes when there is a collision happens // OR index=(index+1)%Bucket;
			}
			
			if(table[index]==0) //empty slot
				return;
			
//			if(index>table.length-1)
//				index-=table.length; //This line implements circular traversal.
		}
		
	}

	/*T.C : O(n)
	 * A.S.C : O(n)
	 * 
	 * LOGIC : We insert the key in array at its position, position we get from the hash function, if the
	 * position is already occupied we just moved index by 1, we do it linearly until we find the empty
	 * space full circle.
	 * 
	 * NOTE : If we reach the end of the array we search from the beginning again.
	 * */
	private void insert(int key, int bucket2) {
		int index=key%bucket2,i=0; // Hash Function
		
		while(size<table.length){
			if(table[index]==0){
				table[index]=key;
				size++;
				break;
			}
			else{
				i++;
				index=(index+i)%bucket2; // This line executes when there is a collision happens // OR index=(index+1)%Bucket;
			}
//			if(index>table.length-1) 
//				index-=table.length; //This line is implements circular traversal.
		}
		
		if(size>=table.length)
			return;
	}

}
