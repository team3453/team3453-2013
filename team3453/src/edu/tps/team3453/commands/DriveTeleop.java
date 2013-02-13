/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.commands;

import edu.tps.team3453.RobotMap;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author Madeline
 */
public class DriveTeleop extends CommandBase {
    SpeedController leftMotor;
    SpeedController rightMotor;
    RobotDrive drive;
    Joystick stick;
    
    public DriveTeleop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(leftDriveMotor);
        requires(rightDriveMotor);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        leftMotor = leftDriveMotor.getMotor();
        rightMotor = rightDriveMotor.getMotor();
        drive = new RobotDrive(leftMotor, rightMotor);
        stick = new Joystick(RobotMap.leftJoystick);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        drive.arcadeDrive(stick);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
