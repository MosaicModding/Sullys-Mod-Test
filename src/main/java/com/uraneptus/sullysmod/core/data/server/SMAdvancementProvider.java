package com.uraneptus.sullysmod.core.data.server;

import com.uraneptus.sullysmod.SullysMod;
import com.uraneptus.sullysmod.core.registry.SMItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdventureAdvancements;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Consumer;

public class SMAdvancementProvider extends AdvancementProvider {
    public SMAdvancementProvider(DataGenerator generatorIn, ExistingFileHelper fileHelperIn) {
        super(generatorIn, fileHelperIn);
    }

    @Override
    protected void registerAdvancements(Consumer<Advancement> consumer, ExistingFileHelper fileHelper) {
        Advancement JADE_GRINDSET = Advancement.Builder.advancement().display(SMItems.ROUGH_JADE.get(), new TranslatableComponent("advancements.adventure.jade_grindset.title"), new TranslatableComponent("advancements.adventure.jade_grindset.description"),null, FrameType.TASK, true, true, false).parent(new ResourceLocation("adventure/root")).addCriterion("rough_jade", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(SMItems.ROUGH_JADE.get()))).requirements(RequirementsStrategy.OR).save(consumer, new ResourceLocation(SullysMod.MOD_ID, "adventure/jade_grindset"), fileHelper);
        Advancement POLISH_JADE = Advancement.Builder.advancement().display(SMItems.POLISHED_JADE.get(), new TranslatableComponent("advancements.adventure.polish_jade.title"), new TranslatableComponent("advancements.adventure.polish_jade.description"), null, FrameType.TASK, true, true, false).parent(JADE_GRINDSET).addCriterion("polished_jade", new Criterion(InventoryChangeTrigger.TriggerInstance.hasItems(SMItems.POLISHED_JADE.get()))).requirements(RequirementsStrategy.OR).save(consumer, new ResourceLocation(SullysMod.MOD_ID, "adventure/polish_jade"), fileHelper);

        SullysMod.LOGGER.info("ADVANCEMENT GENERATION COMPLETE");
    }
}