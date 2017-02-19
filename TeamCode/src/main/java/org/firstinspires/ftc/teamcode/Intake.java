package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;
import com.qualcomm.robotcore.hardware.CRServo;

public class Intake {
    public Intake(CRServo...crservos){
        this.crservos=crservos;
    }
    public void forward(boolean forward){
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
    }

    CRServo[] crservos;
}
