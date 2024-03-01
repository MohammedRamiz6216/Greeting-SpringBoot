package com.bridgelabz.myservices;

import java.util.List;

import com.bridgelabz.model.Greetings;

public interface Myservice {
 public List<Greetings> getGreetings();
 public Greetings getGreeting(int id);
 public Greetings addGreetings(Greetings msg);
 public Greetings putGreetings(Greetings msg);
 public String deleteGreetings(int id);
 
}
