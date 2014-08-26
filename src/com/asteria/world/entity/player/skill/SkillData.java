package com.asteria.world.entity.player.skill;

/**
 * Holds constant data for {@link Skill}s.
 * 
 * @author lare96
 */
public enum SkillData {

    ATTACK(6248, 6249, 6247),
    DEFENCE(6254, 6255, 6253),
    STRENGTH(6207, 6208, 6206),
    HITPOINTS(6217, 6218, 6216),
    RANGED(5453, 6114, 4443),
    PRAYER(6243, 6244, 6242, 0),
    MAGIC(6212, 6213, 6211),
    COOKING(6227, 6228, 6226, 1),
    WOODCUTTING(4273, 4274, 4272, 2),
    FLETCHING(6232, 6233, 6231, 3),
    FISHING(6259, 6260, 6258, 4),
    FIREMAKING(4283, 4284, 4282, 5),
    CRAFTING(6264, 6265, 6263, 6),
    SMITHING(6222, 6223, 6221, 7),
    MINING(4417, 4438, 4416, 8),
    HERBLORE(6238, 6239, 6237, 9),
    AGILITY(4278, 4279, 4277, 10),
    THIEVING(4263, 4264, 4261, 11),
    SLAYER(12123, 12124, 12122, 12),
    FARMING(4889, 4890, 4887, 13),
    RUNECRAFTING(4268, 4269, 4267, 14);

    /** The lines that level up text will be printed on. */
    private int firstLine, secondLine;

    /** The chatbox interface displayed on level up. */
    private int chatbox;

    /** The index in the skill event array. */
    private int index;

    /**
     * Create a new {@link SkillData}.
     * 
     * @param firstLine
     *            the first line that level up text will be printed on.
     * @param secondLine
     *            the second line that level up text will be printed on.
     * @param chatbox
     *            the chatbox interface displayed on level up.
     * @param index
     *            the index in the skill event array.
     */
    private SkillData(int firstLine, int secondLine, int chatbox, int index) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.chatbox = chatbox;
        this.index = index;
    }

    /**
     * Create a new {@link SkillData} with the default skill event index.
     * 
     * @param firstLine
     *            the first line that level up text will be printed on.
     * @param secondLine
     *            the second line that level up text will be printed on.
     * @param chatbox
     *            the chatbox interface displayed on level up.
     */
    private SkillData(int firstLine, int secondLine, int chatbox) {
        this(firstLine, secondLine, chatbox, -1);
    }

    /**
     * Gets the first line that level up text will be printed on.
     * 
     * @return the first line that level up text will be printed on.
     */
    public int getFirstLine() {
        return firstLine;
    }

    /**
     * Gets the second line that level up text will be printed on.
     * 
     * @return the second line that level up text will be printed on.
     */
    public int getSecondLine() {
        return secondLine;
    }

    /**
     * Gets the chatbox interface displayed on level up.
     * 
     * @return the chatbox interface displayed on level up.
     */
    public int getChatbox() {
        return chatbox;
    }

    /**
     * Gets the index in the skill event array.
     * 
     * @return the index in the skill event array.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Gets a skill data constant instance by its position in the enum.
     * 
     * @param position
     *            the position of the constant to grab.
     * @return the constant on the argued position.
     */
    public static SkillData getSkill(int position) {
        return values()[position];
    }
}