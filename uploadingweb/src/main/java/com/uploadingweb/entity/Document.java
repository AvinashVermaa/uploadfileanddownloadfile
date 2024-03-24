package com.uploadingweb.entity;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;



@Entity
@Table(name="document")
public class Document {

	@Id
	private int id;
	private String name;
	@Lob
	private byte[] data;
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Document(int id, String name, byte[] data) {
		super();
		this.id = id;
		this.name = name;
		this.data = data;
	}
	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + name + ", data=" + Arrays.toString(data) + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
}
