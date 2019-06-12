/**
 *
 * @author SessonaD
 */
package me.dsnet.quickopener.actions;

import me.dsnet.quickopener.actions.popup.CustomCommandPopupAction;
import me.dsnet.quickopener.actions.popup.CustomFileSystemPopupAction;
import me.dsnet.quickopener.actions.popup.CustomTerminalPopupAction;
import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import org.openide.awt.DropDownButtonFactory;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;

@Messages("CTL_CustomCommand=Launch custom command")
public final class ToolbarPresenter implements Presenter.Toolbar {
    @Override
    public Component getToolbarPresenter() {
        final ImageIcon run16 = ImageUtilities.loadImageIcon("me/dsnet/quickopener/icons/run.png", false);
        final ImageIcon run24 = ImageUtilities.loadImageIcon("me/dsnet/quickopener/icons/run24.png", false);
        final ImageIcon folder = new ImageIcon(ImageUtilities.mergeImages(ImageUtilities.loadImage("me/dsnet/quickopener/icons/folder.png", false), ImageUtilities.loadImage("me/dsnet/quickopener/icons/run.png", false), 7, 7));
        final ImageIcon terminal = new ImageIcon(ImageUtilities.mergeImages(ImageUtilities.loadImage("me/dsnet/quickopener/icons/terminal.png", false), ImageUtilities.loadImage("me/dsnet/quickopener/icons/run.png", false), 7, 7));

        CustomCommandPopupAction cAction = new CustomCommandPopupAction("Launch custom command...", run16);
        CustomTerminalPopupAction tAction = new CustomTerminalPopupAction("Open shell in...", terminal);
        CustomFileSystemPopupAction fAction = new CustomFileSystemPopupAction("Open filesystem in...", folder);

        //popup
        JPopupMenu popup = new JPopupMenu();
        popup.add(cAction);
        popup.addSeparator();
        popup.add(tAction);
        popup.add(fAction);

        //button
        final JButton dropDownButton = DropDownButtonFactory.createDropDownButton(run16, popup);
        dropDownButton.addActionListener(cAction);
        dropDownButton.addPropertyChangeListener("PreferredIconSize", new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                boolean useSmallIcon = true;
                final Object prop = evt.getNewValue();

                if (prop instanceof Integer) {
                    if (((Integer) prop) == 24) {
                        useSmallIcon = false;
                    }
                }
                if (useSmallIcon) {
                    dropDownButton.setIcon(run16);
                } else {
                    dropDownButton.setIcon(run24);
                }
            }
        });
        return dropDownButton;
    }
}