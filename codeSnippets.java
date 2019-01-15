	do {
    leftTurn(200,100);
	} while (String.valueOf(sensor.getColor()) != "BLACK");


/*
do {
  do {
    rightTurn(200,100);
  } while (String.valueOf(sensor.getColor()) != "WHITE");

  do {
    forward(300,100);
  } while (String.valueOf(sensor.getColor()) == "BLACK");

  do {
    leftTurn(200,100);
  } while (String.valueOf(sensor.getColor()) != "WHITE");
} while (String.valueOf(sensor.getColor()) != "RED");*/

public static void lineCheck (String colorsearch, int speed, int wait) {
	rotate(-45);
	do {
	rightTurn(speed,wait);
	} while (String.valueOf(sensor.getColor()) != colorsearch);
}


//move along line
      do {
        do {
          forward(100,100);
        } while (String.valueOf(sensor.getColor()) == "BLACK");
// position check looks for white, then rotates to black, if no black, assume
//at end of line and put back
      lineCheck("BLACK",250,400);
    } while (store == false);
