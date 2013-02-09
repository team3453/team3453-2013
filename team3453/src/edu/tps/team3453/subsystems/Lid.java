/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.tps.team3453.RobotMap;
import edu.tps.team3453.commands.LidStop;
/**
 *
 * @author Madeline
 */
public class Lid extends Subsystem {
    private static final SpeedController lidMotor = new Victor(RobotMap.lid);
    //limit switch x2 
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new LidStop());
    }
    public void Open(){
        lidMotor.set(1);
    }
    public void Close(){
        lidMotor.set(-1);
    }
    public void Stop() {
        lidMotor.set(0.0);
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
