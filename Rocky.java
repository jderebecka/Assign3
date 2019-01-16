import ShefRobot.*;


public class Rocky {

  public static Robot myRobot = new Robot("dia-lego-D1");

  public static Speaker mySpeaker = myRobot.getSpeaker();



  public static void playSound (int pitch, int length) {

    mySpeaker.setVolume(10);

    mySpeaker.playTone(pitch,length);
  }

	public static void main(String[] args) {


    playSound(330,160);

    playSound(392,320);

    playSound(440,1280);

    playSound(440,160);

    playSound(494,320);

    playSound(330,1280);

    playSound(330,160);

    playSound(392,320);

    playSound(440,1280);

    playSound(440,160);

    playSound(494,320);

    playSound(330,1280);

    playSound(294,160);

    playSound(262,160);

    playSound(294,320);

    playSound(262,160);

    playSound(294,160);

    playSound(330,640);

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


}
