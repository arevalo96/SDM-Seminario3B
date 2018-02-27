package com.example.carherpi.quoteapp.pojo;

/**
 * Created by Usuario on 27/02/2018.
 */

public class Quotation {
    private String quoteText;
    private String quoteAuthor;

    public void setQuoteText(String quoteText){
        this.quoteText = quoteText;
    }

    public String getQuoteText(){
        return  quoteText;
    }

    public void setQuoteAuthor(String quoteAuthor){
        this.quoteAuthor = quoteAuthor;
    }

    public String getQuoteAuthor(){
        return  quoteAuthor;
    }

}
