package museum.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

import Exception.ResourceAlreadyExistsException;

import Exception.ResourceNotFoundException;
import meseum.entity.Article;
import meseum.entity.Category;
import museumDao.ArticleDao;

public class ArticleService {
	private ArticleDao articleDao;
	
	public ArticleService() throws SQLException {
		articleDao = new ArticleDao();
	}
	
	public void addArticel(String name, Category category, LocalDate date_created, String creator_name) throws SQLException {
		
		
		Optional<Article> existingArticle = articleDao.findAll().stream().
		filter(article -> article.getName().equalsIgnoreCase(name)).findFirst();
		if(existingArticle.isEmpty()) {
			Article newArticle = new Article(0, name, category, date_created, creator_name);
			boolean status = articleDao.save(newArticle);
			if(status)
				System.out.println("Added Sucessfully");
			else
				System.out.println("Failed");
		}
		else
			throw new ResourceAlreadyExistsException("Article Already Exist");
		
	
	}
	public void displaAll() throws SQLException {
		articleDao.findAll().stream().forEach(article-> System.out.println(article));
	}
	public void displayArticleId(int id) throws SQLException {
		Article foundArticle = articleDao.findById(id);
		if(foundArticle !=null)
			System.out.println(foundArticle);
		else
			throw new ResourceNotFoundException("Article not found"+id);
	}
	public void displayArticle(int id) throws ResourceNotFoundException,SQLException {
		Article art = articleDao.findById(id);
		if (art != null)
			System.out.println(art);
		else
			throw new ResourceNotFoundException("Article not found with id " + id);
	}
	
	public void deleteArticle(int id) throws SQLException {
		Boolean status = articleDao.delete(id);
		if (status)
			System.out.println("Article deleted Sucessfully!!");
		else
			System.out.println("Article failed to delete!!");
		
	}
	
	public void updateArticle(int id, String name, Category category, LocalDate createdDate, String creatorName) throws SQLException,ResourceNotFoundException {
		Article art = articleDao.findById(id);
		if (art != null) {
		Boolean status = ((ArticleDao) articleDao).update(new Article(id, name, category, createdDate, creatorName));
		if (status)
			System.out.println("Article deleted Sucessfully!!");
		else
			System.out.println("Article failed to delete!!");
		}
		else
			throw new ResourceNotFoundException("Article not found with id " + id);
	
		
	}
}
 