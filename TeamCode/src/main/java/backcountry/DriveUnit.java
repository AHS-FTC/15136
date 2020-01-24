package org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
//import com.qualcomm.robotcore.eventloop.opmode.OpMode;

public class DriveUnit {
    private double gearRatio;
    private double wheelDiameter;
    private String deviceName;
    private HardwareMap hardwareMap;
    private DcMotor motor;
    private boolean direction;
    //private static OpMode opmode;


    public DriveUnit(double gearRatio, double wheelDiameter, String deviceName, boolean direction) {
        this.gearRatio = gearRatio;
        this.wheelDiameter = wheelDiameter;
        this.deviceName = deviceName;
        this.direction = direction;
        init();
    }

    public void init(){
        motor = FTCUtilities.getHardwareMap().get(DcMotor.class,deviceName);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setPower(double power){
        if(!direction){power=-power;}
        motor.setPower(power);
    }

    public void zeroDistance(){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }

    //this method should return the distance travelled in inches
    public double getInchesTravelled(){
        double ticksPerRevolution=537.6;

        int ticks = motor.getCurrentPosition();
        double revolutions = ticks/ticksPerRevolution;
        double distance = revolutions*wheelDiameter*Math.PI;


        return Math.abs(distance);

    }

}
