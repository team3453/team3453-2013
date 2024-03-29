package edu.tps.team3453;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name.
 * Window Motor- kForward= clockwise, kReverse= counterclockwise
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    //PWM
    public static final int panServoInput = 1;
    public static final int tiltServoInput = 2;
    public static final int leftDriveMotor = 4;
    public static final int rightDriveMotor = 5;
    public static final int rightArm = 6;
    public static final int leftArm = 7;
    
     //   leftEncoder = new Encoder(7,8);
     //   rightEncoder = new Encoder(5,6);
    //DIO
    public static final int leftDriveEncoderA = 7;
    public static final int leftDriveEncoderB = 8;
    public static final int rightDriveEncoderA = 5;
    public static final int rightDriveEncoderB = 6;
    public static final int closeLidLimitSwitch = 1;
    public static final int openLidLimitSwitch = 2;
    public static final int climberChassisExtendLimitSwitch = 3;
    public static final int climberChassisRetractLimitSwitch = 4;
    
    //public static final int testLimitSwitch = 10;
    public static final int limitSwitchCrashPreventer = 10;
    public static final int leftArmEncoderA = 11;
    public static final int leftArmEncoderB = 12;
    
    //Second DSC
    public static final int limitSwitchRearWheelExtend = 1;
    public static final int limitSwitchRearWheelPolePosition = 2;
    public static final int limitSwitchLeftArmReach = 3;
    public static final int limitSwitchLeftArmPull = 4;
    public static final int limitSwitchRightArmReach = 5;
    public static final int limitSwitchRightArmPull = 6;
    public static final int limitSwitchDumperUp = 7;
    public static final int limitSwitchDumperDown = 8;
    
    public static final int rightArmEncoderA = 11;
    public static final int rightArmEncoderB = 12;
    
    //relay
    public static final int dumperArmMotor = 6;
    public static final int rightSolenoid = 5;
    public static final int leftSolenoid = 4;
    public static final int climberChassis = 3;
    public static final int rearWheel = 2;
    public static final int lid = 1;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    public static int leftJoystick = 1;
}
