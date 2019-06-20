public class FenwickTree {
    /* FenWick Tree A.K.A. Binary Indexed Tree
     * is a simple solution to sum the first i-th elements
     * Both update and query can be completed in O(log n) time
     */
    private int[] sum;
    private int[] arr;
    private int arrSize;

    public FenwickTree(int[] nums){
        
        arrSize = nums.length + 1;
        arr = new int[nums.length];
        sum = new int[arrSize];

        for(int i = 0; i < arr.length; i++){
            update(i, nums[i]);
        }
    }

    public void update(int i, int updateValue){
        /* update number at index i
           and update the sum */
        if(i >= arrSize - 1) return;
        int index = i + 1;
        updateValue = updateValue - arr[i];
        while(index < arrSize){
            sum[index] += updateValue;
            index += getLowBit(index);
        }
        arr[i] = updateValue;
    }

    public int query(int i){
        /* query the sum of the first i-th numbers */
        if(i >= arrSize - 1) return -1;
        int index = i + 1;
        int result = 0;
        while(index > 0){
            result += sum[index];
            index -= getLowBit(index);
        }
        return result;
    }

    private int getLowBit(int x){
        /* get low bit of an integer */
        return x & (-x);
    }
}
