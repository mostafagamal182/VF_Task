Feature: Passenger Booking train

Scenario:Passenger go to booking and select seat for trip
Given Passenger navigate trips page
When Passenger Choose route
And Passenger choose arrival date
And Passenger search for bus
And Passenger select a seat
  And Passenger	choose the boarding point and dropping point
  And Passenger fill the “Customer” and “Passenger” details
  And Passenger click on “make payment” and fill all the fields without submitting the payment