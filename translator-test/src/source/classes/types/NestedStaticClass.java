package source.classes.types;

public class NestedStaticClass {

    public static double z = 3;

    public static void baz() {}

    public static class Inner {
        private int x = 1;
        public long y = 2;
        public static double z = 3;

        public void foo() {
            System.out.println(NestedNonStaticClass.z);
            NestedNonStaticClass.baz();

            bar();
            baz();
        }
        private int bar() { return 42;}
        public static void baz() {}
    }

}
