package Basic.geeksforgeeks.Hashing;
/*Double Hashing is used in order to overcome the secondary clustering that we face in quadratic probing.
 * Here along with normal hashing we used extra hashing function= (6-key)%6 [h2(key)].
 * 
 * LOAD FACTOR : Alpha(load factor) directly proportional to number of n keys inserted/ number of slots in 
 * hash table
 * 
 * Load Factor should always be <= 1.
 * 
 * Expected nr of iterations required = 1/1-alpha(load factor). For eg if the load factor is 0.8 then 5 iterations
 * would be required to get the empty slot.
 * */
public class DoubleHashing {
	static int Bucket,size;
	int table[];
	DoubleHashing(int b){
		Bucket=b;
		table=new int[9];
	}
	public static void main(String[] args) {
		DoubleHashing dh = new DoubleHashing(7);
		
		//int[] arr={48,42,50,55,53,68,131,194,257};
		int arr[] = {49,63,56,52,54,48};
		
		for(int i=0; i<arr.length; i++)
			dh.insert(arr[i],Bucket);
		
		int key=48;
		dh.remove(key,Bucket);
		System.out.println(dh.search(48,Bucket));
	}
	
	/*T.C : O(n)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : We compute the hash function for the key first. We stop our search if the below criteria meets
	 * 1.The element is found at the index, if not double hashing traverse.
	 * 2.We encountered an empty slot.
	 * 3.If the whole hash table is full, then we traverse whole hash table until we reach the index from where
	 * we had started in beginning.
	 */
	private boolean search(int key, int bucket2) {
		int i=0;
		int index=((key%bucket2)+i*(6-(key%6)))%bucket2;
		int val=index;
		
		do{
			if(table[index]==key){
				return true;
			}else{
				i++;
				index=(key+i*(6-(key%6)))%Bucket; // OR index=(index+1)%Bucket;
			}
			
			if(table[index]==key)
				return true;
			else if(table[index]==0)
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
	 * position is already occupied we just moved index by 1, we do it using double hashing until we find the empty
	 * space or reach the same element again full circle.
	 * 
	 * NOTE : If we reach the end of the array we search from the beginning again.
	 * */
	private void remove(int key, int bucket2) {
		int i=0;
		int index=((key%bucket2)+i*(6-(key%6)))%bucket2;
		
		while(size<=table.length){
			if(table[index]==key){
				table[index]=-1;  /*We don't mark the position as empty so that in search operation it doesn't stop
				when it reaches the deleted position.*/
				size--;
				break;
			}
			else{
				i++;
				index=((key%bucket2)+i*(6-(key%6)))%bucket2; // This line executes when there is a collision happens.
			}
			
			if(index>table.length-1)
				index-=table.length; //This line is implements circular traversal.
		}
		
		if(size==0)
			return;
	}

	/*T.C : O(n)
	 * A.S.C : O(n)
	 * 
	 * LOGIC : We insert the key in array at its position, position we get from the hash function, if the
	 * position is already occupied we just moved index by 1, we do it using double hashing until we find the empty
	 * space full circle.
	 * 
	 * NOTE : If we reach the end of the array we search from the beginning again.
	 * */
	private void insert(int key, int bucket2) {
		int i=0;
		int index=((key%bucket2)+i*(6-(key%6)))%bucket2; // Hash Function
		
		while(size<table.length){
			if(table[index]==0){
				table[index]=key;
				size++;
				break;
			}
			else{
				i++;
				index=((key%bucket2)+i*(6-(key%6)))%bucket2; // This line executes when there is a collision happens.
			}
			
			if(index>table.length-1) 
				index-=table.length; //This line is implements circular traversal.
		}
		
		if(size>=table.length)
			return;
	}
}
