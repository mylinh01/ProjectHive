# Drop table if exists in hive
hive -e 'DROP TABLE ytdata'

# Creating youtube data table.
hive -e "create table ytdata (vid_id string, uploader_name string,
interval_from_created_to_upload int, category string, video_length
int, no_of_views int, ratings float, no_of_ratings int, no_of_comments
int) row format delimited fields terminated by ','location '/ngoctham/hive/warehouse'"

# Query to check table is generated without any error
hive -e "select * from ytdata"
