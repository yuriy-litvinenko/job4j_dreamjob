package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

public class PsqlMain {

    public static void main(String[] args) {
        Store store = PsqlStore.instOf();

        store.save(new Post(0, "Java Job"));
        store.save(new Post(0, "Java Job 2"));
        int post_upd_id = 0;
        System.out.println("Post data after insert");
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
            post_upd_id = post.getId();
        }
        store.save(new Post(post_upd_id, "Java Job Update"));
        System.out.println("Post data after update last record");
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }

        store.save(new Candidate(0, "Java Worker"));
        store.save(new Candidate(0, "Java Worker 2"));
        int cand_upd_id = 0;
        System.out.println("Candidate data after insert");
        for (Candidate cand : store.findAllCandidates()) {
            System.out.println(cand.getId() + " " + cand.getName());
            cand_upd_id = cand.getId();
        }
        store.save(new Candidate(cand_upd_id, "Java Worker Update"));
        System.out.println("Candidate data after update last record");
        for (Candidate cand : store.findAllCandidates()) {
            System.out.println(cand.getId() + " " + cand.getName());
        }
    }
}
