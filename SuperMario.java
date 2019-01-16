import ShefRobot.*;


public class SuperMario {

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


  public static boolean ball = false;
  final static int SPEED = 100;
  final static int WAIT = 50;


  public static void playSound (int pitch, int length) {
    mySpeaker.playTone(pitch,length);
  }

  public static void rotateRight (int rotation) {
    angle.reset();
    angle.getAngle();
    rightMotor.rotate(rotation);
  }

  public static void rotateLeft (int rotation) {
    angle.reset();
    angle.getAngle();
    leftMotor.rotate(rotation);
  }

	public static void main(String[] args) {
    rightMotor.setSpeed(100);
    leftMotor.setSpeed(100);

  //  rotateRight(-70);

    rotateLeft(-90);

/*
playSound(2,520);
playSound(659,10);
playSound(2,130);
playSound(659,21);
playSound(2,260);
playSound(659,10);
playSound(2,130);
//    rest);
*/
/*
playSound(2,13);
playSound(523,10);
playSound(2,13);
playSound(659,21);
playSound(2,26);
playSound(784,42);
playSound(2,52);
playSound(392,42);
playSound(2,52);
playSound(523,26);
playSound(2,26);
playSound(523,10);
playSound(2,13);
playSound(392,10);
playSound(2,13);
//    rest
playSound(2,26);
playSound(330,21);
playSound(2,26);
//    rest
playSound(2,13);
playSound(440,21);
playSound(2,26);
*/

/*playSound(494,10);
//playSound(2,13);
//    rest
//playSound(2,13);
playSound(466,10);
//playSound(2,13);
playSound(440,21);
//playSound(2,26);
playSound(392,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
playSound(784,10);
//playSound(2,13
playSound(880,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(784,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(659,21);
//playSound(2,26
playSound(523,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
playSound(494,26);
//playSound(2,26
playSound(494,10);
//playSound(2,13
playSound(523,26);
//playSound(2,26
playSound(523,10);
//playSound(2,13
playSound(392,10);
//playSound(2,13
//    rest
//playSound(2,26
playSound(330,21);
//playSound(2,26
//    rest
//playSound(2,13
playSound(440,21);
//playSound(2,26
playSound(494,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(466,10);
//playSound(2,13
playSound(440,21);
//playSound(2,26
playSound(392,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
playSound(784,10);
//playSound(2,13
playSound(880,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(784,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(659,21);
//playSound(2,26
playSound(523,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
playSound(494,26);
//playSound(2,26
playSound(494,10);
//playSound(2,13
//    rest
//playSound(2,26
playSound(784,10);
//playSound(2,13
playSound(740,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(622,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(415,10);
//playSound(2,13
playSound(440,10);
//playSound(2,13
playSound(523,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(440,10);
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
//    rest
//playSound(2,26
playSound(784,10);
//playSound(2,13
playSound(740,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(622,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(1047,21);
//playSound(2,26
playSound(1047,10);
//playSound(2,13
playSound(1047,42);
//playSound(2,52
//    rest
//playSound(2,26
playSound(784,10);
//playSound(2,13
playSound(740,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(622,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(415,10);
//playSound(2,13
playSound(440,10);
//playSound(2,13
playSound(523,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(440,10);
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
//    rest
//playSound(2,26
playSound(622,21);
//playSound(2,26
//    rest
//playSound(2,13
playSound(587,26);
//playSound(2,26
playSound(587,10);
//playSound(2,13
playSound(523,42);
//playSound(2,52
//    rest
//playSound(2,52
//    rest
//playSound(2,26
playSound(784,10);
//playSound(2,13);
playSound(740,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(587,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(415,10);
//playSound(2,13
playSound(440,10);
//playSound(2,13
playSound(523,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(440,10);
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
//    rest
//playSound(2,26
playSound(784,10);
//playSound(2,13
playSound(740,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(587,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(1047,21);
//playSound(2,26
playSound(1047,10);
//playSound(2,13
playSound(1047,42);
//playSound(2,52
//    rest
//playSound(2,26
playSound(784,10);
//playSound(2,13
playSound(740,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(622,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(415,10);
//playSound(2,13
playSound(440,10);
//playSound(2,13
playSound(523,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(440,10);
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
//    rest
//playSound(2,26
playSound(622,21);
//playSound(2,26
//    rest
//playSound(2,13
playSound(587,26);
//playSound(2,26
playSound(587,10);
//playSound(2,13
playSound(523,42);
//playSound(2,52
//    rest
//playSound(2,52
playSound(523,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(523,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(587,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(392,42);
//playSound(2,52
playSound(523,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(523,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
//    rest
//playSound(2,52
playSound(523,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(523,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(587,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(392,42);
//playSound(2,52
playSound(659,10);
//playSound(2,13
playSound(659,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(659,21);
//playSound(2,26
playSound(784,42);
//playSound(2,52
//    rest
//playSound(2,52
playSound(523,26);
//playSound(2,26
playSound(523,10);
//playSound(2,13
playSound(392,10);
//playSound(2,13
//    rest
//playSound(2,26
playSound(330,21);
//playSound(2,26
//    rest);
//playSound(2,13
playSound(440,21);
//playSound(2,26
playSound(494,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(466,10);
//playSound(2,13
playSound(440,21);
//playSound(2,26
playSound(392,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
playSound(784,10);
//playSound(2,13
playSound(880,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(784,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(659,21);
//playSound(2,26
playSound(523,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
playSound(494,26);
//playSound(2,26
playSound(494,10);
//playSound(2,13
playSound(523,26);
//playSound(2,26
playSound(523,10);
//playSound(2,13
playSound(392,10);
//playSound(2,13
//    rest
//playSound(2,26
playSound(330,21);
//playSound(2,26
//    rest
//playSound(2,13
playSound(440,21);
//playSound(2,26
playSound(494,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(466,10);
//playSound(2,13
playSound(440,21);
//playSound(2,26
playSound(392,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
playSound(784,10);
//playSound(2,13
playSound(880,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(784,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(659,21);
//playSound(2,26
playSound(523,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
playSound(494,26);
//playSound(2,26
playSound(494,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(392,10);
//playSound(2,13
//    rest
//playSound(2,26
playSound(415,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(698,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(440,42);
//playSound(2,52
playSound(494,10);
//playSound(2,13
playSound(880,10);
//playSound(2,13
playSound(880,10);
//playSound(2,13
playSound(880,10);
//playSound(2,13
playSound(784,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(392,42);
//playSound(2,52
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(392,10);
//playSound(2,13
//    rest);
//playSound(2,26
playSound(415,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(698,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(440,42);
//playSound(2,52
playSound(494,10);
//playSound(2,13
playSound(698,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
playSound(523,42);
//playSound(2,52
//    rest
//playSound(2,52
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(392,10);
//playSound(2,13
//    rest
//playSound(2,26
playSound(415,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(698,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(440,42);
//playSound(2,52
playSound(494,10);
//playSound(2,13
playSound(880,10);
//playSound(2,13
playSound(880,10);
//playSound(2,13
playSound(880,10);
//playSound(2,13
playSound(784,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(392,42);
//playSound(2,52
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(392,10);
//playSound(2,13
//    rest);
//playSound(2,26
playSound(415,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(698,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(440,42);
//playSound(2,52
playSound(494,10);
//playSound(2,13
playSound(698,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
playSound(523,42);
//playSound(2,52
//    rest
//playSound(2,52
playSound(523,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(523,10);
//playSound(2,13
//    rest);
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(587,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(392,42);
//playSound(2,52
playSound(523,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(523,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
//    rest);
//playSound(2,52
playSound(523,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(523,10);
//playSound(2,13
//    rest);
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(587,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(392,42);
//playSound(2,52
playSound(659,10);
//playSound(2,13
playSound(659,21);
//playSound(2,26
playSound(659,10);
//playSound(2,13
//    rest
//playSound(2,13
playSound(523,10);
//playSound(2,13
playSound(659,21);
//playSound(2,26
playSound(784,42);
//playSound(2,52
//    rest
//playSound(2,52
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(392,10);
//playSound(2,13
//    rest);
//playSound(2,26
playSound(415,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(698,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(440,42);
//playSound(2,52
playSound(494,10);
//playSound(2,13
playSound(880,10);
//playSound(2,13
playSound(880,10);
//playSound(2,13
playSound(880,10);
//playSound(2,13
playSound(784,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(392,42);
//playSound(2,52
playSound(659,10);
//playSound(2,13
playSound(523,21);
//playSound(2,26
playSound(392,10);
//playSound(2,13
//    rest
//playSound(2,26
playSound(415,21);
//playSound(2,26
playSound(440,10);
//playSound(2,13
playSound(698,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(440,42);
//playSound(2,52
playSound(494,10);
//playSound(2,13
playSound(698,21);
//playSound(2,26
playSound(698,10);
//playSound(2,13
playSound(698,10);
//playSound(2,13
playSound(659,10);
//playSound(2,13
playSound(587,10);
//playSound(2,13
playSound(523,42);
//playSound(2,52*/
  }

}
