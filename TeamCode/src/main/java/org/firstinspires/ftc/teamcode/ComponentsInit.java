package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.adafruit.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AccelerationSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;

import com.qualcomm.robotcore.hardware.AnalogInput;

import static java.lang.Math.*;

public abstract class ComponentsInit extends OpMode {
    DcMotor mFL, mFR, mRL, mRR, mBL, mUW, mLW;
    Servo sTL, sTR;
    CRServo sTI, sLI, sRI;
    AnalogInput tbUP;
    ColorSensor sColor;
    Accelerometer sAccel = new Accelerometer();
    private DcMotor[] motors = {mFL, mFR, mRL, mRR, mBL, mUW, mLW};
    private CRServo[] crservos = {sTI, sLI, sRI};
    private Servo[] servos = {sTL, sTR};

    public static final class ComponentMap {
        final static int M_FRONT_LEFT = 0;
        final static int M_FRONT_RIGHT = 1;
        final static int M_REAR_LEFT = 2;
        final static int M_REAR_RIGHT = 3;
        final static int M_BOTTOM_LIFT = 4;
        final static int M_UPPER_WHEEL = 5;
        final static int M_LOWER_WHEEL = 6;
        //servo
        final static int S_TOP_LEFT = 0;
        final static int S_TOP_RIGHT = 1;
        //crservo
        final static int S_INTAKE_FRONT = 0;
        final static int S_INTAKE_MID = 1;
        final static int S_INTAKE_REAR = 2;
        final static int S_FEED_TOP = 3;
        final static int S_FEED_BOTTOM = 4;
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
        sAccel.imu = hardwareMap.get(BNO055IMU.class, "accel");
    }

    void crservoInit() {
        //crservos[S_TOP_INTAKE]=hardwareMap.crservo.get("ti");
        //crservos[S_RIGHT_INTAKE]=hardwareMap.crservo.get("ri");
        //crservos[S_LEFT_INTAKE]=hardwareMap.crservo.get("li");
        crservos[S_INTAKE_FRONT] = hardwareMap.crservo.get("fi");
        crservos[S_INTAKE_MID] = hardwareMap.crservo.get("mi");
        crservos[S_INTAKE_REAR] = hardwareMap.crservo.get("ri");

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

        //motors[M_FRONT_RIGHT].setDirection(DcMotorSimple.Direction.REVERSE);
        //motors[M_REAR_RIGHT].setDirection(DcMotorSimple.Direction.REVERSE);
        motors[M_FRONT_LEFT].setDirection(DcMotorSimple.Direction.REVERSE);
        motors[M_REAR_LEFT].setDirection(DcMotorSimple.Direction.REVERSE);
        //motors[M_UPPER_LIFT].setDirection(DcMotorSimple.Direction.REVERSE);
    }


    void servoInit() {
        servos[S_TOP_LEFT] = hardwareMap.servo.get("sl");
        servos[S_TOP_RIGHT] = hardwareMap.servo.get("sr");

    }

    CRServo[] getCRServos() {
        return crservos;
    }

    Servo[] getServos() {
        return servos;
    }

    DcMotor[] getMotors() {
        return motors;
    }

}
