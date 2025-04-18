package meseum.entity;

import java.time.LocalDate;


public class Article {
	private int id;
	private String name;
	private Category category;
	private LocalDate createdDate;
	private String creator_name ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreator_name() {
		return creator_name;
	}
	public void setCreator_name(String creator_name) {
		this.creator_name = creator_name;
	}
	public int getId() {
		return id;
	}
	public Article(int id, String name, Category category, LocalDate createdDate, String creator_name) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.createdDate = createdDate;
		this.creator_name = creator_name;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", name=" + name + ", category=" + category + ", createdDate=" + createdDate
				+ ", creator_name=" + creator_name + "]";
	}

	
	
	
}
