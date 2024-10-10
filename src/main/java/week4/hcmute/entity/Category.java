package week4.hcmute.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="categories")
@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CategoryId")
	
	private int categoryid;
	
	@Column(name="CategoryName",columnDefinition = "nvarchar(50) not null")
	@NotEmpty(message="Khong duoc phep rong")
	private String categoryname;
	
	@Column(name = "Images", columnDefinition = "NVARCHAR(MAX) NULL")
	private String images;
	
	@Column(name = "Status")
	private int status;
	
	@OneToMany(mappedBy = "category")
	private List<Video> videos;
	
	public Video addVideo(Video video)
	{
		getVideos().add(video);
		video.setCategory(this);
		
		return video;
	}
	
	public Video removeVideo(Video video)
	{
		getVideos().remove(video);
		video.setCategory(null);
		
		return video;
	}
}
