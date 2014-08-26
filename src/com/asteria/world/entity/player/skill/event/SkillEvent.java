package com.asteria.world.entity.player.skill.event;

import com.asteria.world.entity.player.Player;
import com.asteria.world.entity.player.skill.SkillData;

/**
 * The parent class of all skill functions that provides implementation for a
 * wide variety of skills. More generic skills that need many different skill
 * implementations as well as dynamic resetting such as <code>FLETCHING</code>,
 * <code>CRAFTING</code>, or <code>SMITHING</code> may extend this class. As an
 * alternative if one wanted, those generic skills could be split up into many
 * more specific skill actions instead.
 * 
 * @author lare96
 */
public abstract class SkillEvent {

    /**
     * The method that fires the skill event index to ensure that the skill will
     * be reset by {@link #stopSkill}. This method <b>must</b> be invoked prior
     * to starting the skill action to ensure the skill index will be fired.
     * 
     * @implNote If this method is overridden, it must invoke:
     * 
     *           <pre>
     * player.getSkillEvent()[skill().getIndex()] = true;
     * </pre>
     * 
     *           Within the code to ensure that the skill index will be fired. A
     *           call to the superclass method in this context:
     * 
     *           <pre>
     *           super.startSkill(...);
     * </pre>
     * 
     *           Will have the same effect.
     * 
     * 
     * @param player
     *            the player that the skill will be started for.
     * @see SkillAction#startSkill(Player)
     */
    public void startSkill(Player player) {
        player.getSkillEvent()[skill().getIndex()] = true;
    }

    /**
     * A dynamic method executed when the argued player performs any action that
     * stops a skill such as walking, dropping an item, equipping an item, etc.
     * 
     * @param player
     *            the player that this method will be executed for.
     */
    public abstract void stopSkill(Player player);

    /**
     * The {@link SkillData} constant that corresponds to this skill.
     * 
     * @return the skill data constant.
     */
    public abstract SkillData skill();
}
