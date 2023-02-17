# virgin-money-developer-challenge
This Kotlin MVVM project is designed to provide an easy-to-use interface for viewing colleagues' contact details and checking the availability of rooms in the office. It follows the Model-View-ViewModel (MVVM) architectural pattern, which separates the UI from the business logic and data models.
<img width="715" alt="image" src="https://user-images.githubusercontent.com/8994634/219545163-b7aacd5b-83ba-44d4-b297-e5132b503e48.png">
<img width="444" alt="image" src="https://user-images.githubusercontent.com/8994634/219545201-eb17aed5-f3b7-4224-b47e-460a13929067.png">


The project includes a data layer that fetches and stores information about colleagues and room availability. This information is provided to the ViewModel layer, which communicates with the View layer to update the UI fetched from API network calls using Retrofit. Clicking on a colleague's name displays their full contact details, including phone number and email address.
![Screenshot_1676605328](https://user-images.githubusercontent.com/8994634/219545253-353be595-dc97-43d3-bc00-f2398907de1b.png)
![Screenshot_1676605331](https://user-images.githubusercontent.com/8994634/219545254-e8f8cc70-8340-430c-9130-7e59d5508164.png)
![Screenshot_1676605335](https://user-images.githubusercontent.com/8994634/219545256-7149cee4-6c53-41b2-afd0-b9ba1b84b088.png)

The room availability feature shows a list of all available rooms, along with their current occupancy status. Users can filter the list to show only available or occupied rooms, and click on a room to see more details, such as the name of the current occupant and the duration of their reservation.

Overall, the Kotlin MVVM project provides an efficient and user-friendly way for employees to access important contact information and track room availability in the office.



