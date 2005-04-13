/* Copyright 2004 The JA-SIG Collaborative.  All rights reserved.
 * See license distributed with this file and
 * available online at http://www.uportal.org/license.html
 */
package org.jasig.cas.event;

import javax.servlet.http.HttpServletRequest;

/**
 * Implementation of an HttpRequestEvent that adds convenience methods
 * to log page accesses.
 * 
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.0
 *
 */
public class PageRequestHttpRequestEvent extends AbstractHttpRequestEvent {

    private static final long serialVersionUID = 3257290244557910064L;

    private static final String HEADER_USER_AGENT = "User-Agent";
    
    private static final String HEADER_REFERRER = "Referer";
    
    public PageRequestHttpRequestEvent(HttpServletRequest request) {
        super(request);
    }
    
    /**
     * Convenience method to return just the page requested stripped of any extra context or querystring information.
     * @return the truncated page requested.
     */
    public String getPage() {
        final String requestUri = getRequest().getRequestURI();
        final String requestContext = getRequest().getContextPath();
        return requestUri.substring(requestUri.indexOf(requestContext)+requestContext.length()+1);
    }
    
    /** Convenience method to return the IPAddress.
     * 
     * @return the IP Address of the remote user.
     */ 
    public String getIpAddress() {
        return getRequest().getRemoteAddr();
    }
    
    /**
     * Convenience method to return the type of request.
     * @return GET or POST in most cases.
     */
    public String getMethod() {
        return getRequest().getMethod();
    }
    
    /**
     * Convenience method to return the user agent.
     * 
     * @return the string from the User Agent header.
     */
    public String getUserAgent() {
        return getRequest().getHeader(HEADER_USER_AGENT);
    }
    
    /** Convenience method to return the referrer. Note, that this method name uses the proper header.
     * 
     * @return the referrer if there is one, null otherwise.
     */
    public String getReferrer() {
        return getRequest().getHeader(HEADER_REFERRER);
    }
}