package com.innostax.CRUD.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innostax.CRUD.dao.UserRepositoryImpl;
import com.innostax.CRUD.entity.User;

@Service
public class ServiceImpl implements ServiceInter {

	@Autowired
	UserRepositoryImpl userRepository;

	@Override
	public List<User> sortedList(List<User> list) {

		return helperToSort(list);
	}

	private static List<User> helperToSort(List<User> list) {
		ArrayList<String> Slist = new ArrayList<>();
		for (User user : list) {
			Slist.add(user.getName());
		}
		

		Collections.sort(Slist);
		

		return resultGen(Slist, list);
	}

	private static List<User> resultGen(ArrayList<String> Slist, List<User> list) {
		int n = Slist.size();
		List<User> result = new ArrayList<>();
		System.out.println(Slist) ;
		System.out.println(list) ;
		for (int i = 0; i < n; i++) {
			String check = Slist.get(i) ; 
			for(int j = 0 ; j < list.size() ; j ++) {
				if(list.get(j).getName().toString().equals(check)) {
					result.add(list.get(j)) ;
					list.remove(j) ;
				}
			}
		}
		
		

		return result;
	}

}
