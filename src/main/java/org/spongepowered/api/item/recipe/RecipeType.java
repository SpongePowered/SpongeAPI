package org.spongepowered.api.item.recipe;

import org.spongepowered.api.CatalogType;
import org.spongepowered.api.util.annotation.CatalogedBy;

@CatalogedBy(RecipeTypes.class)
public interface RecipeType<T extends Recipe> extends CatalogType {


}
