package leetcode.dec;

public class LC605PlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) { 

        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        if (n == 0)
            return true;
        
        if(flowerbed.length ==1 && n==1 && flowerbed[0]==0){
            return true;
        }

        int i = 1;

        if (flowerbed.length >= 2 && flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            n--;
        }

        if (flowerbed.length >= 2 && flowerbed[flowerbed.length - 2] == 0 && flowerbed[flowerbed.length - 1] == 0) {
            flowerbed[flowerbed.length-1] = 1;
            n--;
        }

        while (i < flowerbed.length - 1) {
            if (flowerbed[i] == 0 && flowerbed[i - 1] != 1 && flowerbed[i + 1] != 1) {
                flowerbed[i] = 1;
                n--;
            }
            i++;
        }

        if (n <= 0) {
            return true;
        }
        return false;

    
    }

    public static void main(String[] args) {
        LC605PlaceFlowers obj = new LC605PlaceFlowers();
        int[] flowerbed = { 1, 0, 0, 0, 1 };
        int n = 2;
        System.out.println(obj.canPlaceFlowers(flowerbed, n));

    }

}
