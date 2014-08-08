package no.web.faces;

import no.web.model.BlogEntry;
import no.web.service.BlogEntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BlogEntryWizard {

    private static final Logger log = LoggerFactory.getLogger(BlogEntryWizard.class);

    @Inject
    private BlogEntryService blogEntryService;
    private BlogEntry blogEntry = new BlogEntry();

    public List<BlogEntry> getBlogEntries() {
        List<BlogEntry> blogEntries = blogEntryService.findBlogEntries();
        return blogEntries;
    }

    public BlogEntry getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(BlogEntry blogEntry) {
        this.blogEntry = blogEntry;
    }

    public String saveBlogEntry() {
        blogEntryService.saveBlogEntry(blogEntry);
        return "success";
    }

    public void delete(BlogEntry blogEntry) {
        blogEntryService.deleteBlogEntry(blogEntry);
    }

    @PostConstruct
    public void initialize() {
        log.info("blogs init");
    }

    public void init() {
        System.out.println("test seam faces init action");
    }

}