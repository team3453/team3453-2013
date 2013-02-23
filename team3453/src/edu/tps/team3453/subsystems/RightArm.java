/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.tps.team3453.Utils;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.tps.team3453.commands.RightArmDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Madeline
 */
public class RightArm extends Subsystem {
    SpeedController rightArm = new Victor(RobotMap.rightArm);
    private static DigitalInput limitSwitchRightArmReach = new DigitalInput(2, RobotMap.limitSwitchRightArmReach);
    private static DigitalInput limitSwitchRightArmPull = new DigitalInput(2, RobotMap.limitSwitchRightArmPull);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new RightArmDoNothing());
    }
    public void rightArmReach(){
        rightArm.set(1);
    }
    public void rightArmPull(){
        rightArm.set(-1);
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
}
