package general;

public class ConvertDecimalToBinary {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 0; i < n; i++) {
            
            String str = convertDecimalToBinary(i);
            System.out.println(str);
        }
    }

    private static String convertDecimalToBinary(int n) {
        String str = "";
        int sum=0;
        if(n==0) {
            return "0";
        }
        while(n!=0) {
            str=(n%2)+str;
            sum=(n%2)+sum;
            System.out.println("-->"+sum);
            n=n/2;
            
        }
        
        return str;

    }

}
