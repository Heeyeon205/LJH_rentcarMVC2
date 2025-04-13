	package com.rentcar.vo;
	
	import java.sql.Timestamp;
	
	public class Board {
		private int no;
		private String writer;
		private Timestamp regDate;
		private String subject;
		private String contents;
		
		public Board(int no, String writer, Timestamp regDate, String subject, String contents) {
			super();
			this.no = no;
			this.writer = writer;
			this.regDate = regDate;
			this.subject = subject;
			this.contents = contents;
		}
		
		public Board(String writer, String subject, String contents) {
			this.writer = writer;
			this.subject = subject;
			this.contents = contents;
		}
		
		public Board(int no, String subject, String contents) {
			this.no = no;
			this.subject = subject;
			this.contents = contents;
		}
		
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public Timestamp getRegDate() {
			return regDate;
		}
		public void setRegDate(Timestamp regDate) {
			this.regDate = regDate;
		}
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getContents() {
			return contents;
		}
		public void setContents(String contents) {
			this.contents = contents;
		}
	
		@Override
		public String toString() {
			return "Board [no=" + no + ", writer=" + writer + ", regDate=" + regDate + ", subject=" + subject
					+ ", contents=" + contents + "]";
		}
	}