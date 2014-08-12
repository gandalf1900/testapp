package no.web.service;

import no.web.data.BlogRepository;
import no.web.data.PersonRepository;
import no.web.model.BlogEntry;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class BlogEntryService {

    @Inject
    private BlogRepository blogRepository;

    public BlogEntry saveBlogEntry(BlogEntry blogEntry) {
        return blogRepository.saveBlogEntry(blogEntry);
    }

    public List<BlogEntry> findBlogEntries() {
        return blogRepository.findBlogEntries();
    }

    public void deleteBlogEntry(BlogEntry blogEntry) {
        blogRepository.deleteBlogEntry(blogEntry);
    }

    public void deleteAll() {
        blogRepository.deleteAll();
    }
}
