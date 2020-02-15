package springframework.annotation;

@FirstLevelRepository
public @interface SecondLevelRepository {
    String value() default "";
}
