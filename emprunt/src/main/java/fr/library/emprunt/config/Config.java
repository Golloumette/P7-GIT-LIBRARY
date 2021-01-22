package fr.library.emprunt.config;

import java.util.ResourceBundle;

public class Config {
    private String classname;
    private String url;
    private String user;
    private String password;
    private String show;
    private String ddl;

    public String getShow() {
        return show;
    }
    public String getDdl() {
        return ddl;
    }
    public String getClassname() {
        return classname;
    }
    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public String getUrl() {
        return url;
    }

    public static Config getRessource() {
        if (ressource ==null) {
            ressource = new Config();
        }
        return ressource;
    }


    private static Config ressource;

    private Config() {
        readerproperty();

    }

    public void readerproperty() {
        ResourceBundle config = ResourceBundle.getBundle("library");


        classname = config.getString("spring.datasource.driver-class-name");
        user = config.getString("spring.datasource.username");
        password = config.getString("spring.datasource.password");
        url=config.getString("spring.datasource.url");
        show=config.getString("spring.jpa.show-sql");
        ddl=config.getString("spring.jpa.hibernate.ddl-auto");

    }


}
