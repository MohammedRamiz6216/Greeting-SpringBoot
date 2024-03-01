package com.bridgelabz.myservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.RepoDao.GreetingRepo;
import com.bridgelabz.model.Greetings;

@Service
public class Myserviceimpl implements Myservice {
	@Autowired
	private GreetingRepo repo;
      
	@Override
	public List<Greetings> getGreetings() {
		// TODO Auto-generated method stub
		return (List<Greetings>) repo.findAll();
	}

	@Override
	public Greetings getGreeting(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Greetings addGreetings(Greetings msg) {
		// TODO Auto-generated method stub
		return repo.save(msg);
	}

	@Override
	public Greetings putGreetings(Greetings msg) {
		// TODO Auto-generated method stub
//		return repo.save(msg);
		Greetings existingGreetings = repo.findById(msg.getId()).orElse(null);
		existingGreetings.setName(msg.getName());
		existingGreetings.setMessage(msg.getMessage());
		return repo.save(existingGreetings);
	}

	@Override
	public String deleteGreetings(int id) {
		// TODO Auto-generated method stub
		 repo.deleteById(id);
		 return "Message removed!!"+id;
		
	}

	

}
