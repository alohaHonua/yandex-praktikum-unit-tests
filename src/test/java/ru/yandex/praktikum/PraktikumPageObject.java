package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Test;
import org.junit.After;

public class PraktikumPageObject {

    private WebDriver driver;

    @Test
    public void loginTest() {

        ChromeOptions options = new ChromeOptions(); // Драйвер для браузера
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // создать объект класса страницы авторизации
        LoginPageMesto objLoginPage = new LoginPageMesto(driver);

        // выполнить авторизацию
        objLoginPage.login("Введи сюда email твоей учётной записи",
                "Введи сюда пароль твоей учётной записи");

    }

    @After
    public void tearDown() {
        // Закрыть браузер
        driver.quit();
    }
}