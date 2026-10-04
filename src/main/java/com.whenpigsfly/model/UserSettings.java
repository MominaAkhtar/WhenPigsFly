public class UserSettings{
    String theme;
    String defaultScreen;
    boolean reducedMotion;
    boolean mascotVisible;

//user settings costructor
public UserSettings(){

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
    this.theme = theme;
}

public void setDefaultScreen(String screen){
    defaultScreen = screen;
}

public void setReducedMotion(boolean value){
    reducedMotion = value;
}

public void setMascotVisible(boolean value){
    mascotVisible = value;
}
}