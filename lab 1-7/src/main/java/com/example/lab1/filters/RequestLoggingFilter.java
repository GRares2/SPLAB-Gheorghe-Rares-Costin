package com.example.lab1.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class RequestLoggingFilter implements Filter {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Log BEFORE processing the request
        String timestamp = LocalDateTime.now().format(formatter);
        String method = httpRequest.getMethod();
        String uri = httpRequest.getRequestURI();
        String queryString = httpRequest.getQueryString();
        String fullUrl = queryString != null ? uri + "?" + queryString : uri;

        System.out.println("==================================================");
        System.out.println("INCOMING REQUEST");
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Method: " + method);
        System.out.println("URL: " + fullUrl);
        System.out.println("Remote Address: " + httpRequest.getRemoteAddr());
        System.out.println("==================================================");

        long startTime = System.currentTimeMillis();

        // Pass the request down the filter chain (to next filter or servlet)
        chain.doFilter(request, response);

        // Log AFTER processing the request
        long duration = System.currentTimeMillis() - startTime;
        String endTimestamp = LocalDateTime.now().format(formatter);

        System.out.println("==================================================");
        System.out.println("RESPONSE");
        System.out.println("Timestamp: " + endTimestamp);
        System.out.println("Status Code: " + httpResponse.getStatus());
        System.out.println("Duration: " + duration + "ms");
        System.out.println("==================================================\n");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("RequestLoggingFilter initialized");
    }

    @Override
    public void destroy() {
        System.out.println("RequestLoggingFilter destroyed");
    }
}