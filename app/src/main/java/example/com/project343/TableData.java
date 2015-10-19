package example.com.project343;

import android.provider.BaseColumns;

/**
 * Created by isahbellodoro on 10/18/15.
 */
public class TableData {
    private String USER_NAME;
    private String USER_PASS;
    private String USER_GENDER;
    private String USER_HUBBY;
    private String USER_FNAME;
    private String DISCRIPTION;



    public TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String USER_NAME ="user_name";
        public static final String USER_PASS ="user_pass";
        public static final String USER_GENDER ="user_gender";
        public static final String USER_HUBBY ="user_hubby";
        public static final String USER_FNAME ="user_fname";
        public static final String DISCRIPTION ="discription";
        public static final String DATABASE_NAME ="user_info";
        public static final String TABLE_NAME ="table_name";

    }


}
