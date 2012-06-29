package artlife;

import java.util.Random;

public enum travel{
    WALK,SWIM,FLY,ICE;
	private static final travel[] VALUES = values();
	private static final Random r = new Random();
	public static travel random() {
		return VALUES[r.nextInt(VALUES.length)];
	}
}