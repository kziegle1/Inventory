package com.example.android.inventory.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * API Contract for the inventory app.
 */
public final class InventoryContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private InventoryContract() {
    }

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.inventory";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's)
     * For instance, content://com.example.android.inventory/inventory/ is a valid path for
     * looking at book data. content://com.example.android.inventory/staff/ will fail,
     * as the ContentProvider hasn't been given any information on what to do with "staff".
     */
    public static final String PATH_INVENTORY = "inventory";

    /**
     * Inner class that defines constant values for the inventory database table.
     * Each entry in the table represents a single book.
     */
    public static final class InventoryEntry implements BaseColumns {

        /**
         * The content URI to access the inventory data in the provider
         */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_INVENTORY);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of inventory.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INVENTORY;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single book.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INVENTORY;

        /**
         * Name of database table for inventory
         */
        public final static String TABLE_NAME = "inventory";

        /**
         * Unique ID number for the book (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the book.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_NAME = "name";

        /**
         * Phone number of the supplier.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_BOOK_SUPPLIER_PHONENUMBER = "phonenumber";
        /**
         * Quantity of the books
         */
        public final static String COLUMN_BOOK_QUANTITY = "quantity";

        /**
         * Supplier of the book
         * <p>
         * The only possible values are {@link #SUPPLIER_BARNESANDNOBLE}, {@link #SUPPLIER_AMAZON},
         * or {@link #SUPPLIER_SCHOLASTIC}.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_SUPPLIER = "supplier";

        /**
         * Book price
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_BOOK_PRICE = "price";

        public final static String COLUMN_BOOK_SUMMARY = "summary";

        /**
         * Possible values for the book supplier.
         */

        public static final int SUPPLIER_BARNESANDNOBLE = 0;
        public static final int SUPPLIER_AMAZON = 1;
        public static final int SUPPLIER_SCHOLASTIC = 2;


        /**
         * Returns whether or not the given supplier is {@link #SUPPLIER_AMAZON}, {@link #SUPPLIER_BARNESANDNOBLE},
         * or {@link #SUPPLIER_SCHOLASTIC}.
         */
        public static boolean isValidSupplier(int supplier) {
            if (supplier == SUPPLIER_AMAZON || supplier == SUPPLIER_BARNESANDNOBLE || supplier == SUPPLIER_SCHOLASTIC) {
                return true;
            }
            return false;
        }
    }

}
