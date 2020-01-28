package org.firstinspires.ftc.teamcode.TeamCode.src.main.java.org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.Chassis;
import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.FTCUtilities;
import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.Robot;

@Autonomous(name="PN_RedPlatform", group="Linear Opmode")

public class RedPlatform extends LinearOpMode {

    private Robot robot;
    private PlanRedPlatform Platform;

    @Override
    public void runOpMode() {
        FTCUtilities.setOpMode(this);
        robot = new Robot();
        robot.init();
        Chassis chassis = robot.getChassis();
        Platform = new PlanRedPlatform(chassis);

        waitForStart();
        Platform.run();
    }
}
