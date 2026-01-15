package com.example.moviemanagement.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
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

        String timestamp = LocalDateTime.now().format(formatter);
        String method = httpRequest.getMethod();
        String uri = httpRequest.getRequestURI();
        String queryString = httpRequest.getQueryString();
        String fullUrl = queryString != null ? uri + "?" + queryString : uri;


        System.out.println("INCOMING REQUEST");
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Method: " + method);
        System.out.println("URL: " + fullUrl);
        System.out.println("Remote Address: " + httpRequest.getRemoteAddr());


        long startTime = System.currentTimeMillis();

        chain.doFilter(request, response);

        long duration = System.currentTimeMillis() - startTime;
        String endTimestamp = LocalDateTime.now().format(formatter);


        System.out.println("RESPONSE");
        System.out.println("Timestamp: " + endTimestamp);
        System.out.println("Status Code: " + httpResponse.getStatus());
        System.out.println("Duration: " + duration + "ms");

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