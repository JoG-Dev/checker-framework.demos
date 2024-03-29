package utilMDE;



/**
 * Interface for things that make boolean decisions.
 * This is inspired by java.io.FilenameFilter.
 **/
@DefaultQualifier(NonNull.class)
public interface Filter<T> {
  /** Tests whether a specified Object satisfies the filter. */
  boolean accept(T o);
}
