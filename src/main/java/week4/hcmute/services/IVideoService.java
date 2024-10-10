package week4.hcmute.services;

import java.util.List;

import week4.hcmute.entity.Video;

public interface IVideoService {

	void insert(Video video);

	void update(Video video);

	void delete(String videoid) throws Exception;

	Video findById(String videoid);

	List<Video> findAll();

	List<Video> findAll(int page, int pagesize);

}
