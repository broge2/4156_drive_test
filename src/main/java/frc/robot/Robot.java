/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick xboxController;

  @Override
  public void robotInit() {

    CANSparkMax m_frontLeft = new CANSparkMax(1, MotorType.kBrushless);
    CANSparkMax m_rearLeft = new CANSparkMax(2, MotorType.kBrushless);
    SpeedControllerGroup mLeft = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

    CANSparkMax m_frontRight = new CANSparkMax(3, MotorType.kBrushless);
    CANSparkMax m_rearRight = new CANSparkMax(4, MotorType.kBrushless);
    SpeedControllerGroup mRight = new SpeedControllerGroup(m_frontRight, m_rearRight);

    m_myRobot = new DifferentialDrive(mLeft, mRight);
    xboxController = new Joystick(0);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.arcadeDrive(xboxController.getRawAxis(1) * -1, xboxController.getRawAxis(4));
  }
}
