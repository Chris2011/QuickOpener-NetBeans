/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dsnet.quickopener.prefs;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import org.openide.util.NbPreferences;

/**
 *
 * @author SessonaD
 */
public class PrefsUtil {
    private static final Preferences prefs = NbPreferences.forModule(QuickOpenerPanel.class);
    
    public static void store(String key, String val){
        prefs.put(key,val); 
    }

    public static void store(QuickOpenerProperty property) throws BackingStoreException {
        String key = key(property);
        prefs.put(key, property.getValue());
        property.storeDetails(prefs.node(key));
    }
    
    public static void remove(QuickOpenerProperty property) throws BackingStoreException {
        remove(key(property));
    }

    public static void remove(String key) throws BackingStoreException {
        prefs.remove(key);
        if (prefs.nodeExists(key)) {
            prefs.node(key).removeNode();
        }
    }
    
    public static void removeAll(String prefix) throws BackingStoreException {
        for(String key : prefs.keys()){
            if(key.startsWith(prefix)){
                remove(key);
            }
        }
    }
    
    public static QuickOpenerProperty load(String prefix, String description, String defaultVal) throws BackingStoreException {
        if (prefix == null) {
            prefix = "";
        }
        String key = key(prefix, description);
        String value = prefs.get(key, defaultVal);

        QuickOpenerProperty property;
        switch (prefix) {
            case "command":
                property = new QuickOpenerCommand(description, value);
                break;
            default:
                property = new QuickOpenerProperty(description, value);
                break;
        }

        if (prefs.nodeExists(key)) {
            property.loadDetails(prefs.node(key));
        }

        return property;
    }

    public static List<QuickOpenerProperty> getAllMatching(String prefix) throws BackingStoreException{
        List<QuickOpenerProperty> list = new ArrayList<> ();
        for(String key : prefs.keys()){
            if(key.startsWith(prefix)){
                String description = unescape(key.substring(prefix.length()));
                list.add(load(prefix, description, ""));
            }
        }
        return list;
    }

    private static String escape(String s) {
        return s.replaceAll(" ", "_");
    }

    private static String unescape(String s) {
        return s.replaceAll("_", " ");
    }

    private static String key(QuickOpenerProperty property) {
        return key(property.getPrefix(), property.getDescription());
    }

    private static String key(String prefix, String description) {
        return (prefix != null ? prefix : "") + escape(description);
    }
}
