package com.sessonad.oscommands.commands;

import com.sessonad.oscommands.detector.OperatingSystem;

/**
 *
 * @author mherrn
 */
public class LinuxEnlightenmentCommands extends Commands {

    @Override
    public OperatingSystem getOperatingSystem() {
        return OperatingSystem.LINUX_ENLIGHTENMENT;
    }
}
