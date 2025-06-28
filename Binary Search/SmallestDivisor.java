class Solution {
    public int smallestDivisor(int[] a, int t) {
        int max=Arrays.stream(a).max().getAsInt();
        int min=1;

        while(min<max){
            int mid=min+(max-min)/2;
            int sum=0;
            for(int j:a){
                int res=0;
                if(j%mid!=0) res=(j/mid)+1;
                else res=j/mid;
                sum+=res;
            }

            if(sum<=t) max=mid;
            else min=mid+1;
        }
        return min;
    }
}
