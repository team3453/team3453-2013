/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.tps.team3453.commands.RightArmDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author admin
 */
public class RightArm extends PIDSubsystem {

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    SpeedController rightArm = new Victor(RobotMap.rightArm);
    private static DigitalInput limitSwitchRightArmReach = new DigitalInput(2, RobotMap.limitSwitchRightArmReach);
    private static DigitalInput limitSwitchRightArmPull = new DigitalInput(2, RobotMap.limitSwitchRightArmPull);

    private static double currentOutput = 0.0;

    // Initialize your subsystem here
    public RightArm() {
        super("RightArm", Kp, Ki, Kd);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
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
        return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
    public void rightArmReach(){
        rightArm.set(-0.2);
    }
    public void rightArmPull(){
        rightArm.set(0.2);
    }
    public void stop(){
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
}
