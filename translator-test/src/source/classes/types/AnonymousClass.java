package source.classes.types;

public class AnonymousClass {

    private int x = 1;
    public long y = 2;
    public static double z = 3;

    public Object foo(){
        return new Object() {
            @Override
            public String toString() {
                return "" + x + y + z;
            }
        };
    }

    public AnonymousClass bar(){
        final int i = 1;
        return new AnonymousClass() {
            public Object foo() {
                return i + "BAZ";
            }
        };
    }

}
