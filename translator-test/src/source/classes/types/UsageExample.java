package source.classes.types;

public class UsageExample {

    public static void main(String[] args) {
        TopLevelClass topLevel = new TopLevelClass();
        TopLevelClass.baz();
        System.out.println(TopLevelClass.z);
        topLevel.foo();
        System.out.println(topLevel.y);

        NestedStaticClass.Inner nestedStatic = new NestedStaticClass.Inner();
        nestedStatic.foo();
        System.out.println(nestedStatic.y);
        NestedStaticClass.Inner.baz();
        System.out.println(NestedStaticClass.Inner.z);

        NestedNonStaticClass nestedNonStatic = new NestedNonStaticClass();
        NestedNonStaticClass.Inner innerNonStatic = nestedNonStatic.newInner();
        innerNonStatic.foo();
        System.out.println(innerNonStatic.y);
        innerNonStatic = nestedNonStatic.new Inner();
        System.out.println(innerNonStatic.z);

        AnonymousClass anonymous = new AnonymousClass();
        anonymous.foo();
        anonymous.bar();

        InnerClass inner = new InnerClass();
        inner.foo();
        InnerClass.bar();;
    }

}
