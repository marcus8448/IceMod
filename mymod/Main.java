package mymod;

import mymod.biome.IceLands;
import mymod.blocks.IcyOre;
import mymod.blocks.IcyOreGen;
import mymod.items.FlintAndIce;
import mymod.items.FrozenBeef;
import mymod.items.FrozenStick;
import mymod.items.IceFragment;
import mymod.items.IcePickaxe;
import mymod.items.IceSword;
import mymod.projectiles.EntityHunkOIce;
import mymod.projectiles.HunkOIce;
import mymod.projectiles.RenderHunkOIce;
import mymod.proxies.CommonProxy;
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
	@Mod( modid = "icemod", name = "Ice Mod", version = "0.1")
	@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class Main {

/*	PROXY INFO */
	@SidedProxy(clientSide = "mymod.proxies.ClientProxy", serverSide = "mymod.proxies.CommonProxy")
	public static CommonProxy proxy;
		
	
/**	
 * DECLARATION SECTION 
 * *********************************************************** */
//  DECLARE A NEW CREATIVE TAB  
        public static CreativeTabs IceModTab;
        
        //DIM 2 DECLARE
        public static int MyDimensionID_1 =2;

//FROZEN STICK
    public static Item FrozenStick;
    
//  DECLARE NEW TOOL MATERIAL
        public static EnumToolMaterial IceMaterial = EnumHelper.addToolMaterial("IceMaterial", 4, 1700, 9.0F, 4.0F, 11);
        
//  DECLARE THE SWORD 
        public static Item IceSword;
        
//  DECLARE THE PICKAXE 
        public static Item IcePick;
        
//  DECLARE THE ITEM
        public static Item IceFragment;
        
//  DECLARE THE BLOCK
        public static Block IcyOre;
        
//  DECLARE THE FOOD
        public static Item FrozenBeef;

//  DECLARE THE BIOME
        public static  BiomeGenBase IceLands;  
          
//  DECLARE THE FLINT AND DIAMOND
        public static Item FlintAndDiamond;

// DECLARE BALL OF MAGMA
        public static Item HunkOIce;
        




/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	


@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{
/**	
 * LOAD SECTION 
 * *********************************************************** */ 

//  LOAD THE CREATIVE TAB
        IceModTab = new CreativeTabs("IceMod") {
            public ItemStack getIconItemStack() {
                return new ItemStack(FrozenBeef, 1, 0);   // Icon, Stack Size, Tab Position
            }
        };
        
        //FROZEN STICK
         FrozenStick = new FrozenStick(999, "FrozenStick").setCreativeTab(CreativeTabs.tabMisc);
        GameRegistry.registerItem(FrozenStick, "FrozenStick");
        LanguageRegistry.addName(FrozenStick, "Frozen Stick");     
        
//  LOAD FIRESWORD
        IceSword = new IceSword(1000, EnumToolMaterial.EMERALD, "IceSword").setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(IceSword, "IceSword");
        LanguageRegistry.addName(IceSword, "Ice Sword");     
        
//  LOAD FIRE PICKAXE
        IcePick = new IcePickaxe(1001, Main.IceMaterial, "IcePickaxe").setCreativeTab(CreativeTabs.tabTools);
        GameRegistry.registerItem(IcePick, "IcePickaxe");
        LanguageRegistry.addName(IcePick, "Ice Pickaxe");  	
//  LOAD THE ITEM
        IceFragment = new IceFragment(1002, "IceFragment").setCreativeTab(CreativeTabs.tabMisc);
        GameRegistry.registerItem(IceFragment, "IceFragment");
        LanguageRegistry.addName(IceFragment, "Ice Fragment");        
        
//  LOAD THE BLOCK 
        IcyOre = new IcyOre(1003, Material.rock, "IcyiOre").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerBlock(IcyOre, "IcyOre");
        LanguageRegistry.addName(IcyOre, "Icy Ore"); 
		MinecraftForge.setBlockHarvestLevel(IcyOre, "pickaxe", 3);

		
 //  LOAD THE FOOD
        FrozenBeef = new FrozenBeef(1004, 3, 3.0F, true, "FrozenBeef").setCreativeTab(CreativeTabs.tabFood);
        GameRegistry.registerItem(FrozenBeef, "FrozenBeef");
        LanguageRegistry.addName(FrozenBeef, "Frozen Beef"); 
        
//  LOAD BIOME
        IceLands = new IceLands(77);
        GameRegistry.addBiome(IceLands);        

 //  LOAD FLINT AND DIAMOND
        FlintAndDiamond = new FlintAndIce(1006, "FlintAndDiamond").setCreativeTab(CreativeTabs.tabTools);
        GameRegistry.registerItem(FlintAndDiamond, "FlintAndDiamond");
        LanguageRegistry.addName(FlintAndDiamond, "Flint And Diamond");
        
//  LOAD THE ITEM
         HunkOIce = new HunkOIce(1007, "HunkOIce").setCreativeTab(CreativeTabs.tabMisc);
        GameRegistry.registerItem(HunkOIce, "HunkOIce");
        LanguageRegistry.addName(HunkOIce, "HunkOIce"); 
        EntityRegistry.registerGlobalEntityID(EntityHunkOIce.class, "HunkOIce", 1);
         EntityRegistry.registerModEntity(EntityHunkOIce.class, "HunkOIce", 1, this, 256, 1, true);
         LanguageRegistry.instance().addStringLocalization("entity.modid.HunkOIce.name", "HunkOIce");
         RenderingRegistry.registerEntityRenderingHandler(EntityHunkOIce.class, new RenderHunkOIce(HunkOIce));
   
    
                  
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}

@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
	
/**	
 * RECIPES SECTION 
 * *********************************************************** */

//  SWORD RECIPE  
        GameRegistry.addRecipe(new ItemStack(IceSword, 1), new Object[]
        {
                " D ",
                " D ",
                " S ",
            'D', Item.diamond,
            'S', Main.FrozenStick,
        });

 //  PICKAXE RECIPE  
        GameRegistry.addRecipe(new ItemStack(IcePick, 1), new Object[]
        {
                "XXX",
                " S ",
                " S ",
            'S', Main.FrozenStick,
            'X', Item.diamond,
        }); 
        
 //  SMELTING RECIPE
        GameRegistry.addSmelting(IcyOre.blockID, (new ItemStack(IcyOre, 9)), 10);

//  FOOD RECIPE         
        GameRegistry.addRecipe(new ItemStack(FrozenBeef, 1), new Object[]
        {
                "CCC",
                "CBC",
                "CCC",
            'C', Block.ice,
            'B', Item.beefCooked,
        });

//  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(FlintAndDiamond, 1), new Object[]
        {
                "   ",
                " I ",
                "  F",
            'I', Block.ice,
            'F', Item.flint,
        });
        //  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(IceFragment, 9), new Object[]
        {
                "   ",
                " I ",
                "   ",
            'I', Block.ice,
        });
        //  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(FrozenStick, 3), new Object[]
        {
                "III",
                "SSS",
                "III",
            'I', Main.IceFragment,
            'S', Item.stick,
        });
        
  

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */

//  REGISTER THE ORE GENERATION 
    GameRegistry.registerWorldGenerator(new IcyOreGen());
    
//  CHANGE TAB NAME
        LanguageRegistry.instance().addStringLocalization("itemGroup.IceModTab", "en_US", "Ice Mod");  
        


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}
