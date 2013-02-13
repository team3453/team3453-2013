/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.tps.team3453.commands.LeftArmDoNothing;

/**
 *
 * @author Madeline
 */
public class LeftArm extends Subsystem {
    SpeedController leftArm = new Victor(RobotMap.leftArm);
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
}
