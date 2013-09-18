package com.dovesquare;

import java.io.*;
import java.net.*;
import java.util.*;

import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.*;
import org.eclipse.jetty.server.nio.*;
import org.eclipse.jetty.util.thread.*;
import org.eclipse.jetty.webapp.*;

/**
 * Example WebServer class which sets up an embedded Jetty appropriately
 * whether running in an IDE or in "production" mode in a shaded jar.
 * 
 * @author steve liles
 */
public class WebServer
{
	// TODO: You should configure this appropriately for your environment
	private static final String LOG_PATH = "./var/logs/access/yyyy_mm_dd.request.log";

	private static final String WEB_XML = "webapp/WEB-INF/web.xml";
    private static final String CLASS_ONLY_AVAILABLE_IN_IDE = "com.sjl.IDE";
    private static final String PROJECT_RELATIVE_PATH_TO_WEBAPP = "src/main/webapp";
    
    public static interface WebContext
    {
        public File getWarPath();
        public String getContextPath();
    }
    
    private Server server;
    private int port;
    private String bindInterface;
    
    public WebServer(int aPort)
    {
        this(aPort, null);
    }
    
    public WebServer(int aPort, String aBindInterface)
    {        
        port = aPort;
        bindInterface = aBindInterface;
    }
    
    public void start() throws Exception
    {
        server = new Server();

        server.setThreadPool(createThreadPool());
        server.addConnector(createConnector());
        server.setHandler(createHandlers());        
        server.setStopAtShutdown(true);
                
        server.start();       
    }
    
    public void join() throws InterruptedException
    {
        server.join();
    }
    
    public void stop() throws Exception
    {        
        server.stop();
    }
    
    private ThreadPool createThreadPool()
    {
    	// TODO: You should configure these appropriately
    	// for your environment - this is an example only
        QueuedThreadPool _threadPool = new QueuedThreadPool();
        _threadPool.setMinThreads(10);
        _threadPool.setMaxThreads(100);
        return _threadPool;
    }
    
    private SelectChannelConnector createConnector()
    {
        SelectChannelConnector _connector = new SelectChannelConnector();
        _connector.setPort(port);
        _connector.setHost(bindInterface);
        return _connector;
    }
    
    private HandlerCollection createHandlers()
    {                
        WebAppContext _ctx = new WebAppContext();
        _ctx.setContextPath("/");
        
        if(isRunningInShadedJar())
        {          
            _ctx.setWar(getShadedWarUrl());
        }
        else
        {            
            _ctx.setWar(PROJECT_RELATIVE_PATH_TO_WEBAPP);
        }
        
        List<Handler> _handlers = new ArrayList<Handler>();
        
        _handlers.add(_ctx);
        
        HandlerList _contexts = new HandlerList();
        _contexts.setHandlers(_handlers.toArray(new Handler[0]));
        
        RequestLogHandler _log = new RequestLogHandler();
        _log.setRequestLog(createRequestLog());
        
        HandlerCollection _result = new HandlerCollection();
        _result.setHandlers(new Handler[] {_contexts, _log});
        
        return _result;
    }
    
    private RequestLog createRequestLog()
    {
        NCSARequestLog _log = new NCSARequestLog();
        
    	File _logPath = new File(LOG_PATH);
        _logPath.getParentFile().mkdirs();
                
        _log.setFilename(_logPath.getPath());
        _log.setRetainDays(90);
        _log.setExtended(false);
        _log.setAppend(true);
        _log.setLogTimeZone("GMT");
        _log.setLogLatency(true);
        return _log;
    }
    
//---------------------------
// Discover the war path
//---------------------------   
    
    private boolean isRunningInShadedJar()
    {
        try
        {
            Class.forName(CLASS_ONLY_AVAILABLE_IN_IDE);
            return false;
        }
        catch(ClassNotFoundException anExc)
        {
            return true;
        }
    }
    
    private URL getResource(String aResource)
    {
        return Thread.currentThread().getContextClassLoader().getResource(aResource); 
    }
    
    private String getShadedWarUrl()
    {
        String _urlStr = getResource(WEB_XML).toString();
        // Strip off "WEB-INF/web.xml"
        return _urlStr.substring(0, _urlStr.length() - 15);
    }
}