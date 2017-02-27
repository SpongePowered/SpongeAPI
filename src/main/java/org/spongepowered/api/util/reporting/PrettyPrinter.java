package org.spongepowered.api.util.reporting;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import java.io.PrintStream;
import java.util.Collection;
import java.util.Map;

/**
 * Prints information in a pretty box
 */
public interface PrettyPrinter {

    /**
     * Interface for object which supports printing to pretty printer
     */
    interface IPrettyPrintable {

        /**
         * Append this objec to specified pretty printer
         *
         * @param printer printer to append to
         */
        void print(PrettyPrinter printer);

    }


    /**
     * Table column alignment
     */
    enum Alignment {
        LEFT,
        RIGHT
    }


    /**
     * Set the wrap width (default 80 columns)
     *
     * @param wrapWidth new width (in characters) to wrap to
     * @return fluent interface
     */
    PrettyPrinter wrapTo(int wrapWidth);

    /**
     * Get the current wrap width
     *
     * @return the current wrap width
     */
    int wrapTo();

    /**
     * Begin a new table with no header and adaptive column widths
     *
     * @return fluent interface
     */
    PrettyPrinter table();

    /**
     * Begin a new table with the specified headers and adaptive column widths
     *
     * @param titles Column titles
     * @return fluent interface
     */
    PrettyPrinter table(String... titles);

    /**
     * Begin a new table with the specified format. The format is specified as a
     * sequence of values with {@link String}s defining column titles,
     * {@link Integer}s defining column widths, and {@link Alignment}s defining
     * column alignments. Widths and alignment specifiers should follow the
     * relevant column title. Specify a <em>negative</em> value to specify the
     * <em>maximum</em> width for a column (values will be truncated).
     *
     * <p>For example, to specify a table with two columns of width 10:</p>
     *
     * <code>printer.table("Column 1", 10, "Column 2", 10);</code>
     *
     * <p>A table with a column 30 characters wide and a right-aligned column 20
     * characters wide:</p>
     *
     * <code>printer.table("Column 1", 30, "Column 2", 20, Alignment.RIGHT);
     * </code>
     *
     * @param format format string, see description
     * @return fluent interface
     */
    PrettyPrinter table(Object... format);

    /**
     * Set the column spacing for the current table. Default = 2
     *
     * @param spacing Column spacing in characters
     * @return fluent interface
     */
    PrettyPrinter spacing(int spacing);

    /**
     * Print the current table header. The table header is automatically printed
     * before the first row if not explicitly specified by calling this method.
     *
     * @return fluent interface
     */
    PrettyPrinter th();

    ;
    /**
     * Print a table row with the specified values. If more columns are
     * specified than exist in the table, then the table is automatically
     * expanded.
     *
     * @param args column values
     * @return fluent interface
     */
    PrettyPrinter tr(Object... args);

    /**
     * Adds a blank line to the output
     *
     * @return fluent interface
     */
    PrettyPrinter add();

    /**
     * Adds a string line to the output
     *
     * @param string format string
     * @return fluent interface
     */
    PrettyPrinter add(String string);

    /**
     * Adds a formatted line to the output
     *
     * @param format format string
     * @param args arguments
     *
     * @return fluent interface
     */
    PrettyPrinter add(String format, Object... args);

    /**
     * Add elements of the array to the output, one per line
     *
     * @param array Array of objects to print
     * @return fluent interface
     */
    PrettyPrinter add(Object[] array);

    /**
     * Add elements of the array to the output, one per line
     *
     * @param array Array of objects to print
     * @param format Format for each row
     * @return fluent interface
     */
    PrettyPrinter add(Object[] array, String format);

    /**
     * Add elements of the array to the output, one per line, with array indices
     *
     * @param array Array of objects to print
     * @return fluent interface
     */
    PrettyPrinter addIndexed(Object[] array);

    /**
     * Add elements of the collection to the output, one per line, with indices
     *
     * @param c Collection of objects to print
     * @return fluent interface
     */
    PrettyPrinter addWithIndices(Collection<?> c);

    /**
     * Adds a pretty-printable object to the output, the object is responsible
     * for adding its own representation to this printer
     *
     * @param printable object to add
     * @return fluent interface
     */
    PrettyPrinter add(IPrettyPrintable printable);

    /**
     * Print a formatted representation of the specified throwable with the
     * default indent (4)
     *
     * @param th Throwable to print
     * @return fluent interface
     */
    PrettyPrinter add(Throwable th);

    /**
     * Print a formatted representation of the specified throwable with the
     * specified indent
     *
     * @param th Throwable to print
     * @param indent Indent size for stacktrace lines
     * @return fluent interface
     */
    PrettyPrinter add(Throwable th, int indent);

    /**
     * Print a formatted representation of the specified stack trace with the
     * specified indent
     *
     * @param stackTrace stack trace to print
     * @param indent Indent size for stacktrace lines
     * @return fluent interface
     */
    PrettyPrinter add(StackTraceElement[] stackTrace, int indent);

    /**
     * Adds the specified object to the output
     *
     * @param object object to add
     * @return fluent interface
     */
    PrettyPrinter add(Object object);

    /**
     * Adds the specified object to the output
     *
     * @param object object to add
     * @param indent indent amount
     * @return fluent interface
     */
    PrettyPrinter add(Object object, int indent);

    /**
     * Adds a formatted line to the output, and attempts to wrap the line
     * content to the current wrap width
     *
     * @param format format string
     * @param args arguments
     *
     * @return fluent interface
     */
    PrettyPrinter addWrapped(String format, Object... args);

    /**
     * Adds a formatted line to the output, and attempts to wrap the line
     * content to the specified width
     *
     * @param width wrap width to use for this content
     * @param format format string
     * @param args arguments
     *
     * @return fluent interface
     */
    PrettyPrinter addWrapped(int width, String format, Object... args);


    /**
     * Add a formatted key/value pair to the output
     *
     * @param key Key
     * @param format Value format
     * @param args Value args
     * @return fluent interface
     */
    PrettyPrinter kv(String key, String format, Object... args);

    /**
     * Add a key/value pair to the output
     *
     * @param key Key
     * @param value Value
     * @return fluent interface
     */
    PrettyPrinter kv(String key, Object value);

    /**
     * Set the minimum key display width
     *
     * @param width width to set
     * @return fluent
     */
    PrettyPrinter kvWidth(int width);

    /**
     * Add all values of the specified map to this printer as key/value pairs
     *
     * @param map Map with entries to add
     * @return fluent
     */
    PrettyPrinter add(Map<?, ?> map);

    /**
     * Adds a horizontal rule to the output
     *
     * @return fluent interface
     */
    PrettyPrinter hr();


    /**
     * Adds a horizontal rule of the specified char to the output
     *
     * @param ruleChar character to use for the horizontal rule
     * @return fluent interface
     */
    PrettyPrinter hr(char ruleChar);

    /**
     * Centre the last line added
     *
     * @return fluent interface
     */
    PrettyPrinter centre();

    /**
     * Outputs this printer to stderr and to a logger decorated with the calling
     * class name with level {@link Level#DEBUG}
     *
     * @return fluent interface
     */
    PrettyPrinter trace();

    /**
     * Outputs this printer to stderr and to a logger decorated with the calling
     * class name at the specified level
     *
     * @param level Log level to write messages
     * @return fluent interface
     */
    PrettyPrinter trace(Level level);

    /**
     * Outputs this printer to stderr and to a logger decorated with specified
     * name with level {@link Level#DEBUG}
     *
     * @param logger Logger name to write to
     * @return fluent interface
     */
    PrettyPrinter trace(String logger);

    /**
     * Outputs this printer to stderr and to a logger decorated with specified
     * name with the specified level
     *
     * @param logger Logger name to write to
     * @param level Log level to write messages
     * @return fluent interface
     */
    PrettyPrinter trace(String logger, Level level);

    /**
     * Outputs this printer to stderr and to the supplied logger with level
     * {@link Level#DEBUG}
     *
     * @param logger Logger to write to
     * @return fluent interface
     */
    PrettyPrinter trace(Logger logger);

    /**
     * Outputs this printer to stderr and to the supplied logger with the
     * specified level
     *
     * @param logger Logger to write to
     * @param level Log level to write messages
     * @return fluent interface
     */
    PrettyPrinter trace(Logger logger, Level level);

    /**
     * Outputs this printer to the specified stream and to a logger decorated
     * with the calling class name with level {@link Level#DEBUG}
     *
     * @param stream Output stream to print to
     * @return fluent interface
     */
    PrettyPrinter trace(PrintStream stream);

    /**
     * Outputs this printer to the specified stream and to a logger decorated
     * with the calling class name with the specified level
     *
     * @param stream Output stream to print to
     * @param level Log level to write messages
     * @return fluent interface
     */
    PrettyPrinter trace(PrintStream stream, Level level);

    /**
     * Outputs this printer to the specified stream and to a logger with the
     * specified name with level {@link Level#DEBUG}
     *
     * @param stream Output stream to print to
     * @param logger Logger name to write to
     * @return fluent interface
     */
    PrettyPrinter trace(PrintStream stream, String logger);

    /**
     * Outputs this printer to the specified stream and to a logger with the
     * specified name at the specified level
     *
     * @param stream Output stream to print to
     * @param logger Logger name to write to
     * @param level Log level to write messages
     * @return fluent interface
     */
    PrettyPrinter trace(PrintStream stream, String logger, Level level);

    /**
     * Outputs this printer to the specified stream and to the supplied logger
     * with level {@link Level#DEBUG}
     *
     * @param stream Output stream to print to
     * @param logger Logger to write to
     * @return fluent interface
     */
    PrettyPrinter trace(PrintStream stream, Logger logger);

    /**
     * Outputs this printer to the specified stream and to the supplied logger
     * with at the specified level
     *
     * @param stream Output stream to print to
     * @param logger Logger to write to
     * @param level Log level to write messages
     * @return fluent interface
     */
    PrettyPrinter trace(PrintStream stream, Logger logger, Level level);

    /**
     * Print this printer to stderr
     *
     * @return fluent interface
     */
    PrettyPrinter print();

    /**
     * Print this printer to the specified output
     *
     * @param stream stream to print to
     * @return fluent interface
     */
    PrettyPrinter print(PrintStream stream);

    /**
     * Write this printer to the specified logger at {@link Level#INFO}
     *
     * @param logger logger to log to
     * @return fluent interface
     */
    PrettyPrinter log(Logger logger);

    /**
     * Write this printer to the specified logger
     *
     * @param logger logger to log to
     * @param level log level
     * @return fluent interface
     */
    PrettyPrinter log(Logger logger, Level level);

    /**
     * Convenience method, alternative to using <tt>Thread.dumpStack</tt> which
     * prints to stderr in pretty-printed format.
     */
    static void dumpStack() {
    }
}
