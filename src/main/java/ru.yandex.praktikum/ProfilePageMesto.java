package ru.yandex.praktikum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

// Класс cтраницы редактирования профиля
class ProfilePageMesto {

    private WebDriver driver;
    // создай локатор для поля «Занятие» в профиле пользователя
    private By activity = By.id("owner-description");

    // создай локатор для кнопки «Сохранить» в профиле пользователя
    private By save = By.xpath(".//form[@name = 'edit']/button[2]");

    public ProfilePageMesto (WebDriver driver){
        this.driver = driver;
    }

    // метод для проверки открытости поля «Занятие», удаления текста из неё и ввода нового значения из параметра
    public void changeProfileDescription(String changed){
        //Assert.assertTrue(driver.findElement(activity).isEnabled());
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(activity));
        driver.findElement(activity).clear();
        driver.findElement(activity).sendKeys(changed);
    }

    // метод для нажатия на кнопку сохранения профиля
    public void clickSaveProfileButton(){
        driver.findElement(save).click();
    }
}
