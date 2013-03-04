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
public class LeftArmJoystickControl extends CommandBase {
    
    private boolean isForwards, isBackwards;
    
    public LeftArmJoystickControl() {
        requires(leftArm);
        requires(leftSolenoid);
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
            /*
            leftArm.setSetpoint(2000);
            leftSolenoid.Unlock();
            leftArm.enable();
            */
            leftArm.leftArmPull();
            
            isForwards = true;
            isBackwards = false;
        }
        else if (OI.joystick2.getY() <=-.150) {
            /*
            leftArm.setSetpoint(-2000);
            leftSolenoid.Unlock();
            leftArm.enable();
            */
            leftArm.leftArmReach();
            isForwards = false;
            isBackwards = true;
        }
        else{
            leftArm.disable();
            leftArm.stop();
            leftSolenoid.Lock();
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
            isForwards = false;
            isBackwards = false;
            leftArm.disable();
            leftArm.stop();
            leftSolenoid.Lock();
    }
    public boolean isLimitPressed() {
        if ((leftArm.isRetracted()) && isForwards){
           return true; 
        } else if((leftArm.isExtended()) && isBackwards) {
            return true;
        } else {
            return false;
        }
            
    }
}
