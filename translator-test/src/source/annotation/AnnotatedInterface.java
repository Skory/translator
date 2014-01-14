package source.annotation;

@TypeAnnotation(owner = AnnotatedInterface.class)
public interface AnnotatedInterface {

    @MemberAnnotation
    @SourceAnnotation(doc = "interface declaration")
    String getDescription(@ParameterAnnotation int level);

}
