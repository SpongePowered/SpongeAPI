package org.spongepowered.api.util.reporting;

import org.apache.logging.log4j.Logger;
import org.spongepowered.api.command.CommandSource;

import java.net.URL;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

/**
 * TODO Decide on PrettyPrinter or ErrorReport or mesh the two into one?
 */
public interface ErrorReport {

    Optional<Throwable> getCause();

    boolean isUserError();

    ErrorReport setUserError(boolean isUserError);

    String getDescription();

    ErrorSection addSection(String title);

    ErrorReport addReportable(ErrorReportable reportable);

    void dispatchFatal() throws RuntimeException;

    void dispatchToCommandSource(CommandSource source);

    void dispatchTo(Logger logger);

    String toText();

}
