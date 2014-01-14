package source.classes.hierarchy;

public class ChildClass extends BaseClass {

    private int x = -1;
    public long y = -2;
    public static double z = -3;

    public ChildClass() {
        // omit constructor - should be called anyway
    }

    public ChildClass(int x) {
        super(x);
    }

    public ChildClass(long y) {
        super();
    }

    @Override
    public void foo() {
        super.foo();
        System.out.println("Child foo");
    }

    public void bar() {
        System.out.println(x);

        System.out.println(super.y);
        System.out.println(y);

        System.out.println(super.z);
        System.out.println(BaseClass.z);
        System.out.println(z);
    }

    public static void main(String[] args) {
        BaseClass b = new ChildClass(41l);
        b.foo();

        b = new BaseClass();
        b.foo();

        ChildClass c = new ChildClass(42);
        c.foo();
        c.bar();
    }
}
