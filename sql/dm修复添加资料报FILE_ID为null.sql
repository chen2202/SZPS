
-- 上次也出现这个问题，是因为触发器失效了，这边再重新执行次
create or replace trigger BEFOREDMFILEINSERT
before insert on DM_FILE
for each row
begin
  select SEQ_DM_FILE.nextval into :new.FILE_ID from dual;
end;