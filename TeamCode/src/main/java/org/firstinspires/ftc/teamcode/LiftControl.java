package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import static org.firstinspires.ftc.teamcode.ComponentsInit.ComponentMap.*;

public class LiftControl {
    public LiftControl(DcMotor... motors) {
        this.motors = motors;
    }

    public void setValues(boolean dpDown, boolean dpUp) {
        if (dpUp) {
            motors[M_BOTTOM_LIFT].setPower(1);
            motors[M_UPPER_LIFT].setPower(1);
        } else if (dpDown) {
            motors[M_BOTTOM_LIFT].setPower(-1);
            motors[M_UPPER_LIFT].setPower(-1);
        }
        else{
            motors[M_BOTTOM_LIFT].setPower(0);
            motors[M_UPPER_LIFT].setPower(0);
        }

    }

    DcMotor[] motors;
}
