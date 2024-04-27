package com.tpe;

//Java tabanli Web uygulamalari web.xml dosyasi ile config edilir
//bu classi web.xml yerne kullanicaz.

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//DispatcherServlet konfigurasyonu icin gerekli adimlari gosterir
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {//dataya erisim: Hibernate, JBDC
        return new Class[]{
                RootConfig.class
        };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {//viewresolver, handlermapping
        return new Class[]{
                WebMvcConfig.class
        };
    }

    @Override//hangi url ile gelen istekler servlet tarafindan karsilanacak ayarlamasi
    protected String[] getServletMappings() {
        return new String[]{
                "/"
        };
    }
}
