package source.classes.types;

public interface NestedInterface {

    int x = 1;
    long y = 2;
    double z = 3;

    void foo();

    public interface InnerInterface {
        int x = 1;
        long y = 2;
        double z = 3;

        void foo();
    }

    public class InnerClass {
        private int x = 1;
        public long y = 2;
        public static double z = 3;

        public void foo() {}
        private int bar() { return 42;}
        public static void baz() {}
    }

}
