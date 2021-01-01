package leetcode.array;

public class LC1534CountGoodTriplets {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        if (arr.length < 3) {
            return 0;
        }
        int count = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) > a)
                    continue;
                for (int k = j + 1; k < arr.length; k++) {
                    // System.out.println(i+","+j+","+k);
                    // System.out.println(arr[i]+","+arr[j]+","+arr[k]);
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b
                            && Math.abs(arr[i] - arr[k]) <= c) {

                        count++;
                    }

                }
            }
        }

        return count;

    }
    
    
    public int countGoodTripletsSol(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        int[] pre = new int[1001];
        int[] post = new int[1001];  // stores suffix sum
        pre[arr[0]] = 1;
        for(int i = n-1; i > 1; i--) {
            post[arr[i]]++;
        }
        for(int i = 1; i <= 1000; i++) {
            post[i] = post[i-1] + post[i];
        }
        
        for(int j = 1; j < n-1; j++) {
            int v = arr[j];
            int p1 = Math.max(0, v-a);
            int p2 = Math.min(1000, v+a);
            int t1 = Math.max(0, v-b);
            int t2 = Math.min(1000, v+b);
            
            for(int s = p1; s <= p2; s++) {
                if (pre[s] == 0) continue;
                int m1 = Math.max(t1, s-c);
                int m2 = Math.min(t2, s+c);
                if (m2 >= m1) {
                    if (m1 == 0) {
                        ans += pre[s] * post[m2];
                    } else {
                        ans += pre[s] * (post[m2] - post[m1-1]);
                    }
                }
            }
            pre[v]++;
            for(int i = arr[j+1]; i <= 1000; i++) {
                post[i]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1534CountGoodTriplets obj = new LC1534CountGoodTriplets();

        int[] arr = { 3, 0, 1, 1, 9, 7 };
        int a = 7, b = 2, c = 3;
        System.out.println(obj.countGoodTriplets(arr, a, b, c));
    }

}
