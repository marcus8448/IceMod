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


	@Mod( modid = "IceMod", name = "Ice Mod", version = "1.5")
	@NetworkMod(clientSideRequired=true, serverSideRequired=true)	


public class IceMod {

	@SidedProxy(clientSide = "iceMod.proxies.ClientProxy", serverSide = "iceMod.proxies.CommonProxy")
	public static CommonProxy proxy;
		

        public static CreativeTabs IceModTab;
	
        public static EnumToolMaterial IceMaterial = EnumHelper.addToolMaterial("IceMaterial", 4, 1700, 9.0F, 4.0F, 11);
	
        public static BiomeGenBase IceLands; 
	
        public static Block IcyOre;
	
	public static Item FrozenStick;
	public static Item IceSword;
        public static Item IcePick;
        public static Item IceFragment;
        public static Item FrozenBeef; 
        public static Item FlintAndDiamond;
        public static Item HunkOIce;
        
	@EventHandler	
	public void preInit(FMLPreInitializationEvent event) 
	{

         IceModTab = new CreativeTabs("IceMod") {
        public ItemStack getIconItemStack() 
		return new ItemStack(FrozenBeef, 1, 0);
	 }};
        
        FrozenStick = new FrozenStick(999, "FrozenStick").setCreativeTab(CreativeTabs.tabMisc);
        GameRegistry.registerItem(FrozenStick, "FrozenStick");
        LanguageRegistry.addName(FrozenStick, "§9Frozen Stick");

        IceSword = new IceSword(1000, EnumToolMaterial.EMERALD, "IceSword").setCreativeTab(CreativeTabs.tabCombat);
        GameRegistry.registerItem(IceSword, "IceSword");
        LanguageRegistry.addName(IceSword, "§9Ice Sword");     
        
        IcePick = new IcePickaxe(1001, IceMod.IceMaterial, "IcePickaxe").setCreativeTab(CreativeTabs.tabTools);
        GameRegistry.registerItem(IcePick, "IcePickaxe");
        LanguageRegistry.addName(IcePick, "§9Ice Pickaxe");  	
		
        IceFragment = new IceFragment(1002, "IceFragment").setCreativeTab(CreativeTabs.tabMisc);
        GameRegistry.registerItem(IceFragment, "IceFragment");
        LanguageRegistry.addName(IceFragment, "§9Ice Fragment");        
        
        IcyOre = new IcyOre(1003, Material.rock, "IcyiOre").setCreativeTab(CreativeTabs.tabMaterials);
        GameRegistry.registerBlock(IcyOre, "IcyOre");
        LanguageRegistry.addName(IcyOre, "§9Icy Ore"); 
		MinecraftForge.setBlockHarvestLevel(IcyOre, "pickaxe", 3);

		
        FrozenBeef = new FrozenBeef(1004, 3, 3.0F, true, "FrozenBeef").setCreativeTab(CreativeTabs.tabFood);
        GameRegistry.registerItem(FrozenBeef, "FrozenBeef");
        LanguageRegistry.addName(FrozenBeef, "§9Frozen Beef"); 
        
        IceLands = new IceLands(54);
        GameRegistry.addBiome(IceLands);        

        FlintAndDiamond = new FlintAndIce(1006, "FlintAndDiamond").setCreativeTab(CreativeTabs.tabTools);
        GameRegistry.registerItem(FlintAndDiamond, "FlintAndDiamond");
        LanguageRegistry.addName(FlintAndDiamond, "§9Flint & Diamond");
        
        HunkOIce = new HunkOIce(1007, "HunkOIce").setCreativeTab(CreativeTabs.tabMisc);
        GameRegistry.registerItem(HunkOIce, "Hunk O Ice");
        LanguageRegistry.addName(HunkOIce, "Hunk O Ice"); 
        EntityRegistry.registerGlobalEntityID(EntityHunkOIce.class, "Hunk O Ice", 1);
        EntityRegistry.registerModEntity(EntityHunkOIce.class, "Hunk O Ice", 1, this, 256, 1, true);
        LanguageRegistry.instance().addStringLocalization("entity.modid.Hunk O Ice.name", "Hunk O Ice");
        RenderingRegistry.registerEntityRenderingHandler(EntityHunkOIce.class, new RenderHunkOIce(HunkOIce));
	}

@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
		
		GameRegistry.addRecipe(new ItemStack(IceSword, 1), new Object[]
    	    {
                "IDI",
                "IDI",
                " S ",
            'D', Item.diamond,
            'S', IceMod.FrozenStick,
            'I', Block.ice,
        });

        GameRegistry.addRecipe(new ItemStack(IcePick, 1), new Object[]
        {
                "IXI",
                " S ",
                " S ",
            'S', IceMod.FrozenStick,
            'X', Item.diamond,
			'I', Block.Ice,
        }); 

        GameRegistry.addSmelting(IcyOre.blockID, (new ItemStack(Ice, 9)), 100);
        
        GameRegistry.addRecipe(new ItemStack(FrozenBeef, 1), new Object[]
        {
                "CSC",
                "SBS",
                "CSC",
            'C', Block.ice,
            'B', Item.beefCooked,
			's', IceMod.IceFragment,
        });

        GameRegistry.addSmelting(FrozenBeef, (new ItemStack(Beef, 1)), new Object []
  
        GameRegistry.addRecipe(new ItemStack(FlintAndDiamond, 1), 10);
        {
                "   ",
                " I ",
                "  F",
            'I', Block.ice,
            'F', Item.flint,
        });

        GameRegistry.addRecipe(new ItemStack(IceFragment, 9), new Object[]
        {
                "   ",
                " I ",
                "   ",
            'I', Block.ice,
        });

        GameRegistry.addRecipe(new ItemStack(FrozenStick, 1), new Object[]
        {
                "III",
                "ISI",
                "III",
            'I', IceMod.IceFragment,
            'S', Item.stick,
        });

 	   GameRegistry.registerWorldGenerator(new IcyOreGen());
   	 LanguageRegistry.instance().addStringLocalization("itemGroup.IceModTab", "en_US", "§9Ice Mod");  
	LanguageRegistry.instance().addStringLocalization("itemGroup.IceModTab", "en_CA", "§9Ice Mod");  
        
@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{

	}
	
}
