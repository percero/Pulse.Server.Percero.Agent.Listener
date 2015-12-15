
create or replace PROCEDURE INSERT_TO_UPDATE_TABLE
(
  vTableName IN VARCHAR2,
  vRowId IN NUMBER,
  vType IN VARCHAR2

) IS
    vUpdateTblID NUMBER:=1;

BEGIN
    select max(ID) + 1 INTO vUpdateTblID FROM UPDATE_TABLE_DEV;

    IF vUpdateTblID is null THEN
      vUpdateTblID := 1;

    END IF;
    insert into update_table_dev(ID, TABLENAME, ROW_ID,timestamp, type) VALUES(vUpdateTblID, vTableName, vRowId, sysdate,vType );

COMMIT;

END INSERT_TO_UPDATE_TABLE;
/