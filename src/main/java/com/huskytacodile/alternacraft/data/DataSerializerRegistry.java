package com.huskytacodile.alternacraft.data;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.entities.dinos.AlternaDinoEntity;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.EnumMap;

public class DataSerializerRegistry {
    public static final DeferredRegister<EntityDataSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, Alternacraft.MOD_ID);

    public static final RegistryObject<EntityDataSerializer<EnumMap<AlternaDinoEntity.DinoLevelCategory, Double>>> DINO_LEVEL_CAT = SERIALIZERS.register("dino_level_cat",
            () -> EntityDataSerializer.simple((writer, map) -> writer.writeMap(map, FriendlyByteBuf::writeEnum, FriendlyByteBuf::writeDouble),
                    (reader) -> new EnumMap<AlternaDinoEntity.DinoLevelCategory, Double>(reader.readMap(buf -> buf.readEnum(AlternaDinoEntity.DinoLevelCategory.class), FriendlyByteBuf::readDouble))));
}
