package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;

public class FlyWheel {
    public FlyWheel(DcMotor...motors){
        this.motors=motors;
    }

    public void forward(boolean forward){
        if(forward)
            motors[M_UPPER_LIFT].setPower(0.8);
        else
            motors[M_UPPER_LIFT].setPower(0);
    }
    public void backward(boolean backward){
        if(backward)
            motors[M_UPPER_LIFT].setPower(-0.8);
        else
            motors[M_UPPER_LIFT].setPower(0);
    }
    DcMotor motors[];
}
