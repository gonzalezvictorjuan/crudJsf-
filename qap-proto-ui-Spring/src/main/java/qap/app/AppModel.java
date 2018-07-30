package qap.app;

/**
 *
 * @author christian
 */
public class AppModel {
    private String name;
    private String title;
    private String description;
    private String version;
    private String logo;
    private String icon;
    private String banner;

    public AppModel(String appName) {
        this.name  = appName;
        this.title = appName;
        this.description = appName + " es una aplicación web";
        this.version = "1.0";
        
        String leftFile = "/resources/images/" + appName.toLowerCase() + "/" + appName.toLowerCase();
        this.logo    = leftFile + "_logo.png";
        this.icon    = leftFile + "_favicon.png";
        this.banner  = leftFile + "_banner.png";
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }        
    
}
