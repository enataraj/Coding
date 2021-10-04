
public class TestingOverloading {
    public static void main(String[] args) {
        Anilmal a = new Anilmal();
        a.bark("Test");

        Anilmal b = new Dog();
        b.bark("Parent");
        
        
        Dog d = new Dog();
        d.bark();
        d.bark("test");
        
        

    }

}
