package com.asteria.world.entity.player.minigame;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.asteria.world.entity.player.Player;

/**
 * A static utility class that holds methods for managing {@link Minigame}s.
 * 
 * @author lare96
 */
public final class Minigames {

    /** A map containing all of the minigames. */
    private static Set<Minigame> minigames = new HashSet<>();

    /** Loads all of the minigames into a set. */
    public static void loadMinigames() {
        // minigames.add(new PestControl());
    }

    /**
     * Returns an {@link Optional} representing the minigame the argued player
     * is in.
     * 
     * @param player
     *            the player to get the optional for.
     * @return the optional representing the minigame.
     */
    public static Optional<Minigame> get(Player player) {
        return minigames.stream().filter(m -> m.inMinigame(player)).findFirst();
    }

    /**
     * Determines if the argued player is in a minigame.
     * 
     * @param player
     *            the player to determine for.
     * @return <code>true</code> if the player is in a minigame,
     *         <code>false</code> otherwise.
     */
    public static boolean inMinigame(Player player) {
        return get(player).isPresent();
    }

    private Minigames() {}
}
