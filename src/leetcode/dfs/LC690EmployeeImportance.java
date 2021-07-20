package leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC690EmployeeImportance {

    // Definition for Employee.
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    int importance = 0;
    public int getImportance(List<Employee> employees, int id) {

        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        List<Integer> idList = new ArrayList<>();
        idList.add(id);
        dfsHelper(map, idList);
        return importance;
    }

    private void dfsHelper(Map<Integer, Employee> map, List<Integer> subordinates) {
        if (subordinates == null || subordinates.size() == 0) {
            return;
        }

        for (Integer subOrdinate : subordinates) {
            Employee employee = map.get(subOrdinate);
            importance += employee.importance;
            dfsHelper(map, employee.subordinates);
        }

    }

}
