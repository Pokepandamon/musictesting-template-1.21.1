package com.testing;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Musictesting implements ModInitializer {
	public static final String MOD_ID = "musictesting";

	public static final SoundEvent ITEM_METAL_WHISTLE = registerSound("metal_whistle");

	// actual registration of all the custom SoundEvents
	private static SoundEvent registerSound(String id) {
		//Identifier identifier = Identifier.of(MOD_ID, id);
		Identifier identifier = Identifier.of("musictesting:metal_whistle");
		return Registry.register(Registries.SOUND_EVENT, identifier, SoundEvent.of(identifier));
	}

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		ServerTickEvents.START_SERVER_TICK.register(server -> {
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
				//player.getWorld().playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.ENTITY_HORSE_DEATH, SoundCategory.MASTER, 100F, 1F);
				player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), this.ITEM_METAL_WHISTLE, SoundCategory.MASTER, 100F, 1F);
				//player.getWorld().playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.MUSIC_DISC_OTHERSIDE, SoundCategory.MASTER, 100F, 1F);
				//LOGGER.info("I was here");
			}
		});
	}
}