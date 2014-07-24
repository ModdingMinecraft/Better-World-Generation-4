package bwg4.deco;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DecoGrass extends WorldGenerator
{
	private Block block;
	private int metadata;

    public DecoGrass(Block b, int m)
    {
		block = b;
		metadata = m;
    }

    public boolean generate(World world, Random rand, int x, int y, int z)
    {
    	while(y > 0)
    	{
    		if(!world.isAirBlock(x, y, z) || world.getBlock(x, y, z).isLeaves(world, x, y, z))
    		{
    			break;
    		}
    		y--;
    	}
    	
    	if(block == Blocks.double_plant)
    	{
            for (int l = 0; l < 64; ++l)
            {
                int i1 = x + rand.nextInt(8) - rand.nextInt(8);
                int j1 = y + rand.nextInt(4) - rand.nextInt(4);
                int k1 = z + rand.nextInt(8) - rand.nextInt(8);

                if (world.isAirBlock(i1, j1, k1) && (!world.provider.hasNoSky || j1 < 254) && Blocks.double_plant.canPlaceBlockAt(world, i1, j1, k1))
                {
                    Blocks.double_plant.func_149889_c(world, i1, j1, k1, metadata, 2);
                }
            }
    	}
    	else
    	{
            for (int l = 0; l < 128; ++l)
            {
                int i1 = x + rand.nextInt(8) - rand.nextInt(8);
                int j1 = y + rand.nextInt(4) - rand.nextInt(4);
                int k1 = z + rand.nextInt(8) - rand.nextInt(8);

                if (world.isAirBlock(i1, j1, k1) && block.canBlockStay(world, i1, j1, k1))
                {
                    world.setBlock(i1, j1, k1, block, metadata, 2);
                }
            }
    	}
    	return true;
    }
}
