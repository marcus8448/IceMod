package iceMod;

import iceMod.biome.IceLands;
import iceMod.blocks.IcyOre;
import iceMod.blocks.IcyOreGen;
import iceMod.items.FlintAndIce;
import iceMod.items.FrozenBeef;
import iceMod.items.FrozenStick;
import iceMod.items.IceFragment;
import iceMod.items.IcePickaxe;
import iceMod.items.IceSword;
import iceMod.projectiles.EntityHunkOIce;
import iceMod.projectiles.HunkOIce;
import iceMod.projectiles.RenderHunkOIce;
import iceMod.proxies.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import api.Structure;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;


/* 	MOD INFO */
	@Mod( modid = "IceMod", name = "Ice Mod", version = "1.5")
	@NetworkMod(clientSideRequired=true, serverSideRequired=true)	


public class IceMod {

/*	PROXY INFO */
	@SidedProxy(clientSide = "iceMod.proxies.ClientProxy", serverSide = "iceMod.proxies.CommonProxy")
	public static CommonProxy proxy;
		

//  Declare the IceMod Creative Tab
        public static CreativeTabs IceModTab;
//  Declare the Frozen Stick
    public static Item FrozenStick;
    
//  Declare the IceMaterial
        public static EnumToolMaterial IceMaterial = EnumHelper.addToolMaterial("IceMaterial", 4, 1700, 9.0F, 4.0F, 11);
        
//  Declare the IceSword
        public static Item IceSword;
        
//  Declare the IcePickaxe
        public static Item IcePick;
        
//  Declare the IceFragment
        public static Item IceFragment;
        
//  Declare the IcyOre
        public static Block IcyOre;
        
//  Declare the FrozenBeef
        public static Item FrozenBeef;

//  Declare the Icy cold biome
        public static  BiomeGenBase IceLands;  
          
//  Declare the Flint and Diamond
        public static Item FlintAndDiamond;

//  Declare the Hunk O' Ice
        public static Item HunkOIce;
        




/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{

	// Load the items/blocks etc

//  Load the IceMod Creative Tab
        IceModTab = new CreativeTabs("IceMod") {
            public ItemStack getIconItemStack() {
                return new ItemStack(FrozenBeef, 1, 0);   // Icon, Stack Size, Tab Position
            }
        };
        
//  Load the FrozenStick
         FrozenStick = new FrozenStick(999, "FrozenStick").setCreativeTab(CreativeTabs.tabMisc);
        GameRegistry.registerItem(FrozenStick, "FrozenStick");
        LanguageRegistry.addName(FrozenStick, "Frozen Stick");     
        
//  Load the IceSword
        IceSword = new IceSword(1000, EnumToolMaterial.EMERALD, "IceSword").setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(IceSword, "IceSword");
        LanguageRegistry.addName(IceSword, "Ice Sword");     
        
//  Load the IcePickaxe
        IcePick = new IcePickaxe(1001, IceMod.IceMaterial, "IcePickaxe").setCreativeTab(CreativeTabs.tabTools);
        GameRegistry.registerItem(IcePick, "IcePickaxe");
        LanguageRegistry.addName(IcePick, "Ice Pickaxe");  	
//  Load the IceFragment
        IceFragment = new IceFragment(1002, "IceFragment").setCreativeTab(CreativeTabs.tabMisc);
        GameRegistry.registerItem(IceFragment, "IceFragment");
        LanguageRegistry.addName(IceFragment, "Ice Fragment");        
        
//  Load the IcyOre
        IcyOre = new IcyOre(1003, Material.rock, "IcyiOre").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerBlock(IcyOre, "IcyOre");
        LanguageRegistry.addName(IcyOre, "Icy Ore"); 
		MinecraftForge.setBlockHarvestLevel(IcyOre, "pickaxe", 3);

		
 //  Load the FrozenBeef
        FrozenBeef = new FrozenBeef(1004, 3, 3.0F, true, "FrozenBeef").setCreativeTab(CreativeTabs.tabFood);
        GameRegistry.registerItem(FrozenBeef, "FrozenBeef");
        LanguageRegistry.addName(FrozenBeef, "Frozen Beef"); 
        
//  Load the Icelands
        IceLands = new IceLands(54);
        GameRegistry.addBiome(IceLands);        

 //  Load the Flint and diamond
        FlintAndDiamond = new FlintAndIce(1006, "FlintAndDiamond").setCreativeTab(CreativeTabs.tabTools);
        GameRegistry.registerItem(FlintAndDiamond, "FlintAndDiamond");
        LanguageRegistry.addName(FlintAndDiamond, "Flint & Diamond");
        
//  Load the Hunk O' Ice
         HunkOIce = new HunkOIce(1007, "HunkOIce").setCreativeTab(CreativeTabs.tabMisc);
        GameRegistry.registerItem(HunkOIce, "Hunk O' Ice");
        LanguageRegistry.addName(HunkOIce, "Hunk O' Ice"); 
        EntityRegistry.registerGlobalEntityID(EntityHunkOIce.class, "Hunk O' Ice", 1);
         EntityRegistry.registerModEntity(EntityHunkOIce.class, "Hunk O' Ice", 1, this, 256, 1, true);
         LanguageRegistry.instance().addStringLocalization("entity.modid.Hunk O' Ice.name", "Hunk O' Ice");
         RenderingRegistry.registerEntityRenderingHandler(EntityHunkOIce.class, new RenderHunkOIce(HunkOIce));
   
    
                  
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}

@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
	
/**	
 * RECIPES SECTION 
 * *********************************************************** */

// The Recipe for the Ice Sword
        GameRegistry.addRecipe(new ItemStack(IceSword, 1), new Object[]
        {
                "IDI",
                "IDI",
                " S ",
            'D', Item.diamond,
            'S', IceMod.FrozenStick,
			'I', Block.ice,
        });

 // The Recipe for the Ice Pickaxe
        GameRegistry.addRecipe(new ItemStack(IcePick, 1), new Object[]
        {
                "IXI",
                " S ",
                " S ",
            'S', IceMod.FrozenStick,
            'X', Item.diamond,
			'I', Block.Ice,
        }); 
        
 // The Smelting Recipe for ICYORE
        GameRegistry.addSmelting(IcyOre.blockID, (new ItemStack(IcyOre, 9)), 10);

// The Recipe for Frozen Beef         
        GameRegistry.addRecipe(new ItemStack(FrozenBeef, 1), new Object[]
        {
                "CSC",
                "SBS",
                "CSC",
            'C', Block.ice,
            'B', Item.beefCooked,
			's', IceMod.IceFragment,
        });

// The Recipe for the Flint And Diamond      
        GameRegistry.addRecipe(new ItemStack(FlintAndDiamond, 1), new Object[]
        {
                "   ",
                " I ",
                "  F",
            'I', Block.ice,
            'F', Item.flint,
        });
        // The Recipe for the Ice Fragment   
        GameRegistry.addRecipe(new ItemStack(IceFragment, 9), new Object[]
        {
                "   ",
                " I ",
                "   ",
            'I', Block.ice,
        });
        // The Recipe for the Frozen Sticks    
        GameRegistry.addRecipe(new ItemStack(FrozenStick, 3), new Object[]
        {
                "III",
                "SSS",
                "III",
            'I', IceMod.IceFragment,
            'S', Item.stick,
        });
        
  

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */

// Register Icy Ore Gen
    GameRegistry.registerWorldGenerator(new IcyOreGen());
    
// Change The Ice Mod Tab's Name
        LanguageRegistry.instance().addStringLocalization("itemGroup.IceModTab", "en_US", "Ice Mod");  
        


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}
