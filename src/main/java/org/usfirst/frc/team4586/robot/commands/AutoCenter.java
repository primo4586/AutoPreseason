/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//
package org.usfirst.frc.team4586.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class AutoCenter extends CommandGroup {
  /**
   * Add your docs here.
   */	private NetworkTable table;

  
  public AutoCenter() {
    this.table = table;

    //addSequential(new AutoDrive(25)); 
    System.out.println(table.getValue("angle"));
		addSequential(new AlignByVision()); 
  	//addSequential(new AutoDrive(48)); 
    //addSequential(new CatchCube()); 
  //  addSequential(new AutoDrive(20)); 
//    addSequential(new CatchCube()); 

  }
}
