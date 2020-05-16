package view;

import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.spring4.view.AbstractThymeleafView;
import org.thymeleaf.spring4.view.ThymeleafView;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

import java.io.File;
import java.util.Locale;

public class HtmlView extends ThymeleafView {

//
//    @Override
//    public boolean checkResource(Locale locale) {
//        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
//        return file.exists();// 判断该页面是否存在
//    }
}
