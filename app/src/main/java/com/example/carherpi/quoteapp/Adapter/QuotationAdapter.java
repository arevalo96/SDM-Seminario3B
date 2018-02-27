package com.example.carherpi.quoteapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.carherpi.quoteapp.pojo.Quotation;
import com.example.carherpi.quoteapp.R;

import java.util.List;

/**
 * Created by Usuario on 27/02/2018.
 */

public class QuotationAdapter extends ArrayAdapter {

    private List<Quotation> data;
    private int layout;
    private Context context;

    private class ViewHolder {
        TextView tvQuotationText;
        TextView tvQuotationAuthor;
    }



    public QuotationAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);

        this.data = objects;
        this.context = context;
        this.layout = resource;
    }

    public View getView(int position, @Nullable View convertView , @NonNull ViewGroup parent) {
        View result = convertView;
        ViewHolder holder;

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            result = ((Activity) this.context).getLayoutInflater().inflate(this.layout, null);

            // Keep references for View elements in the layout
            holder = new ViewHolder();
            holder.tvQuotationText = result.findViewById(R.id.tvQuote);
            holder.tvQuotationAuthor = result.findViewById(R.id.tvAuthor);
            // Associate the ViewHolder to the View
            result.setTag(holder);
        }

        // Retrieve the ViewHolder from the View
        holder = (ViewHolder) result.getTag();
        // Populate the View with information from the required position of the data source
        holder.tvQuotationText.setText(data.get(position).getQuoteText());
        holder.tvQuotationAuthor.setText(data.get(position).getQuoteAuthor());

        // Return the View
        return result;
    }
}
