/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dsnet.quickopener.prefs;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.BackingStoreException;
import javax.swing.*;
import me.dsnet.quickopener.QuickMessages;
import me.dsnet.quickopener.prefs.filemanager.IFileManagerConfigurator;
import me.dsnet.quickopener.prefs.filemanager.impl.CajaFileManagerConfigurator;
import me.dsnet.quickopener.prefs.filemanager.impl.SpaceFileManagerConfigurator;
import me.dsnet.quickopener.prefs.shell.chooser.IShellConfigurator;
import me.dsnet.quickopener.prefs.shell.chooser.impl.GitBashConfigurator;
import me.dsnet.quickopener.prefs.shell.chooser.impl.MateTerminalConfigurator;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.NotifyDescriptor;
import org.openide.util.NbBundle;

/**
 *
 * @author SessonaD
 */
public class GeneralPanel extends javax.swing.JPanel {

    /**
     * Creates new form GeneralPanel
     */
    public GeneralPanel() {
        initComponents();
        try {
            QuickOpenerProperty customSeparator=PrefsUtil.load(null,"generalseparator",getOSSeparator());
            jLabel2.setText(customSeparator.getValue());
            QuickOpenerProperty customShell=PrefsUtil.load(null,"customShell",null);
            cShellLabel.setText((customShell.getValue()==null)?"not defined":customShell.getValue());
            QuickOpenerProperty customFileManager=PrefsUtil.load(null,"customFileManager",null);
            cFileManagerLabel.setText(customFileManager.getValue()==null ? "not defined" : customFileManager.getValue());
            QuickOpenerProperty confirmation=PrefsUtil.load(null,"confirmationDialogue","true");
            boolean isConfirmSelected = Boolean.parseBoolean(confirmation.getValue());
            confirmationCheckBox.setSelected(isConfirmSelected);
        } catch (BackingStoreException ex) {
        }

        shellConfigureButton.setEnabled(!getAvailableConfigurators().isEmpty());
        fileManagerConfigureButton.setEnabled(!getAvailableFileManagerConfigurators().isEmpty());
    }

    private String getOSSeparator(){
        return System.getProperty("file.separator");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        applyButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cShellLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        applyCShellButton = new javax.swing.JButton();
        cshellTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        confirmationCheckBox = new javax.swing.JCheckBox();
        applyConfirmationButton = new javax.swing.JButton();
        shellConfigureButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        applyCFileManagerButton = new javax.swing.JButton();
        fileManagerConfigureButton = new javax.swing.JButton();
        cFileManagerTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cFileManagerLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.jLabel3.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.jLabel4.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.jLabel2.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(applyButton, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.applyButton.text")); // NOI18N
        applyButton.setFocusable(false);
        applyButton.setRequestFocusEnabled(false);
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        jTextField1.setText(org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.jTextField1.text")); // NOI18N

        jLabel5.setLabelFor(jTextField1);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel5, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.jLabel5.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel6, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.jLabel6.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cShellLabel, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.cShellLabel.text")); // NOI18N

        jLabel8.setLabelFor(cshellTextField);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel8, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.jLabel8.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(applyCShellButton, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.applyCShellButton.text")); // NOI18N
        applyCShellButton.setFocusable(false);
        applyCShellButton.setRequestFocusEnabled(false);
        applyCShellButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyCShellButtonActionPerformed(evt);
            }
        });

        cshellTextField.setText(org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.cshellTextField.text")); // NOI18N

        jLabel7.setLabelFor(confirmationCheckBox);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel7, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.jLabel7.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(confirmationCheckBox, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.confirmationCheckBox.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(applyConfirmationButton, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.applyConfirmationButton.text")); // NOI18N
        applyConfirmationButton.setFocusable(false);
        applyConfirmationButton.setRequestFocusEnabled(false);
        applyConfirmationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyConfirmationButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(shellConfigureButton, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.shellConfigureButton.text")); // NOI18N
        shellConfigureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shellConfigureButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(resetButton, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.resetButton.text")); // NOI18N
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(applyCFileManagerButton, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.applyCFileManagerButton.text")); // NOI18N
        applyCFileManagerButton.setFocusable(false);
        applyCFileManagerButton.setRequestFocusEnabled(false);
        applyCFileManagerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyCFileManagerButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(fileManagerConfigureButton, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.fileManagerConfigureButton.text")); // NOI18N
        fileManagerConfigureButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileManagerConfigureButtonActionPerformed(evt);
            }
        });

        cFileManagerTextField.setText(org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.cFileManagerTextField.text")); // NOI18N

        jLabel9.setLabelFor(cshellTextField);
        org.openide.awt.Mnemonics.setLocalizedText(jLabel9, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.jLabel9.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(cFileManagerLabel, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.cFileManagerLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel10, org.openide.util.NbBundle.getMessage(GeneralPanel.class, "GeneralPanel.jLabel10.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(258, 258, 258)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)
                                .addComponent(cShellLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cshellTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(shellConfigureButton)
                                .addGap(6, 6, 6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(applyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(applyCShellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(resetButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(confirmationCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(193, 193, 193)
                        .addComponent(applyConfirmationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(10, 10, 10)
                                .addComponent(cFileManagerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cFileManagerTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileManagerConfigureButton)
                        .addGap(6, 6, 6)
                        .addComponent(applyCFileManagerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(applyButton)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cShellLabel)
                    .addComponent(jLabel8)
                    .addComponent(applyCShellButton)
                    .addComponent(shellConfigureButton)
                    .addComponent(cshellTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cFileManagerLabel)
                    .addComponent(jLabel9)
                    .addComponent(applyCFileManagerButton)
                    .addComponent(fileManagerConfigureButton)
                    .addComponent(cFileManagerTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(applyConfirmationButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(confirmationCheckBox)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addComponent(resetButton))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        String customSep = jTextField1.getText();
        if(customSep!=null && !customSep.isEmpty()){
            PrefsUtil.store("generalseparator" , customSep);
            jLabel2.setText(customSep);
        }else{
            NotifyDescriptor d = new NotifyDescriptor.Message(QuickMessages.SEPARATOR_NULL,NotifyDescriptor.WARNING_MESSAGE);
            DialogDisplayer.getDefault().notify(d);
        }
    }//GEN-LAST:event_applyButtonActionPerformed

    private void applyCShellButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyCShellButtonActionPerformed
        String cshell = cshellTextField.getText();
        if(cshell!=null && !cshell.isEmpty()){
            PrefsUtil.store("customShell" , cshell);
            cShellLabel.setText(cshell);
        }else{
            NotifyDescriptor d = new NotifyDescriptor.Message(QuickMessages.CUSTOM_SHELL,NotifyDescriptor.WARNING_MESSAGE);
            DialogDisplayer.getDefault().notify(d);
        }
    }//GEN-LAST:event_applyCShellButtonActionPerformed

    private void applyConfirmationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyConfirmationButtonActionPerformed
        PrefsUtil.store("confirmationDialogue", Boolean.toString(confirmationCheckBox.isSelected()));
    }//GEN-LAST:event_applyConfirmationButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        try {
            PrefsUtil.remove("customShell");
        } catch (BackingStoreException ex) {
        }
        cShellLabel.setText("not defined");
        cshellTextField.setText("not defined");

        confirmationCheckBox.setSelected(false);
        PrefsUtil.store("confirmationDialogue", Boolean.toString(confirmationCheckBox.isSelected()));

        try {
            PrefsUtil.remove("generalseparator");
        } catch (BackingStoreException ex) {
        }
        jLabel2.setText(getOSSeparator());
        jTextField1.setText("");

    }//GEN-LAST:event_resetButtonActionPerformed

    @NbBundle.Messages(
            {"LBL_Form_Label=Choose a configurator:",
                    "LBL_Dialog=Configurator",}
    )
    private void shellConfigureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shellConfigureButtonActionPerformed
        JTextField shellTextField = cshellTextField;

        List<String> labels = new ArrayList<>();
        for (IShellConfigurator configurator : getAvailableConfigurators()) {
            if (configurator.isAvailable()) {
                labels.add(configurator.getLabel());
            }
        }

        final JList jList = new JList(labels.toArray(new String[labels.size()]));
        JPanel form = new JPanel(new BorderLayout());
        form.add(jList, BorderLayout.CENTER);
        form.add(new JLabel(Bundle.LBL_Form_Label()), BorderLayout.NORTH);
        jList.setSelectedIndex(0);
        DialogDescriptor dd = new DialogDescriptor(form, Bundle.LBL_Dialog());
        Object result = DialogDisplayer.getDefault().notify(dd);
        if (result == NotifyDescriptor.OK_OPTION) {
            IShellConfigurator configurator = getAvailableConfigurators().get(jList.getSelectedIndex());

            String configure = configurator.configure();
            if (null != configure) {
                shellTextField.setText(configure);
            }
        }
    }//GEN-LAST:event_shellConfigureButtonActionPerformed

    private void applyCFileManagerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyCFileManagerButtonActionPerformed
        String cFileManager = cFileManagerTextField.getText();
        if(cFileManager!=null && !cFileManager.isEmpty()){
            PrefsUtil.store("customFileManager" , cFileManager);
            cFileManagerLabel.setText(cFileManager);
        }else{
            NotifyDescriptor d = new NotifyDescriptor.Message(QuickMessages.CUSTOM_FILEMANAGER,NotifyDescriptor.WARNING_MESSAGE);
            DialogDisplayer.getDefault().notify(d);
        }
    }//GEN-LAST:event_applyCFileManagerButtonActionPerformed

    private void fileManagerConfigureButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileManagerConfigureButtonActionPerformed
        JTextField fileManagerTextField = cFileManagerTextField;

        List<String> labels = new ArrayList<>();
        for (IFileManagerConfigurator configurator : getAvailableFileManagerConfigurators()) {
            if (configurator.isAvailable()) {
                labels.add(configurator.getLabel());
            }
        }

        final JList<String> jList = new JList(labels.toArray(new String[labels.size()]));
        JPanel form = new JPanel(new BorderLayout());
        form.add(jList, BorderLayout.CENTER);
        form.add(new JLabel(Bundle.LBL_Form_Label()), BorderLayout.NORTH);
        jList.setSelectedIndex(0);
        DialogDescriptor dd = new DialogDescriptor(form, Bundle.LBL_Dialog());
        Object result = DialogDisplayer.getDefault().notify(dd);
        if (result == NotifyDescriptor.OK_OPTION) {
            IFileManagerConfigurator configurator = getAvailableFileManagerConfigurators().get(jList.getSelectedIndex());

            String configure = configurator.configure();
            if (null != configure) {
                fileManagerTextField.setText(configure);
            }
        }
    }//GEN-LAST:event_fileManagerConfigureButtonActionPerformed

    private List<IShellConfigurator> getAvailableConfigurators() {
        //TODO externalize the configuration of available configurators
        List<IShellConfigurator> allconfigurators = Arrays.asList(new GitBashConfigurator(), new MateTerminalConfigurator());
        List<IShellConfigurator> availableConfigurators = new ArrayList<>();
        for (IShellConfigurator configurator : allconfigurators) {
            if (configurator.isAvailable()) {
                availableConfigurators.add(configurator);
            }
        }
        return availableConfigurators;
    }

    private List<IFileManagerConfigurator> getAvailableFileManagerConfigurators() {
        //TODO externalize the configuration of available configurators
        List<IFileManagerConfigurator> allconfigurators = Arrays.asList(new CajaFileManagerConfigurator(), new SpaceFileManagerConfigurator());
        List<IFileManagerConfigurator> availableConfigurators = new ArrayList<>();
        for (IFileManagerConfigurator configurator : allconfigurators) {
            if (configurator.isAvailable()) {
                availableConfigurators.add(configurator);
            }
        }
        return availableConfigurators;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JButton applyCFileManagerButton;
    private javax.swing.JButton applyCShellButton;
    private javax.swing.JButton applyConfirmationButton;
    private javax.swing.JLabel cFileManagerLabel;
    private javax.swing.JTextField cFileManagerTextField;
    private javax.swing.JLabel cShellLabel;
    private javax.swing.JCheckBox confirmationCheckBox;
    private javax.swing.JTextField cshellTextField;
    private javax.swing.JButton fileManagerConfigureButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton shellConfigureButton;
    // End of variables declaration//GEN-END:variables
}
