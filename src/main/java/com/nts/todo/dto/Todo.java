package com.nts.todo.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Todo {
	private long id;
	private String name;
	private LocalDateTime regdate;
	private int sequence;
	private String title;
	private String type;

	public long getId() {
		return id;
	}

	public Todo() {
		super();
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getRegdate() {
		return regdate;
	}

	public LocalDate getRegdateForView() {
		//시간은 제외하고 return
		if (regdate != null) {
			return regdate.toLocalDate();
		}
		return null;
	}

	public void setRegdate(LocalDateTime regdate) {
		this.regdate = regdate;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "todo [id=" + id + ", name=" + name + ", regdate=" + regdate + ", sequence=" + sequence + ", title="
			+ title + ", type=" + type + "]";
	}

}
