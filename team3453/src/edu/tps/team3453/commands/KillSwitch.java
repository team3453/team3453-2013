/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.commands;

/**
 *
 * @author digimo
 */
public class KillSwitch extends CommandBase {
    
    public KillSwitch() {
        // Use requires() here to declare subsystem dependencies
       requires(climberChassis);
       requires(dumperArm);
       requires(leftArm);
       requires(rightArm);
       requires(leftDriveMotor);
       requires(lid);
       requires(rearWheel);
       requires(rightDriveMotor);
       requires(leftSolenoid);
       requires(rightSolenoid);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        climberChassis.Stop();
        dumperArm.Stop();
        leftArm.stop();
        leftDriveMotor.off();
        lid.Stop();
        rearWheel.stop();
        rightArm.stop();
        rightDriveMotor.off();
        leftSolenoid.Lock();
        rightSolenoid.Lock();
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

