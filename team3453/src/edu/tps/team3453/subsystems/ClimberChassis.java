
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.tps.team3453.RobotMap;
import edu.tps.team3453.Utils;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.tps.team3453.commands.ClimberChassisDoNothing;
import edu.wpi.first.wpilibj.DigitalInput;
import java.lang.Boolean;
/**
 *
 * @author Madeline
 */
public class ClimberChassis extends Subsystem {
    Relay climberChassis = new Relay(RobotMap.climberChassis);
    private static final DigitalInput limitSwitchExtend = new DigitalInput(RobotMap.climberChassisExtendLimitSwitch);
    private static final DigitalInput limitSwitchRetract = new DigitalInput(RobotMap.climberChassisRetractLimitSwitch);
    
    // Put methods for controlling this subsystem
    
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(new ClimberChassisDoNothing());
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
    public boolean isExtended() {
        return limitSwitchExtend.get();
    }
    public boolean isRetracted() {
        return limitSwitchRetract.get();
    }
}
