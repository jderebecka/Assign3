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
  //public static UltrasonicSensor dist =
    //myRobot.getUltrasonicSensor(Sensor.Port.S3);
  public static Speaker mySpeaker = myRobot.getSpeaker();


  public static boolean ball = false;
  final static int SPEED = 100;
  final static int WAIT = 50;


  public static void playSound (int pitch, int length) {
    mySpeaker.playTone(pitch,length);
  }
  public static void forward (int speed, int wait) {
    leftMotor.setSpeed(speed);
    rightMotor.setSpeed(speed);
    leftMotor.forward();
    rightMotor.forward();
    myRobot.sleep(wait);
    System.out.println(sensor.getColor());
  }

  public static void backward (int speed, int wait) {
    leftMotor.setSpeed(speed);
    rightMotor.setSpeed(speed);
    leftMotor.backward();
    rightMotor.backward();
    myRobot.sleep(wait);
    System.out.println(sensor.getColor());
  }

  public static void stop () {
    leftMotor.stop();
    rightMotor.stop();
  }

  public static void leftTurn (int speed, int wait) {
    leftMotor.setSpeed(0);
    leftMotor.forward();
    rightMotor.setSpeed(speed);
    rightMotor.forward();
    myRobot.sleep(wait);
    System.out.println(sensor.getColor());
  }

  public static void rightTurn (int speed, int wait) {
    rightMotor.setSpeed(0);
    rightMotor.forward();
    leftMotor.setSpeed(speed);
    leftMotor.forward();
    myRobot.sleep(wait);
    System.out.println(sensor.getColor());
  }

  public static void pivotRight (int speed, int wait) {
    rightMotor.setSpeed(speed);
    rightMotor.backward();
    leftMotor.setSpeed(speed);
    leftMotor.forward();
    myRobot.sleep(wait);
    System.out.println(sensor.getColor());
  }

  public static void pivotLeft (int speed, int wait) {
    rightMotor.setSpeed(speed);
    rightMotor.forward();
    leftMotor.setSpeed(speed);
    leftMotor.backward();
    myRobot.sleep(wait);
    System.out.println(sensor.getColor());
  }

  public static void rotateLeft (int rotation) {
    angle.reset();
    angle.getAngle();
    leftMotor.setSpeed(200);
    leftMotor.rotate(rotation);
  }

  public static void rotateRight (int rotation) {
    angle.reset();
    angle.getAngle();
    rightMotor.setSpeed(200);
    rightMotor.rotate(rotation);
  }

  public static void lineCheck (String find, int speed, int wait) {
    if (ball==false) {
      rotateLeft(-70);
    } else if (ball==true) {
      rotateRight(-70);
    }
    do {
      if (ball==false) {
        pivotRight(75,wait);
      } else if (ball==true) {
        pivotLeft(75,wait);
      }
    } while (String.valueOf(sensor.getColor()) != find);
  }

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

  public static void playSound1 (int freq, int duration) {
    mySpeaker.playTone(freq,duration);
  }


      public static void party () {
        pivotRight(500,2000);
        stop();
        closeGrab(500,1500);
        playSound1(400,1000);
        playSound1(1000,100);
        playSound1(1100,100);
        playSound1(1500,500);
        openGrab(500,1500);
        pivotLeft(500,2000);
        stop();
      }


	public static void main(String[] args) {
/*
    Float test = dist.getDistance();

    System.out.println(test);

    do {
      pivotRight(30,5);
      System.out.println(dist.getDistance());
    } while (dist.getDistance() > 0.1);
*/
  party();
  party();

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
