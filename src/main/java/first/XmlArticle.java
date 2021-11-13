package first;

import jdk.nashorn.internal.objects.annotations.Setter;

public class XmlArticle {

    private String title;
    private String content;

    public void setTitle(String title){
        this.title = title;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getTitle(){
        return title;
    }

    public String getContent(){
        return content;
    }
    // usual getters and setters
}