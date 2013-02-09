/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 * @author Madeline
 */
public class DumperArm extends Subsystem {
    

    public void initDefaultCommand() {
        setDefaultMethod(new ArmDoNothing());
    }
}
