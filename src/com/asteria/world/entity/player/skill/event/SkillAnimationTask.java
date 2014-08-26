package com.asteria.world.entity.player.skill.event;

import com.asteria.engine.task.Task;
import com.asteria.engine.task.TaskManager;
import com.asteria.world.entity.Animation;
import com.asteria.world.entity.player.Player;

/**
 * An interface that provides functionality for skills that have animations that
 * run separately from the main chunk of code. Skills like <code>FISHING</code>
 * and <code>MINING</code> need to implement this class. <b>Note that you will
 * still have to make your skill class extend {@link SkillEvent} or one of its
 * subclasses!</b>.
 * 
 * @author lare96
 */
public interface SkillAnimationTask {

    /**
     * The animation that will be executed by the task every
     * {@link #animationDelay}.
     * 
     * @param player
     *            the player performing the animation.
     * @return the animation that will be performed.
     */
    public Animation animation(Player player);

    /**
     * The delay interval that the {@link #animation} will be performed in.
     * 
     * @return the delay that the animation will be performed in.
     */
    public int animationDelay();

    /**
     * Submits a {@link Task} that will execute the {@link #animation} for the
     * argued player every {@link #animationDelay}.
     * 
     * @param event
     *            the skill event being used to reset the player once the skill
     *            has stopped.
     * @param player
     *            the player that this task is being ran for.
     */
    default void start(SkillEvent event, Player player) {

        // Submit a task that will perform the animation for the player in the
        // request interval.
        TaskManager.submit(new Task(animationDelay(), true) {
            @Override
            public void execute() {
                if (!player.getSkillEvent()[event.skill().getIndex()]) {
                    this.cancel();
                    return;
                }

                player.animation(animation(player));
            }

            @Override
            public void onCancel() {
                event.stopSkill(player);
            }
        }.bind(player));
    }
}
