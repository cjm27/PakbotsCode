package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.adafruit.BNO055IMU;
import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import java.util.Locale;

public class Accelerometer implements Runnable{
    BNO055IMU imu;

    Orientation angles;
    Position positions;
    Acceleration accel;

    public void run(){
        initAccel();
    }
    public void initAccel() {
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "AdafruitIMUCalibration.json"; // see the calibration sample opmode

        imu.initialize(parameters);
        angles   = imu.getAngularOrientation().toAxesReference(AxesReference.INTRINSIC).toAxesOrder(AxesOrder.ZYX);
        positions=imu.getPosition();
        accel=imu.getLinearAcceleration();

    }
    Position getPosition(){
        return positions.toUnit(positions.unit.CM);
    }
    Orientation getOrientation(){
        return angles;
    }

    void composeTelemetry(Telemetry telemetry) {
        telemetry.addAction(new Runnable() { @Override public void run()
        {
            angles   = imu.getAngularOrientation().toAxesReference(AxesReference.INTRINSIC).toAxesOrder(AxesOrder.ZYX);
            positions= imu.getPosition();
            accel  = imu.getLinearAcceleration();
        }
        });

        telemetry.addLine()
                .addData("status", new Func<String>() {
                    @Override public String value() {
                        return imu.getSystemStatus().toShortString();
                    }
                })
                .addData("calib", new Func<String>() {
                    @Override public String value() {
                        return imu.getCalibrationStatus().toString();
                    }
                });

        telemetry.addLine()
                .addData("heading", new Func<String>() {
                    @Override public String value() {
                        return formatAngle(angles.angleUnit, angles.firstAngle);
                    }
                })
                .addData("roll", new Func<String>() {
                    @Override public String value() {
                        return formatAngle(angles.angleUnit, angles.secondAngle);
                    }
                })
                .addData("pitch", new Func<String>() {
                    @Override public String value() {
                        return formatAngle(angles.angleUnit, angles.thirdAngle);
                    }
                });
        telemetry.addLine()
                .addData("x", new Func<String>() {
                    @Override public String value() {
                        return positions.x+"";
                    }
                })
                .addData("y", new Func<String>() {
                    @Override public String value() {
                        return positions.y+"";
                    }
                })
                .addData("z", new Func<String>() {
                             public String value() {
                        return positions.z+"";
                    }
                });
        telemetry.addLine()
                .addData("x", new Func<String>() {
                    @Override public String value() {
                        return accel.xAccel+"";
                    }
                })
                .addData("y", new Func<String>() {
                    @Override public String value() {
                        return accel.yAccel+"";
                    }
                })
                .addData("z", new Func<String>() {
                    public String value() {
                        return accel.zAccel+"";
                    }
                });

    }


    String formatAngle(AngleUnit angleUnit, double angle) {
        return formatDegrees(AngleUnit.DEGREES.fromUnit(angleUnit, angle));
    }

    String formatDegrees(double degrees){
        return String.format(Locale.getDefault(), "%.1f", AngleUnit.DEGREES.normalize(degrees));
    }

}