package com.mathiap.bookstore;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.mathiap.bookstore.data.BookStoreContract.BookEntry;
import com.mathiap.bookstore.data.BooksStoreDbHelper;

public class MainActivity extends AppCompatActivity {
    /**
     * Database helper that will provide us access to the database
     */
    private BooksStoreDbHelper mDbHelper;
    TextView testView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        mDbHelper = new BooksStoreDbHelper(this);


        insertData();
        //queryData();


        display();
    }

    private void display() {

        String[] projection = {
                BookEntry._ID,
                BookEntry.COLUMN_PRODUCT_NAME,
                BookEntry.COLUMN_PRICE,
                BookEntry.COLUMN_QUANTITY,
                BookEntry.COLUMN_SUPPLIER_NAME,
                BookEntry.COLUMN_SUPPLIER_PHONE};

        Cursor cursor = getContentResolver().query(BookEntry.CONTENT_URI, null, null, null, null);
        String currentName = "";

        try {
            if (cursor.getCount() > 0) {
                testView = (TextView) findViewById(R.id.test_view);
                int nameColumnIndex = cursor.getColumnIndex(BookEntry.COLUMN_PRODUCT_NAME);
                while (cursor.moveToNext()) {
                    currentName = cursor.getString(nameColumnIndex);
                }

                testView.setText(currentName);
                // If the row ID is -1, then there was an error with insertion.
                Toast.makeText(this, "Retrieved " + cursor.getCount() + " records", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, getString(R.string.error_retrieve), Toast.LENGTH_SHORT).show();
            }
        } finally {
            cursor.close();
        }

    }

    private void insertData() {
        // Gets the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        // Create a ContentValues object where column names are the keys,
        // and a books attributes are the values.
        ContentValues values = new ContentValues();
        values.put(BookEntry.COLUMN_PRODUCT_NAME, "The Power of Habit");
        values.put(BookEntry.COLUMN_PRICE, 12);
        values.put(BookEntry.COLUMN_QUANTITY, 50);
        values.put(BookEntry.COLUMN_SUPPLIER_NAME, "Random House Trade ");
        values.put(BookEntry.COLUMN_SUPPLIER_PHONE, "123456");

        Uri newUri = getContentResolver().insert(BookEntry.CONTENT_URI, values);

        //long newRowId = db.insert(BookEntry.TABLE_NAME, null, values);
        // Show a toast message depending on whether or not the insertion was successful
        if (newUri == null) {
            // If the row ID is -1, then there was an error with insertion.
            Toast.makeText(this, getString(R.string.error_insert), Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "Book saved", Toast.LENGTH_SHORT).show();
        }
    }

    private void queryData() {
        // Create and/or open a database to read from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                BookEntry._ID,
                BookEntry.COLUMN_PRODUCT_NAME,
                BookEntry.COLUMN_PRICE,
                BookEntry.COLUMN_QUANTITY,
                BookEntry.COLUMN_SUPPLIER_NAME,
                BookEntry.COLUMN_SUPPLIER_PHONE};
        String selection = BookEntry._ID + "=?";
        String[] selectionArgs = {"1"};
        // Perform a query on the books table
        Cursor cursor = db.query(
                BookEntry.TABLE_NAME,  // The table to query
                projection,            // The columns to return
                selection,          // The columns for the WHERE clause
                selectionArgs,       // The values for the WHERE clause
                null,          // Don't group the rows
                null,           // Don't filter by row groups
                null);         // The sort order
        try {
            if (cursor.getCount() > 0) {

                // If the row ID is -1, then there was an error with insertion.
                Toast.makeText(this, "Retrieved " + cursor.getCount() + " records", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, getString(R.string.error_retrieve), Toast.LENGTH_SHORT).show();
            }
        } finally {
            cursor.close();
        }
    }
}
