package no.web.rest;

import no.web.data.BlogRepository;
import no.web.model.BlogEntry;
import org.jboss.resteasy.annotations.cache.NoCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @NoCache
    @Path("blog/{blogId}")
    public BlogEntry getBlogById(@PathParam("blogId") String blogId) {

        System.out.println("************* getAllBlogEntries");
        log.info("getAllBlogEntries");
        long timestamp = System.currentTimeMillis();
        Optional<BlogEntry> blogEntry = blogRepository.findBlogById(Long.parseLong(blogId));

        long timeMillis = System.currentTimeMillis();
        Long l = timeMillis - timestamp;

        log.info("getAllBlogEntries took "+ l.toString()+" ms.");

        if (blogEntry.isPresent()) {
            return blogEntry.get();
        } else {
            throw new WebApplicationException(404);
        }
    }

    @GET
    @NoCache
    @Path("blog/{blogName}")
    public List<BlogEntry> getBlogByName(@PathParam("blogName") String blogName) {

        System.out.println("************* getAllBlogEntries");
        log.info("getAllBlogEntries");
        long timestamp = System.currentTimeMillis();
        List<BlogEntry> blogEntries = blogRepository.findBlogEntries();

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

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newBlog(BlogEntry blogEntry) {
        System.out.println("** newBlog created: "+blogEntry);

        String s = "blogEntry done : " + blogEntry;

        return Response.status(201).entity(s).build();

    }

}
