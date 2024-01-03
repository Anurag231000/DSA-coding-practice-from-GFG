package Basic.geeksforgeeks.Hashing;
/*Quadratic Probing is one of the techniques for the Open Addressing concept.
 * This technique helps in overcome the clustering issue that comes in Linear Probing.
 * 
 * CONS : 1.Quadratic probing also faces clustering problem known as SECONDARY CLUSTERING but it is better than
 * PRIMARY CLUSTERING that we face in Linear Probing.
 * 2. It might not able to find the empty slot even if there is one.
 * 
 * Here we are using an array to implement quadratic probing.
 * 
 * NOTE : It is cache friendly.
 * 
 * LOAD FACTOR : Alpha(load factor) directly proportional to number of n keys inserted/ number of slots in 
 * hash table
 * 
 * NOTE : load factor should be always < 0.5. It means that the nr of slots or hash table size is double of the
 * nr of keys inserted.
 * The QUADRATIC PROBING works only if the load factor is < 0.5 and nr of keys inserted is prime number.
 * 
 * */
public class QuadraticProbing {
	
	static int Bucket,size;
	int table[];
	QuadraticProbing(int b){
		Bucket=b;
		table=new int[7];
	}
	
	public static void main(String[] args) {
		QuadraticProbing qp = new QuadraticProbing(7);
		
		//int[] arr={48,42,50,55,53,68};
		int arr[] = { 50, 700, 76, 85,
				92, 73, 101 };
		
		for(int i=0; i<arr.length; i++)
			qp.insert(arr[i],Bucket);
		
		int key=80;
		//qp.remove(key,Bucket);
		System.out.println(qp.search(key,Bucket));
	}
	
	/*T.C : O(n)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : We compute the hash function for the key first. We stop our search if the below criteria meets
	 * 1.The element is found at the index, if not quadratically traverse.
	 * 2.We encountered an empty slot.
	 * 3.If the whole hash table is full, then we traverse whole hash table until we reach the index from where
	 * we had started in beginning.
	 */
	private boolean search(int key, int bucket2) {
		int index=key%Bucket;
		int val=index,i=0;
		
		do{
			if(table[index]==key){
				return true;
			}else{
				i++;
				index=(index+(i*i))%Bucket;
			}
			
			if(table[index]==key) //1
				return true;
			else if(table[index]==0) //2
				return false;
				
			if(index>table.length-1) //3
				index-=table.length;
		}
		while(size<table.length-1 && index!=val && table[index]!=0);
		
		return false;
	}

	/*T.C : O(n)
	 * A.S.C : O(1)
	 * 
	 * LOGIC : We delete the key from an array at its position, position we get from the hash function, if the
	 * position is already occupied we just moved index by i*i(quadratically), we do it linearly until we find the empty
	 * space or reach the same element again full circle.
	 * 
	 * NOTE : If we reach the end of the array we search from the beginning again.
	 * */
	private void remove(int key, int bucket2) {
		int index=key%bucket2,i=0;
		
		while(size<=table.length){
			if(table[index]==key){
				table[index]=-1;  /*We don't mark the position as empty so that in search operation it doesn't stop
				when it reaches the deleted position.*/
				size--;
				break;
			}
			else{
				i++;
				index=(index+(i*i))%Bucket; // This line executes when there is a collision happens
			}
			
			if(index>table.length-1)
				index-=table.length; //This line is implements circular traversal.
		}
		if(size==0)
			return;
	}

	/*T.C : O(n*size of hash table)
	 * A.S.C : O(n)
	 * 
	 * LOGIC : We insert the key in array at its position, position we get from the hash function, if the
	 * position is already occupied we just moved index by i*i(quadratically), we do it linearly until we find the empty
	 * space or full circle.
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
				index=(index+(i*i))%Bucket; // This line executes when there is a collision happens
			}
			
			if(index>table.length-1) 
				index-=table.length; //This line is implements circular traversal.
		}
		
		if(size>=table.length)
			return;
	}

}

