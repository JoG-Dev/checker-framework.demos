package checkers.source;

import java.lang.annotation.*;

import checkers.nonnull.NonNullChecker;

/**
 * Specifies the argument that this checker recognizes for suppressing warnings
 * via the {@link SuppressWarnings} annotation. In order for this annotation to
 * have an effect, it must be placed on the declaration of a class that extends
 * {@link SourceChecker}.
 * 
 * <p>
 * 
 * For example, warnings issued by the NonNull checker can be suppressed using
 * {@code \@SuppressWarnings("nonnull")} because {@link NonNullChecker} is
 * annotated with {@code \@SuppressWarningsKey("nonnull")}.
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SuppressWarningsKey {
    
    /**
     * @return the string that causes this checker to suppress a warning when
     *         passed as the argument of {@link SuppressWarnings}
     */
    String value();
}
