package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;
import com.qualcomm.robotcore.hardware.CRServo;

public class Intake {
    public Intake(CRServo...crservos){
        this.crservos=crservos;
        intakeStop();
    }

    public void setIntakeValues(boolean forward, boolean backward){
        if (forward)
            intakeForward();
        else if (backward)
            intakeReverse();
        else
            intakeStop();
    }
    public void setFeedValues(boolean forward, boolean backward){
        if(forward)
            feedForward();
        else if(backward)
            feedReverse();
        else
            feedStop();

    }

    public void intakeForward(){
        crservos[S_INTAKE_BOTTOM].setPower(1);
        crservos[S_INTAKE_TOP].setPower(-1.0);
    }

    public void intakeReverse(){
        crservos[S_INTAKE_BOTTOM].setPower(-1.0);
        crservos[S_INTAKE_TOP].setPower(1);
    }

    public void intakeStop(){

        crservos[S_INTAKE_TOP].setPower(0);
        crservos[S_INTAKE_BOTTOM].setPower(0);
    }

    public void feedForward(){
        crservos[S_FEED_TOP].setPower(1);
        crservos[S_FEED_BOTTOM].setPower(1);
    }

    public void feedReverse(){
        crservos[S_FEED_TOP].setPower(-1.0);
        crservos[S_FEED_BOTTOM].setPower(-1.0);
    }

    public void feedStop(){
        crservos[S_FEED_TOP].setPower(0);
        crservos[S_FEED_BOTTOM].setPower(0);
    }

    CRServo[] crservos;
}
