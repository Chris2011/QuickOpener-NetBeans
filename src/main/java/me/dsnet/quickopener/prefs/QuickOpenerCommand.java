package me.dsnet.quickopener.prefs;

import java.util.prefs.Preferences;

/**
 *
 * @author Ben Miller
 */
public class QuickOpenerCommand extends QuickOpenerProperty {
    private boolean skipConfirmation = false;

    public QuickOpenerCommand(String description, String value) {
        super(description, value, "command");
    }

    public boolean isSkipConfirmation() {
        return skipConfirmation;
    }

    public void setSkipConfirmation(boolean skipConfirmation) {
        this.skipConfirmation = skipConfirmation;
    }

    @Override
    void storeDetails(Preferences prefs) {
        prefs.putBoolean("skipConfirmation", skipConfirmation);
    }

    @Override
    void loadDetails(Preferences prefs) {
        skipConfirmation = prefs.getBoolean("skipConfirmation", false);
    }
}
