package dnac;
import java.util.UUID;

public class UUIDGenerator {
    
    public void generateUUID() {
        String uuid = UUID.randomUUID().toString();
        System.out.println("UUID : "+uuid);
    }
    
    
    public static void main(String[] args) {
        UUIDGenerator instance = new UUIDGenerator();
        instance.generateUUID();
        
    }

}
