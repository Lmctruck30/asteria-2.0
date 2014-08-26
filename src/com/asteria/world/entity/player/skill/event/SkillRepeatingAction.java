package com.asteria.world.entity.player.skill.event;

import java.util.Optional;

import com.asteria.engine.task.Task;
import com.asteria.engine.task.TaskManager;
import com.asteria.world.entity.player.Player;

/**
 * An implementation of {@link SkillAction} that provides extremely specific
 * functionality for skills that have repeated actions in strict time intervals.
 * An example of skills that should extend this class are <code>FISHING</code>,
 * <code>COOKING</code>, <code>WOODCUTTING</code>, and <code>MINING</code>.
 * 
 * @author lare96
 */
public abstract class SkillRepeatingAction extends SkillAction {

    @Override
    public void execute(Player player) {

        // Construct and submit the main action task.
        TaskManager.submit(new Task(actionInterval(player),
            initialExecute(player)) {
            @Override
            public void execute() {
                if (!player.getSkillEvent()[skill().getIndex()]) {
                    this.cancel();
                    return;
                }
                executeAction(player, this);
            }

            @Override
            public void onCancel() {
                stopSkill(player);
            }
        }.bind(player));

        // Construct and submit the animation task, if we have one.
        animationTask().ifPresent(t -> t.start(this, player));
    }

    /**
     * The code for the action that will be executed in {@link #actionInterval}
     * intervals. Note that checks to the skill event array <b>do not</b> need
     * to be made as they are already done in the underlying {@link #execute}
     * implementation.
     * 
     * @param player
     *            the player that this action is being executed for.
     * @param task
     *            the instance of the task being used to execute the action in
     *            strict intervals.
     */
    public abstract void executeAction(Player player, Task task);

    /**
     * The amount of time it takes <b>in ticks</b> for the action to start again
     * after it has just completed. To find out exactly out how long the action
     * interval is, take whatever value is returned by this method and multiply
     * it by <tt>600</tt>.
     * 
     * @param player
     *            the player this action is being executed for.
     * @return the amount of ticks this action must wait after being executed.
     */
    public abstract int actionInterval(Player player);

    /**
     * Determines if this action should be executed before being delayed, or
     * delayed than executed upon registration.
     * 
     * @param player
     *            the player this task is being registered for.
     * @return <code>true</code> if the action should be executed first,
     *         <code>false</code> if the action should be delayed first.
     */
    public abstract boolean initialExecute(Player player);

    /**
     * The animation task that will perform the animation for the {@link Player}
     * executing the skill.
     * 
     * @return the animation task instance wrapped in an optional container for
     *         convenience.
     */
    public abstract Optional<SkillAnimationTask> animationTask();
}
