package com.spring.kjw.board.Reply;

import java.util.Date;

public class ReplyVO {
	
	private int rid;
	private int id;
	private String rp_content;
	private String rp_writer;
	private Date reg_dt;
	private Date edit_dt;
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRp_content() {
		return rp_content;
	}
	public void setRp_content(String rp_content) {
		this.rp_content = rp_content;
	}
	public String getRp_writer() {
		return rp_writer;
	}
	public void setRp_writer(String rp_writer) {
		this.rp_writer = rp_writer;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	public Date getEdit_dt() {
		return edit_dt;
	}
	public void setEdit_dt(Date edit_dt) {
		this.edit_dt = edit_dt;
	}
	
	
	
	
	
	

}
