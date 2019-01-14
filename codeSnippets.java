	do {
    leftTurn(200,100);
	} while (String.valueOf(sensor.getColor()) != "BLACK");



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
