package org.spongepowered.api.service.economy.account;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.util.annotation.CatalogedBy;

import java.util.Optional;

@CatalogedBy(AccountDeletionResults.class)
public interface AccountDeletionResult extends CatalogType {

    /**
     * Gets whether the account was deleted successfully.
     *
     * @return If the deletion was successful
     */
    boolean isSuccessful();

    /**
     * Gets a default message tied to the
     * specific account deletion type, if specified.
     *
     * @return A default message tied to the result type, if it exists
     */
    default Optional<Text> getMessage() {
        return Optional.empty();
    }

}
