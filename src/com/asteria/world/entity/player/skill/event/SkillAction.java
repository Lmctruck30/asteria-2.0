package com.asteria.world.entity.player.skill.event;

import com.asteria.world.entity.player.Player;

/**
 * A {@link SkillEvent} implementation that provides more specific functionality
 * for skills that require some sort of general action. Skills such as
 * <code>PRAYER</code> should extend this class.
 * 
 * @author lare96
 */
public abstract class SkillAction extends SkillEvent {

    @Override
    public final void startSkill(Player player) {

        // First we check the player.
        if (executeIf(player) && !player.getSkillEvent()[skill().getIndex()]) {

            // The player passed the checks, so we can start the skill.
            super.startSkill(player);
            execute(player);
            return;
        }

        // If the player did not pass, stop the skill if we have it active.
        stopSkill(player);
    }

    /**
     * Determines if the skill will be executed for the argued {@link Player} or
     * not. All preliminary checks that need to be made before starting the
     * skill should be done here.
     * 
     * @param player
     *            the player that will be checked.
     * @return <code>true</code> if the skill can be executed,
     *         <code>false</code> otherwise.
     */
    public abstract boolean executeIf(Player player);

    /**
     * The code that will be executed for the argued {@link Player} if
     * {@link #executeIf} is flagged.
     * 
     * @param player
     *            the player that the code will be executed for.
     */
    public abstract void execute(Player player);

    /**
     * {@inheritDoc}
     * 
     * @implNote This method can and should be overridden if the skill needs to
     *           reset more skill code.
     */
    @Override
    public void stopSkill(Player player) {
        player.getPacketBuilder().resetAnimation();
        player.getSkillEvent()[skill().getIndex()] = false;
    }
}
