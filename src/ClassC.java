
public class ClassC extends ClassB implements Cloneable{
    
    public ClassC() {
        System.out.println("C class");
    }

    private void test123() {
        VNSubstring obj = new VNSubstring();
    }
    public static void main(String[] args) {
        ClassC obj = new ClassC();
    }
    
    
    public Object clone() {
        return null;
    }
    // making --> clone serializarion 
    // clone -- > 
    // ser
    
}
