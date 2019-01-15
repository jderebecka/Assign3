import ShefRobot.*;

public class Assign3 {

    public static ColorSensor.Color color = ColorSensor.Color.BLACK;
    public static ColorSensor.Color col = sensor.getColor();

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

    public static void rotate (int rotation) {
      angle.reset();
      angle.getAngle();
      leftMotor.rotate(rotation);
    }

    public static void lineCheck (String colorsearch, int, angle int speed, int wait) {
      rotate(angle);
      do {
      rightTurn(speed,wait);
      } while (String.valueOf(sensor.getColor()) != colorsearch);
    }

    public static void playSound1 (int tone, int pitch) {
      mySpeaker.playTone(tone,pitch);
    }

	  public static void main(String[] args) {

		  //col = sensor.getColor();
		  //color = ColorSensor.Color.BLACK;

//Start position - get to black line
      do {
        forward(100,100);
      } while (String.valueOf(sensor.getColor()) != "BLACK");



//reached black line, rotate to start following line
      rotate(-90);



//move along line
      do {
        lineCheck("BLACK",-45,250,400);
        do {
          forward(100,100);
        } while (String.valueOf(sensor.getColor()) == "BLACK");
    } while (String.valueOf(sensor.getColor()) != "RED");

//ONCE RED, OPEN PINCERS
//MOVE FORWARD TO COLLECT BALL
//CLOSE PINCERS
//ROTATE 180DEGREES
//MOVE FORWARD UNTIL NOT RED
//IF BLACK, FOLLOW LINE, IF WHITE, FIND LINE
//REVERS CURRENT ROUTE UNTIL YELLOW


//  playSound1(400,100);


		myRobot.close();
	}
}
