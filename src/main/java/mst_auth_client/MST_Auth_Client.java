package mst_auth_client;

import java.io.IOException;
import java.net.http.HttpResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mst_auth_library.MSTAException;
import mst_auth_library.MST_Auth_Servlet;

public class MST_Auth_Client {
	private MST_Auth_Servlet msta_library;
	public MST_Auth_Client() {
	}
	public void SetLibrary (MST_Auth_Servlet MSTALibrary ) {
		msta_library = MSTALibrary;			
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response, String trustedbody) throws ServletException, IOException, MSTAException {
		msta_library.SetMicroservice("MSTAAuthorization");
		msta_library.SetMethodWithBodyString("GET", "MSTAAuthorization OY a get");
		msta_library.SetHeader("Content-Type", "application/json; utf-8");
		HttpResponse resp = msta_library.SendRequest();	  
	    response.getWriter().append(resp.body().toString());

		msta_library.SetMicroservice("MSTADataProvider");
		msta_library.SetMethodWithBodyString("GET", "MSTADataProvider OY a get");
		msta_library.SetHeader("Content-Type", "application/json; utf-8");
		HttpResponse resp2 = msta_library.SendRequest();	  
	    response.getWriter().append(resp2.body().toString());
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response, String trustedbody) throws ServletException, IOException, MSTAException {
	    response.getWriter().append("doPut Served at: ").append(request.getContextPath());
	}
	public void doPut(HttpServletRequest request, HttpServletResponse response, String trustedbody) throws ServletException, IOException, MSTAException {
	    response.getWriter().append("doPut Served at: ").append(request.getContextPath());
	}
	public void doDelete(HttpServletRequest request, HttpServletResponse response, String trustedbody) throws ServletException, IOException, MSTAException {
	    response.getWriter().append("doDelete Served at: ").append(request.getContextPath());
	}
}
