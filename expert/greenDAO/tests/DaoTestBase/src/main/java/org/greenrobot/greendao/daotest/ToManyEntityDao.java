package org.greenrobot.greendao.daotest;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "TO_MANY_ENTITY".
*/
public class ToManyEntityDao extends AbstractDao<ToManyEntity, Long> {

    public static final String TABLENAME = "TO_MANY_ENTITY";

    /**
     * Properties of entity ToManyEntity.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property SourceJoinProperty = new Property(1, String.class, "sourceJoinProperty", false, "SOURCE_JOIN_PROPERTY");
    }

    private DaoSession daoSession;


    public ToManyEntityDao(DaoConfig config) {
        super(config);
    }
    
    public ToManyEntityDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"TO_MANY_ENTITY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"SOURCE_JOIN_PROPERTY\" TEXT);"); // 1: sourceJoinProperty
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"TO_MANY_ENTITY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ToManyEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String sourceJoinProperty = entity.getSourceJoinProperty();
        if (sourceJoinProperty != null) {
            stmt.bindString(2, sourceJoinProperty);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ToManyEntity entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String sourceJoinProperty = entity.getSourceJoinProperty();
        if (sourceJoinProperty != null) {
            stmt.bindString(2, sourceJoinProperty);
        }
    }

    @Override
    protected final void attachEntity(ToManyEntity entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ToManyEntity readEntity(Cursor cursor, int offset) {
        ToManyEntity entity = new ToManyEntity( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1) // sourceJoinProperty
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ToManyEntity entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setSourceJoinProperty(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ToManyEntity entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ToManyEntity entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ToManyEntity entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}