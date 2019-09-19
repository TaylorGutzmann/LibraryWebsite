package com.example.demo.domain;

public class BookAddress {
	private String branchName;
	private String address;
	
	public BookAddress(String branchName, String address) {
		this.branchName = branchName;
		this.address = address;
	}
	public BookAddress() {
		super();
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchAddress() {
		return address;
	}

	public void setBranchAddress(String address) {
		this.address = address;
	}
	
}