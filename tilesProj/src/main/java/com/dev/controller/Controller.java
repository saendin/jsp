package com.dev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//interface라는 클래스는 Controller를 배분했을 때 반드시 execute를 구현해줘야하는 책임이 있음.
public interface Controller {
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException;
}
