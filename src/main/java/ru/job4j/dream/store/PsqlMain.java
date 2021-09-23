package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.sql.Date;

public class PsqlMain {

    public static void main(String[] args) {
        Store store = PsqlStore.instOf();

        store.save(new Post(0, "Java Job", new Date(System.currentTimeMillis())));
        store.save(new Post(0, "Java Job 2", new Date(System.currentTimeMillis())));
        int postUpdId = 0;
        System.out.println("Post data after insert");
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
            postUpdId = post.getId();
        }
        store.save(new Post(postUpdId, "Java Job Update", new Date(System.currentTimeMillis())));
        System.out.println("Post data after update last record");
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }

        store.save(new Candidate(0, "Java Worker", 1, new java.sql.Date(System.currentTimeMillis())));
        store.save(new Candidate(0, "Java Worker 2", 2, new java.sql.Date(System.currentTimeMillis())));
        int candUpdId = 0;
        System.out.println("Candidate data after insert");
        for (Candidate cand : store.findAllCandidates()) {
            System.out.println(cand.getId() + " " + cand.getName());
            candUpdId = cand.getId();
        }
        store.save(new Candidate(candUpdId, "Java Worker Update", 3, new Date(System.currentTimeMillis())));
        System.out.println("Candidate data after update last record");
        for (Candidate cand : store.findAllCandidates()) {
            System.out.println(cand.getId() + " " + cand.getName());
        }
    }
}
