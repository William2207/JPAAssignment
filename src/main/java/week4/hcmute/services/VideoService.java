package week4.hcmute.services;
import java.util.List;

import week4.hcmute.dao.*;
import week4.hcmute.entity.*;
public class VideoService implements IVideoService{
	IVideoDao videodao = new VideoDao();
	@Override
	public List<Video> findAll(int page, int pagesize) {
		return videodao.findAll(page, pagesize);
	}
	@Override
	public List<Video> findAll() {
		return videodao.findAll();
	}
	@Override
	public Video findById(int videoid) {
		return videodao.findById(videoid);
	}
	@Override
	public void delete(int videoid) throws Exception {
		 videodao.delete(videoid);
		
	}
	@Override
	public void update(Video video) {
		 videodao.update(video);
	}
	@Override
	public void insert(Video video) {
		videodao.insert(video);
		
	}
}
