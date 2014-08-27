package no.web.data;

import no.web.model.BlogEntry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

import static org.fest.assertions.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.fail;

public class BlogRepositoryTest {

    BlogRepository blogRepository;

    @Before
    public void setup() {

        setupWithMockBlogRepository();
    }

    @Test
    public void should_find_blog_by_id() {
        Optional<BlogEntry> blogEntry = blogRepository.findBlogById(1L);
        assertThat(blogEntry.get()).isNotNull();
    }

    @Test
    public void should_find_blog_by_name() {
        Optional<BlogEntry> blogEntry = blogRepository.findBlogByName("test");
        assertThat(blogEntry.get()).isNotNull();
    }

    private void setupWithMockBlogRepository() {
        blogRepository = new BlogRepository() {
            @Override
            public BlogEntry saveBlogEntry(BlogEntry blogEntry) {
                return null;
            }

            @Override
            public List<BlogEntry> findBlogEntries() {
                return null;
            }

            @Override
            public void deleteBlogEntry(BlogEntry blogEntry) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public Optional<BlogEntry> findBlogById(Long id) {
                BlogEntry blogEntry = new BlogEntry();
                return Optional.of(blogEntry);
            }

            @Override
            public Optional<BlogEntry> findBlogByName(String name) {
                BlogEntry blogEntry = new BlogEntry();
                return Optional.of(blogEntry);
            }
        };
    }
}