import ShefRobot.*;


public class Assign3 {


    private static ColorSensor.Color color;
    private static ColorSensor.Color col;


    public static Robot myRobot = new Robot("dia-lego-e5");

    public static ColorSensor sensor =
      myRobot.getColorSensor(Sensor.Port.S1);
    public static GyroSensor angle =
      myRobot.getGyroSensor(Sensor.Port.S2);
    public static Motor leftMotor =
      myRobot.getLargeMotor(Motor.Port.A);
    public static Motor rightMotor =
      myRobot.getLargeMotor(Motor.Port.D);
    public static Speaker mySpeaker = myRobot.getSpeaker();

    public static boolean store = false;

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

    public static void positionCheck (String colorsearch, int speed, int wait) {
      leftTurn(speed,wait);
      if (String.valueOf(sensor.getColor()) != colorsearch) {
        rightTurn(speed,wait);
      } else {
        store = true;
        System.out.println(store);
      }
    }

    public static void rotate (int rotation) {
      angle.reset();
      angle.getAngle();
      leftMotor.rotate(rotation);
    }

    public static void playSound1 (int tone, int pitch) {
      mySpeaker.playTone(tone,pitch);
    }

	public static void main(String[] args) {

		col = sensor.getColor();
		color = ColorSensor.Color.BLACK;

//Start position - get to black line
  do {
  forward(100,100);
} while (String.valueOf(sensor.getColor()) != "BLACK");

//reached black line, rotate to start following line
  rotate(-90);

//go forward
  do {
    do {
      forward(100,100);
    } while (String.valueOf(sensor.getColor()) == "BLACK");
// position check looks for white, then rotates to black, if no black, assume
//at end of line and put back
    positionCheck("BLACK",250,400);
  } while (store == false);

  //rotate(90);

  //do {
  //  do {
  //    forward(300,1000);
  //  } while (String.valueOf(sensor.getColor()) == "BLACK");
// position check looks for white, then rotates to black, if no black, assume
//at end of line and put back
//    positionCheck("BLACK",300,300);
  //} while (store == false);



//  playSound1(400,100);


		myRobot.close();
	}
}
