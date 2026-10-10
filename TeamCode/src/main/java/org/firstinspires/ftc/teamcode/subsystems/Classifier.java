package org.firstinspires.ftc.teamcode.subsystems;

import android.graphics.Color;

import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.seattlesolvers.solverslib.command.Subsystem;

public class Classifier implements Subsystem {

    public enum Balltype {
        POLLEN,
        BLUENECTAR,
        REDNECTAR,

        UNKNOWN
    }

    Robot robot;

    public Classifier(Robot robot) {
        this.robot = robot;
    }

    public Balltype id() {
        final float[] hsvValues = new float[3];
        NormalizedRGBA colors = robot.colorSensor.getNormalizedColors();
        Color.colorToHSV(colors.toColor(), hsvValues);

        if (hsvValues[0] < 30) {
            return Balltype.REDNECTAR;
        }
        if (hsvValues[0] < 120 && hsvValues[0] > 60) {
            return Balltype.POLLEN;
        }
        if (hsvValues[0] < 240) {
            return Balltype.BLUENECTAR;
        }
        return Balltype.UNKNOWN;

    }
}