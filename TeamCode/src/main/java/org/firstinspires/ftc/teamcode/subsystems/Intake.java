package org.firstinspires.ftc.teamcode.subsystems;

import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.Subsystem;

public class Intake implements Subsystem {

  Robot robot;

  public Intake(Robot robot) {
      this.robot = robot;
  }


  @Override
  public void periodic() {
  }

  public void runIntake() {
    robot.intakeMotor.setPower(.5);
  }

  public void stop() {
    robot.intakeMotor.setPower(0);
  }

  public Command intakeOn() {
    return new InstantCommand(this::runIntake);
  }

  public Command intakeOff() {
    return new InstantCommand(this::stop);
  }
    }