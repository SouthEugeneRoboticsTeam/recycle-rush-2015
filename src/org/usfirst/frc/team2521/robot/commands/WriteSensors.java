package org.usfirst.frc.team2521.robot.commands;
import org.usfirst.frc.team2521.robot.Robot;
import org.usfirst.frc.team2521.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class WriteSensors extends Command {

    public WriteSensors() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.sensors);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("X Angle", Robot.sensors.getAngleX());
    	SmartDashboard.putNumber("Y Angle", Robot.sensors.getAngleY());
    	SmartDashboard.putNumber("Z Angle", Robot.sensors.getAngleZ());
    	SmartDashboard.putNumber("Conveyor current", Robot.sensors.getCurrent(RobotMap.CONVEYOR_PDP));;
    	SmartDashboard.putBoolean("Tote hooked", Robot.sensors.getCurrent(RobotMap.CONVEYOR_PDP) >= RobotMap.TOTE_CURRENT);
    	SmartDashboard.putNumber("Filtered Angle", Robot.sensors.getComplementaryAngle());
    	SmartDashboard.putNumber("Filtered Angle", Robot.sensors.getDataBasedAngle());
    	SmartDashboard.putNumber("Low pass angle", Robot.sensors.getLPAngle());
    	SmartDashboard.putNumber("Empty Analog", Robot.sensors.getBlank());
    	SmartDashboard.putNumber("Error", Robot.sensors.getDBFilterError());
    	Robot.sensors.sensorLog();
    	Robot.sensors.joystickLog();
    	Robot.sensors.commandLog();
    	Robot.sensors.batteryLog();
    	SmartDashboard.putNumber("X", Robot.sensors.getNewAccelX());
    	SmartDashboard.putNumber("Y", Robot.sensors.getNewAccelY());
    	SmartDashboard.putNumber("Z", Robot.sensors.getNewAccelZ());
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
