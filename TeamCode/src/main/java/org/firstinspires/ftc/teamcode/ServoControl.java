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
        servos[INTAKE_1].setPosition(1);
        servos[INTAKE_2].setPosition(0);
        servos[INTAKE_3].setPosition(1);
    }

    public void intakeReverse(){
        servos[INTAKE_1].setPosition(0);
        servos[INTAKE_2].setPosition(1);
        servos[INTAKE_3].setPosition(0);
    }

    public void intakeStop(){

        servos[INTAKE_1].setPosition(0.5);
        servos[INTAKE_2].setPosition(0.5);
        servos[INTAKE_3].setPosition(0.5);
    }

    public void feedForward(){
        servos[FEED_1].setPosition(1);
        servos[FEED_2].setPosition(1);
    }

    public void feedReverse(){
        servos[FEED_1].setPosition(1);
        servos[FEED_2].setPosition(1);
    }

    public void feedStop(){
        servos[FEED_1].setPosition(1);
        servos[FEED_2].setPosition(1);
    }


    Servo[] servos;
}
