package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;

public class ServoControl {
    //TODO rename servos

    public ServoControl(Servo...servos){
        this.servos=servos;
    }

    public void open(){
        servos[S_TOP_LEFT].setPosition(0.8);
        servos[S_TOP_RIGHT].setPosition(0.8);
    }

    public void close(){
        servos[S_TOP_LEFT].setPosition(0.2);
        servos[S_TOP_RIGHT].setPosition(0.2);
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


    Servo[] servos;
    CRServo[] crservos;
}
