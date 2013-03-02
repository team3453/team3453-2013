/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.tps.team3453.commands.RightArmDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author admin
 */
public class RightArm extends PIDSubsystem {

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    private static final double Kf = 0.2;
    
    private static double KoutMin = 0.2;
    private static double KoutMax = 0.25;
    private static double Ksetpoint = 550;    
    
    private static final SpeedController rightArm = new Victor(RobotMap.rightArm);
    private static final DigitalInput limitSwitchRightArmReach = new DigitalInput(2, RobotMap.limitSwitchRightArmReach);
    private static final DigitalInput limitSwitchRightArmPull = new DigitalInput(2, RobotMap.limitSwitchRightArmPull);
    private static final Encoder rightEncoder = new Encoder(RobotMap.leftArmEncoderA,RobotMap.leftArmEncoderB);

    private static double  currentOutput = 0.0;
    private static double  currentRate = 0.0;
    private static double  currentAverageRate = 09.0;
    private static double  rateArray[];
    private static int     rateArrayIndex = -1;
    private static boolean firstTimeRate = true;
    
      // Initialize your subsystem here
    public RightArm() {
        super("RightArm", Kp, Ki, Kd, Kf);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        
        rateArray = new double[10];
        rightEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kRate);
        setAbsoluteTolerance(2.0);
        
        disable();
        rightEncoder.stop();
        rightEncoder.reset();
        rightEncoder.start();
        setSetpoint(Ksetpoint);       
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new RightArmDoNothing());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        // advance the index and reset it to 0 if we have ran off the highend
        rateArrayIndex++;
        if (rateArrayIndex > 9) {
            rateArrayIndex = 0;
        }
        
        // get the raw rate and store it in the window 
        currentRate = rightEncoder.getRate();
        rateArray[rateArrayIndex] = currentRate;
        
        // prime the entire array with the first measurement if this is the first measurement
        if (firstTimeRate) {
            firstTimeRate = false;
            for (int i = 0; i < 10; i++) {
                rateArray[i] = currentRate;
            }
        }
        
        // calculate the sum and produce the average of the array
        int s = 0;
        for (int i = 0; i < 10; i++) {
            s += rateArray[i];
        }
        currentAverageRate = s / 10.0;
        if (onTarget()) {
            getPIDController().setPID(Kp, Ki, Kd, currentOutput);
        }
        return (currentAverageRate);
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
        
        currentOutput = output;
        rightArm.set(output);        
    }
    public void rightArmReach(){
        rightArm.set(-0.2);
    }
    public void rightArmPull(){
        rightArm.set(0.2);
    }
    public void stop(){
        disable();
        rightArm.set(0);
    }
    public boolean isExtended() {
       return limitSwitchRightArmReach.get();
    }
    public boolean isRetracted() {
        return limitSwitchRightArmPull.get();
    }
    
    public void up5 () {
        currentOutput -= 0.05;
        checkOutput();
        printCurrentOutput();
    }
    
    public void down5 () {
        currentOutput += 0.05;
        checkOutput();
        printCurrentOutput();

    }
    
    public void printCurrentOutput() {
        System.out.println("Right Arm Current Output is "+currentOutput);
    }
    
    
    public void runCurrentOutput() {
        System.out.println("Run Right Arm Current Output is "+currentOutput);
        rightArm.set(currentOutput);
    }
    
    private void checkOutput() {
        if (currentOutput > 1.0) {
            currentOutput = 1.0;
        } else if (currentOutput < -1.0) {
            currentOutput = -1.0;
        }
    }
    
     public void updateStatus() {
        SmartDashboard.putNumber("Right Arm Enc count ", rightEncoder.get());
        SmartDashboard.putNumber("Right Arm Motor out ", rightArm.get());
        SmartDashboard.putNumber("Right Arm Enc rate ",  currentRate);        
    }
    
    public void checkRate() {
        
    }   
}
