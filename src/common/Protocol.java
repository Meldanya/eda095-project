package common;

public class Protocol {
	public static final byte GUESS_WORD          = 0;
	public static final byte GUESS_ACK           = 1;
	public static final byte GUESS_NAK           = 2;

	public static final byte DRAW_LINE_START     = 10;
	public static final byte DRAW_COORD_BULK     = 11;

	public static final byte CMD_DRAWING_STARTED = 20;
	public static final byte CMD_DISABLE_DRAWING = 21;
	public static final byte CMD_ENABLE_DRAWING  = 22;
	public static final byte CMD_SET_COLOR       = 23;
	public static final byte CMD_UNDO            = 24;
	public static final byte CMD_CLEAR_ALL       = 25;
	public static final byte CMD_SET_THICKNESS   = 26;
	public static final byte CMD_UPDATE_RANKING  = 27;

	public static final byte END                 = 30;
}
