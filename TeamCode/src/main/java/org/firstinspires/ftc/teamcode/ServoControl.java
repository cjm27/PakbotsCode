package org.firstinspires.ftc.teamcode;


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
        servos[S_INTAKE_FRONT].setPosition(1);
        servos[S_INTAKE_MID].setPosition(0);
        servos[S_INTAKE_REAR].setPosition(1);
    }

    public void intakeReverse(){
        servos[S_INTAKE_FRONT].setPosition(0);
        servos[S_INTAKE_MID].setPosition(1);
        servos[S_INTAKE_REAR].setPosition(0);
    }

    public void intakeStop(){

        servos[S_INTAKE_FRONT].setPosition(0.5);
        servos[S_INTAKE_MID].setPosition(0.5);
        servos[S_INTAKE_REAR].setPosition(0.5);
    }

    public void feedForward(){
        servos[S_FEED_TOP].setPosition(1);
        servos[S_FEED_BOTTOM].setPosition(1);
    }

    public void feedReverse(){
        servos[S_FEED_TOP].setPosition(0);
        servos[S_FEED_BOTTOM].setPosition(0);
    }

    public void feedStop(){
        servos[S_FEED_TOP].setPosition(0.5);
        servos[S_FEED_BOTTOM].setPosition(0.5);
    }


    Servo[] servos;
}
