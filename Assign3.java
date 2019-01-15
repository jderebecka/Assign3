import ShefRobot.*;

public class Assign3 {

    public static Robot myRobot = new Robot("dia-lego-e5");

    //public static ColorSensor.Color color = ColorSensor.Color.BLACK;


    public static ColorSensor sensor =
      myRobot.getColorSensor(Sensor.Port.S1);
    public static GyroSensor angle =
      myRobot.getGyroSensor(Sensor.Port.S2);
    //public static String color =
      //String.valueOf(sensor.getColor());
    public static Motor leftMotor =
      myRobot.getLargeMotor(Motor.Port.A);
    public static Motor rightMotor =
      myRobot.getLargeMotor(Motor.Port.D);
    public static Motor grapple =
      myRobot.getMediumMotor(Motor.Port.C);
    public static Speaker mySpeaker = myRobot.getSpeaker();


    public static boolean ball = false;
    final static int SPEED = 200;
    final static int WAIT = 100;

    public static void forward (int speed, int wait) {
      leftMotor.setSpeed(speed);
      rightMotor.setSpeed(speed);
      leftMotor.forward();
      rightMotor.forward();
      myRobot.sleep(wait);
      System.out.println(sensor.getColor());
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
      rightMotor.setSpeed(100);
      rightMotor.backward();
      leftMotor.setSpeed(100);
      leftMotor.forward();
      myRobot.sleep(wait);
      System.out.println(sensor.getColor());
    }

    public static void pivotLeft (int speed, int wait) {
      rightMotor.setSpeed(100);
      rightMotor.forward();
      leftMotor.setSpeed(100);
      leftMotor.backward();
      myRobot.sleep(wait);
      System.out.println(sensor.getColor());
    }

    public static void rotate (int rotation) {
      angle.reset();
      angle.getAngle();
      leftMotor.rotate(rotation);
    }

    public static void lineCheck (String find, int speed, int wait) {
      if (ball==false) {
        //rotate(-60);
        rotate(-45);
      } else {
        rotate(45);
      }
      do {
        if (ball==false) {
          pivotRight(speed,wait);
        } else {
          pivotLeft(speed,wait);
        }
      } while (String.valueOf(sensor.getColor()) != find);
    }

    public static void openGrab (int speed, int wait) {
      grapple.setSpeed(speed);
      grapple.forward();
      myRobot.sleep(wait);
    }

    public static void closeGrab (int speed, int wait) {
      grapple.setSpeed(speed);
      grapple.backward();
      myRobot.sleep(wait);
    }

    public static void playSound1 (int tone, int pitch) {
      mySpeaker.playTone(tone,pitch);
    }



//-------------------------------------------------------------------------//
	  public static void main(String[] args) {



    //closeGrab(500,3000);
  //  openGrab(500,3000);



//Start position - get to black line
      do {
        forward(SPEED,WAIT);
      } while (String.valueOf(sensor.getColor()) != "BLACK");


//reached black line, rotate to start following line
      rotate(-90);


//move along line
      do {
        lineCheck("BLACK",SPEED,WAIT);
        do {
          forward(SPEED,WAIT);
        } while (String.valueOf(sensor.getColor()) == "BLACK");
    } while (String.valueOf(sensor.getColor()) != "RED");
    if (String.valueOf(sensor.getColor()) == "RED"){
//ONCE RED, OPEN PINCERS
//CLOSE PINCERS
    ball==true;
    }
      do {
        lineCheck("BLACK",SPEED,WAIT);
        do {
          forward(SPEED,WAIT);
        } while (String.valueOf(sensor.getColor()) == "BLACK");
      } while (String.valueOf(sensor.getColor()) != "YELLOW");

//ROTATE 180DEGREES
//MOVE FORWARD UNTIL NOT RED
//IF BLACK, FOLLOW LINE, IF WHITE, FIND LINE
//REVERS CURRENT ROUTE UNTIL YELLOW


//  playSound1(400,100);


		myRobot.close();
	}
}
