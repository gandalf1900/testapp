package no.web.data;

import no.web.model.BlogEntry;

import java.util.List;

public interface BlogRepository {

    public BlogEntry saveBlogEntry(BlogEntry blogEntry);

    public List<BlogEntry> findBlogEntries();

    public void deleteBlogEntry(BlogEntry blogEntry);

    public void deleteAll();
}
