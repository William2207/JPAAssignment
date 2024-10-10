package week4.hcmute.entity;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;



@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Videos")
@NamedQuery(name = "Video.findAll", query = "SELECT c FROM Video c")
public class Video implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "VideoId")
	private String videoid;
	
	@Column(name = "Active")
	private boolean active;
	
	@Column(name = "Description", columnDefinition = "NVARCHAR(500) null")
	private String description;
	
	@Column(name="Poster", columnDefinition = "NVARCHAR(500) null")
	private String poster;
	
	@Column(name="Title", columnDefinition = "NVARCHAR(500) null")
	private String title;
	
	@Column(name="Views")
	private int views;
	
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category category;
	
}
