/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.tps.team3453.commands.RightArmDoNothing;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author admin
 */
public class RightArm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    private static final double maxPullMax =     1.0;
    private static final double pullMax =     0.8;
    private static final double pullHigh =    0.7;
    private static final double pullMidHigh = 0.65;
    private static final double pullMid =     0.6;
    private static final double pullMidLow =  0.55;
    private static final double pullLow =     0.45;
    private static final double pullMin =     0.40;
    
    private static double currentPull = 0.40;    

    private static final SpeedController rightArm = new Victor(RobotMap.rightArm);
    private static final SpeedController rightArmB = new Victor(RobotMap.rightArmB);
    private static final DigitalInput limitSwitchRightArmReach = new DigitalInput(2, RobotMap.limitSwitchRightArmReach);
    private static final DigitalInput limitSwitchRightArmPull = new DigitalInput(2, RobotMap.limitSwitchRightArmPull);
  
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new RightArmDoNothing());
    }
    
    public void rightArmReach(){
        rightArm.set(-0.3);
        rightArmB.set(-0.3);
    }
    public void rightArmPull(){
        // changed from 0.3 to 0.4
        // increased from 0.4 to 0.7
        rightArm.set(currentPull);
        rightArmB.set(currentPull);
    }
    public void stop(){
        //disable();
        rightArm.set(0);
        rightArmB.set(0);
    }
    public boolean isExtended() {
       return limitSwitchRightArmReach.get();
    }
    public boolean isRetracted() {
        return limitSwitchRightArmPull.get();
    }
    
        
     public void updateStatus() {
        System.out.println("right arm update Status called\n");
                
        //SmartDashboard.putNumber("Right Arm Enc count ", rightEncoder.get());
        SmartDashboard.putNumber("Right Arm Motor out ", rightArm.get());
        //SmartDashboard.putNumber("Right Arm Enc rate ",  currentRate);        
        SmartDashboard.putBoolean("Right Reach Limit", limitSwitchRightArmReach.get());
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
