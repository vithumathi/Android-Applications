package com.mathiap.bookstore;

import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.mathiap.bookstore.data.BookStoreContract.BookEntry;
import com.mathiap.bookstore.data.BooksStoreDbHelper;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final int BOOK_LOADER = 0;
    BooksCursorAdapter mCursorAdaptor;
    /**
     * Database helper that will provide us access to the database
     */
    private BooksStoreDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Setup FAB to open EditorActivity
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                startActivity(intent);
            }
        });
        // Find the ListView which will be populated with the book data
        ListView bookListView = (ListView) findViewById(R.id.list);
        // Find and set empty view on the ListView, so that it only shows when the list has 0 items.
        View emptyView = findViewById(R.id.empty_view);
        bookListView.setEmptyView(emptyView);
        // Setup an Adapter to create a list item for each row of book data in the Cursor.
        // There is no book data yet (until the loader finishes) so pass in null for the Cursor.
        mCursorAdaptor = new BooksCursorAdapter(this, null);
        bookListView.setAdapter(mCursorAdaptor);
        // Setup the item click listener
        bookListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Create new intent to go to {@link EditorActivity}
                Intent intent = new Intent(MainActivity.this, EditorActivity.class);
                // Form the content URI that represents the specific book that was clicked on,
                // by appending the "id" (passed as input to this method) onto the
                // {@link PetEntry#CONTENT_URI}.
                // For example, the URI would be "content://com.example.android.bookstore/books/2"
                // if the book with ID 2 was clicked on.
                Uri currentPetUri = ContentUris.withAppendedId(BookEntry.CONTENT_URI, id);
                // Set the URI on the data field of the intent
                intent.setData(currentPetUri);
                // Launch the {@link EditorActivity} to display the data for the current books.
                startActivity(intent);
            }
        });
        // Kick off the loader
        getLoaderManager().initLoader(BOOK_LOADER, null, this);
    }

    /**
     * Helper method to delete all books in the database.
     */
    private void deleteAllPets() {
        int rowsDeleted = getContentResolver().delete(BookEntry.CONTENT_URI, null, null);
        Log.v("CatalogActivity", rowsDeleted + " rows deleted from books database");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_main.xmlle.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "Delete all entries" menu option
            case R.id.action_delete_all_entries:
                deleteAllPets();
                return true;
        }
        return super.onOptionsItemSelected(item);
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

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                BookEntry._ID,
                BookEntry.COLUMN_PRODUCT_NAME,
                BookEntry.COLUMN_PRICE,
                BookEntry.COLUMN_QUANTITY,
                BookEntry.COLUMN_SUPPLIER_NAME,
                BookEntry.COLUMN_SUPPLIER_PHONE};
        return new CursorLoader(this, BookEntry.CONTENT_URI, projection, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mCursorAdaptor.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mCursorAdaptor.swapCursor(null);
    }

    public void bookSale(int itemId, int bookQuantity) {
        if (bookQuantity > 0) {
            bookQuantity--;
            ContentValues values = new ContentValues();
            values.put(BookEntry.COLUMN_QUANTITY, bookQuantity);
            Uri uri = ContentUris.withAppendedId(BookEntry.CONTENT_URI, itemId);
            int rowsAffected = getContentResolver().update(uri, values, null, null);
            Toast.makeText(MainActivity.this, R.string.sold, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.no_stock,
                    Toast.LENGTH_SHORT).show();
        }
    }
}
