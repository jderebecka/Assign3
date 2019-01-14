import ShefRobot.*;


public class Assign3 {


    private static ColorSensor sensor;


    private static ColorSensor.Color color;
    private static ColorSensor.Color col;


    public static Robot myRobot = new Robot("dia-lego-e5");

    public static GyroSensor angle =
      myRobot.getGyroSensor(Sensor.Port.S2);
    public static Motor leftMotor =
      myRobot.getLargeMotor(Motor.Port.A);
    public static Motor rightMotor =
      myRobot.getLargeMotor(Motor.Port.D);
    public static Speaker mySpeaker = myRobot.getSpeaker();

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
    //  angle = myRobot.getGyroSensor(Sensor.Port.S2);
      angle.reset();
      angle.getAngle();
      leftMotor.rotate(rotation);
    }

    public static void playSound1 (int tone, int pitch) {
      mySpeaker.playTone(tone,pitch);
    }

	public static void main(String[] args) {

		sensor = myRobot.getColorSensor(Sensor.Port.S1);
    //angle = myRobot.getGyroSensor(Sensor.Port.S2);
		//col = sensor.getColor();
		//color = ColorSensor.Color.BLACK;

  //  angle.reset();

  //do {
  forward(300,1000);
//  } while (String.valueOf(sensor.getColor()) != "BLACK");

    //rightTurn(200,500);

  //if (angle.getAngle() > -5.0) {
//    leftTurn(200,500);
//  }
  rotate(-90);


//  playSound1(400,100);


		myRobot.close();
	}
}
