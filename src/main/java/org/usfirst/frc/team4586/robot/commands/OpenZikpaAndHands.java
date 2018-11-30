package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.CubeSystem;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OpenZikpaAndHands extends Command {

	CubeSystem cubeSystem;
	boolean isEnd;
	boolean isToOpen;
    public OpenZikpaAndHands() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	cubeSystem = Robot.cubeSystem;
    	isEnd = false;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isEnd = false;
    	isToOpen = cubeSystem.isOpenedPusher();
    	if(isToOpen){
    		cubeSystem.setPistonL(true);
    	}
    	else {
    		cubeSystem.setPistonR(false);
    		cubeSystem.setPistonL(false);
    	}
    	setTimeout(0.15);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (isTimedOut())
    	{
    		if(isToOpen){
    			cubeSystem.setPistonR(true);
    			cubeSystem.setCubePusher(false);
    		}
    		else{
    			cubeSystem.setCubePusher(true);
        	}
    		isEnd = true;
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isEnd;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
