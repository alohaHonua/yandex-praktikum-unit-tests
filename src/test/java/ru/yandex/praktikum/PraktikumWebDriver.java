package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.Test;
import org.junit.After;

public class PraktikumWebDriver {



    private WebDriver driver;

    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // Открыть вкладку
        driver.get("https://qa-mesto.praktikum-services.ru/");
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}