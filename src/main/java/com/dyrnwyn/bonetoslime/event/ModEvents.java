package com.dyrnwyn.bonetoslime.event;


import com.dyrnwyn.bonetoslime.BoneToSlime;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.merchant.villager.VillagerTrades;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = BoneToSlime.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.CLERIC) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.SLIME_BALL.getItem(), 4);
            int villagerLevel = 1;

            trades.get(villagerLevel).add(((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2), stack, 12, 5, 0.09F)
            ));
        }

        if (event.getType() == VillagerProfession.BUTCHER) {
            Int2ObjectMap<List<VillagerTrades.ITrade>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.BONE.getItem(), 7);
            int villagerLevel = 1;

            trades.get(villagerLevel).add(((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1), stack, 12, 4, 0.05F)
            ));
        }
    }
}
