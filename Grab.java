import ShefRobot.*;

public class Grab {


    public static Robot myRobot = new Robot("dia-lego-e5");

    public static ColorSensor sensor =
      myRobot.getColorSensor(Sensor.Port.S1);
    public static GyroSensor angle =
      myRobot.getGyroSensor(Sensor.Port.S2);
    public static Motor leftMotor =
      myRobot.getLargeMotor(Motor.Port.A);
    public static Motor rightMotor =
      myRobot.getLargeMotor(Motor.Port.D);
    public static Motor grapple =
      myRobot.getMediumMotor(Motor.Port.C);
    public static Speaker mySpeaker = myRobot.getSpeaker();


        public static void openGrab (int speed, int wait) {
          grapple.setSpeed(speed);
          grapple.forward();
          myRobot.sleep(wait);
          grapple.stop();
        }


        public static void closeGrab (int speed, int wait) {
          grapple.setSpeed(speed);
          grapple.backward();
          myRobot.sleep(wait);
          grapple.stop();
        }

        	  public static void main(String[] args) {
              //closeGrab(500,1800);
              openGrab(500,200);

            }
            }
