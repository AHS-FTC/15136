package org.firstinspires.ftc.teamcode.TeamCode.src.main.java.org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.Chassis;
import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.FTCUtilities;
import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.Robot;

@Autonomous(name="AutoTest", group="Linear Opmode")

public class AutoTest extends LinearOpMode {

    private Robot robot;
    private PlanParkBlueNear test1;

    @Override
    public void runOpMode() {
        FTCUtilities.setOpMode(this);
        robot = new Robot();
        robot.init();
        Chassis chassis = robot.getChassis();
        test1 = new PlanParkBlueNear(chassis);

        waitForStart();
        test1.run();
    }
}
