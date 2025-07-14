class Solution {
    public int shipWithinDays(int[] w, int d) {
        int low=Arrays.stream(w).max().getAsInt();
        int high=Arrays.stream(w).sum();

        while(low<high){
            int mid=low+(high-low)/2;
            if(sum(w,mid)>d){
                low=mid+1;
            }else high=mid;
        }
        return low;
    }

    public static int sum(int[] w, int n){
        int count=0, sum=0;
        for(int i:w){
            sum+=i;
            if(sum>n){
                sum=i;
                count++;
            }
        }
        return ++count;
    }
}
