/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dsnet.quickopener.actions.popup;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;
import javax.swing.table.AbstractTableModel;
import me.dsnet.quickopener.prefs.PrefsUtil;
import me.dsnet.quickopener.prefs.QuickOpenerProperty;

/**
 *
 * @author SessonaD
 */
public class PropertyTableModel extends AbstractTableModel {

    private String[] columnNames = {"Name", "Path"};
    private final String prefix;
    private final List<QuickOpenerProperty> data = new ArrayList<>();

    public PropertyTableModel(String prefix) {
        this.prefix = prefix;
        setColumnNames();
        reload();
    }

    private void setColumnNames() {
        if (prefix.equals("command")) {
            columnNames = new String[]{"Name", "Command"};
        } else {
            columnNames = new String[]{"Name", "Path"};
        }
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public Object getValueAt(int row, int col) {
        QuickOpenerProperty property = data.get(row);
        switch (col) {
            case 0:
                return property.getDescription();
            case 1:
                return property.getValue();
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public Class getColumnClass(int c) {
        return String.class;
    }

    public void reload() {
        data.clear();
        try {
            data.addAll(PrefsUtil.getAllMatching(prefix));
        } catch (BackingStoreException ex) {
            //Exceptions.printStackTrace(ex);
        }
        fireTableDataChanged();
    }

    public QuickOpenerProperty getProperty(int row) {
        return data.get(row);
    }

}
