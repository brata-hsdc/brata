A basic Android Eclipse project intended to be a starting point for all teams in the Harris High School Design Challenge.  This was started in 2012, refined to be the FAT: Forensic Analysis Tool in 2013, SAT: Secret Agent Tool in 2014, and now is ... wait and see. :)

The Brata framework can be though of as the Brata application itself (but with missing pieces).  
When students receive the framework, it should where it can be compiled with no errors.  Students 
should compile it and install it on a phone/emulator (to get the look and feel of the application 
itself).  There are many places in the framework code where code is missing.  It is up to the 
students to add code to these "missing sections." By doing this the students will transform the 
framework into "Brata" (a fully functional application that can be used to complete the design 
challenge).

The Brata App, when complete, should be able to communicate with a beacon (another android phone) 
through SMS messages (text messages).  The Application should also be able to help solve clues, 
which are received from the beacon.  The clues should be solved with a collection of 
Tools/Activities that are contained in Brata.

Below are some tips regarding current activities in the framework (which need to be expanded upon 
by the students)

RequestClueActivity:

 - This Activity can be used to request a clue from a beacon by sending a SMS message to the 
   beacon.  The beacon will then respond with a SMS message as well.
   
 - This activity is already capable of sending and receiving SMS messages.  However the students 
   will be responsible for filling in a few missing pieces (phone number to send the SMS to, 
   actual message to send, etc...)  
   
 - When a message is received the DecodeReceivedMsg() function is automatically evoked.  Students 
   will be responsible for decoding the received message using ROT47.

 

SubmitResponseActivity:

 - When a student calculates the answer to a clue, this activity can be used to send the 
   answer/response back to a beacon (through a SMS message).
   
 - This activity is already capable of sending and receiving SMS messages.  However the students 
   will be responsible for filling in a few missing pieces (phone number to send the SMS to, 
   actual message to send, etc...) 
   
 - When a message is received the DecodeReceivedMsg() function is automatically evoked.  Students 
   will be responsible for decoding the received message using ROT47.
 
 
 
InclinationActivity:

 - This activity should be used to fine the inclination of a object.
 
 - The activity as is currently returns the phone orientation to students through X,Y, and Z 
   coordinate values.  It is up to the students to use these values to complete the activities 
   purpose.  A helpful resource to explain the X,Y, and Z values can be found here 
   http://developer.android.com/reference/android/hardware/SensorEvent.html 


NavigationActivity:

 - This activity should be used to help you find your way to a waypoint destination (GPS coordinate)
 
 - Persistent GPS functionality has been provided and is enabled by default, however, it is 
   still necessary to enable the GPS Provider in the Android phone options.  After receiving 
   instruction from the beacon to a go to a waypoint, the coordinates of the waypoint will be 
   entered into this activity.  It is up to the students to create a layout appropriate for 
   inputing a destination GPS coordinate and determining their current location relative to 
   their destination however they see fit.


RangingActivity:

 - This activity will be used to calculate the distance in meters between 2 sets of coordinates
 
 - Only a few basic functions are provided here.  It is up to the student to create a layout 
   appropriate for this task and implement a method for calculating the distance from the first 
   set of coordinates to the second. 
   
 - The required accuracy will depend on the accuracy we can expect from the phones.  More details 
   on our standard we will use for calculating the distance are provided in the activity.


QRCodeScannerActivity:

 - This activity will be used to capture a message from a QR code.
 
 - This activity already has the functionality to launch a scanner.  It is up to the student 
   to trigger the scan and to retrieve the message for display.
 

TimerActivity:

 - This activity is a simple implementation of a timer and is not needed for the BRATA challenge.
   It is meant to provide a complete example of how to accomplish a simple task.
 
 - It demonstrates making repeated updates to a text view element and controlling when to update.


LightSensorActivity:

 - This activity is a simple implementation of a light sensor and is not needed for the BRATA challenge.
   It is meant to provide a complete example of how to accomplish a simple task.
 
 - It demonstrates updating layout elements such as text views, images and buttons as it gets 
   measurements from a sensor and controlling when to update.
