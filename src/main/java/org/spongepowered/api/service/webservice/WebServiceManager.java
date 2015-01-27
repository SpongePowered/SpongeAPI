package org.spongepowered.api.service.webservice;

import java.io.InputStream;
import java.net.URL;

/**
 * Webservice Manager Manages Listeners and Service Registration
 * Created by forsterth on 27/01/2015.
 */
public interface WebServiceManager {

    /**
     * Register Webservice Listener on the specified port
     *
     * @param listener The Webservice to register
     * @param port The port to listen on for calls
     */
    public void registerWebService(WebServiceListener listener, int port);

    /**
     * Terminate WebService
     *
     * @param listener The WebService to destroy
     */
    public void destroyWebService(WebServiceListener listener);


    /**
     * Call external Webservice
     * @param webservice url to send request to
     * @param dataToSend The data to send as json /XML
     * @return InputStream to process response
     */
    public  InputStream callWebService(URL webservice, String dataToSend);


    /**
     * Call external Webservice for Restful service
     * @param webservice Restful URL to call
     * @return InputStream to process response
     */
    public InputStream callWebService(URL webservice);
}
