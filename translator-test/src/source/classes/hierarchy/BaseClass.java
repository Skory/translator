package source.classes.hierarchy;

public class BaseClass {

    private int x = 1;
    public long y = 2;
    public static double z = 3;

    public void foo() { System.out.println("Base foo"); }
    private int bar() { return 42;}
    public static void baz() {}

    public BaseClass() {
    }

    protected BaseClass(int x) {
        this.x = x;
    }

}
