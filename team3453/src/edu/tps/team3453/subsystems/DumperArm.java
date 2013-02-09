/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.tps.team3453.RobotMap;
import edu.tps.team3453.commands.DumperArmDoNothing;

/**
 *
 * @author Madeline
 */
public class DumperArm extends Subsystem {
    private static final SpeedController dumperArmMotor = new Victor(RobotMap.dumperArmMotor);
    

    public void initDefaultCommand() {
        setDefaultCommand(new DumperArmDoNothing());
    }
    public void Up(){
        dumperArmMotor.set(1);
    }
    public void Down(){
        dumperArmMotor.set(-1);
    }
    public void Stop() {
        dumperArmMotor.set(0.0);
    }    
}
