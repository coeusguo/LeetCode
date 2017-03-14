package Accepted;

public class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
        int number = 1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i] != nums[i-1]){
            	nums[number] = nums[i];
            	number ++ ;
            }
                
        }
        return number;
    }
	
	public static void main(String[] args){
		int[] a = {1,1,2,4,4,6,7};
		int b = removeDuplicates(a);
		System.out.println(b);
		for(int i = 0;i<a.length;i++)
			System.out.println(a[i]);
	}
}
