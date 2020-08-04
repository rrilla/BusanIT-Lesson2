package vo;

import java.util.Date;

public class Board {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private int readcount;
	private Date writedate;
	private String image_name;
	private int replycount;
	
	public Board() {}

	public Board(String title, String content, String writer, String image_name,
			int replycount) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.image_name = image_name;
	}
	
	public Board(String title, String content, String writer, String image_name) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.image_name = image_name;
	}

	public Board(int bno, String title, String content, String writer, String image_name,
			int replycount) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.image_name = image_name;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public Date getWritedate() {
		return writedate;
	}

	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}

	public String getImage_name() {
		return image_name;
	}

	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}

	public int getReplycount() {
		return replycount;
	}

	public void setReplycount(int replycount) {
		this.replycount = replycount;
	}

	@Override
	public String toString() {
		return "Board [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", readcount="
				+ readcount + ", writedate=" + writedate + ", image_name=" + image_name + ", replycount=" + replycount
				+ "]";
	}
	
}
