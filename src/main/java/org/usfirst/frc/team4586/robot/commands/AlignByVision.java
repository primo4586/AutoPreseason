package org.usfirst.frc.team4586.robot.commands;

import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AlignByVision extends Command {

	private Driver driver;
	private NetworkTable table;
	private double angle;
	private double distance;

	public AlignByVision() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		this.driver = Robot.driver;
		this.table = table;
  
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		angle = table.getEntry("angle").getDouble(0);
		this.distance = table.getEntry("distance").getDouble(0);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		
		this.angle = this.table.getEntry("angle").getDouble(0);
		if (this.angle > 2)
			this.driver.arcadeDrive(0, 0.2);
		else if (this.angle < -2)
			this.driver.arcadeDrive(0, -0.2);
		if (Math.abs(this.angle) < 2.0) {
			this.driver.setLeft(0.5);
			this.driver.setLeft(0.5);}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Math.abs(this.angle) < 2 && this.distance <40.0;
	}

	// Called once after isFinished returns true
	protected void end() {
		this.driver.stopAllWheels();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		this.end();
		System.out.println("AlignByVision interrupted");
	}
}
