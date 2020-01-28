package org.firstinspires.ftc.teamcode.TeamCode.src.main.java.org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.Chassis;
import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.FTCUtilities;
import org.firstinspires.ftc.teamcode.TeamCode.src.main.java.backcountry.Robot;

@Autonomous(name="PN_BluePlatform", group="Linear Opmode")

public class BluePlatform extends LinearOpMode {

    private Robot robot;
    private PlanBluePlatform Platform;

    @Override
    public void runOpMode() {
        FTCUtilities.setOpMode(this);
        robot = new Robot();
        robot.init();
        Chassis chassis = robot.getChassis();
        Platform = new PlanBluePlatform(chassis);

        waitForStart();
        Platform.run();
    }
}
