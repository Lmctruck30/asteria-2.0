package com.asteria.world.entity.npc.drops;

import com.asteria.util.Utility;
import com.asteria.world.entity.npc.NpcDropTable.BetModification;
import com.asteria.world.entity.npc.NpcDropTable.NpcDrop;
import com.asteria.world.entity.player.Player;

/**
 * A {@link BetModification} extension that handles the rare drop increase when
 * wearing a ring of wealth.
 * 
 * @author lare96
 */
public class RingOfWealthModification extends BetModification {

    /** Create a new {@link RingOfWealthModification}. */
    public RingOfWealthModification() {
        super(0.025);
    }

    @Override
    public void itemPassed(Player player, NpcDrop item) {

        // Item dropped, do ring of wealth stuff.
        if (Utility.RANDOM.nextBoolean()) {
            player.getEquipment().unequipItem(Utility.EQUIPMENT_SLOT_RING,
                false);
            player.getPacketBuilder().sendMessage(
                "Your ring of wealth takes effect and crumbles into dust!");
        } else {
            player.getPacketBuilder().sendMessage(
                "Your ring of wealth takes effect and keeps itself intact!");
        }
    }
}
