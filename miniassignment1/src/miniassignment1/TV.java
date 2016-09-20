package miniassignment1;

public class TV {

	private static final double VOLUME_INCREMENT = 0.07;
	private static final double VOLUME_MAX = 1.0;
	private static final double VOLUME_MIN = 0;
	private static final int CHANNEL_CHANGE = 1;
	private double volume;
	private int currentChannel;
	private int previousChannel;
	private int channelMax;

	public TV(int givenChannelMax) {
		currentChannel = 0;
		previousChannel = 0;
		channelMax = givenChannelMax;
		volume = 0.5;

	}

	public void channelUp() {
		previousChannel = currentChannel;
		currentChannel = (currentChannel + channelMax + CHANNEL_CHANGE)	% channelMax;
		System.out.print(currentChannel);
		System.out.println(previousChannel);

	}

}
