package com.cg.iter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.iter.dao.TraineeDAO;
import com.cg.iter.entitie.Trainee;
import com.cg.iter.exceptions.ApplicationException;


@Service
@Transactional
public class TraineeServiceImpl implements TraineeService {

    @Autowired private TraineeDAO dao;
    
    @Transactional(readOnly=true)
    
    public Trainee find(int id) {
        Trainee t=dao.findById(id);
    	if(t!=null)
    		return dao.findById(id);
    	else
    		 throw new ApplicationException("Trainee with "+id+" doesn't exists!");
    }

    @Transactional(readOnly=true)
    
    public List<Trainee> getAll() {
        return dao.findAll();
    }

    @Transactional(propagation=Propagation.REQUIRED)
    
    public void create(Trainee p) {
    	try {
        dao.save(p);
    	}
    	catch(Exception e) {
           throw new ApplicationException("Trainee with "+p.getId()+" already exists!");
    	}
    }

	public void delete(int id) {
		
		Trainee t=dao.findById(id);
		if(t!=null){
		dao.delete(id);
		}
		else{
	           throw new ApplicationException("Trainee with "+id+" doesn't exists!");
	    	}
	}

	public void modify(Trainee t) {
		
		Trainee t1=dao.findById(t.getId());
		
		if(t1!=null){
			dao.modify(t);
		}
		else
		           throw new ApplicationException("Trainee with "+t1.getId()+" doesn't exists!");
		    	
	}

}
