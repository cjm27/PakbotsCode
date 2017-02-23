package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.adafruit.BNO055IMU;
import com.qualcomm.hardware.adafruit.JustLoggingAccelerationIntegrator;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import java.util.Locale;

public class Accelerometer implements Runnable{
    BNO055IMU imu;

    // State used for updating telemetry
     Orientation angles;
     Acceleration accel;
     Position position;

     public void run(){
         calcAccel();
         while(true){
             angles=imu.getAngularOrientation().toAxesReference(AxesReference.INTRINSIC).toAxesOrder(AxesOrder.ZYX);
             accel=imu.getLinearAcceleration();
             position=imu.getPosition().toUnit(DistanceUnit.CM);
         }
     }
     public void calcAccel() {
         BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
         parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
         parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
         parameters.calibrationDataFile = "AdafruitIMUCalibration.json";
         parameters.accelerationIntegrationAlgorithm = new Integrator();
         angles=imu.getAngularOrientation().toAxesReference(AxesReference.INTRINSIC).toAxesOrder(AxesOrder.ZYX);
         accel=imu.getLinearAcceleration();
         position=imu.getPosition();
         imu.initialize(parameters);
         imu.startAccelerationIntegration(position, new Velocity(), 100);

    }
    void composeTelemetry(Telemetry telemetry) {

        // At the beginning of each telemetry update, grab a bunch of data
        // from the IMU that we will then display in separate lines.
        telemetry.addAction(new Runnable() { @Override public void run()
        {
            // Acquiring the angles is relatively expensive; we don't want
            // to do that in each of the three items that need that info, as that's
            // three times the necessary expense.
            angles   = imu.getAngularOrientation().toAxesReference(AxesReference.INTRINSIC).toAxesOrder(AxesOrder.ZYX);
            accel=imu.getLinearAcceleration();
            position=imu.getPosition().toUnit(DistanceUnit.CM);
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
                .addData("x accel", new Func<String>() {
                    @Override public String value() {
                        return accel.xAccel+"";
                    }
                })
                .addData("y accel", new Func<String>() {
                    @Override public String value() {
                        return accel.yAccel+"";
                    }
                })
                .addData("z accel", new Func<String>() {
                    @Override public String value() {
                        return accel.zAccel+"";
                    }
                });
        telemetry.addLine()
                .addData("x", new Func<String>() {
                    @Override public String value() {
                        return position.x+"";
                    }
                })
                .addData("y", new Func<String>() {
                    @Override public String value() {
                        return position.y+"";
                    }
                })
                .addData("z", new Func<String>() {
                    @Override public String value() {
                        return position.z+"";
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