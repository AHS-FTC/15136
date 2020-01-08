package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TelleOp", group="Iterative Opmode")
public class TelleOp extends OpMode
{
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor RightFront = null;
    private DcMotor LeftFront = null;
    private DcMotor RightBack = null;
    private DcMotor LeftBack = null;

    /*
     * Code to run ONCE when the driver hits INIT
     */
    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");

        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).
        RightFront  = hardwareMap.get(DcMotor.class, "RightFront");
        LeftFront = hardwareMap.get(DcMotor.class, "LeftFront");
        RightBack  = hardwareMap.get(DcMotor.class, "RightBack");
        LeftBack = hardwareMap.get(DcMotor.class, "LeftBack");

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        runtime.reset();
    }

    @Override
    public void loop() {

        double RightBackPower;
        double LeftBackPower;
        double RightFrontPower;
        double LeftFrontPower;

        double strafe = -gamepad1.right_stick_y;
        double drive  =  gamepad1.right_stick_x;
        double turn = gamepad1.left_stick_x;
        RightBackPower    = Range.clip(drive, -1.0, 1.0) ;
        LeftBackPower   = Range.clip(drive, -1.0, 1.0) ;
        RightFrontPower    = Range.clip(drive, -1.0, 1.0) ;
        LeftFrontPower   = Range.clip(drive, -1.0, 1.0) ;

        RightBackPower    = Range.clip(strafe, 1.0, -1.0) ;
        LeftBackPower   = Range.clip(strafe, -1.0, 1.0) ;
        RightFrontPower    = Range.clip(strafe, 1.0, -1.0) ;
        LeftFrontPower   = Range.clip(strafe, -1.0, 1.0) ;

        RightBackPower = Range.clip(turn, -1.0, 1.0);
        RightFrontPower = Range.clip(turn,-1.0, 1.0);
        LeftBackPower = Range.clip(turn,1.0,-1.0);
        LeftFrontPower = Range.clip(turn,1.0,-1.0);



        // Send calculated power to wheels
        RightBack.setPower(RightBackPower);
        RightFront.setPower(LeftBackPower);
        LeftBack.setPower(RightFrontPower);
        LeftFront.setPower(LeftFrontPower);
    }

    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }

}
