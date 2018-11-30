package com.example.android.inventory;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.android.inventory.data.InventoryContract.InventoryEntry;

/**
 * {@link InventoryCursorAdapter} is an adapter for a list or grid view
 * that uses a {@link Cursor} of book data as its data source. This adapter knows
 * how to create list items for each row of book data in the {@link Cursor}.
 */
public class InventoryCursorAdapter extends CursorAdapter {

    /**
     * Constructs a new {@link InventoryCursorAdapter}.
     *
     * @param context The context
     * @param c       The cursor from which to get the book data.
     */
    public InventoryCursorAdapter(Context context, Cursor c) {
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
        // Inflate a list item view using the layout specified in list_item.xml
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
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.name);
        TextView summaryTextView = (TextView) view.findViewById(R.id.quantity);
        //TextView phonenumberTextView = (TextView) view.findViewById(R.id.phonenumber);
        //TextView priceTextView = (TextView) view.findViewById(R.id.price);
        //TextView quantityTextView = (TextView) view.findViewById(R.id.quantity);
        //TextView supplierTextView = (TextView) view.findViewById(R.id.supplier);

        // Find the columns of book attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_BOOK_NAME);
        //int phonenumberColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_BOOK_SUPPLIER_PHONENUMBER);
        //int priceColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_BOOK_PRICE);
        int quantityColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_BOOK_QUANTITY);
        //int supplierColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_BOOK_SUPPLIER);
        //int summaryColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_BOOK_SUMMARY);


        // Read the book attributes from the Cursor for the current book
        String bookName = cursor.getString(nameColumnIndex);
        //String bookPhone = cursor.getString(phonenumberColumnIndex);
        //String bookPrice =cursor.getString(priceColumnIndex);
        //String bookSupplier = cursor.getString(supplierColumnIndex);
        String bookQuantity = cursor.getString(quantityColumnIndex);
        //String bookSummary = cursor.getString(summaryColumnIndex);

        // If the book phone is empty string or null, then use some default text
        // that says "Unknown phone", so the TextView isn't blank.
        if (TextUtils.isEmpty(bookQuantity)) {
            bookQuantity = context.getString(R.string.unknown_quantity);
        }

        // Update the TextViews with the attributes for the current book
        nameTextView.setText(bookName);
        //phonenumberTextView.setText(bookPhone);
        summaryTextView.setText(bookQuantity);
        //priceTextView.setText(bookPrice);
        //summaryTextView.setText(bookSummary);
        //supplierTextView.setText(bookSupplier);
        //quantityTextView.setText(bookQuantity);
    }
}