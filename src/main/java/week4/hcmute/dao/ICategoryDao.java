package week4.hcmute.dao;

import java.util.List;

import week4.hcmute.entity.Category;

public interface ICategoryDao {

	List<Category> findByCategoryname(String catname);

	List<Category> findAll();

	Category findById(int cateid);

	void delete(int cateid) throws Exception;

	void update(Category category);

	void insert(Category category);

	List<Category> findAll(int page, int pagesize);

}
