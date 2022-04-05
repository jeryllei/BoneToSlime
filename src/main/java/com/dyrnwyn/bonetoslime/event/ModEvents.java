package com.dyrnwyn.bonetoslime.event;

import com.dyrnwyn.bonetoslime.BoneToSlime;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = BoneToSlime.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.SLIME_BALL.asItem(), 4);
            int villagerLevel = 1;

            trades.get(villagerLevel).add(((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2), stack, 12, 5, 0.09F)
            ));
        }

        if (event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.SLIME_BLOCK.asItem(), 1);
            int villagerLevel = 2;

            trades.get(villagerLevel).add(((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 9), stack, 8, 9, 0.07F)
            ));
        }

        if (event.getType() == VillagerProfession.BUTCHER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.BONE.asItem(), 7);
            int villagerLevel = 1;

            trades.get(villagerLevel).add(((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1), stack, 12, 4, 0.05F)
            ));
        }

        if (event.getType() == VillagerProfession.BUTCHER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.BONE_BLOCK.asItem(), 5);
            int villagerLevel = 2;

            trades.get(villagerLevel).add(((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 3), stack, 8, 9, 0.07F)
            ));
        }
    }

}
