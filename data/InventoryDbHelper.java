package com.example.android.inventory.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.inventory.data.InventoryContract.InventoryEntry;

/**
 * Database helper for Inventory app. Manages database creation and version management.
 */
public class InventoryDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = InventoryDbHelper.class.getSimpleName();
    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "inventory.db";
    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;


    //private static final String DATABASE_ALTER_BOOK_1 = "ALTER TABLE "
    //+ InventoryEntry._ID + " ADD COLUMN " + InventoryEntry.COLUMN_BOOK_QUANTITY + " string;";

    //private static final String DATABASE_ALTER_BOOK_2 = "ALTER TABLE "
    //+ InventoryEntry._ID + " ADD COLUMN " + InventoryEntry.COLUMN_BOOK_SUPPLIER_PHONENUMBER + " string;";

    /**
     * Constructs a new instance of {@link InventoryDbHelper}.
     *
     * @param context of the app
     */
    public InventoryDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the inventory table
        String SQL_CREATE_INVENTORY_TABLE = "CREATE TABLE " + InventoryEntry.TABLE_NAME + " ("
                + InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + InventoryEntry.COLUMN_BOOK_NAME + " TEXT NOT NULL,"
                + InventoryEntry.COLUMN_BOOK_QUANTITY + " INTEGER,"
                + InventoryEntry.COLUMN_BOOK_SUPPLIER + " TEXT NOT NULL DEFAULT 0,"
                + InventoryEntry.COLUMN_BOOK_SUPPLIER_PHONENUMBER + " INTEGER,"
                + InventoryEntry.COLUMN_BOOK_PRICE + " INTEGER NOT NULL DEFAULT 0);";
        // Execute the SQL statement
        db.execSQL(SQL_CREATE_INVENTORY_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //if (oldVersion < 2) {
        //db.execSQL(DATABASE_ALTER_BOOK_1);
        //}
        //if (oldVersion < 3) {
        //db.execSQL(DATABASE_ALTER_BOOK_2);
        // }// The database is still at version 1, so there's nothing to do be done here.
        // The database is still at version 1, so there's nothing to do be done here.

    }

}
