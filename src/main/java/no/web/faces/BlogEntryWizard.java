package no.web.faces;

import no.web.model.BlogEntry;
import no.web.service.BlogEntryService;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BlogEntryWizard {

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
}