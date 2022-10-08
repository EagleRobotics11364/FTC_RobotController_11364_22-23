package org.firstinspires.ftc.teamcode.teamcode.gen1_meet1;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com      .qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class Beta_TeleOp extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        DcMotor rightFrontMotor = hardwareMap.get(DcMotor.class,"rightFrontMotor");
        DcMotor leftFrontMotor = hardwareMap.get(DcMotor.class,"leftFrontMotor");
        DcMotor rightRearMotor = hardwareMap.get(DcMotor.class,"rightRearMotor");
        DcMotor leftRearMotor = hardwareMap.get(DcMotor.class,"leftRearMotor");

        DcMotor armExtension = hardwareMap.get(DcMotor.class, "armExtension");
        Servo gripServo = hardwareMap.get(Servo.class,"gripServo");


        waitForStart();
        while (opModeIsActive()) {

            //Speed Control
            double speed;
            if (gamepad1.right_bumper) {
                speed = 1;
            } else if (gamepad1.left_bumper) {
                speed = 0.3;
            } else {
                speed = 0.5;
            }

            //Controller Input - Moves Drive Train
            double vertical = gamepad1.left_stick_y * speed;
            double horizontal = -gamepad1.left_stick_x * speed; //Normal is negative
            double pivot = -gamepad1.right_stick_x * speed; //Normal has negative

            rightFrontMotor.setPower(pivot - vertical + horizontal);
            leftFrontMotor.setPower(pivot + vertical + horizontal);
            rightRearMotor.setPower(pivot - vertical - horizontal);
            leftRearMotor.setPower(pivot + vertical - horizontal);

            //Arm Extension
            double value = gamepad2.left_stick_y
        }

        rightFrontMotor.setPower(0.0);
        leftFrontMotor.setPower(0.0);
        rightRearMotor.setPower(0.0);
        leftRearMotor.setPower(0.0);
        armExtension.setPower(0.0);

    }


}
