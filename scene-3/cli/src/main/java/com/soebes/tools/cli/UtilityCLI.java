package com.soebes.tools.cli;

import java.util.Date;

import org.apache.log4j.Logger;

import com.soebes.tools.core.CalculateDelta;

public class UtilityCLI {
    private static Logger LOGGER = Logger.getLogger(UtilityCLI.class);

    
    public static void main(String[] args) {
        new UtilityCLI(args);
    }

    public UtilityCLI(String[] args) {
        UtilityCommands commands = new UtilityCommands(args);
        if (commands.getMainCommand().isHelp()) {
            commands.getCommander().usage();
            System.exit(0);
        }

        if (commands.isDiffCommand()) {
            runDiff(commands.getDiffCommand());
        }
    }

    public void runDiff(DiffCommand diffCommand) {
        LOGGER.info("Diff command has been called.");
        Date fromDate = diffCommand.getDateFrom();
        Date toDate = diffCommand.getDateTo();

        if (toDate != null) {
            CalculateDelta calc = new CalculateDelta();
            long diff = calc.deltaInMilliSeconds(fromDate, toDate);
            System.out.println("Delta: " + diff + " milli seconds.");
        }

    }
}
