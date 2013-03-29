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
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author admin
 */
public class LeftArm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    private static final SpeedController leftArm = new Victor(RobotMap.leftArm);
    private static final SpeedController leftArmB = new Victor(RobotMap.leftArmB);
    private static final DigitalInput limitSwitchLeftArmReach = new DigitalInput(2, RobotMap.limitSwitchLeftArmReach);
    private static final DigitalInput limitSwitchLeftArmPull = new DigitalInput(2, RobotMap.limitSwitchLeftArmPull);

    private static final double maxPullMax =   -0.9;
    private static final double pullMax =     -0.7;
    private static final double pullHigh =    -0.6;
    private static final double pullMidHigh = -0.55;
    private static final double pullMid =     -0.5;
    private static final double pullMidLow =  -0.45;
    private static final double pullLow =     -0.35;
    private static final double pullMin =     -0.30;
    
    private static double currentPull = -0.30;
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LeftArmDoNothing());
    }
    
    public void leftArmReach(){
        // changed from 0.3 to 0.335
        leftArm.set(0.335);
        leftArmB.set(0.335);
    }
    public void leftArmPull(){
        // increased from -0.3 to -0.6
        leftArm.set(currentPull);
        leftArmB.set(currentPull);
    }
    public void stop(){
        //disable();
        leftArm.set(0);
        leftArmB.set(0);
    }
    public boolean isExtended() {
       return limitSwitchLeftArmReach.get();
    }
    public boolean isRetracted() {
        return limitSwitchLeftArmPull.get();
    }
    
    public void updateStatus() {
        System.out.println("left arm update Status called\n");
        //SmartDashboard.putNumber("Left Arm Enc count ", leftEncoder.get());
        SmartDashboard.putNumber("Left Arm Motor out ", leftArm.get());
        //SmartDashboard.putNumber("Left Arm Enc rate ",  currentRate);  
        SmartDashboard.putBoolean("Left Reach Limit", limitSwitchLeftArmReach.get());
     
    }
    
    public void checkRate() {
        
        
    }
    
    public void setPullMin() {
        currentPull = pullMin;
    }
    public void setPullLow() {
        currentPull = pullLow;
    }
    public void setPullMidLow() {
        currentPull = pullMidLow;
    }
    public void setPullMid() {
        currentPull = pullMid;
    }
    public void setPullMidHigh() {
        currentPull = pullMidHigh;
    }
    public void setPullHigh() {
        currentPull = pullHigh;
    }
    public void setPullMax() {
        currentPull = pullMax;
    }
    public void setMaxPullMax() {
        currentPull = maxPullMax;
    }
}
