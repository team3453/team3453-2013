/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.tps.team3453.RobotMap;
import edu.tps.team3453.commands.LidStop;
import edu.wpi.first.wpilibj.Relay;
/**
 *
 * @author Madeline
 */
public class Lid extends Subsystem {
    private static final Relay lidMotor = new Relay(RobotMap.lid);
    //limit switch x2 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LidStop());
    }
    public void Open(){
        lidMotor.set(Relay.Value.kForward);
    }
    public void Close(){
        lidMotor.set(Relay.Value.kReverse);
    }
    public void Stop() {
        lidMotor.set(Relay.Value.kOff);
    }
    public boolean isOpen(){
        //replace with return switch.get();
        return true;
    }
    public boolean isClosed() {
        return true; 
        //replace with return switch.get();
    }
}
