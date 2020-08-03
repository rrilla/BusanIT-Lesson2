package vo;

import java.util.Date;

public class Reply {
	private int rno;
	private int bno;
	private String writer;
	private String replytext;
	private Date writedate;
	
	public Reply() {}

	public Reply(int rno, int bno, String writer, String replytext, Date writedate) {
		super();
		this.rno = rno;
		this.bno = bno;
		this.writer = writer;
		this.replytext = replytext;
		this.writedate = writedate;
	}
	
	
}
