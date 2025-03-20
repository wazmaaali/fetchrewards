Project Overview
This application fetches a list of items from the URL:
https://fetch-hiring.s3.amazonaws.com/hiring.json

The project follows the MVC (Model-View-Controller) architecture:

Model:
I first created a ListItems model class that represents all the variables required by the JSON data.

API Service:
I then created an API services interface that handles all API calls. For this case, it makes a call to the above URL.

Controller:
The Controller class utilizes the service class to fetch the data using Retrofit. The response is then saved for further use.

MainActivity:
In the MainActivity, the response is fetched once the app loads. The data undergoes checks for null values in the name field. Then, it is grouped according to the listID and sorted first by listID, followed by name (using id for more accurate results, as id is the same as name).

RecyclerView:
The final response is parsed into a RecyclerView, using a custom adapter for added flexibility and dynamic content rendering.
