package org.sfeirapp.persistence;

import android.provider.BaseColumns;

/**
 * Created by tarekelchami on 28/04/14.
 */
public final class MonumentContract {

    public MonumentContract() {
    }

    public static abstract class MonumentEnty implements BaseColumns{
        public static final String TABLE_NAME = "monument";
        public static final String COLUMN_NAME_MONUMENT_ID = "monumentid";
        public static final String COLUMN_NAME_TITRE = "titre";
        public static final String COLUMN_NAME_LIEU = "lieu";
        public static final String COLUMN_NAME_DESC = "description";
    }
}
