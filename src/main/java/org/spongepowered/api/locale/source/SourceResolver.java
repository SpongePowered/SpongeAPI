package org.spongepowered.api.locale.source;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.Callable;

/**
 * Class that resolves an {@link InputStream} source for a given {@link Locale}.
 */
public class SourceResolver {

    protected final List<Callable<InputStream>> general = new ArrayList<>();
    protected final Map<Locale, List<Callable<InputStream>>> specific = new HashMap<>();

    public Optional<InputStream> resolve(Locale locale) throws Exception {
        List<Callable<InputStream>> resolvers = this.specific.get(locale);
        if (resolvers != null) {
            for (Callable<InputStream> resolver : resolvers) {
                InputStream in = resolver.call();
                if (in != null) {
                    return Optional.of(in);
                }
            }
        }
        for (Callable<InputStream> resolver : this.general) {
            InputStream in = resolver.call();
            if (in != null) {
                return Optional.of(in);
            }
        }
        return Optional.empty();
    }

    public SourceResolver general(Callable<InputStream> general) {
        this.general.add(general);
        return this;
    }

    public SourceResolver general(Collection<Callable<InputStream>> general) {
        this.general.addAll(general);
        return this;
    }

    public SourceResolver specific(Locale locale, Callable<InputStream> callable) {
        getSpecific(locale).add(callable);
        return this;
    }

    public SourceResolver specific(Locale locale, Collection<Callable<InputStream>> callables) {
        getSpecific(locale).addAll(callables);
        return this;
    }

    protected List<Callable<InputStream>> getSpecific(Locale locale) {
        List<Callable<InputStream>> list = this.specific.get(locale);
        if (list == null) {
            list = new ArrayList<>();
        }
        this.specific.put(locale, list);
        return list;
    }

}
