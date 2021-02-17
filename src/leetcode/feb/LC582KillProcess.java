package leetcode.feb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC582KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, List<Integer>> tree = new HashMap<Integer, List<Integer>>();
        for (int index = 0; index < pid.size(); index++) {
            if (!tree.containsKey(ppid.get(index)))
                tree.put(ppid.get(index), new ArrayList<Integer>());
            if (!tree.containsKey(pid.get(index)))
                tree.put(pid.get(index), new ArrayList<Integer>());
            tree.get(ppid.get(index)).add(pid.get(index));
        }
        if (!tree.containsKey(kill))
            return result;
        dfs(tree, result, kill);
        return result;
    }

    private void dfs(Map<Integer, List<Integer>> tree, List<Integer> result, int current) {
        result.add(current);
        for (int next : tree.getOrDefault(current, new ArrayList<Integer>()))
            dfs(tree, result, next);
    }

    public static List<Integer> killProcessBFS(List<Integer> pids, List<Integer> ppids, int kill) {
        final Map<Integer, List<Integer>> ptoCMap = new HashMap();
        for (int i = 0; i < ppids.size(); i++) {
            int ppid = ppids.get(i);
            ptoCMap.putIfAbsent(ppid, new ArrayList());
            ptoCMap.get(ppid).add(pids.get(i));
        }
        final LinkedList<Integer> q = new LinkedList();
        q.add(kill);
        List<Integer> r = new ArrayList();
        while (!q.isEmpty()) {
            int ppid = q.poll();
            r.add(ppid);
            if (ptoCMap.get(ppid) != null) {
                q.addAll(ptoCMap.get(ppid));
            }
        }
        return r;
    }

    public static void main(String[] args) {
        // System.out.println(killProcess(List.of(1, 3, 10, 5), List.of(3, 0, 5, 3),
        // 5));
    }

}
