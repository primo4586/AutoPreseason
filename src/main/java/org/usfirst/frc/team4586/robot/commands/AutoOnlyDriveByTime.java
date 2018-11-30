package org.usfirst.frc.team4586.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoOnlyDriveByTime extends CommandGroup {

	public AutoOnlyDriveByTime() {
		addSequential(new AutoDriveTime(SmartDashboard.getNumber("Auto Time Straight", 0)));
	}
}
