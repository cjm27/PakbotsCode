package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;
import com.qualcomm.robotcore.hardware.CRServo;

public class Intake {
    public Intake(CRServo...crservos){
        this.crservos=crservos;
    }

    /*public void forward(boolean forward){
        if(forward)
            crservos[S_TOP_INTAKE].setPower(0.8);
        else
            crservos[S_TOP_INTAKE].setPower(0.5);
    }
    public void backward(boolean backward){
        if(backward)
            crservos[S_TOP_INTAKE].setPower(0.2);
        else
            crservos[S_TOP_INTAKE].setPower(0.5);
    }*/

    public void setValues(boolean intakeStatus, boolean leftTrigger, boolean leftBumper, boolean rightTrigger, boolean rightBumper){
        if (leftBumper && !intakeStatus)
            intakeForward();
        else if (leftTrigger)
            intakeReverse();
        else if(intakeStatus)
            intakeStop();
    }


    public void intakeForward(){
        crservos[S_INTAKE_FRONT].setPower(1);
        crservos[S_INTAKE_MID].setPower(0);
        crservos[S_INTAKE_REAR].setPower(1);
    }

    public void intakeReverse(){
        crservos[S_INTAKE_FRONT].setPower(0);
        crservos[S_INTAKE_MID].setPower(1);
        crservos[S_INTAKE_REAR].setPower(0);
    }

    public void intakeStop(){

        crservos[S_INTAKE_FRONT].setPower(0.5);
        crservos[S_INTAKE_MID].setPower(0.5);
        crservos[S_INTAKE_REAR].setPower(0.5);
    }

    public void feedForward(){
        crservos[S_FEED_TOP].setPower(1);
        crservos[S_FEED_BOTTOM].setPower(1);
    }

    public void feedReverse(){
        crservos[S_FEED_TOP].setPower(0);
        crservos[S_FEED_BOTTOM].setPower(0);
    }

    public void feedStop(){
        crservos[S_FEED_TOP].setPower(0.5);
        crservos[S_FEED_BOTTOM].setPower(0.5);
    }

    CRServo[] crservos;
}
