 package mymod.biome;


import mymod.Main;
import net.minecraft.block.Block;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class IceLands extends BiomeGenBase
{
    public IceLands(int par1)
    {
        super(par1);
        
        this.setBiomeName("Icelands");
        
        this.topBlock = (byte)Main.IcyOre.blockID;
        this.fillerBlock = (byte)Block.ice.blockID;
        
        this.theBiomeDecorator.bigMushroomsPerChunk = 10;
        this.theBiomeDecorator.treesPerChunk = 5;
        this.theBiomeDecorator.clayPerChunk  = 3;
        this.theBiomeDecorator.reedsPerChunk = 1;
        this.theBiomeDecorator.deadBushPerChunk = 7;

        this.spawnableMonsterList.add(new SpawnListEntry(EntitySnowman.class, 25, 4, 8));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 25, 4, 8));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityDragon.class, 1, 1, 1));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityIronGolem.class, 1, 1, 1));
        
        this.setMinMaxHeight(0.1F, 0.5F);
        //mnmx
        this.setTemperatureRainfall(0.7F, 0.2F);
   
    }
} 
