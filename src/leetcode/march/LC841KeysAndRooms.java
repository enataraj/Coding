package leetcode.march;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LC841KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0)
            return false;
        Set<Integer> keyset = new HashSet<>();
        keyset.add(0);
        for (int i = 0; i < rooms.size(); i++) {
            for (int key : rooms.get(i)) {
                if (key != i) {
                    keyset.add(key);
                }
            }

        }

        return keyset.size() == rooms.size();
    }

    public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        boolean[] visitedRooms = new boolean[rooms.size()];
        moveBetweenRooms(rooms, 0, visitedRooms);
        
        for(boolean isRoomVisited: visitedRooms) {
            if(!isRoomVisited) {
                return false;
            }
        }
        
        return true;
    }
    
    private void moveBetweenRooms(List<List<Integer>> rooms, int curRoom, boolean[] visitedRooms) {
        
        if(visitedRooms[curRoom]) {
            return;
        }
        visitedRooms[curRoom] = true;
        List<Integer> accessibleRooms = rooms.get(curRoom);
        for(int room: accessibleRooms) {
            moveBetweenRooms(rooms, room, visitedRooms);
        }
    }
    
    
    private boolean[] vis;

    public boolean canVisitAllRoomsBFS2(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        vis = new boolean[rooms.size()];
        vis[0] = true;
        queue.add(0);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : rooms.get(current)) {
                if (!vis[next]) {
                    vis[next] = true;
                    queue.add(next);
                }
            }
        }
        for (int i = 0;i < rooms.size();i ++) {
            if (!vis[i]) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        LC841KeysAndRooms obj = new LC841KeysAndRooms();
        List<Integer> keyList1 = new ArrayList<>();
        List<Integer> keyList2 = new ArrayList<>();
        List<Integer> keyList3 = new ArrayList<>();

        keyList1.add(1);
        keyList2.add(2);
        keyList3.add(3);

        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(keyList1);
        rooms.add(keyList2);
        rooms.add(keyList3);
        System.out.println(obj.canVisitAllRooms(rooms));
    }

}
