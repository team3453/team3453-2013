/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.tps.team3453.commands.PanServoDoNothing;

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
        setDefaultCommand(new PanServoDoNothing());
    }
    public void panServoDoNothing(){
        //servo.set(0);
    }
    public void panWhileOn(){
        servo.set(1);
        SmartDashboard.putNumber("PanServo Degrees", servo.get());
    }
    public void panApproach(){
        servo.set(1);
        SmartDashboard.putNumber("PanServo Degrees", servo.get());
    }
    public void panServoClockwise(){
        //servo.set(1);
        servo.setAngle(100);
        SmartDashboard.putNumber("PanServo Degrees", servo.get());
    }
    public void panServoCounterClockwise(){
        //servo.set(-1);
        servo.setAngle(60);
        SmartDashboard.putNumber("PanServo Degrees", servo.get());
    }
}
