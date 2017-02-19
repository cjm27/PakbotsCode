package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;

public class FlyWheel {
    public FlyWheel(DcMotor...motors){
        this.motors=motors;
    }

    public void setValues(boolean forward,boolean backward){
        if(forward) {
            motors[M_UPPER_WHEEL].setPower(1.0);
            motors[M_LOWER_WHEEL].setPower(-1.0);
        }
        else if(backward){
            motors[M_UPPER_WHEEL].setPower(-1.0);
            motors[M_LOWER_WHEEL].setPower(1.0);
        }
        else{
            motors[M_UPPER_WHEEL].setPower(0);
            motors[M_LOWER_WHEEL].setPower(0);
        }
    }
    DcMotor motors[];
}
