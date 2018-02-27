package com.example.carherpi.quoteapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.carherpi.quoteapp.Adapter.QuotationAdapter;
import com.example.carherpi.quoteapp.pojo.Quotation;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class FavouriteActivity extends AppCompatActivity {

    Context context;
    ListView favouriteListView;
    QuotationAdapter adapter;
    int selectedItem;
    boolean clearAllQuotations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourite);

        // Reference to the current execution context
        context = this;

        // Keep a reference to the ListView object displaying the favourite quotations
        favouriteListView = (ListView) findViewById(R.id.lvFavourite);

        // Create the adapter linking the data source to the ListView:
        adapter = new QuotationAdapter(this, R.layout.quotation_list_row, new ArrayList<Quotation>());

        // Add all the quotations to the data source
        adapter.addAll(getMockQuotations());

        // Set the data behind this ListView
        favouriteListView.setAdapter(adapter);

        favouriteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String author;
                try {
                    // Get the quotation author from the data source and
                    // encode it using UTF-8 to be used as part of an URL
                    //author = URLEncoder.encode(quotationList.get(position).getQuoteAuthor(), "UTF-8");
                    author = URLEncoder.encode(((TextView) view.findViewById(R.id.tvAuthor)).getText().toString(), "UTF-8");

                    // If the quotation is not anonymous, then access Wikipedia
                    if (!author.isEmpty()) {
                        // Create an implicit Intent
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        // Specify the URI required to search for the author on Wikipedia
                        intent.setData(
                                Uri.parse("http://en.wikipedia.org/wiki/Special:Search?search=" + author));
                        // Check whether there is an application able to handle that Intent
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            // Launch the activity
                            startActivity(intent);
                        }
                    }
                    // If the quotation is anonymous then display a message
                    else {
                        Toast.makeText(context, R.string.anonymous_author, Toast.LENGTH_SHORT).show();
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

        favouriteListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                // Keep a reference to the currently selected item
                selectedItem = position;

                // Build an AlertDialog to ask for confirmation before deleting the item
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                // Set the massage to display in the Dialog
                builder.setMessage(R.string.confirmation_delete);
                // Include a Button for handling positive confirmation: delete quotation
                builder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        final Quotation item = (Quotation) adapter.getItem(selectedItem);

                        // Delete the quotation from the data source
                        adapter.remove(item);

                        // If there are no quotations in the favourite list then set to false the flag
                        // that controls whether to display the action for deleting all the quotations
                        if (adapter.getCount() == 0) {
                            clearAllQuotations = false;
                            // Ask the system to rebuild the options of the ActionBar
                            supportInvalidateOptionsMenu();
                        }

                    }
                });
                // Include a Button for handling negative confirmation: do not delete quotation
                // No need for an onClickListener() here, as no action will take place
                builder.setNegativeButton(android.R.string.no, null);
                // Create and show the Dialog
                builder.create().show();
                // Return true as we handled the event
                return true;
            }
        });

    }

    public void clickAuthor(View view) {
        String authorName = "Albert Einstein";
        String url ="http://en.wikipedia.org/wiki/Special:Search?search=" + authorName;
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }

    private List<Quotation> getMockQuotations() {
        List<Quotation> result = new ArrayList<>();
        Quotation item;

        item = new Quotation();
        item.setQuoteText("Think Big");
        item.setQuoteAuthor("IMAX");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("Push button publishing");
        item.setQuoteAuthor("Blogger");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("Beauty outside. Beast inside");
        item.setQuoteAuthor("Mac Pro");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("American by birth. Rebel by choice");
        item.setQuoteAuthor("Harley Davidson");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("Don't be evil");
        item.setQuoteAuthor("Google");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("If you want to impress someone, put him on your Black list");
        item.setQuoteAuthor("Johnnie Walker");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("Live in your world. Play in ours");
        item.setQuoteAuthor("Playstation");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("Impossible is nothing");
        item.setQuoteAuthor("Adidas");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("Solutions for a small planet");
        item.setQuoteAuthor("IBM");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("I'm lovin it");
        item.setQuoteAuthor("McDonalds");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("Just do it");
        item.setQuoteAuthor("Nike");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("Melts in your mouth, not in your hands");
        item.setQuoteAuthor("M&M");
        result.add(item);

        item = new Quotation();
        item.setQuoteText("Because you're worth it");
        item.setQuoteAuthor("Loreal");
        result.add(item);

        return result;
    }
}
