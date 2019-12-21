package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
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
        //motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        //motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setPower(double power){
        if(!direction){power=-power;}
        motor.setPower(power);
    }

    public void zeroDistance(){
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

//    public void adjustPower(double error){
//        double k=1;
//        motor.setPower(motor.getPower()+k*error);
//    }

    //this method should return the distance travelled in inches
    public double getInchesTravelled(){
        double ticksPerRevolution=753.2;

        int ticks = motor.getCurrentPosition();
        double revolutions = ticks/ticksPerRevolution;
        double distance = revolutions*wheelDiameter*Math.PI;

        FTCUtilities.getTelemetry().addData("Ticks: ",ticks);
        FTCUtilities.getTelemetry().update();

        return distance;

    }

}
