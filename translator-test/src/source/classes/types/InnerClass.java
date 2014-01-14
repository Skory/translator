package source.classes.types;

public class InnerClass {

    private int x = 1;
    public long y = 2;
    public static double z = 3;

    public void foo() {
        class InnerInstanceClass {
            @Override
            public String toString() {
                return super.toString() + x + y + z;
            }
        }
        System.out.println(new InnerInstanceClass());
    }

    public static void bar() {
        class InnerStaticClass {
            @Override
            public String toString() {
                return super.toString() + z;
            }
        }
        System.out.println(new InnerStaticClass());
    }
}
