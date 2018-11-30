package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Climber;
import org.usfirst.frc.team4586.robot.subsystems.CubeSystem;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimbRight extends Command {
	private Climber climber;
	private CubeSystem cubeSystem;
    public ClimbRight() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	climber = Robot.climber;
    	cubeSystem = Robot.cubeSystem;
    }

    // Called just before this Command runs the first time
    protected void initialize() { 
    	SmartDashboard.putBoolean("Climbing Motor", true);
    	//    	cubeSystem.setCanUseElevator(false);
    	cubeSystem.setSpeedElevators(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	climber.setSpeedClimbR(1);
    	climber.setSpeedClimbL(1);
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	climber.setSpeedClimbR(0);
    	climber.setSpeedClimbL(0);
    	SmartDashboard.putBoolean("Climbing Motor", false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	climber.setSpeedClimbR(0);
    	climber.setSpeedClimbL(0);
    	SmartDashboard.putBoolean("Climbing Motor", false);
    }
}

