package com.bridgelabz.RepoDao;

import org.springframework.data.repository.CrudRepository;

import com.bridgelabz.model.Greetings;

public interface GreetingRepo extends CrudRepository<Greetings,Integer>{

}
