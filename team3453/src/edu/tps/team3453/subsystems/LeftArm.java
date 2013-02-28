/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.tps.team3453.commands.LeftArmDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 * @author admin
 */
public class LeftArm extends PIDSubsystem {

    private static final double Kp = 0.0;
    private static final double Ki = 0.0;
    private static final double Kd = 0.0;
    
    SpeedController leftArm = new Victor(RobotMap.leftArm);
    private static DigitalInput limitSwitchLeftArmReach = new DigitalInput(2, RobotMap.limitSwitchLeftArmReach);
    private static DigitalInput limitSwitchLeftArmPull = new DigitalInput(2, RobotMap.limitSwitchLeftArmPull);

    private static double  currentOutput = 0.0;
    
    // Initialize your subsystem here
    public LeftArm() {
        super("LeftArm", Kp, Ki, Kd);

        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LeftArmDoNothing());
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
    
    public void leftArmReach(){
        leftArm.set(0.2);
    }
    public void leftArmPull(){
        leftArm.set(-0.2);
    }
    public void stop(){
        leftArm.set(0);
    }
    public boolean isExtended() {
       return limitSwitchLeftArmReach.get();
    }
    public boolean isRetracted() {
        return limitSwitchLeftArmPull.get();
    }
    
    public void up5 () {
        currentOutput += 0.05;
        checkOutput();
        printCurrentOutput();
    }
    
    public void down5 () {
        currentOutput -= 0.05;
        checkOutput();
        printCurrentOutput();

    }
    
    public void printCurrentOutput() {
        System.out.println("Left Arm Current Output is "+currentOutput);
    }
    
    public void runCurrentOutput() {
        System.out.println("Run Left Arm Current Output is "+currentOutput);
        leftArm.set(currentOutput);
    }
    
    private void checkOutput() {
        if (currentOutput > 1.0) {
            currentOutput = 1.0;
        } else if (currentOutput < -1.0) {
            currentOutput = -1.0;
        }
    }
}
