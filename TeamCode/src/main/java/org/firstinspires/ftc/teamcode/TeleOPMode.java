package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Func;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.M_FRONT_LEFT;

@TeleOp(name = "TeleOPMode")
public class TeleOPMode extends ComponentsInit {
    public void init() {
        super.sensorInit();
        super.MotorInit();
        //super.liftMortorInit();
        //liftControl=new LiftControl(super.getMotors());
        hDrive = new HolonomicDrive(super.getMotors());
        //flyWheel=new FlyWheel(super.getMotors());
        //intake=new Intake(super.getCRServos());
        //tDrive=new TankDrive(super.getMotors());
        //servoControl=new ServoControl(super.getServos());

        //sAccel.composeTelemetry(telemetry);
    }

    public void loop() {
        hDrive.setValues(super.driveX(), super.driveLY(), super.driveR());
        //telemetry.addData("position ", hDrive.encoderValues(M_FRONT_LEFT));
        //sAccel.calcAccel();
        //telemetry.addData("position:", sAccel.positions.x+""+sAccel.positions.y+""+sAccel.positions.z+"");

    }

    Intake intake;
    FlyWheel flyWheel;
    LiftControl liftControl;
    HolonomicDrive hDrive;
    TankDrive tDrive;
    ServoControl servoControl;
}
