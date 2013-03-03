/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.commands;

/**
 *
 * @author admin
 */
public class ClimberChassisJoystickControl extends CommandBase {
    
    private boolean isForwards, isBackwards;
    
    public ClimberChassisJoystickControl() {
        requires(climberChassis);
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
        if(climberChassis.getAxisValue() >=.150){
            climberChassis.Forward();
            isForwards = true;
            isBackwards = false;
        }
        else if (climberChassis.getAxisValue() <=-.150) {
            climberChassis.Back();
            isForwards = false;
            isBackwards = true;
        }
        else{
            climberChassis.Stop();
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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
            isForwards = false;
            isBackwards = false;
    }
    public boolean isLimitPressed() {
        if ((climberChassis.isExtended() || rearWheel.isHit()) && isForwards) {
            return true;
        } else if(climberChassis.isRetracted() && isBackwards) {
            return true;
        } else {
            return false;
        }
    }
}