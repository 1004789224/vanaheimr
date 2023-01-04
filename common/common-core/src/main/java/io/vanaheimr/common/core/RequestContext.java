package io.vanaheimr.common.core;


import io.micronaut.http.HttpRequest;

/**
 * A class that holds the current request context.
 */
public class RequestContext {

    private HttpRequest request;

    private String userId;

    private String tenantId;

    private String requestId;

    public RequestContext() {

    }


    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }


    @Override
    public String toString() {
        return "RequestContext{" +
                "request=" + request +
                ", userId='" + userId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", requestId='" + requestId + '\'' +
                '}';
    }
}