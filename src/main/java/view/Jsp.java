package view;

import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;
import java.util.Locale;

public class Jsp extends InternalResourceView  {
    @Override
    public boolean checkResource(Locale locale) {
        File file = new File(this.getServletContext().getRealPath("/") + getUrl());
        System.out.println("================"+toString());
        return file.exists();// 判断该页面是否存在
    }
}
