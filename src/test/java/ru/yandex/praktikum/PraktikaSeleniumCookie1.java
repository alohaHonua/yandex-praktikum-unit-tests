package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.Cookie;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.junit.Test;
        import org.junit.After;

public class PraktikaSeleniumCookie1 {

    private WebDriver driver;

    @Test
    public void test() {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Добавили новый куки:
        Cookie newCookie = new Cookie("my_first_cookie","15");
        driver.manage().addCookie(newCookie);

        // Изменили значение куки: сначала нужно удалить куки, а затем добавить снова с новым значением
        driver.manage().deleteCookieNamed("my_first_cookie");

        Cookie newCookie1 = new Cookie("my_first_cookie", "25");
        driver.manage().addCookie(newCookie1);
    }

    @After
    public void teardown() {

        driver.quit();
    }
}