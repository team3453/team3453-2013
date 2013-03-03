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
       requires(leftJoystickToken);
       requires(rightJoystickToken);
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
        rearWheel.stop();

        leftArm.stop();
        rightArm.stop();
        leftArm.disable();
        rightArm.disable();
        leftSolenoid.Lock();
        rightSolenoid.Lock();
        
        leftDriveMotor.off();
        leftDriveMotor.disable();
        rightDriveMotor.off();
        rightDriveMotor.disable();

        lid.Stop();
        dumperArm.Stop();
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

