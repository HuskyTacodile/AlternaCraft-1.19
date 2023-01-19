package com.huskytacodile.alternacraft.item;

import com.huskytacodile.alternacraft.Alternacraft;
import com.huskytacodile.alternacraft.entities.ModEntityTypes;
import com.huskytacodile.alternacraft.item.custom.*;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ModItems {
    public enum CreativeModeTabs {
        ALTERNACRAFT_GROUP(new ArrayList<>()),
        BLOCKS_TAB(new ArrayList<>()),
        DNA_SYRINGES(new ArrayList<>());
        public final List<RegistryObject<? extends Item>> list;

        CreativeModeTabs(List<RegistryObject<? extends Item>> list) {
            this.list = list;
        }
    }
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Alternacraft.MOD_ID);

    public static final RegistryObject<Item> ALTERNA_STAFF = register("alterna_staff", CatalystItem::new, CreativeModeTabs.BLOCKS_TAB);
    public static final RegistryObject<ForgeSpawnEggItem> JPFEMALESPINO_SPAWN_EGG = register("jpspino_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.JPSPINO, 0x614141, 0xDC0000, new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> MALUSAURUS_SPAWN_EGG = register("malusaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MALUSAURUS, 0x614141, 0xDC0000,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> INDOMINUS_SPAWN_EGG = register("indominus_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.INDOMINUS, 0xC8C8C8, 0xA5A5A5,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> OXALIA_SPAWN_EGG = register("oxalaia_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.OXALAIA, 0xDFCC8F, 0x2D2611,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> THERI_SPAWN_EGG = register("theri_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.THERI, 0xDFCC3F, 0x2D2611,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> CARNO_SPAWN_EGG = register("carno_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CARNO, 0xDACC8F, 0x2D2611,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> DROMAEO_SPAWN_EGG = register("dromaeo_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DROMAEO, 0xDFDC8F, 0x2D2611,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> TREX_SPAWN_EGG = register("trex_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TYRANNOSAURUS, 0xDFCC9F, 0x2D2611,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> SPINO_GEN2_SPAWN_EGG = register("spino_gen2_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SPINO, 0xD3D751, 0xB12626,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> VELOCIRAPTOR_SPAWN_EGG = register("velociraptor_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.VELOCIRAPTOR, 0xA9A9A9,0x008DAF ,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    /*
    public static final RegistryObject<ForgeSpawnEggItem> TYLOSAURUS_SPAWN_EGG = register("tylosaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.TYLOSAURUS, 0xF4F4F4, 0x131929,
                    new Item.Properties())));
     */

    public static final RegistryObject<ForgeSpawnEggItem> MOSASAURUS_SPAWN_EGG = register("mosasaurus_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.MOSASAURUS, 0x5998C6, 0x19424A,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> CERATOSUCHOPS_SPAWN_EGG = register("ceratosuchops_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CERATOSUCHOPS, 0x585551, 0xA18B00,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> ACRO_SPAWN_EGG = register("acro_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ACRO, 0x000000, 0x1CFCFF,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> INDORAPTOR_GEN2_SPAWN_EGG = register("indoraptor_gen2_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.INDORAPTOR_GEN2, 0x222222, 0xF0C500,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> SCORPIUS_SPAWN_EGG = register("scorpius_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.SCORPIUS, 0x4F4F4F, 0x0A0A0A,
                    new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> ALLOSAURUS_SPAWN_EGG = register("allosaurus_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.ALLOSAURUS, 0xB33B3B, 0x2D71D3,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> BARYONYX_SPAWN_EGG = register("baryonyx_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.BARYONYX, 0x878787, 0x003176,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> BARYONYX_GEN2_SPAWN_EGG = register("baryonyx_gen2_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.BARYONYX_GEN2, 0x878787, 0xF9FF1E,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> CARCHA_SPAWN_EGG = register("carcha_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.CARCHA, 0x2D2D2D, 0xC00000,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> COMPY_SPAWN_EGG = register("compy_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.COMPY, 0x9FDC55, 0x7D8F66,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

    public static final RegistryObject<ForgeSpawnEggItem> MOROS_SPAWN_EGG = register("moros_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.MOROS, 0x9F0000, 0x7D8F66,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<ForgeSpawnEggItem> DRYPTO_SPAWN_EGG = register("drypto_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.DRYPTO, 0x9F0000, 0x7D8F66,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<ForgeSpawnEggItem> INDORAPTOR_SPAWN_EGG = register("indoraptor_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.INDORAPTOR, 0x9F0000, 0x7D8F66,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<ForgeSpawnEggItem> ATROCI_SPAWN_EGG = register("atroci_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.ATROCI, 0x4D3D2D, 0xC27007,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<ForgeSpawnEggItem> PYRO_SPAWN_EGG = register("pyro_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.PYRO, 0x4D3D2D, 0xC27007,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<ForgeSpawnEggItem> YUTYRANNUS_SPAWN_EGG = register("yutyrannus_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.YUTYRANNUS, 0xDFDFDF, 0xA68B48,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<ForgeSpawnEggItem> GIGA_SPAWN_EGG = register("giga_spawn_egg",
                () -> new ForgeSpawnEggItem(ModEntityTypes.GIGA, 0x878787, 0x313131,
                        new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> FOSSIL = register("fossil",
                ()-> new Item(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> TOTEM_OF_HUGO = register("totem_of_hugo",
                ()-> new Item(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> TOTEM_OF_ELEMENT = register("totem_of_element",
                ()-> new Item(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> PAINITE = register("painite",
                ()-> new Item(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> PRIMORDIAL_SHARD = register("primordial_shard",
                ()-> new Item(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> PRIME_BIOLUMINESCENCE = register("prime_bioluminescence",
                ()-> new Item(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> BIOLUMINESCENCE = register("bioluminescence",
                ()-> new Item(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> TITANIUM_INGOT = register("titanium_ingot",
                ()-> new Item(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> MALACHITE = register("malachite",
                ()-> new MalachiteItem(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> AMBER = register("amber",
                ()-> new Item(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> MOSQUITO_IN_AMBER = register("mosquito_in_amber",
                ()-> new Item(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> AMONG_US_RED = register("among_us_red",
                ()-> new Item(new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> PAINITE_SWORD = register("painite_sword",
                ()-> new SwordItem(ModItemTier.PAINITE, 2,1f,new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> CARAMEL_SWORD = register("caramel_sword",
                ()-> new CaramelSwordItem(ModItemTier.ICE_CREAM, 3,1f,new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> MINT_SWORD = register("mint_sword",
                ()-> new MintSwordItem(ModItemTier.ICE_CREAM, 3,1f,new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> SHERBET_SWORD = register("sherbet_sword",
                ()-> new SherbetSwordItem(ModItemTier.ICE_CREAM, 3,1f,new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> TRI_BLADE = register("tri_blade",
                ()-> new SwordItem(ModItemTier.PAINITE, 7,3f,new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> PRIMORDIAL_BLADE = register("primordial_blade",
                ()-> new SwordItem(ModItemTier.PRIMORDIAL, 3,3f,new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> PAINITE_PICKAXE = register("painite_pickaxe",
                ()-> new PickaxeItem(ModItemTier.PAINITE, 1,-2f,new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> PAINITE_AXE = register("painite_axe",
                ()-> new AxeItem(ModItemTier.PAINITE, 4,-1f,new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> PAINITE_SHOVEL = register("painite_shovel",
                ()-> new ShovelItem(ModItemTier.PAINITE, 0,-1f,new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> PAINITE_HOE = register("painite_hoe",
                ()-> new HoeItem(ModItemTier.PAINITE, 0,0f,new Item.Properties()), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<PainiteBowItem> PAINITE_BOW = register("painite_bow",
                () -> new PainiteBowItem(new Item.Properties().stacksTo(1)), CreativeModeTabs.ALTERNACRAFT_GROUP);

        public static final RegistryObject<Item> EMPTY_SYRINGE = register("dna_syringe",
                () -> new DNASyringeItem(new Item.Properties()), CreativeModeTabs.DNA_SYRINGES);

        public static final RegistryObject<Item> EMPTY_DINO_EGG = register("dino_egg",
                () -> new DinoEggItem(new Item.Properties()), CreativeModeTabs.DNA_SYRINGES);

    private static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item, CreativeModeTabs tab){
        var object = ITEMS.register(name, item);
        tab.list.add(object);
        return object;
    }
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
