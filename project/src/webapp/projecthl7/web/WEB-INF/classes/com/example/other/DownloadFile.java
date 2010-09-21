package com.example.other;

/*
 * DownloadFile.java
 *
 * Created on October 20, 2008, 5:46 PM
 */

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author 72737
 * @version
 */
public class DownloadFile extends HttpServlet {

    private String original_filename = "xx.txt";

    private String filename="/tmp/2010-04-19-2010-04-21.txt";
    
    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
            File                f        = new File(filename);
            int                 length   = 0;
            ServletOutputStream op       = response.getOutputStream();
            ServletContext      context  = getServletConfig().getServletContext();
            String              mimetype = context.getMimeType( filename );
    
            //
            //  Set the response and go!
            //
            //
            response.setContentType( (mimetype != null) ? mimetype : "application/octet-stream" );
            response.setContentLength( (int)f.length() );
            response.setHeader( "Content-Disposition", "attachment; filename=\"" + original_filename + "\"" );
    
            
            //
            //  Stream to the requester.
            //
            byte[] bbuf = new byte[filename.length()];
            DataInputStream in = new DataInputStream(new FileInputStream(f));
    
            while ((in != null) && ((length = in.read(bbuf)) != -1))
            {
                op.write(bbuf,0,length);
            }
    
            in.close();
            op.flush();
            op.close();
    
    
    
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}