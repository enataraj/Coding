package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ReadNCharUsingRead4 {

    Queue<String> queue;

    public ReadNCharUsingRead4() {
        queue = new LinkedList<>();
        queue.add("file");
        queue.add("test");
        queue.add("buff");
        queue.add("er");
    }

    private int read4(char[] buf) {
        buff = new char[4];
        if (!queue.isEmpty()) {
            buff = queue.poll().toCharArray();
        }
        return buff.length;

    }

    int readI = 0;
    int writeI = 0;
    char[] buff = new char[4];

    public int read(char[] buf, int n) {
        for (int i = 0; i < n; i++) {
            if (readI == writeI) {
                writeI = read4(buff);
                readI = 0;
                if (writeI == 0)
                    return i;
            }
            buf[i] = buff[readI++];
        }
        return n;
    }

    public static void main(String[] args) {
        ReadNCharUsingRead4 obj = new ReadNCharUsingRead4();
        char[] buf = new char[20];
        System.out.println(obj.read(buf, 6) + "  " + Arrays.toString(buf));
        buf = new char[20];
        System.out.println(obj.read(buf, 5) + "  " + Arrays.toString(buf));
        buf = new char[20];
        System.out.println(obj.read(buf, 4) + "  " + Arrays.toString(buf));
        buf = new char[20];
        System.out.println(obj.read(buf, 3) + "  " + Arrays.toString(buf));
        buf = new char[20];
        System.out.println(obj.read(buf, 2) + "  " + Arrays.toString(buf));
        buf = new char[20];
        System.out.println(obj.read(buf, 10) + "  " + Arrays.toString(buf));
    }
}
