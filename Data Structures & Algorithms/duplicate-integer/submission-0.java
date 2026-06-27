class Solution {

    private void merge(int[] nums, int l, int m, int r){
        int n1 = m-l+1;
        int n2 = r-m;

        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];

        for(int i=0; i< n1; i++)
            temp1[i] = nums[l+i];
        
        for(int j=0; j<n2; j++)
            temp2[j] = nums[m+1+j];

        int resSize = n1+n2;
        
        int k = l;
        int i=0, j=0;
        while( i<n1 && j< n2){
            if(temp1[i] <= temp2[j]){
                nums[k] = temp1[i];
                i++;
            }else{
                nums[k] = temp2[j];
                j++;
            }
            k++;
        }
        //copy remaining elements

        while(i<n1){
            nums[k] = temp1[i];
            i++;
            k++;
        }

        while(j < n2){
            nums[k] = temp2[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] nums, int l, int r){

        if(l < r){
            int m = l + (r-l)/2;
            mergeSort(nums, l , m);
            mergeSort(nums, m+1, r);
            merge(nums, l, m , r);
        }
    }
    public boolean hasDuplicate(int[] nums) {
        
        //sort array 
        mergeSort(nums, 0, nums.length-1);

        //check adjacent elements
        for(int i=0; i < nums.length-1;i++){
            System.out.print(nums[i] + " " );
            if(nums[i] == nums[i+1]){
                return true;

            }
        }
        return false;
    }
}