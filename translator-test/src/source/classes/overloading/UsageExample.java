package source.classes.overloading;

public class UsageExample {

    public static void main(String[] args) {
        byte b = 1;
        char c = 2;
        short s = 3;
        int i = 4;
        long l = 5;
        float f = 6;
        double d = 7;
        String str = "str";
        Object o = new Object();

        new Constructor();
        new Constructor(b);
        new Constructor(c);
        new Constructor(s);
        new Constructor(i);
        new Constructor(l);
        new Constructor(f);
        new Constructor(d);
        new Constructor(str);
        new Constructor(o);

        Method m = new Method();
        System.out.println(m.foo());
        System.out.println(m.foo(b));
        System.out.println(m.foo(c));
        System.out.println(m.foo(s));
        System.out.println(m.foo(i));
        System.out.println(m.foo(l));
        System.out.println(m.foo(f));
        System.out.println(m.foo(d));
        System.out.println(m.foo(str));
        System.out.println(m.foo(o));
    }
}
