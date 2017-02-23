package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.adafruit.BNO055IMU;
import com.qualcomm.hardware.adafruit.NaiveAccelerationIntegrator;
import com.qualcomm.robotcore.util.RobotLog;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

import static org.firstinspires.ftc.robotcore.external.navigation.NavUtil.meanIntegrate;
import static org.firstinspires.ftc.robotcore.external.navigation.NavUtil.plus;

/**
 * Created by rstudent on 2/22/2017.
 */

public class Integrator implements BNO055IMU.AccelerationIntegrator{

        BNO055IMU.Parameters parameters;
        Position position;
        Velocity velocity;
        Acceleration acceleration;

        public Position getPosition() { return this.position; }
        public Velocity getVelocity() { return this.velocity; }
        public Acceleration getAcceleration() { return this.acceleration; }
        public void initialize(BNO055IMU.Parameters parameters, Position initialPosition, Velocity initialVelocity)
        {
            this.parameters = parameters;
            this.position = initialPosition;
            this.velocity = initialVelocity;
            this.acceleration = null;
        }

        public void update(Acceleration linearAcceleration)
            {
            linearAcceleration.xAccel=(int)(linearAcceleration.xAccel+0.5);
            linearAcceleration.yAccel=(int)(linearAcceleration.yAccel+0.5);
            linearAcceleration.zAccel=(int)(linearAcceleration.zAccel+0.5);
            // We should always be given a timestamp here
            if (linearAcceleration.acquisitionTime != 0)
            {
                // We can only integrate if we have a previous acceleration to baseline from
                if (acceleration != null)
                {
                    Acceleration accelPrev    = acceleration;
                    Velocity     velocityPrev = velocity;

                    acceleration = linearAcceleration;

                    if (accelPrev.acquisitionTime != 0)
                    {
                        Velocity deltaVelocity = meanIntegrate(acceleration, accelPrev);
                        velocity = plus(velocity, deltaVelocity);
                    }

                    if (velocityPrev.acquisitionTime != 0)
                    {
                        Position deltaPosition = meanIntegrate(velocity, velocityPrev);
                        position = plus(position, deltaPosition);
                    }

                    if (parameters.loggingEnabled)
                    {
                        RobotLog.vv(parameters.loggingTag, "dt=%.3fs accel=%s vel=%s pos=%s", (acceleration.acquisitionTime - accelPrev.acquisitionTime)*1e-9, acceleration, velocity, position);
                    }
                }
                else
                    acceleration = linearAcceleration;
            }
        }
    }


