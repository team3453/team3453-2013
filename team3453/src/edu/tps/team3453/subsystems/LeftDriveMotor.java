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
import edu.tps.team3453.commands.LeftDriveMotorStop;

/**
 *
 * @author digimo
 */
public class LeftDriveMotor extends PIDSubsystem {

    private static final double Kp = 1.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    private static final double Kf = 0.2;
    private static final double KoutMin = 0.2;
    private static final double KoutMax = 0.25;
    private static final double Ksetpoint = 550;
    
    private static final SpeedController leftMotor = new Victor(RobotMap.leftDriveMotor);
    private static final Encoder leftEncoder = new Encoder(RobotMap.leftDriveEncoderA,RobotMap.leftDriveEncoderB);

    // Initialize your subsystem here
    public LeftDriveMotor() {
        super("LeftDriveMotor", Kp, Ki, Kd, Kf);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        leftEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        
        disable();
        leftEncoder.stop();
        leftEncoder.reset();
        leftEncoder.start();
        setSetpoint(Ksetpoint);
        
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LeftDriveMotorStop());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return leftEncoder.getRate();
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
        leftMotor.set(output);
    }
    
    public SpeedController getMotor() {
        return leftMotor;
    }
    
    public Encoder getEncoder() {
        return leftEncoder;
    }
    
    public void updateStatus() {
        SmartDashboard.putNumber("Left Enc count ", leftEncoder.get());
        SmartDashboard.putNumber("Left Motor out ", leftMotor.get());
        SmartDashboard.putNumber("Left Enc rate ", leftEncoder.getRate());
        
    }
}
