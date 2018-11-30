package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.CubeSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoToSwitch extends Command {
	CubeSystem cubeSystem;
    public AutoToSwitch() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	cubeSystem = Robot.cubeSystem;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (!cubeSystem.getSwitchSensor()) {
    		cubeSystem.setSpeedElevators(SmartDashboard.getNumber("Elevator Speed", 0));
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return cubeSystem.getSwitchSensor();
    }

    // Called once after isFinished returns true
    protected void end() {
    	cubeSystem.stopElevators();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	cubeSystem.stopElevators();
    }
}
