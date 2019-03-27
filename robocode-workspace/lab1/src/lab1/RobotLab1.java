package lab1;
import java.awt.Color;
import static robocode.util.Utils.normalRelativeAngleDegrees;

import robocode.*;


public class RobotLab1 extends Robot {

		public void run() {

			while(true) {
				// Replace the next 4 lines with any behavior you would like
				setBodyColor(Color.red);
				setGunColor(Color.black);
				setRadarColor(Color.yellow);
				setBulletColor(Color.PINK);
				setScanColor(Color.green);
				
				ahead(100);
				turnGunRight(360);
				back(100);
				turnGunRight(360);
			}
		}

		/**
		 * onScannedRobot: What to do when you see another robot
		 */
		public void onScannedRobot(ScannedRobotEvent e) {
			// Replace the next line with any behavior you would like
			double absoluteBearing = getHeading() + e.getBearing();
			double bearingFromGun = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());

			// If it's close enough, fire!
			if (Math.abs(bearingFromGun) <= 3) {
				turnGunRight(bearingFromGun);

				if (getGunHeat() == 0) {
					if(e.getDistance()<50) fire(100);
					else if(e.getDistance()>=50) fire(5);
					
				}
			} 
			
			else {
				turnGunRight(bearingFromGun);
			}
			if (bearingFromGun == 0) {
				scan();
			
			}
		}

		/**
		 * onHitByBullet: What to do when you're hit by a bullet
		 */
		public void onHitByBullet(HitByBulletEvent e) {
			// Replace the next line with any behavior you would like
			turnLeft(30);
			back(10);
		}
		
		/**
		 * onHitWall: What to do when you hit a wall
		 */
		public void onHitWall(HitWallEvent e) {
			// Replace the next line with any behavior you would like
			back(50);
			turnRight(45);
			ahead(50);
			
		}	
	}

	

