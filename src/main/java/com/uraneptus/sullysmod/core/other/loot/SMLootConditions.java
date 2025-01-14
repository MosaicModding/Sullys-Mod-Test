package com.uraneptus.sullysmod.core.other.loot;

import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

public class SMLootConditions {
    public static final LootItemCondition.Builder ON_LANTERNFISH_HEIGHT = LocationCheck.checkLocation(LocationPredicate.Builder.location().setY(MinMaxBounds.Doubles.between(-57.0D, 16.0D)));
    public static final LootItemCondition.Builder IS_DEEPSLATE_CAVE = LocationCheck.checkLocation(LocationPredicate.Builder.location().setY(MinMaxBounds.Doubles.between(-59.0D, 0.0D)));
    public static final LootItemCondition.Builder IS_NORMAL_CAVE = LocationCheck.checkLocation(LocationPredicate.Builder.location().setY(MinMaxBounds.Doubles.between(1.0D, 140.0D)));

    public static LootItemCondition.Builder getPiranhaBiomes() {
        return biomeConditionCheck(Biomes.MANGROVE_SWAMP)
                .or(biomeConditionCheck(Biomes.JUNGLE))
                .or(biomeConditionCheck(Biomes.SPARSE_JUNGLE))
                .or(biomeConditionCheck(Biomes.BAMBOO_JUNGLE));
    }

    public static LootItemCondition.Builder biomeConditionCheck(ResourceKey<Biome> biome) {
        return LocationCheck.checkLocation(LocationPredicate.Builder.location().setBiome(biome));
    }
}
