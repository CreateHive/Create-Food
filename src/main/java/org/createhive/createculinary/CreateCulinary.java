package org.createhive.createculinary;

import net.fabricmc.api.ModInitializer;

import org.createhive.createculinary.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateCulinary implements ModInitializer {
	public static final String MOD_ID = "createculinary";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}