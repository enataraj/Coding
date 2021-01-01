package dnac;

import java.util.LinkedHashMap;
import java.util.Map;

public class InsertQueryGeneration {

    public void generateInsertQuery() {

        Map<String, String> columnValueMap = new LinkedHashMap<>();

        // Put the table Name
        String tableName = "ipaddresspoolinfo";

        // Put Column Value Pairs
       // columnValueMap.put("instance_version", "'Value1'");
        //columnValueMap.put("", "");
        //columnValueMap.put("", "''");
        
     /*  
      *  columnValueMap.put("instance_version", "0");
        columnValueMap.put("id", "9223253");
        columnValueMap.put("instanceuuid", "'43c44684-81f5-43b7-b09c-900c60451332'");
        columnValueMap.put("owner", "'DNAC'");
        columnValueMap.put("contextkey", "'siteId'");
        columnValueMap.put("contextvalue", "'9d033e63-24c5-4c8f-81bf-8d553f501cb8'");
        columnValueMap.put("ipaddresspoolinfo_id", "2036079");
        columnValueMap.put("authentityid", "9223252");
        columnValueMap.put("authentityclass", "-1537870104");
        columnValueMap.put("tenantintsegment", "-1905357158");
        columnValueMap.put("tenantlongsegment", "6561265196000623360");
        
        */
        
        columnValueMap.put("instance_version", "0");
        columnValueMap.put("id", "2036079");
        columnValueMap.put("instanceuuid", "'b8a84014-c206-4c02-ad32-ec16536279f9'");
        columnValueMap.put("ippoolname", "'BLR_GUEST_Bangalore-01'");
        columnValueMap.put("totalreserved", "256");
        columnValueMap.put("broadcastaddr", "183317247");
        columnValueMap.put("networkaddr", "183316992");
        columnValueMap.put("ippoolcidr", "'10.237.50.0/24'");
        columnValueMap.put("apicappname", "'DNAC'");
        columnValueMap.put("usedpercentage", "100");
        columnValueMap.put("parentuuid", "'38e10b74-b378-4882-a3f1-7f55fe350d64'");
        columnValueMap.put("createtime", "1537642942360");
        columnValueMap.put("lastupdatetime", "1537642942360");
        columnValueMap.put("authentityid", "2036079");
        columnValueMap.put("authentityclass", "794181721");
        columnValueMap.put("tenantintsegment", "-1905357158");
        columnValueMap.put("tenantlongsegment", "6561265196000623360");
        columnValueMap.put("ippoolgroup_id", "34837001");
        
        
        
       
        

        StringBuffer columns = new StringBuffer();
        StringBuffer values = new StringBuffer();

        for (String key : columnValueMap.keySet()) {
            columns.append(key + ",");
            values.append(columnValueMap.get(key) + ",");
        }

        columns.deleteCharAt(columns.length() - 1);
        values.deleteCharAt(values.length() - 1);

        String query = "INSERT INTO " + tableName + "(" + columns.toString() + ") VALUES (" + values.toString() + ");";
        System.out.println(query);

    }
    
    
    public static void main(String[] args) {
        InsertQueryGeneration obj = new InsertQueryGeneration();
        obj.generateInsertQuery();
    }

}
