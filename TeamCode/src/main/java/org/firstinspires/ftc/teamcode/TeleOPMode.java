package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Func;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.M_FRONT_LEFT;

@TeleOp(name = "TeleOPMode")
public class TeleOPMode extends ComponentsInit {
    boolean intakeStatus = false;

    public void init() {
        super.sensorInit();
        super.MotorInit();
        super.crservoInit();
        //super.liftMortorInit();
        //liftControl=new LiftControl(super.getMotors());
        hDrive = new HolonomicDrive(super.getMotors());
        flyWheel=new FlyWheel(super.getMotors());
        intake=new Intake(super.getCRServos());
        //tDrive=new TankDrive(super.getMotors());
        //servoControl=new ServoControl(super.getServos());
        new Thread(sAccel).start();
        sAccel.composeTelemetry(telemetry);
    }

    public void loop() {
        hDrive.setValues(super.driveX(), super.driveLY(), super.driveR());
        if(leftTrigger()&& !toggle)
            toggle =true;
        else if(leftTrigger()&& toggle)
            toggle=false;

        intake.setIntakeValues( gamepad1.left_bumper,toggle);
        intake.setFeedValues(gamepad1.right_bumper,rightTrigger());
        flyWheel.setValues(gamepad1.y,gamepad1.a);
        //telemetry.addData("position ", hDrive.encoderValues(M_FRONT_LEFT));
        //sAccel.calcAccel();
        //telemetry.addData("position:", sAccel.positions.x+""+sAccel.positions.y+""+sAccel.positions.z+"");
    }
    boolean toggle=false;
    Intake intake;
    FlyWheel flyWheel;
    LiftControl liftControl;
    HolonomicDrive hDrive;
    TankDrive tDrive;
    ServoControl servoControl;
}
