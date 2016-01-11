package org.spongepowered.api.data.persistence;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.data.DataContainer;
import org.spongepowered.api.data.DataView;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Represents a parser for a particular file format allowing reading and writing
 * a DataContainer to/from a stream of the specific format.
 */
@CatalogedBy(DataFormats.class)
public interface DataFormat extends CatalogType {

    /**
     * Creates a new {@link DataContainer} from the contents of the given
     * {@link InputStream}.
     * 
     * @param input The input stream
     * @return A data container representing the contents of the input stream
     * @throws InvalidDataFormatException If the data in the stream was not a
     *         supported format
     * @throws IOException If there was an error reading from the stream
     */
    DataContainer readFrom(InputStream input) throws InvalidDataFormatException, IOException;

    /**
     * Writes the given {@link DataView} to the given {@link OutputStream} using
     * the format specified by this {@link DataFormat}.
     * 
     * @param output The output stream to write the data to
     * @param data The DataView to write to the stream
     * @throws IOException If there was an error writing to the stream
     */
    void writeTo(OutputStream output, DataView data) throws IOException;

}
