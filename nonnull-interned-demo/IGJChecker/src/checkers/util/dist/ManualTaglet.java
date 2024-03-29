package checkers.util.dist;

import java.util.Map;

import com.sun.javadoc.Tag;
import com.sun.tools.doclets.Taglet;

/**
 * A taglet for processing the {@code \@manual} javadoc block tag, which inserts
 * references to the JSR 308 checkers and framework manual into javadoc.
 * 
 * <p>
 * 
 * The {@code \@manual} tag is used as follows:
 * 
 * <ul>
 * <li>{@code \@manual #} expands to a top-level link to the JSR 308 manual
 * <li>{@code \@manual #anchor text} expands to a link with some text to a
 * particular part of the manual
 * </ul>
 */
public class ManualTaglet implements Taglet {

    @Override
    public String getName() {
        return "manual";
    }

    @Override
    public boolean inConstructor() {
        return true;
    }

    @Override
    public boolean inField() {
        return true;
    }

    @Override
    public boolean inMethod() {
        return true;
    }

    @Override
    public boolean inOverview() {
        return true;
    }

    @Override
    public boolean inPackage() {
        return true;
    }

    @Override
    public boolean inType() {
        return true;
    }

    @Override
    public boolean isInlineTag() {
        return false;
    }
   
    /**
     * Formats a link, given an array of tokens.
     * 
     * @param parts the array of tokens
     * @return a link to the manual top-level if the array size is one, or a
     *         link to a part of the manual if it's larger than one
     */
    private String formatLink(String[] parts) {
        String anchor, text;
        if (parts.length < 2) {
            anchor = "";
            text = "JSR 308 Type-checkers and Framework";
        } else {
            anchor = parts[0];
            text = parts[1];
        }
        return String.format(
                "<A HREF=\"http://types.cs.washington.edu/checker-framework/current/checkers-manual.html%s\">%s</A>",
                anchor, text);
    }
    
    /**
     * Formats the {@code \@manual} tag, prepending the tag header to the
     * tag content.
     * 
     * @param text the tag content
     * @return the formatted tag
     */
    private String formatHeader(String text) {
        return String.format(
                "<DT><B>See the checkers manual:</B><DD>%s<BR>",
                text);
    }

    @Override
    public String toString(Tag tag) {
        String[] split = tag.text().split(" ", 2);
        return formatHeader(formatLink(split));
    }

    @Override
    public String toString(Tag[] tags) {
        if (tags.length == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (Tag t : tags) {
            String[] split = t.text().split(" ", 2);
            if (t != tags[0])
                sb.append(", ");
            sb.append(formatLink(split));
        }
        return formatHeader(sb.toString());
    }

    @SuppressWarnings("unchecked")
    public static void register(Map tagletMap) {
        ManualTaglet tag = new ManualTaglet();
        Taglet t = (Taglet) tagletMap.get(tag.getName());
        if (t != null) {
            tagletMap.remove(tag.getName());
        }
        tagletMap.put(tag.getName(), tag);        
    }
}
