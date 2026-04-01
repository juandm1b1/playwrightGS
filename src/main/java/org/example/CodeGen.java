package org.example;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class CodeGen {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                .setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://demo.playwright.dev/todomvc/#/");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).fill("lo que sea");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).press("Enter");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).fill("otra cosa");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("What needs to be done?")).press("Enter");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Active")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("All")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Completed")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("All")).click();
            page.getByRole(AriaRole.LISTITEM).filter(new Locator.FilterOptions().setHasText("lo que sea")).getByLabel("Toggle Todo").check();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Completed")).click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Active")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Delete")).click();       
        }
    }
}