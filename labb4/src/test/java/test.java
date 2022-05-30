import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import static org.junit.jupiter.api.Assertions.*;
public class test {
    static WebDriver driver;
    static final String Website = "https://formy-project.herokuapp.com/form";
    @BeforeAll
    public static void init(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
    }
    @BeforeEach
    public void BE(){
        driver.get(Website);
    }

    @Test
    public void test1(){
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement jT = driver.findElement(By.id("job-title"));
        WebElement levelofeducation = driver.findElement(By.id("radio-button-2"));

        firstName.sendKeys("Hana");
        lastName.sendKeys("Elmaghraby");
        jT.sendKeys("Student");
        levelofeducation.click();

        assertEquals(firstName.getAttribute("value"),"Hana");
        assertEquals(lastName.getAttribute("value"),"Elmaghraby");
        assertEquals(jT.getAttribute("value"),"Student");
        assertTrue(levelofeducation.isSelected());
        WebElement button = driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a"));
        button.click();

    }
}