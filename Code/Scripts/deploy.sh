# This file is to be run only on the production server.

DB_USERNAME=fusion
DB_PASSWORD=fusion_pass
DB_NAME=fusion
DB_SCRIPTS="../Fusion Web Application/sql"
WEB_CONTENT_SRC="../Fusion Web Application/WebContent/"
WEB_CONTENT_DEST=/opt/tomcat/webapps/ROOT

# Delete Exisiting configurations
rm -r $WEB_CONTENT_DEST
mysql -u $DB_USERNAME -p < "$DB_SCRIPTS"/destroy-db.sql

# Populate Database with Test Data
mysql -u $DB_USERNAME -p < "$DB_SCRIPTS"/create-db.sql
mysql -u $DB_USERNAME -p < "$DB_SCRIPTS"/create-all-tables.sql
mysql -u $DB_USERNAME -p < "$DB_SCRIPTS"/populate-categories.sql
mysql -u $DB_USERNAME -p < "$DB_SCRIPTS"/populate-test-data.sql

# Deploy Web Site
mkdir $WEB_CONTENT_DEST
cp -R "$WEB_CONTENT_SRC"/* $WEB_CONTENT_DEST/
