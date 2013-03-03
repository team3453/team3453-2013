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
public class RightArmJoystickControl extends CommandBase {
    
    private boolean isForwards, isBackwards;
    
    public RightArmJoystickControl() {
        requires(leftArm);
        requires(rightArm);
        requires(leftSolenoid);
        requires(rightSolenoid);
        requires(rightJoystickToken);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isForwards = false;
        isBackwards = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(OI.joystick2.getY() >=.150){
            leftArm.setSetpoint(2000);
            rightArm.setSetpoint(2000);
            leftSolenoid.Unlock();
            leftArm.enable();
            rightSolenoid.Unlock();
            rightArm.enable();
            isForwards = true;
            isBackwards = false;
        }
        else if (OI.joystick2.getY() <=-.150) {
            leftArm.setSetpoint(-2000);
            rightArm.setSetpoint(-2000);
            leftSolenoid.Unlock();
            leftArm.enable();
            rightSolenoid.Unlock();
            rightArm.enable();
            isForwards = false;
            isBackwards = true;
        }
        else{
            leftArm.disable();
            leftArm.stop();
            leftSolenoid.Lock();
            rightArm.disable();
            rightArm.stop();
            rightSolenoid.Lock();
            isForwards = false;
            isBackwards = false;
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isLimitPressed();
    }

    // Called once after isFinished returns true
    protected void end() {
            isForwards = false;
            isBackwards = false;
            leftArm.disable();
            leftArm.stop();
            leftSolenoid.Lock();
            rightArm.disable();
            rightArm.stop();
            rightSolenoid.Lock();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
            isForwards = false;
            isBackwards = false;
            leftArm.disable();
            leftArm.stop();
            leftSolenoid.Lock();
            rightArm.disable();
            rightArm.stop();
            rightSolenoid.Lock();
    }
    public boolean isLimitPressed(){
        if ((leftArm.isExtended() || rightArm.isExtended()) && isForwards){
           return true; 
        } else if((leftArm.isRetracted() || rightArm.isRetracted()) && isBackwards) {
            return true;
        } else {
            return false;
        }
            
    }
}
