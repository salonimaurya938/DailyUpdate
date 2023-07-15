package com.sabpaisa.dao;



import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sabpaisa.entity.Book;

//@EnableJpaRepositories
@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

//	Collection<Book> findByMyClassName(String subName);
	
//	 Book getbyStatus(String subStatus);
	
//	List<Book> findByName(String subName);
	

}
