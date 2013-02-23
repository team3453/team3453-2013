/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.tps.team3453.Utils;
import edu.tps.team3453.commands.RearWheelDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Madeline
 */
public class RearWheel extends Subsystem {
Relay rearWheel = new Relay(RobotMap.rearWheel);
private static final DigitalInput limitSwitchRearWheelExtend = new DigitalInput(2, RobotMap.limitSwitchRearWheelExtend);    
private static final DigitalInput limitSwitchRearWheelRetract = new DigitalInput(2, RobotMap.limitSwitchRearWheelRetract);
// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new RearWheelDoNothing());
    }
    public void extend(){
        rearWheel.set(Relay.Value.kForward);
    }
    public void retract(){
        rearWheel.set(Relay.Value.kReverse);
    }
    public void stop(){
        rearWheel.set(Relay.Value.kOff);
    }
    public boolean isExtended(){
        return limitSwitchRearWheelExtend.get();
    }
    public boolean isRetracted(){
        return limitSwitchRearWheelRetract.get();
    }
}
