package no.web.data;

import no.web.model.BlogEntry;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Ignore;
import org.junit.Test;

import javax.persistence.Entity;
import javax.ws.rs.core.Response;

public class TestBlog {

    final static String REST_ENDPOINT = "http://localhost:8080/webapp";
    final static String SERVICE = "/rest/blogs/post";

    @Test
    @Ignore
    public void should_create_blog() {

    }
}
