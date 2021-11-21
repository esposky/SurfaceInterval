package com.example.otherjavafiles;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String MAIN_TABLE = "MAIN_TABLE";
    private static final String USER_ID = "USER_ID";
    private static final String LOG_ID = "LOG_ID";
    private static final String CERT_ID = "CERT_ID";
    private static final String USER_TABLE = "USER_TABLE";
    private static final String COLUMN_FIRST_NAME = "FIRST_NAME";
    private static final String COLUMN_LAST_NAME =  "LAST_NAME";
    private static final String EMAIL = "EMAIL";
    private static final String PASSWORD = "PASSWORD";
    private static final String DIVELOG_TABLE = "DIVELOG_TABLE";
    private static final String COLUMN_DATE = "DATE";
    private static final String COLUMN_CITY = "CITY";
    private static final String COLUMN_STATE = "STATE";
    private static final String COLUMN_DURATION = "DURATION";
    private static final String COLUMN_MAX_DEPTH = "MAX_DEPTH";
    private static final String COLUMN_AVERAGE_DEPTH = "AVERAGE_DEPTH";
    private static final String COLUMN_PRESSURE_GROUP = "PRESSURE_GROUP";
    private static final String COLUMN_TEMPERATURE = "TEMPERATURE";
    private static final String COLUMN_VISIBILITY = "VISIBILITY";
    private static final String COLUMN_PRESSURE_START = "PRESSURE_START";
    private static final String COLUMN_PRESSURE_END = "PRESSURE_END";
    private static final String COLUMN_AIR_TYPE = "AIR_TYPE";
    private static final String COLUMN_WEIGHT = "WEIGHT";
    private static final String COLUMN_EXPOSURE_PROTECTION = "EXPOSURE_PROTECTION";
    private static final String COLUMN_EQUIPMENT_ID = "EQUIPMENT_ID";
    private static final String COLUMN_DIVE_CONDITIONS = "DIVE_CONDITIONS";
    private static final String COLUMN_DIVE_ACTIVITIES = "DIVE_ACTIVITIES";
    private static final String COLUMN_WILDLIFE_ID = "WILDLIFE_ID";
    private static final String COLUMN_COMMENT = "COMMENT";
    private static final String COLUMN_DIVE_PARTNER = "DIVE_PARTNER";
    private static final String EQUIPMENT_TABLE = "EQUIPMENT_TABLE";
    private static final String COLUMN_GEAR_TYPE = "GEAR_TYPE";
    private static final String COLUMN_BRAND = "BRAND";
    private static final String COLUMN_MODEL = "MODEL";
    private static final String WILDLIFE_TABLE = "WILDLIFE_TABLE";
    private static final String COLUMN_WILDLIFE_TYPE = "WILDLIFE_TYPE";
    private static final String COLUMN_SPECIES = "SPECIES";
    private static final String PARTNER_TABLE = "PARTNER_TABLE";
    private static final String COLUMN_PARTNER_ID = "PARTNER_ID";
    private static final String COLUMN_ASSOCIATION = "COLUMN_ASSOCIATION";
    private static final String COLUMN_CERT_NUM = "CERT_NUM";
    private static final String COLUMN_RENTED = "RENTED";
    private static final String COLUMN_PRICE = "PRICE";
    private static final String COLUMN_NAME = "NAME";
    private static final String COLUMN_LOCATION = "LOCATION";
    private static final String COLUMN_SITENAME = "SITENAME";
    private static final String COLUMN_USERNAME = "USERNAME";
    private static final String WILDLIFE_LOG_TABLE = "WILDLIFE_LOG_TABLE";
    private static final String EQUIPMENT_LOG_TABLE = "EQUIPMENT_LOG_TABLE";


    public DatabaseHelper(@Nullable Context context) {super(context, "surfaceinterval.db", null, 1);}

    // When application opens create these table if they do not already exist
    @Override
    public void onCreate(SQLiteDatabase db) {

        // String for table creation
        String createMainTableStatement = "CREATE TABLE " + MAIN_TABLE + " (" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LOG_ID + " INT, " + CERT_ID + " INT)";
        String createUserTableStatement = "CREATE TABLE " + USER_TABLE + " (" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USERNAME + " TEXT NOT NULL, " + EMAIL + " TEXT NOT NULL, " + PASSWORD + " TEXT NOT NULL)";
        String createDiveLogTableStatement = "CREATE TABLE " + DIVELOG_TABLE + " (" + LOG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_ID +" INTEGER,"+ COLUMN_DATE + " TEXT, " + COLUMN_LOCATION + " TEXT, " + COLUMN_SITENAME + " TEXT, " + COLUMN_DURATION + " INTEGER, " + COLUMN_MAX_DEPTH + " INTEGER, " + COLUMN_AVERAGE_DEPTH + " INTEGER, "
                + COLUMN_PRESSURE_GROUP + " CHAR, " + COLUMN_TEMPERATURE + " INTEGER, " + COLUMN_VISIBILITY + " TEXT, " + COLUMN_PRESSURE_START + " INTEGER, " + COLUMN_PRESSURE_END + " INTEGER, " + COLUMN_AIR_TYPE + " TEXT, " + COLUMN_WEIGHT + " INTEGER, " + COLUMN_EXPOSURE_PROTECTION + " INTEGER, " + COLUMN_EQUIPMENT_ID + " INTEGER, "
                + COLUMN_DIVE_CONDITIONS + " TEXT, " + COLUMN_DIVE_ACTIVITIES + " TEXT, " + COLUMN_WILDLIFE_ID + " INTEGER, " + COLUMN_COMMENT + " TEXT, " + COLUMN_DIVE_PARTNER + " INTEGER)";
        String createEquipmentTableStatement = "CREATE TABLE " + EQUIPMENT_TABLE + " (" + COLUMN_EQUIPMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_ID +" INTEGER, " + COLUMN_GEAR_TYPE + " TEXT, " + COLUMN_BRAND + " TEXT, " + COLUMN_MODEL + " TEXT, " + COLUMN_RENTED + " TEXT, " + COLUMN_PRICE + " REAL, " + "FOREIGN KEY("+USER_ID+") REFERENCES " + USER_TABLE + "(" + USER_ID +"))";
        String createWildlifeTableStatement = "CREATE TABLE " + WILDLIFE_TABLE + " (" + COLUMN_WILDLIFE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_ID +" INTEGER, " + COLUMN_WILDLIFE_TYPE + " TEXT, " + COLUMN_SPECIES + " TEXT, " + "FOREIGN KEY("+USER_ID+") REFERENCES " + USER_TABLE + "(" + USER_ID +"))";
        String createPartnerTableStatement = "CREATE TABLE " + PARTNER_TABLE + " (" + COLUMN_PARTNER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + USER_ID +" INTEGER, " + COLUMN_NAME + " TEXT, " + COLUMN_ASSOCIATION + " TEXT, " + COLUMN_CERT_NUM + " INTEGER, " + "FOREIGN KEY("+USER_ID+") REFERENCES " + USER_TABLE + "(" + USER_ID +"))";
        // Create table that has the wildlife correlating to the order ID.
        String createWildlifeLogTableStatement = "CREATE TABLE " + WILDLIFE_LOG_TABLE + " (" + LOG_ID + " INTEGER, " + COLUMN_WILDLIFE_ID + " INTEGER)";
        String createEquipmentLogTableStatement = "CREATE TABLE " + EQUIPMENT_LOG_TABLE + " (" + LOG_ID + " INTEGER, " + COLUMN_EQUIPMENT_ID + " INTEGER)";
        // Executes query for tables
        db.execSQL(createMainTableStatement);
        db.execSQL(createUserTableStatement);
        db.execSQL(createDiveLogTableStatement);
        db.execSQL(createEquipmentTableStatement);
        db.execSQL(createWildlifeTableStatement);
        db.execSQL(createPartnerTableStatement);
        db.execSQL(createWildlifeLogTableStatement);
        db.execSQL(createEquipmentLogTableStatement);

    } // END onCreate

    // If database is being upgraded (NOT SURE WHAT WILL BE NEEDED YET)
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //

    //Add a new user
    public boolean addNewUser(UserInfo userInfo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USERNAME, userInfo.getUserName());
        cv.put(EMAIL, userInfo.getEmail());
        cv.put(PASSWORD, userInfo.getPassword());

        long insert = db.insert(USER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    } // end addNewUser

    // Delete a user
    public boolean deleteUser(UserInfo userInfo) {
        // Find user in database. If found delete true

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + USER_TABLE + " WHERE " + USER_ID + " = " + userInfo.getUserId();

        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            return true;
        }
        else {
            return false;
        }
    } // end delete user

    // Update user information
    public boolean updateUser(UserInfo userInfo) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_USERNAME, userInfo.getUserName());
        cv.put(EMAIL, userInfo.getEmail());
        cv.put(PASSWORD, userInfo.getPassword());

        long update = db.update(USER_TABLE, cv,"_id = ?", new String[]{USER_ID});

        if (update == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    // Checks to see if username/email is already in database
    public Boolean check_email(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from " + USER_TABLE + " where " + EMAIL + " = ?", new String[]{email});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    // Checks if username and password exists in database to allow user to login
    public boolean checkExists(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM USER_TABLE WHERE EMAIL=? and Password=?", new String[]{username,password});

        int count = cursor.getCount();

        if(count > 0){
            cursor.close();
            db.close();
            return true;
        } else {
            cursor.close();
            db.close();
            return false;
        }
    }
    // Gets the userID from the last login
    public String getLastLogId (String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String ID = "";
        Cursor cursor = db.rawQuery("SELECT USER_ID FROM USER_TABLE WHERE EMAIL=? and Password=?", new String[]{username,password});

        if(cursor != null && cursor.moveToFirst()) {
            ID = cursor.getString(0);
        }
        db.close();
        return ID;
    }

    public boolean addNewLog(SingleLog singleLog, String userID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USER_ID, userID);
        // Put Values for location items
        cv.put(COLUMN_DATE, singleLog.location.getDate());
        cv.put(COLUMN_LOCATION, singleLog.location.getLocation());
        cv.put(COLUMN_SITENAME, singleLog.location.getSiteName());

        // Put values for dive
        cv.put(COLUMN_DURATION, singleLog.dive.getDuration());
        cv.put(COLUMN_MAX_DEPTH, singleLog.dive.getMaxDepth());
        cv.put(COLUMN_AVERAGE_DEPTH, singleLog.dive.getAvgDepth());
        //cv.put(COLUMN_PRESSURE_GROUP, (byte) singleLog.dive.getPressureGroup());
        cv.put(COLUMN_TEMPERATURE, singleLog.dive.getTemp());
        cv.put(COLUMN_VISIBILITY, singleLog.dive.getVisibility());
        cv.put(COLUMN_PRESSURE_START, singleLog.dive.getPressureStart());
        cv.put(COLUMN_PRESSURE_END, singleLog.dive.getPressureEnd());
        cv.put(COLUMN_AIR_TYPE, singleLog.dive.getAirType());
        cv.put(COLUMN_DIVE_CONDITIONS, singleLog.dive.getDiveConditionsNA());
        cv.put(COLUMN_DIVE_ACTIVITIES, singleLog.dive.getDiveActivitiesNA());

        // Put values for equipment
        cv.put(COLUMN_EQUIPMENT_ID, singleLog.equipment.getEquipmentID());

        // Put Values for Wildlife
        cv.put(COLUMN_WILDLIFE_ID, singleLog.wildLife.getWildlifeID());

        // Put values for Dive Partner
        cv.put(COLUMN_DIVE_PARTNER, singleLog.buddy.getPartnerID());

        long insert = db.insert(DIVELOG_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    // Used to test multiple wildlife and equipment
    public boolean addNewLogTest(SingleLogTest singleLog, String userID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        // List to hold wildlife list
        List<WildLife> wildList = new ArrayList<WildLife>();
        wildList = singleLog.wildLifeList.getWildLifeList();
        String wildNums = "";

        // List to hold equipment list
        List<Equipment> equipList = new ArrayList<Equipment>();
        equipList = singleLog.equipmentList.getEquipList();
        String equipNums = "";

        cv.put(USER_ID, userID);
        // Put Values for location items
        cv.put(COLUMN_DATE, singleLog.location.getDate());
        cv.put(COLUMN_LOCATION, singleLog.location.getLocation());
        cv.put(COLUMN_SITENAME, singleLog.location.getSiteName());

        // Put values for dive
        cv.put(COLUMN_DURATION, singleLog.dive.getDuration());
        cv.put(COLUMN_MAX_DEPTH, singleLog.dive.getMaxDepth());
        cv.put(COLUMN_AVERAGE_DEPTH, singleLog.dive.getAvgDepth());
        //cv.put(COLUMN_PRESSURE_GROUP, (byte) singleLog.dive.getPressureGroup());
        cv.put(COLUMN_TEMPERATURE, singleLog.dive.getTemp());
        cv.put(COLUMN_VISIBILITY, singleLog.dive.getVisibility());
        cv.put(COLUMN_PRESSURE_START, singleLog.dive.getPressureStart());
        cv.put(COLUMN_PRESSURE_END, singleLog.dive.getPressureEnd());
        cv.put(COLUMN_AIR_TYPE, singleLog.dive.getAirType());
        cv.put(COLUMN_DIVE_CONDITIONS, singleLog.dive.getDiveConditionsNA());
        cv.put(COLUMN_DIVE_ACTIVITIES, singleLog.dive.getDiveActivitiesNA());

        // Put values for Dive Partner
        cv.put(COLUMN_DIVE_PARTNER, singleLog.buddy.getPartnerID());

        long insert = db.insert(DIVELOG_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    // Returns last divelog id
    public String getLastAdded () {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + DIVELOG_TABLE + " ORDER BY " + LOG_ID + " DESC LIMIT 1", null);
        String ID = "";
        if(cursor != null && cursor.moveToFirst()) {
            ID = cursor.getString(0);

        }

        db.close();
        return ID;
    }
    // Inserts the wildlife ID after we get the log ID
    public boolean updateWildlifeID (String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_WILDLIFE_ID, ID);
        long insert = db.update(DIVELOG_TABLE, cv, LOG_ID + " = ?", new String[]{ID});
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    // Inserts the Equipment ID after we get the log ID
    public boolean updateEquipmentID (String ID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_EQUIPMENT_ID, ID);
        long insert = db.update(DIVELOG_TABLE, cv, LOG_ID + " = ?", new String[]{ID});
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    // Test new table
    public void insertWildlifeLogTable (WildLifeList wildLifeList, String logID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        // List to hold wildlife list
        List<WildLife> wildList = new ArrayList<WildLife>();
        wildList = wildLifeList.getWildLifeList();

        // for each wildlife in the list add to table with same log ID
        db.beginTransaction();
        try {
            for (WildLife wildLife : wildList) {
                cv.put(LOG_ID, logID);
                cv.put(COLUMN_WILDLIFE_ID, wildLife.getWildlifeID());
                db.insert(WILDLIFE_LOG_TABLE, null, cv);
            }
            db.setTransactionSuccessful();
        }
        finally {
            db.endTransaction();
        }
        db.close();
    }

    public void insertEquipmentLogTable (EquipmentList equipmentList, String logID) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        // List to hold wildlife list
        List<Equipment> equipList = new ArrayList<Equipment>();
        equipList = equipmentList.getEquipList();

        // for each wildlife in the list add to table with same log ID
        db.beginTransaction();
        try {
            for (Equipment equipment : equipList) {
                cv.put(LOG_ID, logID);
                cv.put(COLUMN_EQUIPMENT_ID, equipment.getEquipmentID());
                db.insert(EQUIPMENT_LOG_TABLE, null, cv);
            }
            db.setTransactionSuccessful();
        }
        finally {
            db.endTransaction();
        }
        db.close();
    }

    // Maybe create a function to parse the single log wildlifeid/equipmentid
    // and then loop through those. Something like that need to find out how to access
    // all of the ids even though their in the same

    public List<SingleLogTest> getLogsTest() {
        List<SingleLogTest> returnList = new ArrayList<>();
        List<WildLife> tempWildList = new ArrayList<WildLife>();
        List<Equipment> tempEquipList = new ArrayList<Equipment>();

        // Query Strings to return all needed tables

        String queryString = "SELECT * FROM DIVELOG_TABLE A "
                + "INNER JOIN WILDLIFE_TABLE B ON A.WILDLIFE_ID = B.WILDLIFE_ID "
                + "INNER JOIN PARTNER_TABLE C ON A.DIVE_PARTNER = C.PARTNER_ID "
                + "INNER JOIN EQUIPMENT_TABLE D ON A.EQUIPMENT_ID = D.EQUIPMENT_ID";

        //Get database to read and execute queries
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        // loop through results and create new singleLog objects
        if (cursor.moveToFirst()) {
            do {
                // Returns the logID first to then be used to fill the wildlife and equipment lists
                String logID = cursor.getString(0);
                String testWildlifeQuery = "SELECT A.LOG_ID, A.WILDLIFE_ID, B.USER_ID, C.WILDLIFE_TYPE, C.SPECIES  FROM WILDLIFE_LOG_TABLE A "
                        + "JOIN DIVELOG_TABLE B ON A.LOG_ID = B.LOG_ID "
                        + "JOIN WILDLIFE_TABLE C ON A.WILDLIFE_ID = C.WILDLIFE_ID "
                        + "WHERE A.LOG_ID = ?";

                // Once logID is found, it loops through the resulting wildlife in the wildlife_log_table
                Cursor wildCursor = db.rawQuery(testWildlifeQuery, new String[]{logID});
                if (wildCursor.moveToFirst()) {
                    // Loop through results and
                    do {
                        WildLife wildLife = new WildLife(wildCursor.getString(wildCursor.getColumnIndexOrThrow(USER_ID)),wildCursor.getInt(wildCursor.getColumnIndexOrThrow(COLUMN_WILDLIFE_ID)), wildCursor.getString(wildCursor.getColumnIndexOrThrow(COLUMN_WILDLIFE_TYPE)), wildCursor.getString(wildCursor.getColumnIndexOrThrow(COLUMN_SPECIES)));
                        tempWildList.add(wildLife);
                    } while (wildCursor.moveToNext());
                }
                /*
                1st. Creates new temp list based on the list in the loop
                2nd. Creates a WildlifeList object based on that temp list
                3rd. Uses that object to populate the SingleLogTest object
                4th. Clears the list from the loop so next row won't have left over values
                 */
                List<WildLife> testList = new ArrayList<WildLife>(tempWildList);
                WildLifeList wildLifeList = new WildLifeList(testList);
                tempWildList.clear();
                wildCursor.close();

                // Does the same as wildlife but for equipment
                // Once logID is found, it loops through the resulting equipment in the equipment_log_table
                String queryStringEquipment = "SELECT A.LOG_ID, A.EQUIPMENT_ID, B.USER_ID, C.GEAR_TYPE, C.BRAND, C.MODEL, C.RENTED, C.PRICE FROM EQUIPMENT_LOG_TABLE A "
                        + "JOIN DIVELOG_TABLE B ON A.LOG_ID = B.LOG_ID "
                        + "JOIN EQUIPMENT_TABLE C ON A.EQUIPMENT_ID = C.EQUIPMENT_ID "
                        + "WHERE A.LOG_ID = ?";
                Cursor equipCursor = db.rawQuery(queryStringEquipment, new String[]{logID});
                if (equipCursor.moveToFirst()) {
                    do {
                        Equipment equipment = new Equipment(equipCursor.getString(equipCursor.getColumnIndexOrThrow(USER_ID)), equipCursor.getInt(equipCursor.getColumnIndexOrThrow(COLUMN_EQUIPMENT_ID)), equipCursor.getString(equipCursor.getColumnIndexOrThrow(COLUMN_GEAR_TYPE)), equipCursor.getString(equipCursor.getColumnIndexOrThrow(COLUMN_BRAND)), equipCursor.getString(equipCursor.getColumnIndexOrThrow(COLUMN_MODEL)), equipCursor.getInt(equipCursor.getColumnIndexOrThrow(COLUMN_RENTED)) == 1 ? true: false, equipCursor.getDouble(equipCursor.getColumnIndexOrThrow(COLUMN_PRICE)));
                        tempEquipList.add(equipment);
                    } while (equipCursor.moveToNext());
                }

                List<Equipment> equipList = new ArrayList<Equipment>(tempEquipList);
                EquipmentList equipmentList = new EquipmentList(equipList);
                tempEquipList.clear();
                equipCursor.close();

                // Returns remainder of values
                String userID = cursor.getString(1);
                String date = cursor.getString(2);
                String location = cursor.getString(3);
                String siteName = cursor.getString(4);
                int duration = cursor.getInt(5);
                int maxDepth = cursor.getInt(6);
                int avgDepth = cursor.getInt(7);
                int temp = cursor.getInt(9);
                int visibility = cursor.getInt(10);
                int pressureStart = cursor.getInt(11);
                int pressureEnd = cursor.getInt(12);
                int airType = cursor.getInt(13);
                //int weight = cursor.getInt(14);
                int equipID = cursor.getInt(16);
                String diveCond = cursor.getString(17);
                String diveAct = cursor.getString(18);
                int wildlifeID = cursor.getInt(19);
                int partnerID = cursor.getInt(21);

                // Get values from wildlife portion of the database
                String wildlifeType = cursor.getString(24);
                String wildlifeSpecies = cursor.getString(25);

                // Get values for dive partner portion
                String partnerName = cursor.getString(28);
                String association = cursor.getString(29);
                String partnerCertNum = cursor.getString(30);

                // NOT NEEDED JUST HERE TO BE SAFE
                // Get values for the equipment portion
                String gearType = cursor.getString(33);
                String brandMake = cursor.getString(34);
                String model = cursor.getString(35);
                boolean rent = cursor.getInt(36) == 1;
                Double price = cursor.getDouble(37);

                // Set all variable for single log
                LocationDetails locationDetails = new LocationDetails(location, date, siteName);
                DiveDetails diveDetails = new DiveDetails(duration, maxDepth, avgDepth, temp, visibility, pressureStart, pressureEnd, airType, diveCond, diveAct);
                DivePartner divePartner = new DivePartner(userID, partnerID, partnerName, partnerCertNum,association);


                // Set singlelog to be cycled thru
                SingleLogTest newSingleLog = new SingleLogTest(locationDetails, diveDetails, divePartner, equipmentList, wildLifeList);
                returnList.add(newSingleLog);


            } while (cursor.moveToNext());
        }
        else {
            // failure do not add anything
        }
        // close both the cursor and the db when done
        cursor.close();
        db.close();
        return returnList;
    }

    // Original
    public List<SingleLog> getLogs() {
        List<SingleLog> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM DIVELOG_TABLE A "
            + "INNER JOIN WILDLIFE_TABLE B ON A.WILDLIFE_ID = B.WILDLIFE_ID "
            + "INNER JOIN PARTNER_TABLE C ON A.DIVE_PARTNER = C.PARTNER_ID "
            + "INNER JOIN EQUIPMENT_TABLE D ON A.EQUIPMENT_ID = D.EQUIPMENT_ID";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop through results and create new singleLog objects
            do {
                String userID = cursor.getString(1);
                String date = cursor.getString(2);
                String location = cursor.getString(3);
                String siteName = cursor.getString(4);
                int duration = cursor.getInt(5);
                int maxDepth = cursor.getInt(6);
                int avgDepth = cursor.getInt(7);
                int temp = cursor.getInt(9);
                int visibility = cursor.getInt(10);
                int pressureStart = cursor.getInt(11);
                int pressureEnd = cursor.getInt(12);
                int airType = cursor.getInt(13);
                //int weight = cursor.getInt(14);
                int equipID = cursor.getInt(16);
                String diveCond = cursor.getString(17);
                String diveAct = cursor.getString(18);
                int wildlifeID = cursor.getInt(19);
                int partnerID = cursor.getInt(21);

                // Get values from wildlife portion of the database
                String wildlifeType = cursor.getString(24);
                String wildlifeSpecies = cursor.getString(25);

                // Get values for dive partner portion
                String partnerName = cursor.getString(28);
                String association = cursor.getString(29);
                String partnerCertNum = cursor.getString(30);

                // Get values for the equipment portion
                String gearType = cursor.getString(33);
                String brandMake = cursor.getString(34);
                String model = cursor.getString(35);
                boolean rent = cursor.getInt(36) == 1;
                //boolean customerActive = cursor.getInt(3) == 1 ? true: false;
                Double price = cursor.getDouble(37);

                // Set all variable for single log
                LocationDetails locationDetails = new LocationDetails(location, date, siteName);
                DiveDetails diveDetails = new DiveDetails(duration, maxDepth, avgDepth, temp, visibility, pressureStart, pressureEnd, airType, diveCond, diveAct);
                DivePartner divePartner = new DivePartner(userID, partnerID, partnerName, partnerCertNum,association);
                WildLife wildLife = new WildLife(userID, wildlifeID, wildlifeType, wildlifeSpecies);
                Equipment equipment = new Equipment(userID, equipID,  gearType, brandMake, model, rent, price);

                // Set singlelog to be cycled thru
                SingleLog newSingleLog = new SingleLog(locationDetails, diveDetails, divePartner, equipment, wildLife);
                //CustomerModel newCustomer = new CustomerModel(customerID, customerName, customerAge, customerActive);
                returnList.add(newSingleLog);

            } while (cursor.moveToNext());
        }
        else {
            // failure do not add anything
        }
        // close both the cursor and the db when done
        cursor.close();
        db.close();
        return returnList;
    }

    // Use update? to maybe just update files from previous page?
    // Adds new log but only from second page

    // Update
    public boolean updateDiveLog(DiveDetails diveDetails) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_DURATION, diveDetails.getDuration());
        cv.put(COLUMN_MAX_DEPTH, diveDetails.getMaxDepth());
        cv.put(COLUMN_AVERAGE_DEPTH, diveDetails.getAvgDepth());
        cv.put(COLUMN_TEMPERATURE, diveDetails.getTemp());
        cv.put(COLUMN_VISIBILITY, diveDetails.getVisibility());
        cv.put(COLUMN_PRESSURE_START, diveDetails.getPressureStart());
        cv.put(COLUMN_PRESSURE_END, diveDetails.getPressureEnd());
        cv.put(COLUMN_AIR_TYPE, diveDetails.getAirType());

        long update = db.update(DIVELOG_TABLE, cv,"_id = ?", new String[]{LOG_ID});

        if (update == -1) {
            return false;
        }
        else {
            return true;
        }
    } // END updateEquipment

    // Add log database info here


    // Add Equipment
    /*
        isRental is not a usual getter, may need to make changes to get to work with database
        as it does not take bool. Will appear as a 0 or 1.
     */
    public boolean addNewEquipment(Equipment equipment) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USER_ID, equipment.getUserID());
        cv.put(COLUMN_GEAR_TYPE, equipment.getType());
        cv.put(COLUMN_BRAND, equipment.getMake());
        cv.put(COLUMN_MODEL, equipment.getModel());
        cv.put(COLUMN_RENTED, Boolean.toString(equipment.isRental()));
        cv.put(COLUMN_PRICE, equipment.getPrice());

        long insert = db.insert(EQUIPMENT_TABLE, null, cv);
        if (insert == -1) {
            return false;
        }
        else {
            return true;
        }

    } // END addNewEquipment
    // Get last equipment id from page to be create
    public String getEquipmentId (Equipment equipment) {
        SQLiteDatabase db = this.getWritableDatabase();
        String ID = "";
        Cursor cursor = db.rawQuery("SELECT EQUIPMENT_ID FROM EQUIPMENT_TABLE WHERE USER_ID=? and GEAR_TYPE=? AND BRAND=? AND MODEL=? AND RENTED=? AND PRICE=?", new String[]{equipment.getUserID(), equipment.getType(), equipment.getMake(), equipment.getModel(), Boolean.toString(equipment.isRental()), Double.toString(equipment.getPrice())});

        if(cursor != null && cursor.moveToFirst()) {
            ID = cursor.getString(0);
        }
        else {
            ID = null;
        }
        db.close();
        return ID;
    }

    // Gets wildlife from database and displays it in listview
    public List<Equipment> getEquipment(String userID) {
        List<Equipment> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM EQUIPMENT_TABLE WHERE USER_ID = " + userID;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop through results and create new Equipment objects
            do {
                int equipmentID = cursor.getInt(0);
                String userId = cursor.getString(1);
                String gearType = cursor.getString(2);
                String gearBrandMake = cursor.getString(3);
                String gearModel = cursor.getString(4);
                Boolean rented = (cursor.getInt(5) == 1);
                Double price = cursor.getDouble(6);

                Equipment newEquipment = new Equipment(userId, equipmentID, gearType, gearBrandMake, gearModel, rented, price);
                returnList.add(newEquipment);

            } while (cursor.moveToNext());
        }
        else {
            // failure do not add anything
        }
        // close both the cursor and the db when done
        cursor.close();
        db.close();
        return returnList;

    }

    // Delete and Equipment from the database
    /*
        I need to create an id parameter in the equipment class so we know which equipment to delete
     */
//    public boolean deleteEquipment(Equipment equipment) {
//        // Find user in database. If found delete true
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        String queryString = "DELETE FROM " + EQUIPMENT_TABLE + " WHERE " + COLUMN_EQUIPMENT_ID + " = " + equipment.get;
//
//        Cursor cursor = db.rawQuery(queryString, null);
//
//        if (cursor.moveToFirst()) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    } // end delete user

    public boolean updateEquipment(Equipment equipment) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_GEAR_TYPE, equipment.getType());
        cv.put(COLUMN_BRAND, equipment.getMake());
        cv.put(COLUMN_MODEL, equipment.getModel());
        cv.put(COLUMN_RENTED, equipment.isRental());
        cv.put(COLUMN_PRICE, equipment.getPrice());

        long update = db.update(EQUIPMENT_TABLE, cv,"_id = ?", new String[]{COLUMN_EQUIPMENT_ID});

        if (update == -1) {
            return false;
        }
        else {
            return true;
        }
    } // END updateEquipment

    //              WILDLIFE SECTION
    // Will need to add a wildlife ID for delete section

    public boolean addNewWildlife(WildLife wildlife) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USER_ID, wildlife.getUserID());
        cv.put(COLUMN_WILDLIFE_TYPE, wildlife.getType());
        cv.put(COLUMN_SPECIES, wildlife.getSpecies());

        long insert = db.insert(WILDLIFE_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    // Return WildlifeID to be added
    public String getWildlifeId (WildLife wildLife) {
        SQLiteDatabase db = this.getWritableDatabase();
        String ID = "";
        Cursor cursor = db.rawQuery("SELECT WILDLIFE_ID FROM WILDLIFE_TABLE WHERE USER_ID=? and WILDLIFE_TYPE=? and SPECIES=?", new String[]{wildLife.getUserID(), wildLife.getType(), wildLife.getSpecies()});

        if(cursor != null && cursor.moveToFirst()) {
            ID = cursor.getString(0);
        }
        else {
            ID = null;
        }
        db.close();
        return ID;
    }

    public List<WildLife> getWildlife(String userID) {
        List<WildLife> returnList = new ArrayList<>();
        String queryString = "SELECT * FROM WILDLIFE_TABLE WHERE USER_ID = " + userID;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop through results and create new singleLog objects
            do {
                int wildlifeID = cursor.getInt(0);
                String userId = cursor.getString(1);
                String type = cursor.getString(2);
                String species = cursor.getString(3);

                WildLife newWildLife = new WildLife(userId, wildlifeID, type, species);
                returnList.add(newWildLife);

            } while (cursor.moveToNext());
        }
        else {
            // failure do not add anything
        }
        // close both the cursor and the db when done
        cursor.close();
        db.close();
        return returnList;

    }

    // Gets the wildlife based off of the log id
    public List<WildLife> getSingleWildlife(SingleLogTest singleLogTest) {
        List<WildLife> returnList = new ArrayList<>();
        // Query string to get specific log
        String logString = "SELECT LOG_ID FROM DIVELOG_TABLE WHERE DIVE_PARTNER = " + singleLogTest.buddy.getPartnerID();


        SQLiteDatabase db = this.getReadableDatabase();
        Cursor idCursor = db.rawQuery(logString, null);
        int logID = 0;

        // Get log id from the single log based on the partner ID
        if (idCursor.moveToFirst()) {
            do {
                logID = idCursor.getInt(0);
            } while (idCursor.moveToNext());
        }
        // Else do nothing
        else {

        }

        // Use log id to get wildlife

        String queryString = "SELECT * FROM WILDLIFE_TABLE A " +
                "JOIN WILDLIFE_LOG_TABLE B ON A.WILDLIFE_ID = B.WILDLIFE_ID WHERE B.LOG_ID = " + logID; // Fixing this;
        Cursor cursor = db.rawQuery(queryString, null);

        if (cursor.moveToFirst()) {
            // loop through results and create new singleLog objects
            do {
                int wildlifeID = cursor.getInt(0);
                String userId = cursor.getString(1);
                String type = cursor.getString(2);
                String species = cursor.getString(3);

                WildLife newWildLife = new WildLife(userId, wildlifeID, type, species);
                returnList.add(newWildLife);

            } while (cursor.moveToNext());
        }
        else {
            // failure do not add anything
        }
        // close both the cursor and the db when done
        cursor.close();
        db.close();
        return returnList;

    }

//    public boolean deleteWildlife(Wildlife wildlife) {
//        // Find user in database. If found delete true
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        String queryString = "DELETE FROM " + WILDLIFE_TABLE + " WHERE " + COLUMN_WILDLIFE_ID + " = " + wildlife.getID() ;
//
//        Cursor cursor = db.rawQuery(queryString, null);
//
//        if (cursor.moveToFirst()) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    } // end delete wildlife

    public boolean updateWildlife(WildLife wildlife) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_WILDLIFE_TYPE, wildlife.getType());
        cv.put(COLUMN_SPECIES, wildlife.getSpecies());

        long update = db.update(WILDLIFE_TABLE, cv,"_id = ?", new String[]{COLUMN_WILDLIFE_ID});

        if (update == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    //              PARTNER SECTION
    // Will need to add a wildlife ID for delete section

    public boolean addNewPartner(DivePartner divePartner) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USER_ID, divePartner.getUserID());
        cv.put(COLUMN_NAME, divePartner.getName());
        cv.put(COLUMN_ASSOCIATION, divePartner.getRole());
        cv.put(COLUMN_CERT_NUM, divePartner.getCertNum());

        long insert = db.insert(PARTNER_TABLE, null, cv);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String getPartnerId (DivePartner divePartner) {
        SQLiteDatabase db = this.getWritableDatabase();
        String ID = "";
        Cursor cursor = db.rawQuery("SELECT PARTNER_ID FROM PARTNER_TABLE WHERE USER_ID=? and NAME=? and COLUMN_ASSOCIATION=? and CERT_NUM=?", new String[]{divePartner.getUserID(), divePartner.getName(), divePartner.getRole(), divePartner.getCertNum()});

        if(cursor != null && cursor.moveToFirst()) {
            ID = cursor.getString(0);
        }
        else {
            ID = null;
        }
        db.close();
        return ID;
    }

//    public boolean deleteWildlife(Wildlife wildlife) {
//        // Find user in database. If found delete true
//
//        SQLiteDatabase db = this.getWritableDatabase();
//        String queryString = "DELETE FROM " + WILDLIFE_TABLE + " WHERE " + COLUMN_WILDLIFE_ID + " = " + wildlife.getID() ;
//
//        Cursor cursor = db.rawQuery(queryString, null);
//
//        if (cursor.moveToFirst()) {
//            return true;
//        }
//        else {
//            return false;
//        }
//    } // end delete wildlife

    public boolean updatePartner(DivePartner divePartner) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, divePartner.getName());
        cv.put(COLUMN_ASSOCIATION, divePartner.getRole());
        cv.put(COLUMN_CERT_NUM, divePartner.getCertNum());

        long update = db.update(PARTNER_TABLE, cv,"_id = ?", new String[]{COLUMN_PARTNER_ID});

        if (update == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}
