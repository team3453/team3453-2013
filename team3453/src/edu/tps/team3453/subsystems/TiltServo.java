/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Madeline
 */
public class TiltServo extends Subsystem {
Servo servo = new Servo(RobotMap.tiltServoInput);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void tiltServoDoNothing(){
        servo.set(0);
    }
    public void tiltServoWhileOn(){
        servo.set(1);
    }
    public void tiltServoApproach(){
        servo.set(1);
    }
}