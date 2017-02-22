package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;

public class ServoControl {

    public ServoControl(Servo...servos){
        this.servos=servos;
    }

    public void openLeft(){
        servos[S_TOP_LEFT].setPosition(0);
    }
    public void closeLeft(){
        servos[S_TOP_LEFT].setPosition(0.35);
    }

    public void openRight(){
        servos[S_TOP_RIGHT].setPosition(0.45);
    }
    public void closeRight(){
        servos[S_TOP_RIGHT].setPosition(1.0);
    }

    public void pull(){
        servos[S_WINCH].setPosition(0.65);
    }

    public void release(){
        servos[S_WINCH].setPosition(0.4);
    }

    Servo[] servos;
}
