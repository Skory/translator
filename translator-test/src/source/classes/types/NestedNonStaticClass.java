package source.classes.types;

public class NestedNonStaticClass {

    private int x = 1;
    public long y = 2;
    public static double z = 3;

    public void foo() {}
    private int bar() { return 42;}
    public static void baz() {}

    public Inner newInner() {
        return new Inner();
    }

    public class Inner {
        private int x = 1;
        public long y = 2;
        public double z = 3;

        public void foo() {
            System.out.println(NestedNonStaticClass.this.x);
            System.out.println(NestedNonStaticClass.this.y);
            System.out.println(NestedNonStaticClass.z);
            NestedNonStaticClass.this.foo();
            NestedNonStaticClass.this.bar();
            NestedNonStaticClass.baz();

            bar();
        }
        private int bar() { return 42;}
    }
}
