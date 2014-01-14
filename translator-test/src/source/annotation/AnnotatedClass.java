package source.annotation;

@TypeAnnotation(owner = AnnotatedClass.class)
@SourceAnnotation
public class AnnotatedClass implements AnnotatedInterface {

    @MemberAnnotation("Answer to all")
    private int importantField = 42;

    @ConstructorAnnotation({"This", "Is", "A", "Constructor"})
    public AnnotatedClass() {
    }

    @ConstructorAnnotation({"This", "Is", "A", "Constructor"})
    public AnnotatedClass(int answer) {
        if (answer != 42) {
            throw new IllegalArgumentException("Not a 42");
        }
    }

    @Override
    @MemberAnnotation("Override annotation")
    public String getDescription(@ParameterAnnotation int level) {
        @VariableAnnotation
        int reverseLevel = -level;
        return "Nope";
    }

    @MemberAnnotation("Getter for answer to all")
    public int getImportantField() {
        return importantField;
    }
}
