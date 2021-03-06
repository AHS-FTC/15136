package org.firstinspires.ftc.teamcode.TeamCode.src.main.java.org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.Chassis;
import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.FTCUtilities;
import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.Robot;

@Autonomous(name="NI_BlueDepo", group="Linear Opmode")

public class BlueDepo extends LinearOpMode {

    private Robot robot;
    private PlanBlueDepo Depo;
    private Servo intakeflop = null;

    @Override
    public void runOpMode() {
        FTCUtilities.setOpMode(this);
        robot = new Robot();
        robot.init();
        Chassis chassis = robot.getChassis();
        intakeflop =hardwareMap.get(Servo.class,"intakeFlop");
        Depo = new PlanBlueDepo(chassis);


        waitForStart();
        intakeflop.setPosition(0);
        Depo.run();
    }
}
