package edu.tps.team3453.commands;
import edu.tps.team3453.OI;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class goAtLimit extends CommandBase {
    
    public goAtLimit() {
        requires(rightDriveMotor);
        requires(leftDriveMotor);
        requires(leftJoystickToken);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double yVal = OI.joystick.getY();
        if(yVal <= -0.125) {
            rightDriveMotor.goAtLimit();
            leftDriveMotor.goAtLimit();
        } else if(yVal >= 0.125) {
            rightDriveMotor.goAtInverseLimit();
            leftDriveMotor.goAtInverseLimit();
        } else {
            rightDriveMotor.off();
            leftDriveMotor.off();
        }
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
