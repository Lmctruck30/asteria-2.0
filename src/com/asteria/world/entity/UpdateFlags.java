package com.asteria.world.entity;

import java.util.BitSet;

/**
 * Manages update flags for all in-game entities.
 * 
 * @author lare96
 */
public class UpdateFlags {

    /** A bit set holding the values for the update flags. */
    private BitSet bits = new BitSet(Flag.size());

    /**
     * An enumeration representing all of the update flags.
     * 
     * @author lare96
     */
    public enum Flag {
        APPEARANCE(0),
        CHAT(1),
        GRAPHICS(2),
        ANIMATION(3),
        FORCED_CHAT(4),
        FACE_ENTITY(5),
        FACE_COORDINATE(6),
        HIT(7),
        HIT_2(8),
        TRANSFORM(9);

        /** The index of this update flag in the bit set. */
        private int id;

        /**
         * Create a new {@link Flag}.
         * 
         * @param id
         *            the index of this update flag in the bit set.
         */
        private Flag(int id) {
            this.id = id;
        }

        /**
         * Gets the index of this update flag in the bit set.
         * 
         * @return the index of this update flag in the bit set.
         */
        public int getId() {
            return id;
        }

        /**
         * Gets the amount of constants in this enumeration.
         * 
         * @return the amount of constants in this enumeration.
         */
        public static int size() {
            return Flag.values().length;
        }
    }

    /**
     * Flags the argued update flag. This method will do nothing if the argued
     * flag already has a value of <code>true</code>.
     * 
     * @param flag
     *            the update flag that will be flagged.
     */
    public void flag(Flag flag) {
        bits.set(flag.getId());
    }

    /**
     * Flips the value of the argued update flag.
     * 
     * @param flag
     *            the update flag that will be flipped.
     */
    public void flip(Flag flag) {
        bits.flip(flag.getId());
    }

    /**
     * Gets the value of an update flag.
     * 
     * @param flag
     *            the update flag to get the value of.
     * @return the value of the flag.
     */
    public boolean get(Flag flag) {
        return bits.get(flag.getId());
    }

    /**
     * Determines if an update is required. This is done by checking if the
     * backing {@link #bits} is not empty.
     * 
     * @return true if an update is required, meaning the backing bit set is not
     *         empty.
     */
    public boolean isUpdateRequired() {
        return !bits.isEmpty();
    }

    /**
     * Resets the update flags, essentially reverting all flags back to a state
     * of <code>false</code>.
     */
    public void reset() {
        bits.clear();
    }
}
