class Solution {
    public int minDays(int[] a, int m, int k) {
        int min=Arrays.stream(a).min().getAsInt();
        int max=Arrays.stream(a).max().getAsInt();
        if(a.length< (long) m*k) return -1;
        while(min<max){
            int mid=min+(max-min)/2;
            int count=0,res=0;
            for(int i:a){
                if(i<=mid){
                    count++;
                }else{
                    res+=(count/k);
                    count=0;
                }
            }
            res+=(count/k);
            if(res>=m) max=mid;
            else min=mid+1;
        }
        return min;
    }
}