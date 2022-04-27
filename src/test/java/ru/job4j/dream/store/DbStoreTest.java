package ru.job4j.dream.store;

import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.sql.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DbStoreTest {
    @Test
    public void whenCreatePost() {
        Store store = PsqlStore.instOf();
        Post post = new Post(0, "Java Junior", null);
        store.save(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenUpdatePost() {
        Store store = PsqlStore.instOf();
        Post post = new Post(1, "Java Middle", null);
        store.save(post);
        Post postInDb = store.findPostById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
    }

    @Test
    public void whenCreateCandidate() {
        Store store = PsqlStore.instOf();
        Candidate candidate = new Candidate(0, "Java Junior", 1, new Date(System.currentTimeMillis()));
        store.save(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }

    @Test
    public void whenUpdateCandidate() {
        Store store = PsqlStore.instOf();
        Candidate candidate = new Candidate(1, "Java Middle", 2, new Date(System.currentTimeMillis()));
        store.save(candidate);
        Candidate candidateInDb = store.findCandidateById(candidate.getId());
        assertThat(candidateInDb.getName(), is(candidate.getName()));
    }
}
