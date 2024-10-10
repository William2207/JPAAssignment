package week4.hcmute.dao;

import java.util.List;

import week4.hcmute.entity.Video;

public interface IVideoDao {

	List<Video> findAll(int page, int pagesize);

	List<Video> findAll();

	Video findById(int videoid);

	void delete(int videoid) throws Exception;

	void update(Video video);

	void insert(Video video);

}
