package Basic.geeksforgeeks.Sorting;


public class MajorityElement {
	
	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		int[] nums = {2,2,1,1,1,2,2};
		//System.out.println(me.majorityElement(nums));
		System.out.println(me.eff_majorityElement(nums));
	}
	 private int eff_majorityElement(int[] nums) {
		//if one element is occuring more than half of the time then 
         //it means all other elements are occuring less than half of the time
         //So on first time traversal it is sure that candidate will be 
         //the item which occured more than half of the times.

         int count = 0;
         int candidate = -1;
         for(int i=0;i<nums.length;i++)
         {
             if(count==0)
             {
                 candidate=nums[i];
                 count=1;
             }
             else
             {
                 if(candidate==nums[i])
                     count++;
                 else
                     count--;
             }
         }
         return candidate;	
	}
	public int majorityElement(int[] nums) {
	       int l=0,h=nums.length-1;
	        qsort(nums,l,h);
	        l=0;
	        for(int j=0; j<nums.length; j++){
	        	System.out.print(nums[j] + " ");
	        }
	        int major=nums.length/2,res=-1,index=l,count=0;
	        for(int i=0; i<nums.length; i++){
	            if(nums[index]==nums[i]){
	                count++;
	                if(count>major)
	                    res=nums[index];
	            }
	            else{
	            	count=0;
	                index=i;
	                i=i-1;
	            }
	        }
	        return res;
	    }
	   
	    public void qsort(int[] nums, int l, int h){
	        if(l<h){
	            int p=partition(nums,l,h);
	            qsort(nums,l,p);
	            qsort(nums,p+1,h);
	        }
	    }
	    
	    public int partition(int[] nums, int l, int h){
	        int low=l-1, high=h+1,pivot=nums[l];
	        
	        while(true){
	            do{
	                low++;
	            }while(nums[low]<pivot);
	                
	            do{
	                high--;
	            }while(nums[high]>pivot);
	            
	            if(low>=high)
	                return high;
	            
	            int temp=nums[low];
	            nums[low]=nums[high];
	            nums[high]=temp;
	        }
	    }
}
