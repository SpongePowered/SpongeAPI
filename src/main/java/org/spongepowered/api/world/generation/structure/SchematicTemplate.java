package org.spongepowered.api.world.generation.structure;

import org.spongepowered.api.datapack.DataPack;
import org.spongepowered.api.datapack.DataPackEntry;
import org.spongepowered.api.util.CopyableBuilder;
import org.spongepowered.api.util.ResourceKeyedBuilder;
import org.spongepowered.api.world.schematic.Schematic;

/**
 * The template for a vanilla structure schematic.
 */
public interface SchematicTemplate extends DataPackEntry<SchematicTemplate> {

    Schematic schematic();

    interface Builder extends ResourceKeyedBuilder<SchematicTemplate, Builder>, CopyableBuilder<SchematicTemplate, Builder> {

        Builder pack(DataPack<SchematicTemplate> pack);

    }
}
