package dnac;

import java.util.LinkedHashMap;
import java.util.Map;

public class InsertQueryGeneration {

    public void generateInsertQuery() {

        Map<String, String> columnValueMap = new LinkedHashMap<>();

        // Put the table Name
        String tableName = "TableName";

        // Put Column Value Pairs
        columnValueMap.put("column1", "'Value1'");
        columnValueMap.put("column2", "Value2");
        columnValueMap.put("column3", "'Value 123'");
        columnValueMap.put("column3", "'Value''123'");

        StringBuffer columns = new StringBuffer();
        StringBuffer values = new StringBuffer();

        for (String key : columnValueMap.keySet()) {
            columns.append(key + ",");
            values.append(columnValueMap.get(key) + ",");
        }

        columns.deleteCharAt(columns.length() - 1);
        values.deleteCharAt(values.length() - 1);

        String query = "INSERT INTO " + tableName + "(" + columns.toString() + ") VALUES (" + values.toString() + ") RETURNING *;";
        System.out.println(query);

    }
    
    
    public static void main(String[] args) {
        InsertQueryGeneration obj = new InsertQueryGeneration();
        obj.generateInsertQuery();
    }

}
