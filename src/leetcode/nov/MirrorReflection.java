package leetcode.nov;

public class MirrorReflection {

    public int mirrorReflection(int p, int q) {
        int ext = q;
        int reflection = p;
        while (ext % 2 == 0 && reflection % 2 == 0) {
            ext /= 2;
            reflection /= 2;
        }

        if (ext % 2 == 0 && reflection % 2 != 0)
            return 0;
        if (ext % 2 == 1 && reflection % 2 == 0)
            return 2;
        if (ext % 2 == 1 && reflection % 2 != 0)
            return 1;
        return -1;

    }

    public static void main(String[] args) {
        MirrorReflection obj = new MirrorReflection();
        int p = 2, q = 1;
        System.out.println(obj.mirrorReflection(p, q));
    }
}
