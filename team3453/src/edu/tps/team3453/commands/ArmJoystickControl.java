/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.tps.team3453.commands;

import edu.tps.team3453.OI;

/**
 *
 * @author admin
 */
public class ArmJoystickControl extends CommandBase {
    
    private boolean isRetracting, isExtending;
    private double yVal;
    private boolean killit;
    
    public ArmJoystickControl() {
        requires(leftArm);
        requires(rightArm);
        //requires(leftSolenoid);
        //requires(rightSolenoid);
        requires(rightJoystickToken);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        isRetracting = false;
        isExtending = false;
        killit = false;
        System.out.println("============ ======================= ==========");
        System.out.println("============ in ArmJoystickControl ==========");
        System.out.println("============ ======================= ==========");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        /*
        if (isLimitPressed()) {
            System.out.println("============ ======================= ==========");
            System.out.println("============ ======================= ==========");
            System.out.println("============ set kill it true ==========");
            System.out.println("============ ======================= ==========");
            System.out.println("============ ======================= ==========");
            killit = true;
            end();
            return;
        } */
        if (killit) {
            System.out.println("============ ======================= ==========");
            System.out.println("============ ======================= ==========");
            System.out.println("============ encountered kill it true ==========");
            System.out.println("============ ======================= ==========");
            System.out.println("============ ======================= ==========");
  
            end();
            return;
        }
        yVal = OI.joystick2.getY();

        
        //Joystick Axis- Forward= negative, Backwards= positive for attack3 and extreme3DPro
        if(yVal >= .150){
            /*
            leftArm.setSetpoint(-2000);
            rightArm.setSetpoint(2000);
            leftSolenoid.Unlock();
            leftArm.enable();
            rightSolenoid.Unlock();
            rightArm.enable();
            */
            isRetracting = true;
            isExtending = false;
            if(!isLimitPressed()) {
                if (yVal <= 0.3) {
                    leftArm.setPullMin();
                    rightArm.setPullMin();
                } else if (yVal <= 0.4) {
                    leftArm.setPullLow();
                    rightArm.setPullLow();
                } else if (yVal <= 0.5) {
                    leftArm.setPullMidLow();
                    rightArm.setPullMidLow();
                } else if (yVal <= 0.6) {
                    leftArm.setPullMid();
                    rightArm.setPullMid();
                } else if (yVal <= 0.7) {
                    leftArm.setPullMidHigh();
                    rightArm.setPullMidHigh();
                } else if (yVal <= 0.8) {
                    leftArm.setPullHigh();
                    rightArm.setPullHigh();
                } else if (yVal < 1.0) {
                    leftArm.setPullMax();
                    rightArm.setPullMax();
                } else {
                    leftArm.setMaxPullMax();
                    rightArm.setMaxPullMax();
                }
                leftArm.leftArmPull();
                rightArm.rightArmPull();
            }
        }
        else if (yVal <= -.150) {
            /*
            leftArm.setSetpoint(2000);
            rightArm.setSetpoint(-2000);
            leftSolenoid.Unlock();
            leftArm.enable();
            rightSolenoid.Unlock();
            * 
            rightArm.enable();
            */
            
            isRetracting = false;
            isExtending = true;
            
            if(!isLimitPressed()) {
                leftArm.leftArmReach();
                rightArm.rightArmReach();
            }
        }
        else{
            //leftArm.disable();
            leftArm.stop();
            //leftSolenoid.Lock();
            //rightArm.disable();
            rightArm.stop();
            //rightSolenoid.Lock();
            isRetracting = false;
            isExtending = false;
        }
        
        isRetracting = false;
        isExtending = false;
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return killit;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("============ ======================= ==========");
        System.out.println("============ ending ArmJoystickControl ==========");
        System.out.println("============ ======================= ==========");
            isRetracting = false;
            isExtending = false;
            //leftArm.disable();
            leftArm.stop();
            //leftSolenoid.Lock();
            //rightArm.disable();
            rightArm.stop();
            //rightSolenoid.Lock();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
            isRetracting = false;
            isExtending = false;
            //leftArm.disable();
            leftArm.stop();
            //leftSolenoid.Lock();
            //rightArm.disable();
            rightArm.stop();
            //rightSolenoid.Lock();
    }
    public boolean isLimitPressed(){
        
       if ((leftArm.isRetracted() || rightArm.isRetracted()) && isRetracting){
           
           System.out.println("============ in isRetracting ==========");
           System.out.println("isLimitPressed returning true");
           
           System.out.println("leftArm.isExtended "+leftArm.isExtended());
           System.out.println("leftArm.isRetracted "+leftArm.isRetracted());
           
           System.out.println("rightArm.isExtended "+rightArm.isExtended());
           System.out.println("rightArm.isRetracted "+rightArm.isRetracted());
           
           System.out.println("isExtending "+isExtending);
           System.out.println("isRetracting "+isRetracting);
           
           killit = true;
           return true; 
           
       } else if ((leftArm.isExtended() || rightArm.isExtended()) && isExtending){
           
           System.out.println("============ in isExtending ==========");
           System.out.println("isLimitPressed returning true");
           
           System.out.println("leftArm.isExtended "+leftArm.isExtended());
           System.out.println("leftArm.isRetracted "+leftArm.isRetracted());
           
           System.out.println("rightArm.isExtended "+rightArm.isExtended());
           System.out.println("rightArm.isRetracted "+rightArm.isRetracted());
           
           System.out.println("isExtending "+isExtending);
           System.out.println("isRetracting "+isRetracting);
           
           killit = true;
           return true; 
        } else {
       
       
         /*else if((leftArm.isExtended()) && isExtending) {
   //         return true;
     //   } else { */
          return false;
        }
            
    }
}
