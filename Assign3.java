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

    public static void playSound (int freq, int duration) {
      mySpeaker.playTone(freq,duration);
    }

    public static void party () {

          playSound(330,160);

          playSound(392,320);

          playSound(440,1280);
          pivotRight(1500,1000);
          stop();
          playSound(440,160);

          playSound(494,320);
          pivotLeft(1500,1000);
          stop();
          playSound(330,1280);

          playSound(330,160);

          playSound(392,320);

          playSound(440,1280);
          pivotRight(1500,1000);
          stop();
          playSound(440,160);

          playSound(494,320);

          playSound(330,1280);
          pivotLeft(1500,1000);
          stop();
          playSound(294,160);

          playSound(262,160);

          playSound(294,320);

          playSound(262,160);

          playSound(294,160);

          playSound(330,640);
          pivotRight(1500,1000);
          stop();
          playSound(262,160);

          playSound(262,160);

          playSound(247,320);

          playSound(247,160);

          playSound(220,320);

          playSound(220,160);

          playSound(196,320);

          playSound(349,160);

          playSound(330,1280);

          playSound(659,1280);
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
      playSound(1000,100);
      playSound(1100,100);
      playSound(1500,500);
      //if (String.valueOf(sensor.getColor()) == "RED"){
        closeGrab(500,2200);
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

      playSound(400,1000);
      openGrab(500,2200);

      party();


		myRobot.close();
	}
}
