package com.example.demo.web.config;


import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {

    private static final String I18N_LANGUAGE_SESSION = "i18n_language_session";
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String param = request.getParameter("lang");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(param)){
            String []split = param.split("_");
            locale = new Locale(split[0],split[1]);
            //将国际化语言保存到session
            HttpSession session = request.getSession();
            session.setAttribute(I18N_LANGUAGE_SESSION,locale);
        }else{
            //如果没有带国际化参数，则判断session有没有保存，有保存，则使用保存的，
            // 也就是之前设置的，避免之后的请求不带国际化参数造成语言显示不对
            HttpSession session = request.getSession();
            Locale localeSession = (Locale) session.getAttribute(I18N_LANGUAGE_SESSION);
            if(localeSession!=null){
                locale = localeSession;
            }
        }
        return locale;
    }
    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
