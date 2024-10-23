package com.testing;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class MusictestingClient implements ClientModInitializer {


	@Override
	public void onInitializeClient() {
		//Registry.register(Registries.SOUND_EVENT, Identifier.of(MOD_ID, "metal_whistle"),
				//SoundEvent.of(Identifier.of(MOD_ID, "metal_whistle")));
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
	}
}