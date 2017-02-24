package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;
@TeleOp(name = "TeleOPMode")
public class TeleOPMode extends OpMode {

    ComponentsInit comp;

    public void init() {
        comp = new ComponentsInit(hardwareMap, gamepad1);
        new Thread(comp.getAccel()).start();
        comp.getAccel().composeTelemetry(telemetry);
        time=System.currentTimeMillis();
       // comp.getServoControl().release();
    }

    public void loop() {

        comp.hDrive.setValues(comp.driveX(), comp.driveLY(), comp.driveR());
        /*
        if(gamepad1.y&& (System.currentTimeMillis()-time)>=250) {
            time=System.currentTimeMillis();
            toggle = !toggle;
        }
        comp.getIntake().setIntakeValues(gamepad1.left_bumper,comp.leftTrigger());
        comp.getIntake().setFeedValues(gamepad1.right_bumper,comp.rightTrigger());
        comp.getFlyWheel().setValues(gamepad1.a,toggle);
        comp.getLiftControl().setValues(gamepad1.dpad_up, gamepad1.dpad_down);
        if(gamepad1.dpad_right)
            comp.getServoControl().openLeft();
        else if(gamepad1.dpad_left)
                comp.getServoControl().closeLeft();
        if (gamepad1.x) comp.getServoControl().openRight();
            else if(gamepad1.b) comp.getServoControl().closeRight();

        if(gamepad1.start){
            comp.getServoControl().pull();
        } else if (gamepad1.guide){
            comp.getServoControl().release();
        }
        */
        telemetry.addData("rotation ",comp.getEncoderValue(M_FRONT_LEFT));

    }
    double time;
    boolean toggle=false;
}
