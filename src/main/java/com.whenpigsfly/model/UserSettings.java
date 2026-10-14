public class UserSettings{
    private String theme;
    private String defaultScreen;
    private boolean reducedMotion;
    private boolean mascotVisible;

//user settings costructor
public UserSettings(){
this.theme = "light";
this.defaultScreen = "dashboard";
this.reducedMotion = false;
this.mascotVisible = true;
}

//getters
public String getTheme(){
    return theme;
}

public String getDefaultScreen(){
    return defaultScreen;
}

public boolean isReducedMotion(){
    return reducedMotion;
}

public boolean isMascotVisible(){
    return mascotVisible;
}

//setters
public void setTheme(String theme){
    if(theme != null && !theme.isBlank()){
        this.theme = theme;
    }
}

public void setDefaultScreen(String screen){
    if(screen != null && !screen.isBlank()){
        defaultScreen = screen;
    }
}

public void setReducedMotion(boolean value){
    reducedMotion = value;
}

public void setMascotVisible(boolean value){
    mascotVisible = value;
}
}