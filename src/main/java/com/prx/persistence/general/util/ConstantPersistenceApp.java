package com.prx.persistence.general.util;

public final class ConstantPersistenceApp {

    public final static String PG_UUID_FUNCTION = "general.uuid_generate_v4()";

    public final static String SCHEMA_NAME = "general";

    public final static String ADDRESS_TABLE_NAME = "address";
    public final static String CONTACT_TABLE_NAME = "contact";
    public final static String CONTACT_TYPE_TABLE_NAME = "contact_type";
    public final static String FEATURE_TABLE_NAME = "feature";
    public final static String IDENTIFICATION_DOCUMENT_TABLE_NAME = "identification_document";
    public final static String PERSON_TABLE_NAME = "person";
    public final static String ROLE_TABLE_NAME = "role";
    public final static String ROLE_FEATURE_TABLE_NAME = "role_feature";
    public final static String SERVICE_TABLE_NAME ="service";
    public final static String USER_TABLE_NAME = "user";
    public final static String USER_ROLE_TABLE_NAME ="user_role";

    public final static String ID_CN = "id";
    public final static String NAME_CN = "name";
    public final static String ACTIVE_CN = "active";
    public final static String DESCRIPTION_CN = "description";

    private ConstantPersistenceApp() {
        //Default constructor
    }
}
