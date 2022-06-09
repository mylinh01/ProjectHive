# Xoa file du lieu va ket qua ton tai trong Hive
rm -r data_*.csv*
rm -r result_*

echo "----- Start Youtube Data Analysis -----"

  # Downloading data file from the client system
  wget http://$1:$2/download/data.csv

  # Loading data file into hive table
  hive -e "LOAD DATA LOCAL INPATH 'data.csv' OVERWRITE INTO TABLE ytdata";

  echo "----- Load data complete -----"

  # Display videos with ratings more than 4.7
  hive -e 'select * from ytdata where ratings > 4.7' > result_1
  # Uploading the result file to the client system
  curl -X POST http://$1:$2/upload1 -H 'content-type: multipart/form-data' -F file=@result_1
  echo "----- complete query 1-----"

  # Display top 10 engaging videos. It is measured asnumber of ratings + number of comments /number of views
  hive -e 'select vid_id,( (no_of_ratings+no_of_comments)/no_of_views) as engagement_value from ytdata order by engagement_value desc limit 10' > result_2
  # Uploading the result file to the client system
  curl -X POST http://$1:$2/upload2 -H 'content-type: multipart/form-data' -F file=@result_2
  echo "----- complete query 2-----"

  # Show total number of videos of each category
  hive -e 'select category, count(vid_id) as total from ytdata group by category' > result_3
  # Uploading the result file to the client system
  curl -X POST http://$1:$2/upload3 -H 'content-type: multipart/form-data' -F file=@result_3
  echo "----- complete query 3-----"

echo "----- End Youtube Data Analysis -----"
