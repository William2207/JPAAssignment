package week4.hcmute.services;

import java.util.List;

import week4.hcmute.entity.Video;

public interface IVideoService {

	void insert(Video video);

	void update(Video video);

	void delete(int videoid) throws Exception;

	Video findById(int videoid);

	List<Video> findAll();

	List<Video> findAll(int page, int pagesize);

}
