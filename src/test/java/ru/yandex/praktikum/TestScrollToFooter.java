package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestScrollToFooter {

    private WebDriver driver;

    @Test
    public void test() {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Это блок авторизации
        driver.findElement(By.id("email")).sendKeys("kalnina_45@yandex.ru");
        driver.findElement(By.id("password")).sendKeys("123456788");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));

        // Найди футер
        WebElement element = driver.findElement(By.xpath(".//footer"));
        // Прокрути страницу до футера
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
