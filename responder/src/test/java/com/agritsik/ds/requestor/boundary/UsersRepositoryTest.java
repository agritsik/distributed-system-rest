package com.agritsik.ds.requestor.boundary;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrey on 8/27/16.
 */
public class UsersRepositoryTest {

    @Test
    public void findAll() throws Exception {

        // arrange
        UsersRepository repository = new UsersRepository();
        repository.find().stream().forEach(System.out::println);

        // act && assert
        assertEquals(99, repository.find().size());

    }

}