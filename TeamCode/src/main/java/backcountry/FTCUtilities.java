package org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class FTCUtilities {

    private static HardwareMap hardwareMap;
    private static Telemetry telemetry;
    private static OpMode opMode;


    public static HardwareMap getHardwareMap(){
        return hardwareMap;
    }

    public static void setTelemetry(Telemetry t){
        FTCUtilities.telemetry = t;
    }

    public static Telemetry getTelemetry(){
        return telemetry;
    }

    public static void setOpMode(OpMode o){
        FTCUtilities.opMode = o;
        hardwareMap = o.hardwareMap;
    }
    public static OpMode getOpMode(){
        return opMode;
    }

    public static void getTelemetry(String caption, Object object){
        opMode.telemetry.addData(caption, object);
        opMode.telemetry.update();
    }

    public static BNO055IMU getIMU (String imuName){
        return hardwareMap.get(BNO055IMU.class, imuName);
    }

    public static DcMotor getMotor(String deviceName) {
        return hardwareMap.get(DcMotor.class, deviceName);
    }

    public static void OpSleep(int ms){
        ((LinearOpMode) opMode).sleep(ms);
    }
}
