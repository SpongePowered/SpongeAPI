package org.spongepowered.api.service.economy.transaction;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

@CatalogedBy(EconomyTransactionResultTypes.class)
public interface EconomyTransactionResultType extends CatalogType {

    /**
     * Gets whether the economy transaction was successfully completed.
     *
     * @return If the economy transaction was successful.
     */
    boolean isSuccessful();

    /**
     * Gets a default message tied to the
     * specific result type if specified.
     *
     * @return A default message tied to the result type
     */
    default Optional<Text> getMessage() {
        return Optional.empty();
    }

}
