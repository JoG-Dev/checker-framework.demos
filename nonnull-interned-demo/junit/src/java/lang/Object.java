package java.lang;

@DefaultQualifier(NonNull.class)
public class Object{
  public Object() { throw new RuntimeException("skeleton method"); }
  public boolean equals(@Nullable Object a1) { throw new RuntimeException("skeleton method"); }
  public java.lang.String toString() { throw new RuntimeException("skeleton method"); }
  public final void wait(long a1, int a2) throws java.lang.InterruptedException { throw new RuntimeException("skeleton method"); }
  public final void wait() throws java.lang.InterruptedException { throw new RuntimeException("skeleton method"); }

  private static native void registerNatives();
  public final native Class<?> getClass();
  public native int hashCode();
  protected native Object clone() throws CloneNotSupportedException;
  public final native void notify();
  public final native void notifyAll();
  public final native void wait(long timeout) throws InterruptedException;
}
