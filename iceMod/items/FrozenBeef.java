package iceMod.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class FrozenBeef extends ItemFood 
{
   
    private String texturePath = "iceMod:";
    
    public FrozenBeef(int itemID, int healAmount, Float saturationModifier, boolean isWolfsFavoriteMeat, String textureName) 
    {
        super(itemID, healAmount, saturationModifier, isWolfsFavoriteMeat);
        this.setUnlocalizedName(textureName);
        texturePath += textureName;
    }

@Override
@SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(texturePath);
    }
    /** Makes your Item Enchanted when it is crafted */
        public void onCreated(ItemStack item, World world, EntityPlayer player) 
        {
            item.addEnchantment(Enchantment.knockback, 10);
            // Replace the "." after "Enchantment" to see options
            // The number is the Enchantment Level
        }
}