package ru.yandex.praktikum;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FindElements {

    private WebDriver driver;

    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);

        //Неявное ожидание (автоматическое ожидание перед findElement/s() )
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("http://www.example.com"); // открыли страницу

        WebElement element = driver.findElement(By.xpath(".//img")); // Для поиска одного элемента

        List<WebElement> elements = driver.findElements(By.xpath(".//button")); // Для поиска нескольких элементов

        //клик по элементу
        WebElement elementToClick = driver.findElement(By.linkText("Вход"));
        element.click();
    }
}
