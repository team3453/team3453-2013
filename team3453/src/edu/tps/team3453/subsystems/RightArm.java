/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Madeline
 */
public class RightArm extends Subsystem {
    SpeedController rightArm = new Victor(RobotMap.rightArm);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
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
}
