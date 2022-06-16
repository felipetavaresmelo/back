echo "Download wiremock"

if [[ ! -f app.jar ]]
then
  curl --request GET \
   --url 'https://repo1.maven.org/maven2/com/github/tomakehurst/wiremock-standalone/2.27.2/wiremock-standalone-2.27.2.jar'\
   --output 'app.jar'
fi

echo "Starting wiremock"
java -jar app.jar --port 8888 --global-response-templating

echo "Stopping wiremock"