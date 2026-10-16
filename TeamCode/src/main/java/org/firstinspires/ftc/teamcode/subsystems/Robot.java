package org.firstinspires.ftc.teamcode.subsystems;

import android.graphics.Color;
import android.util.Size;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.Camera;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.opencv.ColorBlobLocatorProcessor;
import org.firstinspires.ftc.vision.opencv.ColorRange;
import org.firstinspires.ftc.vision.opencv.ImageRegion;

// import com.seattlesolvers.solverslib.drivebase.MecanumDrive;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.seattlesolvers.solverslib.drivebase.DifferentialDrive;
import com.seattlesolvers.solverslib.hardware.RevIMU;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.servos.ServoEx;

public class Robot {
    public enum AllianceColor {
        RED,
        BLUE,
        UNKNOWN
    }
    public Telemetry telemetry;
    public ServoEx exampleServo;
    public DifferentialDrive drive;
    //public MecanumDrive drive;
    public RevIMU imu;

    public RevColorSensorV3 colorSensor;
    public Motor intakeMotor;
    public WebcamName webcamName;

    public AllianceColor alliance;

    public Robot(HardwareMap hardwareMap, Telemetry telemetry) {
        this.telemetry = telemetry;
        this.alliance = alliance;

        exampleServo = new ServoEx(hardwareMap, "servo_name");

        colorSensor = hardwareMap.get(RevColorSensorV3.class, "color_sensor");

        intakeMotor = new Motor(hardwareMap, "intake");

        webcamName = hardwareMap.get(WebcamName.class, "Webcam 1");

        Motor fl, fr, bl, br;
        fl = new Motor(hardwareMap, "frontLeft");
        fr = new Motor(hardwareMap, "frontRight");
        // bl = new Motor(hardwareMap, "backLeft", Motor.GoBILDA.RPM_435);
        // br = new Motor(hardwareMap, "backRight", Motor.GoBILDA.RPM_435);
        // drive = new MecanumDrive(fl, fr, bl, br);
        drive = new DifferentialDrive(fl, fr);

        RevIMU imu = new RevIMU(hardwareMap);
        imu.init();

        this.alliance = AllianceColor.UNKNOWN;
    }

    public void setAlliance(AllianceColor alliance) {
        this.alliance = alliance;
    }
    public AllianceColor getAlliance() {
        return this.alliance;
    }




}

