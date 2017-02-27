package org.spongepowered.api.util.reporting;

/**
 * How is this even going to be used? Is this a pretty printed "section"
 * that is divided by space before and after? Is it another star segmented
 * line? What is the point of a "section"? Is it indented?
 * Can we have more sections within sections?
 */
public interface ErrorSection {

    ErrorSection addEntry(String text);

    ErrorSection addEntry(String key, String value);

    ErrorSection addCodeEntry(String key, String value, String language);

    ErrorSection addThrowable(Throwable throwable);

    ErrorReport getParent();

}
