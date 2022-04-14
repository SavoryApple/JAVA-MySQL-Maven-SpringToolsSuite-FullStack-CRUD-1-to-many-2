package com.seannavery.studentroster.services;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.seannavery.studentroster.models.Dorm;
import com.seannavery.studentroster.repositories.DormRepository;

@Service
public class DormService {
    // adding the book repository as a dependency
    private final DormRepository dormRepository;
    
    public DormService(DormRepository dormRepository) {
        this.dormRepository = dormRepository;
    }
    // returns all the books
    public List<Dorm> allDorms() {
        return dormRepository.findAll();
    }
    // creates a book
    public Dorm createDorm(Dorm b) {
        return dormRepository.save(b);
    }
    
    //deletes a book
    public void deleteDorm(Long id) {
    	dormRepository.deleteById(id);
    }
    
    // updates a book
     public Dorm updateDorm(Dorm dorm) {
    	Long dormId = dorm.getId();
    	String dormName = dorm.getName();
    	Dorm dormToUpdate = this.findDorm(dormId);   //set method below for this to work	
    	dormToUpdate.setName(dormName);
    	dormRepository.save(dormToUpdate);
        return dormToUpdate;
    }
    // retrieves a book
    public Dorm findDorm(Long id) {
        Optional<Dorm> optionalDorm = dormRepository.findById(id);
        if(optionalDorm.isPresent()) {
            return optionalDorm.get();
        } else {
            return null;
        }
    }
}
