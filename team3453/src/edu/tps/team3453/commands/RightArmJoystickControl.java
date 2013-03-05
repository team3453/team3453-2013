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
    
    private boolean isRetracting, isExtending;
    
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
        isRetracting = false;
        isExtending = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(OI.joystick2.getY() >= 0.150){
            /*
            rightArm.setSetpoint(-2000);
            rightSolenoid.Unlock();
            rightArm.enable();
            */
            isRetracting = true;
            isExtending = false;
            if(!isLimitPressed()) {
                rightArm.rightArmPull();
            }
        }
        else if (OI.joystick2.getY() <= -0.150) {
            /*
            rightArm.setSetpoint(2000);
            rightSolenoid.Unlock();
            rightArm.enable();
            */
            isRetracting = false;
            isExtending = true;
            if(!isLimitPressed()) {
                rightArm.rightArmReach();
            }
        }
        else{
            leftArm.disable();
            leftArm.stop();
            leftSolenoid.Lock();
            rightArm.disable();
            rightArm.stop();
            rightSolenoid.Lock();
            isRetracting = false;
            isExtending = false;
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isLimitPressed();
    }

    // Called once after isFinished returns true
    protected void end() {
            isRetracting = false;
            isExtending = false;
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
            isRetracting = false;
            isExtending = false;
            leftArm.disable();
            leftArm.stop();
            leftSolenoid.Lock();
            rightArm.disable();
            rightArm.stop();
            rightSolenoid.Lock();
    }
    public boolean isLimitPressed(){
        if (( rightArm.isRetracted()) && isRetracting){
           return true; 
        } else if(( rightArm.isExtended()) && isExtending) {
            return true;
        } else {
            return false;
        }
            
    }
}
