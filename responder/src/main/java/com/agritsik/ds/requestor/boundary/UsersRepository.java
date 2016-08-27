package com.agritsik.ds.requestor.boundary;

import com.agritsik.ds.requestor.entity.User;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by andrey on 7/5/16.
 */
@Repository
public class UsersRepository {

    private List<User> all = new ArrayList<>();

    public UsersRepository() {
        Faker f = new Faker();

        all = IntStream.range(1, 100)
                .mapToObj(i -> new User(i, f.name().firstName(), f.name().lastName(), f.internet().emailAddress()))
                .collect(Collectors.toList());

    }

    public List<User> find() {
        return find(null);
    }

    public List<User> find(String startsWith) {
        if (startsWith == null) return all;
        return all.stream().filter(o -> o.getFirstName().startsWith(startsWith)).collect(Collectors.toList());
    }


}
