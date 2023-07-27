package com.example.myapplication;

public class SearchResultRow {

    private String Title;
    private String Url;
    public SearchResultRow (String Title, String Url) {
        this.Title = Title;
        this.Url = Url;
    }
    public String getTitle () {
        return Title;
    }
    public String getUrl () {
        return Url;
    }
    public String toString () {
        return "row data is " + Title + " " + Url;
    }


}
