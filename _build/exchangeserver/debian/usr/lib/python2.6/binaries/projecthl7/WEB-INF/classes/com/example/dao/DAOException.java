package com.example.dao;

public class DAOException extends Exception{
	public DAOException(Exception ex){
		super(ex);
	}
	public DAOException(String error){
		super(error);
	}
}
