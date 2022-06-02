package utils;

public enum CONSTANTS {
    OVERSEAS("Overseas"),
    CALIFORNIA("California"),
    CHINESE("Chinese"),
    NON_CALIFORNIA("NonCalifornia"),
    BLANK(""),
    RESULT_MSG_DEFAULT("Click Create or GetTotal Button");

    private final String text;

    CONSTANTS(final String text) {
        this.text = text;
    }
    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
