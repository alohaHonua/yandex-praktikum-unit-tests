package ru.yandex.praktikum;

import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.chrome.ChromeOptions;
        import org.openqa.selenium.By;
        import org.junit.Test;
        import org.junit.After;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;

public class PraktikaSelenium2 {

    private WebDriver driver;

    @Test
    public void test() throws InterruptedException {
        // Создаём драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Выполни авторизацию
        driver.findElement(By.id("email")).sendKeys("kalnina_45@yandex.ru");
        driver.findElement(By.id("password")).sendKeys("123456788");
        driver.findElement(By.className("auth-form__button")).click();

        System.out.println("Авторизация пройдена");
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("profile__image")));

        // Кликни по кнопке добавления нового контента
        driver.findElement(By.className("profile__add-button")).click();
        System.out.println("Клик по кнопке добавления нового контента");

        // В поле названия введи «Прага»
        driver.findElement(By.name("name")).sendKeys("Прага");
        System.out.println("В поле названия ввели «Прага»");
        System.out.println(driver.findElement(By.xpath(".//input[@name='name']")).getAttribute("value"));

        // В поле ссылки на изображение введи ссылку
        driver.findElement(By.name("link")).sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/new_photo_selenium.jpg");
        System.out.println("В поле названия ввели ссылку");
        System.out.println(driver.findElement(By.name("link")).getAttribute("value"));


        // Сохрани контент
        driver.findElement(By.xpath(".//form[@name='new-card']/button[text()='Сохранить']")).click();
        System.out.println("Нажали сохранить");

        Thread.sleep(1000);
        // Дождись появления кнопки удаления карточки
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated((By.xpath(".//button[@class = 'card__delete-button card__delete-button_visible']"))));
        System.out.println("Подождали появления кнопки удаления карточки");

        // Удали контент
        driver.findElement(By.xpath(".//button[@class = 'card__delete-button card__delete-button_visible']")).click();
        System.out.println("Удалили карточку");
    }

    @After
    public void teardown() {
     driver.quit();
    }
}