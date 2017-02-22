package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Func;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.M_FRONT_LEFT;

@TeleOp(name = "TeleOPMode")
public class TeleOPMode extends ComponentsInit {
    boolean intakeStatus = false;

    public void init() {
        //super.sensorInit();
        super.MotorInit();
        super.crservoInit();
        super.servoInit();
        liftControl=new LiftControl(super.getMotors());
        hDrive = new HolonomicDrive(super.getMotors());
        flyWheel=new FlyWheel(super.getMotors());
        intake=new Intake(super.getCRServos());
        //tDrive=new TankDrive(super.getMotors());
        servoControl=new ServoControl(super.getServos());
        //`new Thread(getAccel()).start();
        //getAccel().composeTelemetry(telemetry);
        time=System.currentTimeMillis();
    }

    public void loop() {
        hDrive.setValues(super.driveX(), super.driveLY(), super.driveR());
        if(gamepad1.y&& (System.currentTimeMillis()-time)>=250) {
            time=System.currentTimeMillis();
            toggle = !toggle;
        }
        intake.setIntakeValues(gamepad1.left_bumper,leftTrigger());
        intake.setFeedValues(gamepad1.right_bumper,rightTrigger());
        flyWheel.setValues(gamepad1.a,toggle);
        liftControl.setValues(gamepad1.dpad_up, gamepad1.dpad_down);
        if(gamepad1.x)
            servoControl.open();
        else if(gamepad1.b)
            servoControl.close();

        //telemetry.addData("position ", hDrive.encoderValues(M_FRONT_LEFT));
        //sAccel.calcAccel();
        //telemetry.addData("position:", sAccel.positions.x+""+sAccel.positions.y+""+sAccel.positions.z+"");
    }
    double time;
    boolean toggle=false;
    Intake intake;
    FlyWheel flyWheel;
    LiftControl liftControl;
    HolonomicDrive hDrive;
    TankDrive tDrive;
    ServoControl servoControl;
}
