# This file is to be run only on the production server.

WEB_CONTENT_SRC=../"Fusion Web Application"/WebContent/
WEB_CONTENT_DEST=/opt/tomcat/webapps/fusion

# Delete Exisiting configurations
rm -r $WEB_CONTENT_DEST

# Deploy
mkdir $WEB_CONTENT_DEST
cp -R $WEB_CONTENT_SRC/* $WEB_CONTENT_DEST/
