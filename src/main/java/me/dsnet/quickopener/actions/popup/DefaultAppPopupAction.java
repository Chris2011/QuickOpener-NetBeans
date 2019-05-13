/*
 * Copyright (C) 2018 Diego Zambelli Sessona (diego.sessona@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package me.dsnet.quickopener.actions.popup;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.dsnet.quickopener.PathFinder;
import me.dsnet.quickopener.actions.AbstractFileContextAwareAction;
import org.netbeans.api.annotations.common.StaticResource;
import org.openide.awt.ActionID;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.NotificationDisplayer;
import org.openide.filesystems.FileObject;
import org.openide.loaders.DataObject;
import org.openide.loaders.DataShadow;
import org.openide.nodes.Node;
import org.openide.windows.Mode;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
    category = "File",
    id = "me.dsnet.quickopener.actions.popup.DefaultAppPopupAction"
)
@ActionRegistration(
    displayName = "#CTL_OpenInDefaultAppAction", lazy = false
)
@ActionReferences({
    @ActionReference(path = "Menu/File", position = 955),
    @ActionReference(path = "Loaders/Languages/Actions", position = 1000),
    @ActionReference(path = "Shortcuts", name = "O-4")
})
@Messages("CTL_OpenInDefaultAppAction=Open in Default App")
public class DefaultAppPopupAction extends AbstractFileContextAwareAction implements ActionListener {
    private static final Logger LOG = Logger.getLogger(DefaultAppPopupAction.class.getName());

    @StaticResource
    private static final String ICON = "me/dsnet/quickopener/icons/default16.png";

    @Override
    public void actionPerformed(ActionEvent ev) {
        openInDefaultApp();
    }

    @Override
    public String getName() {
        return Bundle.CTL_OpenInDefaultAppAction();
    }

    @Override
    protected boolean enable(Node[] activatedNodes) {
        File file = null;

        if (null != activatedNodes && activatedNodes.length == 1) {
            file = PathFinder.getActiveFile(activatedNodes[0].getLookup().lookup(DataObject.class), false);
        }

        return null != file && file.isFile();
    }

    @Override
    protected String iconResource() {
        return ICON;
    }

    @Override
    protected void performAction(Node[] activatedNodes) {
        openInDefaultApp();
    }

    private boolean openInDefaultApp() {
        final Mode editorMode = WindowManager.getDefault().findMode("editor");

        if (editorMode == null) {
            return true;
        }

        TopComponent activeTC = TopComponent.getRegistry().getActivated();
        DataObject dataObject = null;

        if (activeTC != null) {
            dataObject = activeTC.getLookup().lookup(DataObject.class);

            if (dataObject instanceof DataShadow) {
                dataObject = ((DataShadow) dataObject).getOriginal();
            }
        }

        try {
            if (dataObject != null) {
                final FileObject primaryFile = dataObject.getPrimaryFile();

                if (primaryFile != null) {
                    final String fileName = primaryFile.getPath();

                    if (!dataObject.getPrimaryFile().isFolder() && fileName != null) {
                        Desktop.getDesktop().open(new File(fileName));
                    }
                }
            }
        } catch (IOException ex) {
            LOG.log(Level.WARNING, ex.getMessage());
            
            NotificationDisplayer.getDefault().notify("Error while opening in default app.", NotificationDisplayer.Priority.HIGH.getIcon(), ex.getLocalizedMessage(), null);
        }

        return false;
    }
}
