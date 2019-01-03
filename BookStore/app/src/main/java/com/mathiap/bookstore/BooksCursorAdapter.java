package com.mathiap.bookstore;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.mathiap.bookstore.data.BookStoreContract.BookEntry;

/**
 * {@link BooksCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of book inventory data as its data source. This adapter knows
 * how to create list items for each row of book data in the {@link Cursor}.
 */
public class BooksCursorAdapter extends CursorAdapter {
    /**
     * Constructs a new {@link BooksCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the data.
     */
    public BooksCursorAdapter(Context context, Cursor c) {
        super(context, c, 0 /* flags */);
    }

    /**
     * Makes a new blank list item view. No data is set (or bound) to the views yet.
     *
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already
     *                moved to the correct position.
     * @param parent  The parent to which the new view is attached to
     * @return the newly created list item view.
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
    }

    /**
     * This method binds the book data (in the current row pointed to by cursor) to the given
     * list item layout. For example, the name for the current book can be set on the name TextView
     * in the list item layout.
     *
     * @param view    Existing view, returned earlier by newView() method
     * @param context app context
     * @param cursor  The cursor from which to get the data. The cursor is already moved to the
     *                correct row.
     */
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final Context mContex = context;
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.list_item_name);
        TextView priceTextView = (TextView) view.findViewById(R.id.list_item_price);
        TextView quantityTextView = (TextView) view.findViewById(R.id.list_item_quantity);
        Button saleButton = (Button) view.findViewById(R.id.button_sale);
        // Find the columns of book attributes that we're interested in
        int idColumnIndex = cursor.getColumnIndex(BookEntry._ID);
        int nameColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_PRODUCT_NAME);
        int priceColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_PRICE);
        final int quantityColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_QUANTITY);
        // Read the book attributes from the Cursor for the current book selected
        final int itemId = cursor.getInt(idColumnIndex);
        String bookName = cursor.getString(nameColumnIndex);
        int bookPrice = cursor.getInt(priceColumnIndex);
        final int bookQuantity = cursor.getInt(quantityColumnIndex);
        // Update the TextViews with the attributes for the current book
        nameTextView.setText(bookName);
        priceTextView.setText("$" + Integer.toString(bookPrice));
        quantityTextView.setText("Quant: " + Integer.toString(bookQuantity));
        saleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity Activity = (MainActivity) mContex;
                Activity.bookSale(itemId, bookQuantity);
            }
        });
    }
}