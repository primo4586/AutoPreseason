package org.usfirst.frc.team4586.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoSideSwitchRight extends CommandGroup {

    public AutoSideSwitchRight() {
    	String gameData = DriverStation.getInstance().getGameSpecificMessage();
		while (gameData.isEmpty()) {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
		}
		addSequential(new AutoStart());
		if (gameData.charAt(0) == 'R')
		{
			addSequential(new AutoDrive(290));
			addSequential(new AutoTurn(-90*SmartDashboard.getNumber("Auto Direction", 1)));
			addSequential(new AutoDrive(90));
			addSequential(new CatchCube());
		}
		else
		{
			addSequential(new AutoDrive(500));
		}
    }
}
