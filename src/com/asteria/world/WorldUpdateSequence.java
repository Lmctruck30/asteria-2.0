package com.asteria.world;

import com.asteria.world.entity.Entity;

/**
 * A task that serves the purpose of updating all registered {@link Entity}s in
 * the {@link World}.
 * 
 * @author lare96
 *
 * @param <T>
 *            the type of {@link Entity} we are updating.
 */
public interface WorldUpdateSequence<T extends Entity> {

    /**
     * The first stage of the update sequence that executes processing code and
     * prepares the entity for updating.
     * 
     * @param t
     *            the entity that is being prepared for updating.
     */
    public void executePreUpdate(T t);

    /**
     * The main stage of the update sequence that performs parallelized updating
     * on the entity.
     * 
     * @param t
     *            the entity that is being updated.
     */
    public void executeUpdate(T t);

    /**
     * The last stage of the update sequence that resets the entity and prepares
     * it for the next cycle.
     * 
     * @param t
     *            the entity that is being reset for the next cycle.
     */
    public void executePostUpdate(T t);
}
