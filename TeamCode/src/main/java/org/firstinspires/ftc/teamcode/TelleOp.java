package org.firstinspires.ftc.teamcode.TeamCode.src.main.java.org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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
    private DcMotor intakeRight = null;
    private DcMotor intakeLeft = null;
    private DcMotor beltRight = null;
    private DcMotor beltLeft = null;
    private Servo intakeflop = null;

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
        intakeLeft  = hardwareMap.get(DcMotor.class, "intakeLeft");
        intakeRight = hardwareMap.get(DcMotor.class, "intakeRight");
        beltLeft  = hardwareMap.get(DcMotor.class, "beltLeft");
        beltRight = hardwareMap.get(DcMotor.class, "beltRight");
        intakeflop =hardwareMap.get(Servo.class,"intakeFlop");

        // Tell the driver that initialization is complete.
        telemetry.addData("Status", "Initialized");

        LeftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        LeftBack.setDirection(DcMotorSimple.Direction.REVERSE);
        RightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        RightFront.setDirection(DcMotorSimple.Direction.FORWARD);

        LeftFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LeftBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RightBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

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
        double drive = gamepad1.left_stick_y;
        double strafe  =  gamepad1.left_stick_x;
        double turn = gamepad1.right_stick_x;

        double frontLeft = drive - strafe - turn;
        double frontRight = drive + strafe + turn;
        double backLeft = drive + strafe - turn;
        double backRight = drive - strafe + turn;

        double intake = gamepad1.right_trigger;
        double intakeback = gamepad1.left_trigger;
        boolean belt = gamepad1.right_bumper;

        if(belt){
            beltRight.setPower(-1);
            beltLeft.setPower(1);
        }else{
            beltRight.setPower(0);
            beltLeft.setPower(0);
        }

        if(gamepad1.y) {
            intakeflop.setPosition(0);
        }

        intakeLeft.setPower(-intake);
        intakeRight.setPower(intake);
        intakeLeft.setPower(intakeback);
        intakeRight.setPower(-intakeback);

        RightBack.setPower(backRight);
        RightFront.setPower(frontRight);
        LeftBack.setPower(backLeft);
        LeftFront.setPower(frontLeft);
    }
    @Override
    public void stop() {
    }

}
