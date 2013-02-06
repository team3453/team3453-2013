/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.commands;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 * @author digimo
 */
public class AutoDriveFreeFwd extends CommandBase {
    double setpoint;
    SpeedController leftMotor = leftDriveMotor.getMotor();
    SpeedController rightMotor = rightDriveMotor.getMotor();
    Encoder leftEncoder = leftDriveMotor.getEncoder();
    Encoder rightEncoder = rightDriveMotor.getEncoder();
    boolean initrun = true;
    
    public AutoDriveFreeFwd () {
        requires(leftDriveMotor);
        requires(rightDriveMotor);
    }
    
    public AutoDriveFreeFwd(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(leftDriveMotor);
        requires(rightDriveMotor);
        this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        if (initrun) {
            initrun = false;
            leftEncoder.reset();
            leftEncoder.start();
            rightEncoder.reset();
            rightEncoder.start();
            leftMotor.set(0.2);
            rightMotor.set(-0.1);
            
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        leftDriveMotor.updateStatus();
        rightDriveMotor.updateStatus();
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if ((leftEncoder.get() >= setpoint) || (rightEncoder.get() >= setpoint)) {
            initrun = true;
            return true;
        } else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        initrun = true;
        leftMotor.set(0);
        rightMotor.set(0);
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        initrun = true;
        leftMotor.set(0);
        rightMotor.set(0);
    }
    
    public void setSetPoint (double setpoint) {
        this.setpoint = setpoint;
    }
}
