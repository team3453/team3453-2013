package edu.tps.team3453;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    public static final int leftDriveMotor = 1;
    public static final int rightDriveMotor = 2;
    
     //   leftEncoder = new Encoder(7,8);
     //   rightEncoder = new Encoder(5,6);
    public static final int leftDriveEncoderA = 7;
    public static final int leftDriveEncoderB = 8;
    public static final int rightDriveEncoderA = 5;
    public static final int rightDriveEncoderB = 6;
    
    public static final int lid = 1;
    
    public static final int closeLidLimitSwitch = 1;
    public static final int openLidLimitSwitch = 2;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
}
