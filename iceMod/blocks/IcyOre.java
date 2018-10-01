package mymod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class IcyOre extends Block {

    private String texturePath = "icemod";  
    private int blockID;
    
    public IcyOre (int id, Material blockMaterial, String textureName) {
        
        super(par1, blockMaterial);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName(textureName);
        texturePath += textureName;
        blockID = id;
    }

    public int idDropped(int int1, Random rand, int int2)
    {
        return blockID;
    }
    
    public int quantityDropped(Random rand)
    {
        return 1;
    }

    public void registerIcons(IconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(texturePath);
    }
    
}

