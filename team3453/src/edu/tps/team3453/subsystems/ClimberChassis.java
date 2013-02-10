/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Madeline
 */
public class ClimberChassis extends Subsystem {
    Relay climberChassis = new Relay(RobotMap.climberChassis);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void Forward(){
        climberChassis.set(Relay.Value.kForward);
    }
    public void Back(){
        climberChassis.set(Relay.Value.kReverse);
    }
    public void Stop(){
        climberChassis.set(Relay.Value.kOff);
    }
}
