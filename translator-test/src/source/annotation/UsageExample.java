package source.annotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class UsageExample {

    public void analyzePackage() {
        Package sourcePackage = Package.getPackage("source.annotation");
        PackageAnnotation packageAnnotation = sourcePackage.getAnnotation(PackageAnnotation.class);
        if (packageAnnotation != null) {
            System.out.println("Package annotation present");
        }
    }

    public void analyzeClass() throws NoSuchMethodException {
        Class<AnnotatedClass> cls = AnnotatedClass.class;
        TypeAnnotation typeAnnotation = cls.getAnnotation(TypeAnnotation.class);
        System.out.println(typeAnnotation.owner());

        Method method = cls.getMethod("getDescription", int.class);
        System.out.println(Arrays.toString(method.getDeclaredAnnotations()));
        System.out.println(Arrays.toString(method.getParameterAnnotations()));

        for (Constructor<?> constructor : cls.getConstructors()) {
            System.out.println(Arrays.toString(constructor.getAnnotations()));
        }
    }

    public void analyzeInterface() throws NoSuchMethodException {
        Class<AnnotatedInterface> cls = AnnotatedInterface.class;
        TypeAnnotation typeAnnotation = cls.getAnnotation(TypeAnnotation.class);
        System.out.println(typeAnnotation.owner());

        Method method = cls.getMethod("getDescription", int.class);
        System.out.println(Arrays.toString(method.getDeclaredAnnotations()));
        System.out.println(Arrays.toString(method.getParameterAnnotations()));
    }

    public static void main(String[] args) throws Exception {
        UsageExample example = new UsageExample();
        example.analyzePackage();
        example.analyzeClass();
        example.analyzeInterface();
    }

}
