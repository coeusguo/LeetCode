package Accepted;

/*
Given an integer array nums, find the sum of the elements between indices i and j (i ¡Ü j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
 
*/
public class NumArray {

    private int[] nums;
    private int lasti = -1;
    private int lastj = -1;
    private int lastSum = 0;
    private int currentSize = 0;
    private int[] updateList;
    private int[] updateValue;
    public NumArray(int[] nums) {
        this.nums = nums;
        updateList = new int[100];
        updateValue = new int[100];
    }
    
    public void update(int i, int val) {
        updateValue[currentSize] = val - nums[i];
        nums[i] = val;
        updateList[currentSize] = i;
        
        currentSize ++;
    }
    
    public int sumRange(int i, int j) {
        if(lasti == -1||i>=lastj||j<=lasti){
            lastSum = 0;
            for(int k = i;k<=j;k++)
                lastSum += nums[k];
            lasti = i;
            lastj = j;
            currentSize = 0;
            return lastSum;
        }
        if(lasti >= i){
            for(int k = i;k<lasti;k++)
                lastSum += nums[k];
        }
        else{
            for(int k = lasti;k<i;k++)
                lastSum -= nums[k];
        }
        
        if(lastj <= j){
            for(int k = lastj + 1;k<=j;k++)
                lastSum += nums[k];
        }
        else{
            for(int k = j + 1;k<= lastj;k++)
                lastSum -= nums[k];
        }
        for(int m = 0;m<currentSize;m++){
            if(updateList[m]>=lasti && updateList[m]<=lastj)
                lastSum += updateValue[m];
        }
       
        lasti = i;
        lastj = j;
        currentSize = 0;
        return lastSum;
    }
}