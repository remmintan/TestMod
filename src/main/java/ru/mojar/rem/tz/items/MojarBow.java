package ru.mojar.rem.tz.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class MojarBow extends ItemBow{

    public MojarBow(){
        super();
        this.setUnlocalizedName("new_bow");
        this.setCreativeTab(CreativeTabs.COMBAT);
    }

    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 1;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand){
        playerIn.setActiveHand(hand);
        onPlayerStoppedUsing(itemStackIn, worldIn, playerIn, 1000);
        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        ItemStack itemstack = new ItemStack(Items.ARROW);

        if(!(entityLiving instanceof EntityPlayer))return;
        EntityPlayer entityplayer = (EntityPlayer)entityLiving;

        if (!worldIn.isRemote)
        {
            ItemArrow itemarrow = (ItemArrow)((ItemArrow)(itemstack.getItem() instanceof ItemArrow ? itemstack.getItem() : Items.ARROW));
            EntityArrow entityarrow = itemarrow.createArrow(worldIn, itemstack, entityplayer);
            entityarrow.setAim(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F,  3.0F, 1.0F);

            entityarrow.setIsCritical(true); //always critical

            int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

            if (j > 0)
            {
                entityarrow.setDamage(entityarrow.getDamage() + (double)j * 0.5D + 0.5D);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

            if (k > 0)
            {
                entityarrow.setKnockbackStrength(k);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0)
            {
                entityarrow.setFire(100);
            }

            stack.damageItem(1, entityplayer);
            entityarrow.pickupStatus = EntityArrow.PickupStatus.CREATIVE_ONLY;
            worldIn.spawnEntityInWorld(entityarrow);
            worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.NEUTRAL, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);
        }
    }

}
