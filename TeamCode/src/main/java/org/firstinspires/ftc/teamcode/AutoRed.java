package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by rstudent on 2/23/2017.
 */
@Autonomous(name = "Red")
public class AutoRed extends LinearOpMode{
    public void runOpMode(){
        runtime = new ElapsedTime();
        ComponentsInit comp=new ComponentsInit(hardwareMap,gamepad1);
        runtime.reset();
        while(runtime.seconds()<=1){
            comp.tDrive.setValues(0.8,0.8);
        }
        comp.tDrive.setValues(0,0);
        runtime.reset();
        while(runtime.seconds()<=2){
            if(runtime.seconds()>=1.5) {
                comp.getIntake().setFeedValues(true, false);
            }
            comp.getFlyWheel().setValues(true,false);
        }
        comp.getIntake().setFeedValues(false, false);
        comp.getFlyWheel().setValues(false,false);
    }
    ElapsedTime runtime;
}
