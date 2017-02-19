package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;
public class LiftControl {
    public LiftControl(DcMotor...motors){
        this.motors=motors;
    }

    public void setValues(boolean dpDown,boolean dpUp){
        if(dpUp)
            motors[M_BOTTOM_LIFT].setPower(0.6);
        else if(dpDown)
            motors[M_BOTTOM_LIFT].setPower(-0.6);

    }
    DcMotor[] motors;
}
