import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaTest {

    //import the konga url
    private WebDriver driver;
    @BeforeTest
    public void start() throws InterruptedException {
        // locate the webdriver
        System.setProperty("webdriver.edge.driver","src/main/resources/msedgedriver.exe");
        //1. visit the url konga
        driver = new EdgeDriver();
        //2. input the konga page url (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        //3. maximize the browser
        driver.manage().window().maximize();
        //4. click on login to open konga login page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a"));
        Thread.sleep(5000);

    }
    @Test (priority = 1)
    public void positiveTest() throws InterruptedException {
        //click on the computer accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        //click on the laptops in subcategory
        driver.findElements(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a")).clear();
        //click on the Apple MacBooks
        driver.findElements(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).clear();
        //add an item to the cart
        driver.findElements(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).clear();
        //select address
        driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).clear();
        //continue to make payment
        driver.findElements(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).clear();
        //select a card payment method3
        driver.findElements(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).clear();
        //select a card payment method
        driver.findElements(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).clear();
        //input invalid card details
        driver.findElements(By.xpath("//*[@id=\"validateCardForm\"]")).clear();
        //print out the error message: invalid card number
        driver.findElements(By.xpath("//*[@id=\"card-number_unhappy\"]")).clear();
        //close the iframe that displays the input card model
        driver.findElements(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).clear();
        Thread.sleep(5000);

    }

    @AfterTest
    public void closebrowser(){
        // quite the browser
        driver.quit();
    }

}
