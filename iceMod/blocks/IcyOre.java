package mymod.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;

public class IcyOre extends Block {

    private String texturePath = "mymod:";  
    private int thisBlockID;
    
    public IcyOre (int par1, Material blockMaterial, String textureName) {
        
        super(par1, blockMaterial);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setUnlocalizedName(textureName);
        texturePath += textureName;
        thisBlockID = par1;
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return thisBlockID;
    }
    
    public int quantityDropped(Random random)
    {
        return 1;
    }

    public void registerIcons(IconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(texturePath);
    }
    
}

