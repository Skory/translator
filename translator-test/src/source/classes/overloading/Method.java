package source.classes.overloading;

public class Method {

    public String foo(){ return "No arg"; }
    public String foo(byte b){ return "byte"; }
    public String foo(char c){ return "char"; }
    public String foo(short s){ return "short"; }
    public String foo(int i){ return "int"; }
    public String foo(long l){ return "long"; }
    public String foo(float f){ return "float"; }
    public String foo(double d){ return "double"; }
    public String foo(String d){ return "double"; }
    public String foo(Object d){ return "double"; }

}
