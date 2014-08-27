package no.web.data;

import no.web.model.BlogEntry;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        final Query query = em.createQuery("select b from BlogEntry b order by b.created desc");
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

    @Override
    public void deleteAll() {
        System.out.println("** deleteAll");

    }

    @Override
    public Optional<BlogEntry> findBlogById(Long id) {
        TypedQuery<BlogEntry> query = em.createQuery("select b from BlogEntry b where b.id = :id", BlogEntry.class);
        query.setParameter("id", id);
        try {
            BlogEntry blogEntry = query.getSingleResult();
            return Optional.of(blogEntry);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<BlogEntry> findBlogByName(String name) {
        return null;
    }
}
