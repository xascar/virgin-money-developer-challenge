# virgin-money-developer-challenge
This Kotlin MVVM project is designed to provide an easy-to-use interface for viewing colleagues' contact details and checking the availability of rooms in the office. It follows the Model-View-ViewModel (MVVM) architectural pattern, which separates the UI from the business logic and data models.
<center><img width="818" alt="image" src="https://user-images.githubusercontent.com/8994634/219546118-8161023f-dea2-4118-9fc4-6909d172dbef.png"></center>

The project includes a data layer that fetches and stores information about colleagues and room availability. This information is provided to the ViewModel layer, which communicates with the View layer to update the UI fetched from API network calls using Retrofit. Clicking on a colleague's name displays their full contact details, including phone number and email address.

<center><img width="715" alt="image" src="https://user-images.githubusercontent.com/8994634/219545163-b7aacd5b-83ba-44d4-b297-e5132b503e48.png"></center>

The room availability feature shows a list of all available rooms, along with their current occupancy status. Users can filter the list to show only available or occupied rooms, and click on a room to see more details, such as the name of the current occupant and the duration of their reservation.

<center><img width="444" alt="image" src="https://user-images.githubusercontent.com/8994634/219545201-eb17aed5-f3b7-4224-b47e-460a13929067.png"></center>

Overall, the Kotlin MVVM project provides an efficient and user-friendly way for employees to access important contact information and track room availability in the office.



