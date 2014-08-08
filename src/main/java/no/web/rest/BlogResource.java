package no.web.rest;

import no.web.data.BlogRepository;
import no.web.model.BlogEntry;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
}
