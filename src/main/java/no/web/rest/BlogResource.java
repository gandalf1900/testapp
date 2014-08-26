package no.web.rest;

import no.web.data.BlogRepository;
import no.web.model.BlogEntry;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("blogs")
@Produces("application/json")
public class BlogResource {

    private static final Logger log = LoggerFactory.getLogger(BlogResource.class);

    @Inject
    private BlogRepository blogRepository;

    @GET
    @NoCache
    @Path("all")
    public List<BlogEntry> getAllBlogEntries() {

        System.out.println("************* getAllBlogEntries");
        log.info("getAllBlogEntries");
        long timestamp = System.currentTimeMillis();
        List<BlogEntry> blogEntries = blogRepository.findBlogEntries();

        // fake some server response time..
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long timeMillis = System.currentTimeMillis();
        Long l = timeMillis - timestamp;

        log.info("getAllBlogEntries took "+ l.toString()+" ms.");

        return blogEntries;
    }

    @GET
    @Path("books/fiction")
    public List getAllFiction() {

        System.out.println("************* getAllFiction");
        return new ArrayList<>(59);
    }

    @GET
    @Path("{tiv:\\d\\d\\d}")
    public List test(@PathParam("tiv") String tiv) {

        System.out.println("************* test, tiv = " +tiv);
        return new ArrayList<>(59);
    }
}
