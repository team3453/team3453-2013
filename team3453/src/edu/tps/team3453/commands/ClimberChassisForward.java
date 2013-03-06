/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.commands;

/**
 *
 * @author Madeline
 */
public class ClimberChassisForward extends CommandBase {
    
    public ClimberChassisForward() {
        requires(climberChassis);
        //requires(tiltServo);
        //requires(panServo);
        setTimeout(5.0);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        climberChassis.Forward();
        //tiltServo.tiltServoWhileOn();
        //panServo.panWhileOn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isStopped();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
    private boolean isStopped() {
        if (climberChassis.isRetracted() || rearWheel.isHit() || isTimedOut()){
            return true;
        }else {
            return false;
        }
    }
}
