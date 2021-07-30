
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class jdbcConnection {

	public static void main(String[] args) throws SQLException   {
		// TODO Auto-generated method stub
		String host = "localhost";
		String port = "3306";
		//Class.forName("com.mysql.jdbc.Driver");
		//DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
		Connection con = DriverManager.getConnection("jdbc:mysql://" + host +":"+ port + "/salesForce", "root", "BelieveOnYou@22");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("Select * from employee where id = 74");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	
	driver.get("https://login.salesforce.com/?locale=eu");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		while(rs.next())
		{
			
			driver.findElement(By.xpath("//input[@id='username']")).sendKeys(rs.getString("username"));
			driver.findElement(By.cssSelector("#password")).sendKeys(rs.getString("password"));
			driver.findElement(By.cssSelector("#Login")).click();
		
		}

	}

}
