package org.usfirst.frc.team4586.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoStart extends CommandGroup {

    public AutoStart() {
    	//addSequential(new CalibrateGyro());
    	addSequential(new AutoToSwitch()); // Lifts to switch at begin
		addSequential(new CatchCube()); // Opens the claws
		addParallel(new AutoDrive(60));
		addSequential(new Wait(0.1));
		addSequential(new LiftToFloor());
		//addSequential(new AutoDrive(40));
		addSequential(new CatchCube());
		addSequential(new Wait(0.05));
		addSequential(new LiftToSwitch()); // Lifts down the ele
    }
}
