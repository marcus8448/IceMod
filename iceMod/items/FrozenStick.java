package iceMod.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class FrozenStick extends Item {
    
    private String texturePath = "iceMod:";
    
    public FrozenStick(int ItemID, String textureName)
    {
        super(ItemID);
        this.setUnlocalizedName(textureName);
        this.setCreativeTab(CreativeTabs.tabMaterials);
        texturePath += textureName;
    }

@Override   
@SideOnly(Side.CLIENT)

    public void registerIcons(IconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(texturePath);
    }   

        //Ice can be very sharp
        public void onCreated(ItemStack item, World world, EntityPlayer player) 
        {
            item.addEnchantment(Enchantment.sharpness, 7);
        }
}
