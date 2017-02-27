package org.spongepowered.api.util.reporting;

import java.util.function.Consumer;

/**
 * TODO Rename, better name than ErrorReportable
 * This is realistically supposed to add itself to an error report
 * so that it can be presented in a pretty format, but sometimes, the
 * format is determined by the context of which the object is being
 * consumed.
 *
 * Case in point: a PluginContainer may format itself as a
 * string for the name of the plugin, the version, the file jar found,
 * but for a mod list, the list itself may need to be indented, actually
 * listed, etc.
 */
public interface ErrorReportable extends Consumer<ErrorReport> {

    /**
     * Accepts the provided {@link ErrorReport} to decorate the
     * report either in an {@link ErrorSection} or simply to the
     * report itself. More used for official reports that can be
     * submitted as issues to developers to resolve by being printed
     * to file or paste bin service, and less something to be
     * read in a console log.
     *
     * @param report The report to populate
     */
    @Override
    void accept(ErrorReport report);
}
