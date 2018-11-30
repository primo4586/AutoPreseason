/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team4586.robot.commands;


import org.usfirst.frc.team4586.robot.Robot;
import org.usfirst.frc.team4586.robot.subsystems.Driver;

import edu.wpi.first.wpilibj.HLUsageReporting.Null;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoTurnTest extends Command {
  Driver driver;
  double setPoint;
  double kP;
	double prevError;
	double kD;



  public AutoTurnTest(int i) {
    this.setPoint = i;
    driver = Robot.driver;

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      driver.setGyroControllerSetPoint(setPoint);
      setTimeout(0.8);
    	driver.gyroController.enable();
    	driver.resetGyro();
    	kP = SmartDashboard.getNumber("kP", 0.11);
    	kD = SmartDashboard.getNumber("kP", 0.13);
    	prevError = 0;

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double error = setPoint - driver.getGyro();
    	double der = (error - prevError) / 0.2;
    	double drcw = kD*der;
    	double prcw = kP*error;
    	if (Math.abs(driver.getGyro() - setPoint) >= 1) 
    		driver.arcadeDrive(0,(prcw + drcw) * 0.8);
    	else
    		driver.arcadeDrive(0, 0);
    	prevError = error;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Math.abs(this.driver.getGyro() - this.setPoint) <= Math.abs(2)||isTimedOut();

    
    
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    driver.gyroController.disable();
  	driver.arcadeDrive(0, 0);
  	System.out.println(setPoint);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    driver.gyroController.disable();
    driver.arcadeDrive(0, 0);
    System.out.println(setPoint);
  }
}
