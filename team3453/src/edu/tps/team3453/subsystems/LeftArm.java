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
import edu.tps.team3453.commands.LeftArmDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *
 * @author Madeline
 */
public class LeftArm extends Subsystem {
    SpeedController leftArm = new Victor(RobotMap.leftArm);
    private static DigitalInput limitSwitchLeftArmReach = new DigitalInput(2, RobotMap.limitSwitchLeftArmReach);
    private static DigitalInput limitSwitchLeftArmPull = new DigitalInput(2, RobotMap.limitSwitchLeftArmPull);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LeftArmDoNothing());
    }
    public void leftArmReach(){
        leftArm.set(1);
    }
    public void leftArmPull(){
        leftArm.set(-1);
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
}
