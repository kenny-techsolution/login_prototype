package com.dovesquare;

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
        
<<<<<<< HEAD
=======
 
>>>>>>> 78899bbaa2d1210298a619389fb770d16ebecfba
        server.start();
        server.join();
    }

}