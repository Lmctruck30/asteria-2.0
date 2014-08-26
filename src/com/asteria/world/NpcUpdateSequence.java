package com.asteria.world;

import com.asteria.world.entity.npc.Npc;
import com.asteria.world.entity.npc.NpcAggression;

/**
 * A {@link WorldUpdateSequence} implementation for {@link Npc}s that provides
 * code for each of the updating stages. The actual updating stage is not
 * supported by this implementation because npc's are updated for players.
 * 
 * @author lare96
 */
public class NpcUpdateSequence implements WorldUpdateSequence<Npc> {

    @Override
    public void executePreUpdate(Npc t) {
        try {
            NpcAggression.target(t);
            t.getMovementCoordinator().coordinate();
            t.getMovementQueue().execute();
        } catch (Exception e) {
            e.printStackTrace();
            World.getNpcs().remove(t);
        }
    }

    @Override
    public void executeUpdate(Npc t) {
        throw new UnsupportedOperationException(
            "NPCs cannot be updated for NPCs!");
    }

    @Override
    public void executePostUpdate(Npc t) {
        try {
            t.reset();
        } catch (Exception e) {
            e.printStackTrace();
            World.getNpcs().remove(t);
        }
    }
}
