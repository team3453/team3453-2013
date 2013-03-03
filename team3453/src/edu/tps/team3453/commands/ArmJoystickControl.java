/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.commands;

import edu.tps.team3453.OI;

/**
 *
 * @author admin
 */
public class ArmJoystickControl extends CommandBase {
    
    public ArmJoystickControl() {
        requires(leftArm);
        requires(token);
        requires(rightArm);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isLimitPressed();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    public boolean isLimitPressed(){
        if (leftArm.isExtended() || rightArm.isExtended() || leftArm.isRetracted() || rightArm.isRetracted()){
           return true; 
        }
        else{
            return false;
        }
            
    }
}
