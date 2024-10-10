package week4.hcmute.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import week4.hcmute.configs.JPAConfig;
import week4.hcmute.entity.*;

public class VideoDao implements IVideoDao {

	@Override
	public void insert(Video video) {

		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();

			// gọi phuong thức để insert, update, delete
			enma.persist(video);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;

		} finally {
			enma.close();
		}
	}

	@Override
	public void update(Video video) {

		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();

			// gọi phuong thức để insert, update, delete

			enma.merge(video);

			trans.commit();

		} catch (Exception e) {

			e.printStackTrace();

			trans.rollback();

			throw e;
		} finally {
			enma.close();

		}
	}
	@Override
	public void delete(int videoid) throws Exception {

		EntityManager enma = JPAConfig.getEntityManager();
		EntityTransaction trans = enma.getTransaction();
		try {
			trans.begin();

			// gọi phuong thức để insert, update, delete

			Video video = enma.find(Video.class, videoid);
			if (video != null) {

				enma.remove(video);

			} else {

				throw new Exception("Không tìm thấy");

			}

			trans.commit();

		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();

			throw e;
		} finally {

			enma.close();
		}
	}
	@Override
	public Video findById(int videoid) {
		EntityManager enma = JPAConfig.getEntityManager();
		Video video = enma.find(Video.class, videoid);
		return video;
	}
	@Override
	public List<Video> findAll() {
		EntityManager enma = JPAConfig.getEntityManager();
		TypedQuery<Video> query = enma.createNamedQuery("Video.findAll", Video.class);
		return query.getResultList();
	}
	
	 @Override
	public List<Video> findAll(int page, int pagesize) {


		 EntityManager enma = JPAConfig.getEntityManager();


		 TypedQuery<Video> query= enma.createNamedQuery("Video.findAll", Video.class);


		 query.setFirstResult(page*pagesize);


		 query.setMaxResults(pagesize);


		 return query.getResultList();
		 }
	
}
