package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;

public class FlyWheel {
    public FlyWheel(DcMotor...motors){
        this.motors=motors;
    }

    public void setValues(boolean forward,boolean backward){
        if(forward)
            motors[M_UPPER_WHEEL].setPower(0.8);
        else if(backward)
            motors[M_UPPER_WHEEL].setPower(-0.8);
        else
            motors[M_UPPER_WHEEL].setPower(0);

    }
    DcMotor motors[];
}
