package com.asteria.engine.task.listener;

import com.asteria.engine.task.Task;

/**
 * A listener that will repeatedly execute code until some sort of event occurs.
 * 
 * @author lare96
 */
public abstract class OnFireEventListener extends Task {

    /**
     * Create a new {@link OnFireEventListener}.
     * 
     * @param rate
     *            the rate in which the code will be fired.
     */
    public OnFireEventListener(int rate) {
        super(rate, true);
    }

    /**
     * Create a new {@link OnFireEventListener} that will execute code in
     * <tt>600</tt>ms intervals.
     */
    public OnFireEventListener() {
        this(1);
    }

    /**
     * Will repeatedly execute the code within {@link #run} until this boolean
     * is flagged.
     * 
     * @return <code>true</code> if this listener should stop executing code,
     *         <code>false</code> if this listener should keep executing code.
     */
    public abstract boolean listenFor();

    /** The code that will be executed until {@link #listenFor} is flagged. */
    public abstract void run();

    @Override
    public void execute() {

        // Check if the condition has been flagged.
        if (listenFor()) {

            // It has, so we cancel this listener.
            this.cancel();
            return;
        }

        // Otherwise we run the logic.
        this.run();
    }
}
