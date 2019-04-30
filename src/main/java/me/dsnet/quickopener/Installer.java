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
package me.dsnet.quickopener;

import java.io.IOException;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.modules.ModuleInstall;
import org.openide.util.Exceptions;
import org.openide.windows.WindowManager;

public class Installer extends ModuleInstall {
    protected static final String DEFAULT_APP_POPUP_ACTION_STRING = "me-dsnet-quickopener-actions-popup-DefaultAppPopupAction.shadow";
    protected static final String DEFAULT_EDITOR_POPUP_ACTION_ORIG = "Actions/File/me-dsnet-quickopener-actions-popup-DefaultAppPopupAction.instance";

    @Override
    public void restored() {
        WindowManager.getDefault().invokeWhenUIReady(new ActionInstaller());
    }

    @Override
    public void uninstalled() {
        WindowManager.getDefault().invokeWhenUIReady(new ActionUninstaller());
    }

    private static abstract class FileTypeHandler implements Runnable {
        @Override
        public void run() {
            final FileObject loaders = FileUtil.getConfigFile("Loaders");
            final FileObject[] categories = loaders.getChildren();

            for (FileObject category : categories) {
                final FileObject[] fileTypes = category.getChildren();

                for (FileObject fileType : fileTypes) {
                    handleFileType(fileType);
                }
            }
        }

        protected abstract void handleFileType(FileObject fileType);
    }

    private static final class ActionInstaller extends FileTypeHandler {
        @Override
        protected void handleFileType(FileObject fileType) {
            // TODO: Only files, no folders. But all filestypes are also folders (isFolder() -> returning true)
//            if (fileType.isFolder()) {
                try {
                    final FileObject actionsFolder = FileUtil.createFolder(fileType, "Actions");
                    int actionPosition = 9999;
                    final FileObject openInDefaultAppAction = actionsFolder.getFileObject(DEFAULT_APP_POPUP_ACTION_STRING);

                    if (openInDefaultAppAction == null) {
                        final FileObject action = actionsFolder.createData(DEFAULT_APP_POPUP_ACTION_STRING);

                        action.setAttribute("originalFile", DEFAULT_EDITOR_POPUP_ACTION_ORIG);
                        action.setAttribute("position", actionPosition);
                    }
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
//            }
        }
    }

    private static final class ActionUninstaller extends FileTypeHandler {
        @Override
        protected void handleFileType(FileObject fileType) {
//            if (!fileType.isFolder()) {
                try {
                    final FileObject actionsFolder = FileUtil.createFolder(fileType, "Actions");
                    final FileObject openInDefaultAppAction = actionsFolder.getFileObject(DEFAULT_APP_POPUP_ACTION_STRING);

                    if (openInDefaultAppAction != null) {
                        openInDefaultAppAction.delete();
                    }
                } catch (IOException ex) {
                    Exceptions.printStackTrace(ex);
                }
//            }
        }
    }
}
