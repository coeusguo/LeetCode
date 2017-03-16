package Accepted;
/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/
public class FindMinimum {
    public int findMin(int[] nums) {
        int result = findMin(nums,1,nums.length);
       return nums[0] < result? nums[0]:result;
            
    }
    public int findMin(int[] nums,int i ,int j){
        if(i == j)
            return nums[i - 1];
        int mid = (i + j) / 2;
        if(nums[mid - 1] > nums[0])
            return findMin(nums,mid + 1,j);
        else if(nums[mid - 1] < nums[0])
            return findMin(nums,i,mid);
            
        else{
            int max1 = findMin(nums,i,mid);
            int max2 = findMin(nums,mid + 1,j);
            return max1>max2?max2:max1;
        }
    }
}