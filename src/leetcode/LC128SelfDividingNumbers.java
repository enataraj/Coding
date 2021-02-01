package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC128SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isDivisible(i)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isDivisible(int num) {
        int inputNum = num;

        while (num > 0) {
            int div = num % 10;
            if (div == 0 || inputNum % div != 0) {
                return false;
            }
            num = num / 10;
        }

        return true;
    }
    
    
    public List<Integer> selfDividingNumbersSol(int left, int right) 
    {
        
        List<Integer> list=new ArrayList<>();
        for(int i=left;i<=right;i++)
        {
            if(selfDiv(i)==true)
            {
                list.add(i);
            }
        }
        return list;
    }
    public boolean selfDiv(int n)
    {
        int temp=n;
        int rem;
        while(temp!=0)
        {
            rem=temp%10;
            if(rem==0 || (n%rem)!=0)
            {
                return false;
            }
            temp/=10;
        }
        return true;
    }

    public static void main(String[] args) {
        LC128SelfDividingNumbers obj = new LC128SelfDividingNumbers();
        obj.selfDividingNumbers(1, 10000);

    }

}
