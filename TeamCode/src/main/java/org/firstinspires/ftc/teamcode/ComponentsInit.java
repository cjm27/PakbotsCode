package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.adafruit.BNO055IMU;
import com.qualcomm.robotcore.hardware.AccelerationSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;

import com.qualcomm.robotcore.hardware.AnalogInput;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import static java.lang.Math.*;

public class ComponentsInit {
    private DcMotor mFL, mFR, mRL, mRR, mBL, mUW, mLW, mUL;
    private Servo sTL, sTR, sW;
    private CRServo sIT, sIB, sFT,sFB;
    private AnalogInput tbUP;
    private ColorSensor sColor;
    private Accelerometer sAccel;
    //private DistanceSensor distance;
    private DcMotor[] motors = {mFL, mFR, mRL, mRR, mBL, mUW, mLW, mUL};
    private CRServo[] crservos = {sIT, sIB,sFT,sFB};
    private Servo[] servos = {sTL, sTR, sW};
    private HardwareMap hardwareMap;
    private Gamepad gamepad1;

    Intake intake;
    FlyWheel flyWheel;
    LiftControl liftControl;
    HolonomicDrive hDrive;
    ServoControl servoControl;
    TankDrive tDrive;

    public ComponentsInit(HardwareMap hardwareMap, Gamepad gamepad1) {
        this.hardwareMap = hardwareMap;
        this.gamepad1 = gamepad1;

        sensorInit();
        MotorInit();
        crservoInit();
        servoInit();

        //liftControl=new LiftControl(motors);
        hDrive = new HolonomicDrive(motors);
        flyWheel=new FlyWheel(motors);
        intake=new Intake(crservos);
        tDrive=new TankDrive(motors);
        //servoControl=new ServoControl(servos);

    }

    public Intake getIntake() {
        return intake;
    }

    public FlyWheel getFlyWheel() {
        return flyWheel;
    }

    public LiftControl getLiftControl() {
        return liftControl;
    }
    public ServoControl getServoControl() {
        return servoControl;
    }

    public static final class ComponentMap {
        final static int M_FRONT_LEFT = 0;
        final static int M_FRONT_RIGHT = 1;
        final static int M_REAR_LEFT = 2;
        final static int M_REAR_RIGHT = 3;
        final static int M_BOTTOM_LIFT = 4;
        final static int M_UPPER_WHEEL = 5;
        final static int M_LOWER_WHEEL = 6;
        final static int M_UPPER_LIFT = 7; //newly added
        //servo
        final static int S_TOP_LEFT = 0;
        final static int S_TOP_RIGHT = 1;
        final static int S_WINCH = 2;
        //crservo
        final static int S_INTAKE_TOP = 0;
        final static int S_INTAKE_BOTTOM = 1;
        final static int S_FEED_TOP = 2;
        final static int S_FEED_BOTTOM = 3;
    }

    float driveX() {
        return gamepad1.left_stick_x;
    }

    float driveRY() {
        return -gamepad1.right_stick_y;
    }

    float driveR() {
        return gamepad1.right_stick_x;
    }

    float driveLY() {
        final float zero = 0.1f;
        float y = gamepad1.left_stick_y;
        if (abs(y) < zero)
            y = 0;
        else if (y > 0)
            y -= zero;
        else
            y += zero;
        return -y;
    }

    boolean leftTrigger(){
        return gamepad1.left_trigger >= 0.8;
    }

    boolean rightTrigger(){
        return gamepad1.right_trigger >= 0.8;
    }

    void sensorInit() {

        //tbUP=hardwareMap.analogInput.get("tbUP");
        //sColor=hardwareMap.colorSensor.get("color");
        //distance=hardwareMap.get(DistanceSensor.class,"distance");
        sAccel = new Accelerometer();
        sAccel.imu = hardwareMap.get(BNO055IMU.class, "accel");
    }

    void crservoInit() {
        crservos[S_INTAKE_TOP] = hardwareMap.crservo.get("it");
        crservos[S_INTAKE_BOTTOM] = hardwareMap.crservo.get("ib");

        crservos[S_FEED_TOP] = hardwareMap.crservo.get("tf");
        crservos[S_FEED_BOTTOM] = hardwareMap.crservo.get("bf");

    }

    void MotorInit() {
        motors[M_FRONT_LEFT] = hardwareMap.dcMotor.get("fl");
        motors[M_FRONT_RIGHT] = hardwareMap.dcMotor.get("fr");
        motors[M_REAR_LEFT] = hardwareMap.dcMotor.get("rl");
        motors[M_REAR_RIGHT] = hardwareMap.dcMotor.get("rr");
        motors[M_UPPER_WHEEL] = hardwareMap.dcMotor.get("uw");
        motors[M_LOWER_WHEEL] = hardwareMap.dcMotor.get("lw");
        motors[M_UPPER_LIFT] = hardwareMap.dcMotor.get("ul");//new
        motors[M_BOTTOM_LIFT] = hardwareMap.dcMotor.get("ll");//new

        //motors[M_FRONT_RIGHT].setDirection(DcMotorSimple.Direction.REVERSE);
        //motors[M_REAR_RIGHT].setDirection(DcMotorSimple.Direction.REVERSE);
        motors[M_FRONT_LEFT].setDirection(DcMotorSimple.Direction.REVERSE);
        motors[M_REAR_LEFT].setDirection(DcMotorSimple.Direction.REVERSE);
        motors[M_UPPER_LIFT].setDirection(DcMotorSimple.Direction.REVERSE);//new
        motors[M_BOTTOM_LIFT].setDirection(DcMotorSimple.Direction.REVERSE);//new
    }


    void servoInit() {
        servos[S_TOP_LEFT] = hardwareMap.servo.get("sl");
        servos[S_TOP_RIGHT] = hardwareMap.servo.get("sr");
        servos[S_TOP_RIGHT].setPosition(0.0);
        servos[S_WINCH] = hardwareMap.servo.get("w");

    }
    int getEncoderValue(int motor){
        return motors[motor].getCurrentPosition();
    }
    Accelerometer getAccel(){
        return sAccel;
    }


}
