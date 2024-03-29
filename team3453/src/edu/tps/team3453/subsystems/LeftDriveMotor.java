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

    private static double currentOutput = 0.0;
    
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
    
    public void off() {
        disable();
        leftMotor.set(0);
    }

    public void powerOn(double power) {
        leftMotor.set(power);
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

    public void setAt10() {
        System.out.println("left motor set at 10");
        leftMotor.set(0.1);
    }

    public void setAt12() {
        System.out.println("left motor set at 12");
        leftMotor.set(0.12);
    }

    public void setAt15() {
        System.out.println("left motor set at 15");
        leftMotor.set(0.15);
    }

    public void setAt20() {
        System.out.println("left motor set at 20");
        leftMotor.set(0.2);
    }
    
    public void up5 () {
        currentOutput += 0.05;
        checkOutput();
        runCurrentOutput();
    }
    
    public void down5 () {
        currentOutput -= 0.05;
        checkOutput();
        runCurrentOutput();

    }
    
    public void runCurrentOutput() {
        System.out.println("Left Motor Current Output is "+currentOutput);
        leftMotor.set(currentOutput);
    }
    
    private void checkOutput() {
        if (currentOutput > 1.0) {
            currentOutput = 1.0;
        } else if (currentOutput < -1.0) {
            currentOutput = -1.0;
        }
    }
}
