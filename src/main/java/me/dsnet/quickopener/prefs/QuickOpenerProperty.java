/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dsnet.quickopener.prefs;

import java.util.prefs.Preferences;

/**
 *
 * @author SessonaD
 */
public class QuickOpenerProperty {
    private String prefix = "";
    private String description = "";
    private String value = "";

    public QuickOpenerProperty(String description, String value) {
        this(description, value, "");
    }

    public QuickOpenerProperty(String description, String value, String prefix) {
        this.description = description;
        this.value = value;
        this.prefix = prefix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * To be overridden by subclasses
     */
    void storeDetails(Preferences prefs) {
    }

    /**
     * To be overridden by subclasses
     */
    void loadDetails(Preferences prefs) {
    }
}
