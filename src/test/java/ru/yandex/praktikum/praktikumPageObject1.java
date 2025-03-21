package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
public class praktikumPageObject1 {

    private WebDriver driver;

    @Test
    public void checkEmailInHeader() {
        // создали драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // перешли на страницу тестового приложения
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // создай объект класса страницы авторизации
        LoginPageMesto loginPage = new LoginPageMesto(driver);

        // выполни авторизацию
        String email = "kalnina_45@yandex.ru";
        String password = "123456788";
        // передавай эти переменные внутрь метода
        loginPage.login(email, password);

        // создай объект класса заголовка приложения
        HeaderPageMesto headerPageMesto = new HeaderPageMesto(driver);
        // дождись загрузки заголовка
        headerPageMesto.waitForLoadHeader();

        // получи текст элемента в заголовке
        String header = headerPageMesto.emailInHeader();

        // сделай проверку, что полученное значение совпадает с email
        MatcherAssert.assertThat(header, is(email));
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
