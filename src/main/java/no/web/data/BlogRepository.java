package no.web.data;

import no.web.model.BlogEntry;

import java.util.List;
import java.util.Optional;

public interface BlogRepository {

    public BlogEntry saveBlogEntry(BlogEntry blogEntry);

    public List<BlogEntry> findBlogEntries();

    public void deleteBlogEntry(BlogEntry blogEntry);

    public void deleteAll();

    public Optional<BlogEntry> findBlogById(Long id);

    public Optional<BlogEntry> findBlogByName(String  name);
}
