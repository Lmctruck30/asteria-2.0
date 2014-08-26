package com.asteria.world.entity.npc.drops;

import com.asteria.world.entity.npc.NpcDropTable.BetModification;
import com.asteria.world.entity.npc.NpcDropTable.NpcDrop;
import com.asteria.world.entity.player.Player;

/**
 * A {@link BetModification} extension that handles rare items always dropping
 * when the player is of a developer rank. This bet modification only takes
 * effect if debugging is enabled.
 * 
 * @author lare96
 */
public class AlwaysDropModification extends BetModification {

    /** Create a new {@link AlwaysDropModification}. */
    public AlwaysDropModification() {

        // We add a value of + 1.0 or 100% to the bet so the item always drops.
        super(1.0);
    }

    @Override
    public void itemPassed(Player player, NpcDrop item) {
        player.getPacketBuilder().sendMessage(
            "You are a developer so rare items will always drop.");
    }
}
