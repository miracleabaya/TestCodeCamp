import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {
   //import the selenium webdriver
    private WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException {
        //locate the WebDriver
        System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
        //1. open edge browser
        driver = new EdgeDriver();
        //2. input the selenium demo page url (https://selenium-blog.herokuapp.com/)
        driver.get("https://selenium-blog.herokuapp.com/");
        //Test 1. verify that user input the right url and his on the webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/"))
            //pass
            System.out.println("valid webpage");
        else
            //fail
        System.out.println("invalid webpage");
        Thread.sleep(5000);
        //3. maximize the browser
        driver.manage().window().maximize();
        //4. click on signup button to open signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 0)
    public void negativeSignup() throws InterruptedException {
        // Test 2. verify that when user clicks on the signup button, the user is directed to the signup page
        // 5. enter less than 3 characters username in the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("my");
        //6. enter email address in the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("abaya01@mailnator.com");
        //7. enter password in the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("admin01");
        //8. click on signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);

    }
    @Test (priority = 01)
    public void positiveSignup() throws InterruptedException {
        //9. clear the username
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).clear();
        //10. clear the email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).clear();
        //11. enter username in the username field
        driver.findElement(By.xpath("//*[@id=\"user_username\"]")).sendKeys("abaya01");
        //12. enter email address in email field
        driver.findElement(By.xpath("//*[@id=\"user_email\"]")).sendKeys("abaya01@mailnator");
        //13. enter password in the password field
        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys("admin");
        //14. click on the signup button
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        Thread.sleep(5000);
    }
    @AfterTest
    public void closebrowser(){
        //15. Quit the browser
        driver.quit();
    }

}





