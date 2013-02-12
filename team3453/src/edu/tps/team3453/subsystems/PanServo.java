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
public class PanServo extends Subsystem {
    Servo servo = new Servo(RobotMap.panServoInput);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void panServoDoNothing(){
        servo.set(0);
    }
    public void panWhileOn(){
        SmartDashboard.putNumber("PanServoDegrees", servo.getAngle());
        servo.set(1);
    }
    public void panApproach(){
        SmartDashboard.putNumber("PanServoDegrees", servo.getAngle());
        servo.set(1);
    }
    public void panServoClockwise() {
        servo.setAngle(servo.getAngle() + 2.0);
        SmartDashboard.putNumber("PanServoDegrees", servo.getAngle());
    }
    public void panServoCounterclockwise() {
        servo.setAngle(servo.getAngle() - 2.0);
        SmartDashboard.putNumber("PanServoDegrees", servo.getAngle());
    }
}
