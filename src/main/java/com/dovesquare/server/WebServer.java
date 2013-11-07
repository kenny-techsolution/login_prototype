package com.dovesquare.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * WAR-less Java Web App
 * 
 * @author kenny chung
 */
public class WebServer
{

    public static void main(String[] args) throws Exception
    {   
    	String webappDirLocation = "src/main/webapp/";
        Server server = new Server(8080);

        WebAppContext context = new WebAppContext();
        context.setDescriptor(webappDirLocation+"/WEB-INF/web.xml");
        context.setResourceBase(webappDirLocation);
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
 
        server.setHandler(context);
        
        server.start();
        server.join();
    }

}