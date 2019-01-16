import ShefRobot.*;

public class Assign3 {

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
    final static int WAIT = 40;

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


//-------------------------------------------------------------------------//
	  public static void main(String[] args) {
//Start position - get to black line
      do {
        forward(SPEED,WAIT);
      } while (String.valueOf(sensor.getColor()) != "BLACK");

//reached black line, rotate to start following line
      rotateLeft(-90);

//move along line to red circle, then close pincers
      do {
        lineCheck("BLACK",SPEED,WAIT);
        do {
          forward(SPEED,WAIT);
        } while (String.valueOf(sensor.getColor()) == "BLACK");
      } while (String.valueOf(sensor.getColor()) != "RED");

      stop();
      playSound1(4000,1000);
      //if (String.valueOf(sensor.getColor()) == "RED"){
        closeGrab(500,1600);
        ball = true;
        System.out.println(ball);
      //}
      backward(SPEED,200);
      rotateLeft(180);

//move along line to yellow circle, then open pincers
      do {
        lineCheck("BLACK",SPEED,WAIT);
        do {
          forward(SPEED,WAIT);
        } while (String.valueOf(sensor.getColor()) == "BLACK");
      } while (String.valueOf(sensor.getColor()) != "YELLOW");

      playSound1(400,1000);
      openGrab(500,1600);

      party();
      party();
      
		myRobot.close();
	}
}
