class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int l1=s.length(),l2=t.length();
        int[][] dp=new int[l1+1][l2+1];
        int res= f(l1,l2,s,t,dp);
        return res;
    }

    public static int f(int m,int n, String s, String t,int[][] dp){

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                char c=s.charAt(i-1),d=t.charAt(j-1);
                if(c==d) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[m][n];
    }
}