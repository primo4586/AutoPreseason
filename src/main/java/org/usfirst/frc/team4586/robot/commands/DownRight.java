package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Climber;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DownRight extends Command {
	private Climber climber;
	
    public DownRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	climber = Robot.climber;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	climber.setSpeedClimbR(-SmartDashboard.getNumber("Speed climb right", 1));
    	climber.setSpeedClimbL(-SmartDashboard.getNumber("Speed climb right", 1));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	climber.setSpeedClimbR(0);
    	climber.setSpeedClimbL(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	climber.setSpeedClimbR(0);
    	climber.setSpeedClimbL(0);
    }
}
