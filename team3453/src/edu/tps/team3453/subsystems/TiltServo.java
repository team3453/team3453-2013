/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
        SmartDashboard.putNumber("TiltServoDegrees", servo.getAngle());
        servo.set(1);
    }
    public void tiltServoApproach(){
        SmartDashboard.putNumber("TiltServoDegrees", servo.getAngle());
        servo.set(1);
    }
    
    public void tiltServoClockwise() {
        servo.setAngle(servo.getAngle() + 2.0);
        SmartDashboard.putNumber("TiltServoDegrees", servo.getAngle());
    }
    public void tiltServoCounterclockwise() {
        servo.setAngle(servo.getAngle() -2.0);
        SmartDashboard.putNumber("TiltServoDegrees", servo.getAngle());
    }
}
