package no.web.data;

import no.web.model.BlogEntry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class JpaBlogRepository implements BlogRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public BlogEntry saveBlogEntry(final BlogEntry blogEntry) {
        em.persist(blogEntry);
        return blogEntry;
    }

    @Override
    public List<BlogEntry> findBlogEntries() {
        final Query query = em.createQuery("SELECT b FROM BlogEntry b ORDER BY b.created DESC");
        List<BlogEntry> entries = query.getResultList();
        if (entries == null) {
            entries = new ArrayList<BlogEntry>();
        }
        return entries;
    }

    @Override
    public void deleteBlogEntry(BlogEntry blogEntry) {
        blogEntry = em.merge(blogEntry);
        em.remove(blogEntry);
    }
}
