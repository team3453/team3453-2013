/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.tps.team3453.RobotMap;
import edu.tps.team3453.commands.RightDriveMotorStop;

/**
 *
 * @author digimo
 */
public class RightDriveMotor extends PIDSubsystem {

    private static final double Kp = 1.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    private static final double Kf = -0.11;
    private static final double KoutMin = -0.3;
    private static final double KoutMax = -0.08;
    private static final double Ksetpoint = -550;
    
    private static final SpeedController rightMotor = new Victor(RobotMap.rightDriveMotor);
    private static final Encoder rightEncoder = new Encoder(RobotMap.rightDriveEncoderA,RobotMap.rightDriveEncoderB);

    // Initialize your subsystem here
    public RightDriveMotor() {
        super("RightDriveMotor", Kp, Ki, Kd, Kf);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        rightEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        
        disable();
        rightEncoder.stop();
        rightEncoder.reset();
        rightEncoder.start();
        setSetpoint(Ksetpoint);
        
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new RightDriveMotorStop());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return rightEncoder.getRate();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        if (output > KoutMax) {
            output = KoutMax;
        }
        if (output < KoutMin) {
            output = KoutMin;
        }
        rightMotor.set(output);
    }
    
    public void off() {
        disable();
        rightMotor.set(0);
    }

    public void powerOn(double power) {
        rightMotor.set(power);
    }
    
    public SpeedController getMotor() {
        return rightMotor;
    }
    
    public Encoder getEncoder() {
        return rightEncoder;
    }
    
    public void updateStatus() {
        SmartDashboard.putNumber("Right Enc count ", rightEncoder.get());
        SmartDashboard.putNumber("Right Motor out ", rightMotor.get());
        SmartDashboard.putNumber("Right Enc rate ", rightEncoder.getRate());
        
    }    
    
    public void goAtLimit() {
        rightMotor.set(-.2);
    }
    public void goAtInverseLimit() {
        rightMotor.set(.2);
    }
}
