package ohtu;

import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        Random r = new Random();
        WebDriver driver = new ChromeDriver();

        //alkuperäinen testi. Pystyy kirjautumaan sisään olemassaolevalla käyttäjätunnuksella
        driver.get("http://localhost:4567");

        sleep(2);
        WebElement element = driver.findElement(By.linkText("login"));
        /*
         */
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);

        //Kirjautuminen. Oikea käyttäjätunnus väärä salasana
        driver.get("http://localhost:4567");

        sleep(2);
        element = driver.findElement(By.linkText("login"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("login"));
        sleep(2);
        element.submit();
        sleep(3);
        // uuden käyttäjätunnuksen luominen
        driver.get("http://localhost:4567");
        sleep(2);
        element = driver.findElement(By.linkText("register new user"));
        element.click();
        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka" + r.nextInt(999999));
        element = driver.findElement(By.name("password"));
        element.sendKeys("passw0rd");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("passw0rd");
        sleep(2);
        element.submit();
        sleep(3);
        // tämän jälkeen uloskirjautuminen
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);
        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(3);
        driver.quit();
    }

    private static void sleep(int n) {
        try {
            Thread.sleep(n * 1000);
        } catch (Exception e) {
        }
    }
}
