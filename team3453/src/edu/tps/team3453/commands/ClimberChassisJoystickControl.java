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
    
    public ClimberChassisJoystickControl() {
        requires(climberChassis);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(climberChassis.getAxisValue() >=.150){
            climberChassis.Forward();
        }
        else if (climberChassis.getAxisValue() <=-.150) {
            climberChassis.Back();
        }
        else{
            climberChassis.Stop();
        }
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
        if (climberChassis.isExtended() || climberChassis.isRetracted()){
            return true;
    }
    else{
    return false;
}
}
}