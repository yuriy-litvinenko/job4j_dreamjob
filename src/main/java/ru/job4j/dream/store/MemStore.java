package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {

    private static final MemStore INST = new MemStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private final Map<String, User> users = new ConcurrentHashMap<>();

    private static final AtomicInteger POST_ID = new AtomicInteger(4);

    private static final AtomicInteger CANDIDATE_ID = new AtomicInteger(4);

    private static final AtomicInteger USER_ID = new AtomicInteger(2);

    private MemStore() {
        posts.put(1, new Post(1, "Junior Java Job", new Date(System.currentTimeMillis())));
        posts.put(2, new Post(2, "Middle Java Job", new Date(System.currentTimeMillis())));
        posts.put(3, new Post(3, "Senior Java Job", new Date(System.currentTimeMillis())));
        candidates.put(1, new Candidate(1, "Junior Java", 1, new Date(System.currentTimeMillis())));
        candidates.put(2, new Candidate(2, "Middle Java", 2, new Date(System.currentTimeMillis())));
        candidates.put(3, new Candidate(3, "Senior Java", 3, new Date(System.currentTimeMillis())));
        users.put("admin@mail.ru", new User(1, "Admin", "admin@mail.ru", "Admin"));
    }

    public static MemStore instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public void save(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    @Override
    public void save(User user) {
        users.put(user.getEmail(), user);
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }

    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    @Override
    public User findUserByEmail(String email) {
        return users.get(email);
    }

    @Override
    public Collection<City> findAllCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City(1, "Москва"));
        cities.add(new City(2, "Берлин"));
        cities.add(new City(3, "Прага"));
        return cities;
    }

    @Override
    public Object findLastDayCandidates() {
        return null;
    }

    @Override
    public Object findLastDayPosts() {
        return null;
    }
}
