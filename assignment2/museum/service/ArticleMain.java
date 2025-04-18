package museum.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import Exception.ResourceAlreadyExistsException;

import Exception.ResourceNotFoundException;
import meseum.entity.Category;

public class ArticleMain {
	
	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		ArticleService service =null;
		try {
			service = new ArticleService();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		boolean exit =true;
		while(exit) {
			System.out.println("1.Add Article"+"\n2.Display All Article"+"\n3.Display Details Of Article"+"\n0.Exit");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
			{
				try {
					System.out.println("Enter Articel name, category(PAINTING, SCULPTURE, ARTIFACT), created date,created name: ");
					String name=sc.next();
					Category category=Category.valueOf(sc.next());
					LocalDate date = LocalDate.parse(sc.next());
					String creatorName = sc.next();
					service.addArticel(name, category, date, creatorName);
				} catch (SQLException | ResourceAlreadyExistsException e) {
					System.err.println(e.getMessage());
				}
				break;
			}	
			case 2:{
				try {
					service.displaAll();
				} catch (SQLException e) {
					System.err.println(e.getMessage());
				}
				break;
			}
			case 3:{
				try {
					System.out.println("Enter Article Id");
					service.displayArticleId(sc.nextInt());
					
				} catch (SQLException | ResourceNotFoundException ex) {
					System.err.println(ex.getMessage());
				}
				break;
			}
			case 0:{
				exit = false;
				System.out.println("Thanks For Visiting");
				break;
			}
			default:
				System.out.println("Unexcepted Exception...");
			case 4: {
				System.out.println("enter id");
				try {
					service.deleteArticle(sc.nextInt());
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
				break;
			}
			case 5: {
				System.out.println("enter id, name, category(PAINTING,SCULPTURE, ARTIFACT),date, creator name");
				try {
					service.updateArticle(sc.nextInt(), sc.next(), Category.valueOf(sc.next()), LocalDate.parse(sc.next()), sc.next());
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}

			
			}
		}
	}
}
