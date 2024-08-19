package tek.bdd.pages;

import org.openqa.selenium.By;
public class AccountPage {
        public static final By PROFILE_PAGE_TITLE = By.className("account__personal-title");
        public static final By PROFILE_EMAIL_TEXT = By.className("account__information-email");
        public static final By TOAST_BOX = By.className("Toastify__toast-body");

        public static final By ACCOUNT_PROFILE_NAME_TEXT = By.className("account__information-username");

        public static final By PREVIOUS_PASSWORD_INPUT = By.id("previousPasswordInput");
        public static final By NEW_PASSWORD = By.name("newPassword");
        public static final By CONFIRM_NEW_PASSWORD = By.name("confirmPassword");
        public static final By CLICK_PASSWORD_BTN = By.id("credentialsSubmitBtn");


}
