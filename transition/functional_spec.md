1.0 Overview
===========

This document describes Professor Aardvark's Space Adventure entirely from the
user's perspective.

The evil yet ingenious Professor Aardvark (PA) had been captured and the danger
to Brevard County residents was thought to be over. Little did anyone know, but
PA has a daughter, Arianna Aardvark (AA). She is as clever as her father and is
scheming to break him out of prison, stopping at nothing to do so.

The only place thought to be beyond her reach is the International Space Station
or ISS, which has a special security module and separate docking port attached
to keep PA secure. However, all conventional methods to get PA to the ISS have
been compromised by AA.

Your job is to improvise a launch capability, dock with the secure module,
intern PA, and return to Earth, all without being thwarted by Arianna Aardvark.
Good luck!

**This spec is not, by any stretch of the imagination, complete.** All of the
wording will need to be revised several times before it is finalized. The
graphics and layout of the screens is shown here merely to illustrate the
underlying functionality. The actual look and feel will be developed over time
with the input of graphics designers and iterative user feedback.


2.0 Scenarios
============


2.1 Registration
----------------

The members of Team Awesome Aardvark (or AA) arrived at the HSDC competition.
Upon arrival, they were presented with a **team card** that had the following
information:

* Team name: Awesome Aardvark
* Team number: HFQ02
* Three QR codes with the following captions:
	* **Welcome**
	* **Submit**
	* **Qual**

Team AA was asked not to share their team card with anyone, as the five-digit
team number is unique to their team and is used to associate them with all
activity, including associating them with their scoring.

> **Technical Note:** Assuming less than 200 teams, the team number was
> generated to be sufficiently different from all other team numbers in use
> in order to reduce the likelihood of a team inadvertently entering another
> team's number.

Harry started to pull out his Samsung Galaxy S6, but Sally thought her iPhone 6
Plus was the best thing since sliced bread, so she took the team card from Harry,
launched her BRATA application, entered the **Registration** tool, scanned the
**Welcome** QR code on the team card, and began entering the team information
when prompted. _(A1)_

Harry just rolled his eyes and waited for Sally's battery to drain.

Once Sally entered the case-insensitive team name and team number and scanned
the **Submit** QR code, she was greeted with a welcome message confirming her
team had completed the registration and may begin the entry qualification when
instructed. _(A2)_

    +------+              +-------+             +--------+
    | User |              | BRATA |             | Master |
    +--+---+              +---+---+             | Server |
       |                      |                 +----+---+
       |                      |                      |
      +-+  Registration Tool +-+                     |
      | |------------------->| |                     |
      | |                    | |                     |
      | |  Scan QR Code      | |                     |
      | |------------------->| |                     |
      | |                    | |   New Client       +-+
      | |                    | |------------------->| |
      | |                    | |                    | |
      | |                    | | Get Team Name/Team | |
      | |  Enter Team Name/  | | Number             | |
      | |  Team Number       | |<-------------------| |
      | |                    +-+                    +-+
      | |  Scan QR Code       |                      |
      | |------------------->+-+  Register          +-+
      +-+                    | |------------------->| |
       |                     | |                    | |
       |                     | |  Confirmation      | |
       |                     | |  Welcome Message   | |
       |                     | |<-------------------| |
       |                     +-+                    +-+
       |                      |                      |


### 2.1.1 Error Entering Registration Information _(A1)_

Sally carelessly tapped meaningless digits for her team number thinking her
iPhone's auto-correct can and should read her mind.

Since Sally entered the wrong team number, her BRATA application responded that
her registration failed.


### 2.1.2 Alternate Clients _(A2)_

Sally could not stand waiting for the competition to begin. She was bored out of
her mind listening to all the boring talks about how great this is and how this
will help them when they get to college. When someone started describing an
odometer for his hamster, Sally decided she had enough and started checking
Twitter and Facebook on her phone, and then played a round of Flappy Bird before
putting on an episode of _Utopia_.

Pretty soon her low battery indicator came on, and she realized she left her
charger at home. No other iPhone user was willing to lend his/her charging cable
to her because everyone was worried about their own battery life, especially
other iPhone 6 users that refused to believe that a smaller battery would last
just as long as the one in last year's model.

Harry rolled his eyes again, and pulled out his phone. He took the team card
back from Sally and registered himself, indicating to take over for the team
when prompted since the team had already registered.

> **Note:** The take-over did not require the team to go through entry
> qualification again under the assumption that anyone taking over a team's
> BRATA is taking it over with a back-up phone running the exact same BRATA
> build as the original.

> TODO: Recommend requiring a take-over to go through the entry qualification
> all over again. Although this will be quicker in the field because it will
> allow a team to quickly recover from a dead phone, this can blow up in our
> face because a team without a proper back-up phone can bring in a development
> phone at the last minute as a last resort and continue through the challenge,
> effectively bypassing all the work we put into the entry qualification.

He checked the Mobile Scoreboard and verified his registration was completed.
Next, the Aardvarks had to go through the entry qualification.

Sally just sat and sulked thinking about her inability to check Snapchat for the
remainder of the day.

    +------+              +-------+             +--------+
    | User |              | BRATA |             | Master |
    +--+---+              +---+---+             | Server |
       |                      |                 +----+---+
       |                      |                      |
       |                      |                      |
      +-+  Enter Team Name/   |                      |
      | |  Team Number        |                      |
      | |                     |                      |
      | |  Scan QR Code       |                      |
      | |------------------->+-+  Register          +-+
      +-+                    | |------------------->| |
       |                     | |                    | |
       |                     | | Already Registered | |
       |                     | |<-------------------| |
       |                     +-+                    +-+
      +-+                     |                      |
      | |  Take Over          |                      |
      | |------------------->+-+ Register(TakeOver) +-+
      +-+                    | |------------------->| |
       |                     | |                    | |
       |                     | |  Confirmation      | |
       |                     | |  Welcome Message   | |
       |                     | |<-------------------| |
       |                     +-+                    +-+
       |                      |                      |


2.2 Entry Qualification
-----------------------

The Babbage Bots completed registration. Next, they had to find out how good a
job they did with their BRATA.

As instructed, the Bots pulled out a second phone loaded with the BRATA software.
Samantha launched the BRATA app on the second phone, selected **Registration**,
and scanned the **Qual** QR code from the Bots' **team card**. _(A1)_

This brought up the Master Server's entry qualification page on the second phone
while Jess brought up the BRATA app on their primary phone.

The qualification page began by prompting for the team ID, which Samantha
entered promptly.

> **Note:** This put the Master Server into a training/qualification mode for
> the given team ID.

The Bots followed the instructions on the qualification page, which provided a
selection of tests to run as well as the progress of their qualification test.

Samantha selected each test one-by-one on the qualification page while Jess
followed the required steps in the BRATA app on the primary phone, filling out
fields and submitting information.

As each test completed, the qualification page showed that the test passed and
the Bots breathed a sigh of relief.

Samantha went back several times and re-ran tests that Jess previously passed
just to double-check and make sure there were truly no problems.

The entire ordeal would have taken no more than ten (TBR) minutes if the Bots ran all
tests exactly once without any re-runs. Once all the tests indicated they passed,
Samantha completed the qualification to get the Master Server out of training
mode. _(A2)_

Samantha's phone showed a welcome message confirming her team had completed the
entry qualification successfully and may begin the challenges when instructed.

Jess checked the Mobile Scoreboard and verified her qualification was completed.

TODO: Sequence diagram


### 2.2.1 Using a PC _(A1)_

Since the Bots only had one BRATA-capable phone available, they went to a
qualification kiosk and launched the link to the Master Server's entry qualification page.


### 2.2.2 Entry Qualification Failed _(A2)_

No matter what the Bots tried, Samantha and Jess could not get all the Unlock
tests to pass.

When the competition was about to begin, Samantha completed the qualification to
get the Master Server out of training mode.

Samantha's phone showed a welcome message confirming her team had completed the
entry qualification with errors. The page informed the Bots that they may begin
the challenges when instructed, but it would be unlikely they will get through
the corresponding challenges due to the failed tests.

Jess checked the Mobile Scoreboard and verified her qualification was completed,
but the Unlock items indicated the qualification tests failed.


2.3 Launch
----------

At long last, it was time to begin the challenges! After waiting in line for
what seemed like an eternity waiting in line, the Three Bits were escorted
outside to survey and mark the lasers and launch location.

Joel was looking forward to touching the neat-looking Raspberry Pi stations,
so he was disappointed when he learned this challenge had no station with it.

Joel and his team were escorted first to the welcome marker for the challenge,
which displayed a QR code for them to scan. Joel scanned the QR code, and
breathed a sigh of relief when his phone successfully displayed the Master
Server's properly-deciphered response message. _(A1)_, _(A3)_

Joel was up late the night before putting some finishing touches on his BRATA
application, and he couldn't stop second-guessing himself all morning if it was
worth the risk breaking the application since he did not get to test his changes
much at 2:15 a.m.

The Master Server's response provided three data:

* a latitude and a longitude origin (decimal deg)
* the angle of rotation (decimal deg)
* a side length (m)

The response also informed them that the clock had started ticking for this
challenge.

Using this information alone, the Three Bits obtained the location of all three
ground lasers and the location of the space capsule with the help of their BRATA
tools.

The Bits raced with their escort to all four points in any order they wished. At
each point, the Bits observed three markers, each with its own QR code.

> **TODO:** Require visiting the origin first? Require visiting center last?

Using their BRATA application, they were able to determine which was the correct
marker to scan at each point and, therefore, scanned the correct QR code. In
response, their BRATA received an acknowledgment back for each QR code telling
them they selected the right QR code. Additionally, they also a completion
response after scanning the fourth QR code. _(A1)_, _(A2)_

At various times during the challenge, the Joel visited the Mobile Scoreboard
to keep track of their progress throughout the challenge.

> **Note:** Scanning the final correct marker also stopped the clock for the
> team.

After completing the challenge, the team was escorted back inside to continue
with the remaining challenges.

    +------+              +-------+             +--------+
    | User |              | BRATA |             | Master |
    +--+---+              +---+---+             | Server |
       |                      |                 +----+---+
       |                      |                      |
      +-+  Scan QR Code      +-+                     |
      | |------------------->| |                     |
      | |                    | |                     |
      | |                    | |   TODO             +-+
      | |                    | |------------------->| |
      | |                    | |                    | |
      | |                    | | origin             | |
      | |                    | | angle of rotation  | |
      | |                    | | side length        | |
      | |                    | |<-------------------| |
      | |                    +-+                    +-+
      | |  Scan QR Code       |                      |
      | |------------------->+-+  TODO              +-+
      +-+                    | |------------------->| |
       |                     | |                    | |
       |                     | |  Pass/Fail         | |
       |                     | |<-------------------| |
       |                     +-+                    +-+
       |                      |                      |


### 2.3.1 Application Crash _(A1)_

Joel's worst fear was realized when he saw his BRATA application crash after
scanning the first QR code. The Bits thought it might just be a fluke, so they
launched the application again on the same phone.

Since the Bits chose to persist the team information in their BRATA, they did
not have to take out the registration index card to re-enter their team ID.

Unfortunately, their application crashed again upon scanning the QR code again,
and worst of all was they could not tell if the crash occurred before or after
the scanned code had been submitted to the Master Server, and whether or not it
was the correct marker if it did get submitted.

Thinking quickly, Joel switched to the Mobile Scoreboard and was able to confirm
that the selected QR code did indeed make it to the Master Server because the
Mobile Scoreboard showed they got credit for selecting the right marker.

They decided to limp along and try to move onto the next marker. They noticed a
pattern when their BRATA crashed again on this marker as well.

This time, the Mobile Scoreboard showed no indication of them getting the correct
marker, so either it was not submitted or it was not the correct marker. The Bits
looked at each other and decided they had nothing to lose, so Joel went ahead and
tried scanning the second marker after bringing his application up again.

When that produced the same results, he tried one final time with the third
marker. The Mobile Scoreboard showed them finally receiving credit, so the Bits
deduced, the first two markers got submitted as well but were incorrect.

The Three Bits continued limping through the challenge with their escort. They
were not happy with their application, but were relieved that they were able to
continue.


### 2.3.2 Incorrect Point _(A2)_

As Joel feared, his latest changes did not fix the location problem. As the Bits
scanned the marker they believed was correct, their BRATA reported a message back
stating their selection was incorrect. So much for getting a perfect score.

At least Joel didn't feel too bad. He knew they would lose points for each incorrect selection, but at least they could still continue trying for this
challenge without worrying about losing the round after a fixed number of tries.

### 2.3.3 Qualification Failed _(A3)_

When Joel scanned the welcome QR code, the BRATA response included a warning
about the failed qualification. The team was permitted to continue, but it is
unlikely they will complete the challenge successfully.


2.4 Docking
-----------

The Shuttle Pilots were ready for this challenge. They tested, rehearsed, and
practiced for weeks to get through the competition and were sure they were
going to get through everything easily.

When it was their turn to begin the Docking challenge, they noticed there were
several other teams' members measuring different lengths of tape on the floor,
each having a different identifying tape number.

They began by scanning the welcome QR code for the challenge. Their BRATA
responded by giving them instructions to measure one of the tape lengths on the
floor that ranged from 5-20 meters. The instructions specified exactly which
tape to measure by providing and identification number. _(A3)_

They knew their time started, so they quickly moved to measure the tape using
their BRATA tools.

Once they completed their measurement, they scanned the next QR code to submit
their measurement. Their BRATA responded providing three data:

* fuel allocation (kg)
* fore thruster impulse rate (m/s<sup>2</sup>)
* aft thruster impulse rate (m/s<sup>2</sup>)

The Pilots proceeded to use their tools to compute the correct answer. _(A1)_

When ready, they scanned the next QR code and submitted the following:

* coast time _tc_ (s)
* fore thruster burn time _tf_ (s)
* aft thruster burn time _ta_ (s)

Their BRATA reported to watch the display to observe the docking, which the
Pilots didn't need to watch because they knew everything worked.

> **Note:** This stops the clock. If the answer is correct, then the clock will
> not restart for this challenge; on the other hand, the clock will resume
> after the docking completes if the answer is incorrect.

The docking display began a simulation of the docking maneuver that took a total
of _tc_ + _tf_ + _ta_ seconds.

As the simulation completed on the display, the BRATA received a notification
that the maneuver completed successfully, just as the Pilots predicted. _(A2)_

> **TODO:** Since we have had difficulty with unsolicited messages from the
> Master Server to BRATA, should we work around it this time by taking advantage
> of the mobile scoreboard? (See below.)

> **TODO:** Need to decide whether to display the simulation on a screen
> attached to the station, or display on the team's phone. (I believe the
> current consensus is on the screen.)

> **Technical Note:** Four simulations will be displayed--one for each of four
> stations--on a single screen divided into four regions in a 2x2 layout. (TODO
> four regions in a 2x2 layout, or six regions in a 2x3 layout?)

TODO [Proposed] During the simulation, the Shuttle Pilots monitored the docking
status on the Mobile Scoreboard. As the simulation completed on the display, the
Mobile Scoreboard reported that the maneuver completed successfully, just as the
Pilots predicted. _(A2)_

    +------+              +-------+             +--------+            +---------+
    | User |              | BRATA |             | Master |            | Docking |
    +--+---+              +---+---+             | Server |            | Display |
       |                      |                 +----+---+            +----+----+
       |                      |                      |                     |
      +-+  Scan QR Code      +-+                     |                     |
      | |------------------->| |                     |                     |
      | |                    | |                     |                     |
      | |                    | |   TODO             +-+                    |
      | |                    | |------------------->| |                    |
      | |                    | |                    | |                    |
      | |                    | | tape #             | |                    |
      | |                    | |<-------------------| |                    |
      | |--+                 +-+                    +-+                    |
      | |  | Measure Tape     |                      |                     |
      | |  |                  |                      |                     |
      | |<-+                  |                      |                     |
      | |  Enter tape length  |                      |                     |
      | |                     |                      |                     |
      | |  Scan QR Code       |                      |                     |
      | |------------------->+-+  TODO              +-+                    |
      +-+                    | |------------------->| |                    |
       |                     | |                    | |                    |
       |                     | |  fuel allocation   | |                    |
       |                     | |  fore thrust rate  | |                    |
       |                     | |  aft thrust rate   | |                    |
       |   Enter tc, tf, ta  | |<-------------------| |                    |
      +-+                    +-+                    +-+                    |
      | |  Scan QR Code       |                      |                     |
      | |------------------->+-+  TODO              +-+                    |
      +-+                    | |------------------->| |  begin_docking    +-+
       |                     | |                    | |------------------>| |
       |                     | |  Pass/Fail         | |                   | |
       |                     | |<-------------------| |                   | |
       |                     +-+                    +-+                   +-+
       |                      |                      |                     |


### 2.4.1 Incorrect Measurement _(A1)_

The Shuttle Pilots scanned the QR code to submit their measurement, which was
incorrect. The purpose of this submission was to complete the measurement
portion of the activity.

Even though the measurement was incorrect, the Pilots' BRATA responded providing
the same three data and waiting for the Pilots to submit their final three
values the same way as the measurement being correct.


### 2.4.2 Incorrect Response _(A2)_

As the simulation completed on the display, the Pilots were befuddled when their
BRATA received a notification that the maneuver failed.

> **TODO:** Since we have had difficulty with unsolicited messages from the
> Master Server to BRATA, should we work around it this time by taking advantage
> of the mobile scoreboard? (See below.)

TODO [Proposed] During the simulation, the Shuttle Pilots monitored the docking
status on the Mobile Scoreboard. As the simulation completed on the display, the
Pilots were befuddled when the Mobile Scoreboard reported that the maneuver failed.

The [TODO] BRATA/Mobile Scoreboard instructed them to restart the challenge from
the beginning, so they went back, rescanned the welcome QR code, and proceeded to
measure the indicated tape once again with looks of remorse on their faces.

> **Note:** The tape measured subsequent times might not necessarily be the
> same tape measured the preceding time.

The Pilots were disappointed because all time spent during re-runs would be
accumulated into the total time spent on the challenge, but at least they had
three total chances to get this right.

### 2.4.3 Qualification Failed _(A3)_

When the Pilots scanned the welcome QR code, the BRATA response included a
warning about the failed qualification. The team was permitted to continue, but
it would be unlikely they will complete the challenge successfully.


2.5 Unlock
----------

> **Note:** The station used for this challenge is similar to last year's CPA
> station.

The Traveling Salesmen couldn't help admiring the setup for this challenge. This
one had a cable to plug into a headphone jack and it also had a light sensor.
Paul couldn't wait to try it out.

Paul approached the welcome QR code with his team and scanned it. His BRATA app
signaled that they were ready to begin the challenge. The clock was ticking.
_(A4)_

Paul did not like being under pressure. His hands started shaking and his palms
started getting sweaty. He hoped to complete the challenge before his teammates
found out how nervous he was.

He began by plugging in the microphone cord into the 3.5 mm headphone jack of
his phone. There was enough slack in the cord to allow him to orient the phone
properly and scan the second QR code. _(E1)_

> **Technical Note:** The students call BRATA to start listening for tones.

The BRATA indicated acknowledgment from the Master Server. Within a few moments,
the station began playing back tones that the Salesmen could hear, and their
BRATA indicated audio was being received. 

> **Technical Note:** The tones to play back are stored in a single audio file,
> so playing tones consists of playing back a single file. Different files are
> available for playback for different students attempting the challenge.

Once the tones were successfully received, the Salesmen derived the solution and
Paul prepared to scan the third QR code. He knew he had to be ready to send the
light pulses right after.

Moments after Paul scanned the third QR code, the station responded by turning on
its light sensor, which was indicated by an LED on the station turning on steady.

Paul was already in position and activated the light pulses. _(A1)_, _(A2)_

The camera flash on the Salesmen's phone began emitting the light pulses. The
station's LED began flashing, indicating it was receiving the pulses. _(E2)_

The BRATA indicated the emission of light pulses completed. Paul scanned the
final QR code to signal completion.

The clock stopped ticking, the BRATA responded that the team passed the
challenge, and the Salesmen heard an audio clip of a lock opening. _(A3)_

> **TODO:** Since we have had difficulty with unsolicited messages from the
> Master Server to BRATA, should we work around it this time by taking advantage
> of the mobile scoreboard? (See below.)

TODO [Proposed] After sending the light pulses, the Traveling Salesmen monitored
the unlocking status on the Mobile Scoreboard.

TODO [Proposed] The clock stopped ticking, the Mobile Scoreboard indicated that
the team passed the challenge, and the Salesmen heard an audio clip of a lock
opening. _(A3)_

TODO: Sequence diagram


### 2.5.1 Activating Light Pulses Too Soon _(A1)_

Paul's nervousness got the best of him when he fired the light pulses before the
station was ready. As a result, when the station's LED turned on, some of the
pulses had already been sent that the station never registered.

As a result, the challenge failed. (See alternate flow _A3_.)

TODO: Sequence diagram


### 2.5.2 Activating Light Pulses Too Late _(A2)_

Paul was not sure if he was aiming right. He wanted to fire the pulses, but he
also wanted to make sure he got them right. After waiting 15 (TBR) seconds to
receive light pulses and not receiving any, the station's LED and light sensor
turned off.

When Paul finally fired the light pulses, the station's LED remained off.

As a result, the challenge failed. (See alternate flow _A3_.)

TODO: Sequence diagram


### 2.5.3 Challenge Failed _(A3)_

Paul scanned the final QR code to signal completion.

The clock stopped ticking, the BRATA responded that the team failed the
challenge, and the Salesmen heard no audio clip.

> **TODO:** Since we have had difficulty with unsolicited messages from the
> Master Server to BRATA, should we work around it this time by taking advantage
> of the mobile scoreboard? (See below.)

TODO [Proposed] After sending the light pulses, the Traveling Salesmen monitored
the unlocking status on the Mobile Scoreboard.

TODO [Proposed] The clock stopped ticking, the Mobile Scoreboard indicated that
the team failed the challenge, and the Salesmen heard no audio clip.

The [TODO] BRATA/Mobile Scoreboard instructed them to restart the challenge from
the beginning, so they went back and rescanned the welcome QR code. Since they
had not yet unplugged the microphone cord, they knew they would save some time
this time.

The Salesmen were disappointed because all time spent during re-runs would be
accumulated into the total time spent on the challenge, but at least they had
three total chances to get this right.

TODO: Sequence diagram


### 2.5.4 Qualification Failed _(A4)_

When Paul scanned the welcome QR code, the BRATA response included a warning
about the failed qualification. The team was permitted to continue, but it is
unlikely they will complete the challenge successfully.


### 2.5.5 Bad Microphone Cord _(E1)_

The conductive sweat from Paul's hand got onto the tip of the microphone cord as
he held it, causing a short when he plugged the cord into his phone. Paul jumped
back at the sight of the sparks but, then, fanned away the smoke coming out of
his phone.

Paul hoped everything would be alright, and scanned the second QR code anyway.
He was relieved when the Salesmen heard the tones being played back because it
seemed everything was still working, but he noticed the BRATA did not indicate
any audio was being received.

The Salesman began fiddling with the cable and the connection. They re-scanned
the second QR code repeatedly to restart playback of the tone each time, but
the BRATA continued to indicate no audio was being received.

The Salesmen did not want to lose any more time on this challenge, so they called
an escort for help.

Explaining the situation took some time. After 30 (TBR) seconds with no activity,
the BRATA indicated it was no longer listening for audio on the headphone jack.

After explaining the situation, the quick-thinking escort quickly replaced the
microphone cord with a spare. These cords must have been new because Paul noticed
it was still in its original packaging.

Meanwhile, the Salesmen switched to a different phone as well in case the
microphone port of the Paul's phone got damaged.

When Paul re-scanned the second QR code, the Salesmen heard the tones again, and
this time the BRATA indicated audio was being received.

Before allowing the Salesmen to continue, the escort reset the Salesmen's current
challenge so the time lost due to microphone trouble would not be counted against
them.

The Salesmen started the challenge over by re-scanning the welcome QR code.

TODO: Sequence diagram


### 2.5.6 Light Pulses Not Received _(E2)_

The camera flash on the Salesmen's phone began emitting the light pulses;
however, the station's LED continued to stay on steady without flashing, indicating it was waiting to receive pulses but was not receiving any.

The Salesmen were puzzled. Paul tried re-sending the light pulses, but the
station continued to wait.

The Salesmen did not want to lose any more time on this challenge, so they called
an escort for help.

Explaining the situation took some time. After waiting 15 (TBR) seconds to
receive light pulses and not receiving any, the station's LED and light sensor
turned off.

After explaining the situation, the quick-thinking escort moved the Salesmen back
to the queue but put them at the head of the queue. The Salesmen would have to
wait for another station.

The escort took the station offline for troubleshooting.

Finally, the escort reset the Salesmen's current challenge so the time lost due
to light sensor would not be counted against them.

The Salesmen waited for another station to be available, and restarted the
challenge by scanning its welcome QR code.

TODO: Sequence diagram


2.6 Return to Earth
-------------------

> **Note:** The station used for this challenge is similar to last year's CTS
> station.

Dijkstra's Disciples completed the other challenges and were now ready to Return
to Earth (RTE). They began by scanning the welcome QR code. The station indicated
it was currently in standby mode.

Their BRATA responded that the challenge had started and the clock was ticking.
_(A2)_

Meanwhile, the station activated and prompted the user for six Vector _B_ angles.

Following the instructions given, they used the tools on their BRATA to measure
the six angles for Vector _A_ on their wooden prop.

> **Note:** There is a three (TBR) degree tolerance for the angle measurements.

Next, the Disciples entered their six angles into their BRATA app using decimal
degrees. The app returned six new angles in decimal degrees ranging from 0 to
99 for Vector _B_ with instructions to enter them into the navigational computer
and then watch the display.

Then, the Disciples entered these six Vector _B_ angles one-by-one into the
station using its up/down/left/right and Enter buttons.

> **Note:** This stops the clock. If the answer is correct, then the clock will
> not restart for this challenge; on the other hand, the clock will resume
> after the maneuver completes if the answer is incorrect.

The landing display began a simulation of the landing maneuver.

As the simulation completed on the display, the BRATA received a notification
that the maneuver completed successfully. _(A1)_

> **TODO:** Since we have had difficulty with unsolicited messages from the
> Master Server to BRATA, should we work around it this time by taking advantage
> of the mobile scoreboard? (See below.)

> **TODO:** Need to decide whether to display the simulation on a screen
> attached to the station, or display on the team's phone. (I believe the
> current consensus is on the screen.)

> **Technical Note:** Four simulations will be displayed--one for each of four
> stations--on a single screen divided into four regions in a 2x2 layout. (TODO
> four regions in a 2x2 layout, or six regions in a 2x3 layout?)

TODO [Proposed] During the simulation, Dijkstra's Disciples monitored the landing
status on the Mobile Scoreboard. As the simulation completed on the display, the
Mobile Scoreboard reported that the maneuver completed successfully. _(A1)_

    +------+              +-------+             +--------+            +---------+
    | User |              | BRATA |             | Master |            |   RTE   |
    +--+---+              +---+---+             | Server |            | Station |
       |                      |                 +----+---+            +----+----+
       |                      |                      |                     |
      +-+  Scan QR Code      +-+                     |                     |
      | |------------------->| |                     |                     |
      | |                    | |                     |                     |
      | |                    | |   TODO             +-+                    |
      | |                    | |------------------->| | TODO - Initialize +-+
      | |                    | |                    | |------------------>| |
      | |                    | | Instructions       | |                   | |
      | |                    | |<-------------------| |                   | |
      | |--+                 +-+                    +-+                   +-+
      | |  | Measure Prop     |                      |                     |
      | |  |                  |                      |                     |
      | |<-+                  |                      |                     |
      | |  Enter Vector A     |                      |                     |
      | |                     |                      |                     |
      | |  Scan QR Code       |                      |                     |
      | |------------------->+-+  TODO              +-+                    |
      +-+                    | |------------------->| |                    |
       |                     | |                    | |                    |
       |                     | |  Vector B          | |                    |
       |                     | |<-------------------| |                    |
       |                     +-+                    +-+                    |
       |                      |                      |                     |


    +------+            +---------+             +--------+            +---------+
    | User |            |   RTE   |             | Master |            | Landing |
    +--+---+            | Station |             | Server |            | Display |
       |                +----+----+             +----+---+            +----+----+
       |                     |                       |                     |
       |   Enter angles      |                       |                     |
       |                     |                       |                     |
      +-+  Submit answer    +-+                      |                     |
      | |------------------>| |                      |                     |
      | |                   | |   TODO              +-+                    |
      | |                   | |-------------------->| |                    |
      | |                   | |                     | |                    |
      | |                   | | Pass/Fail           | |                    |
      | |                   | |<--------------------| |                    |
      +-+                   | |                     | |  begin_landing    +-+
       |                    | |                     | |------------------>| |
       |                    | |  Pass/Fail          | |                   | |
       |                    | |<--------------------| |                   | |
       |                    +-+                     +-+                   +-+
       |                     |                       |                     |


### 2.6.1 Incorrect Response _(A1)_

As the simulation completed on the display, the BRATA received a notification
that the maneuver failed.

> **TODO:** Since we have had difficulty with unsolicited messages from the
> Master Server to BRATA, should we work around it this time by taking advantage
> of the mobile scoreboard? (See below.)

TODO [Proposed] During the simulation, Dijkstra's Disciples monitored the landing
status on the Mobile Scoreboard. As the simulation completed on the display, the
Mobile Scoreboard reported that the maneuver failed.

The [TODO] BRATA/Mobile Scoreboard instructed them to restart the challenge from
the beginning, so they went back, rescanned the welcome QR code, and proceeded to
measure the prop once again.

The Disciples were disappointed because all time spent during re-runs would be
accumulated into the total time spent on the challenge, but at least they had
three total chances to get this right.

### 2.6.2 Qualification Failed _(A2)_

When the Disciples scanned the welcome QR code, the BRATA response included a
warning about the failed qualification. The team was permitted to continue, but
it would be unlikely they will complete the challenge successfully.


2.7 Scoreboard
--------------

The scoreboard continuously displayed the progress of all teams for the duration
of the competition, sorted by highest score and updating only seconds behind the
current state of the Master Server.

For each team, the scoreboard displayed its score for each challenge and, where
applicable, also displayed status on various phases of a specific challenge. It
also clearly indicated which challenge(s) were remaining for the team.

> **Implementation Note:** There need not be dedicated columns for status of
> the phases of a challenge. Different icons could be used to depict progress
> within a challenge, such as icons representing different percentages of a pie
> chart. 


2.8 Mobile Scoreboard
---------------------

The mobile scoreboard continuously displayed the progress of the team signed-in.
Sign-in consisted of at least providing the team ID.

The mobile scoreboard showed all the same information as the scoreboard, but
only for a single team whereas the scoreboard showed the information for all
teams.


2.9 Training Mode
-----------------

The Irresolutes wanted to take advantage of a public-facing Internet-connected
Master Server to exercise their BRATA during development.

They performed the same steps as listed under the **Entry Qualification** section
with the following difference:

* Any PC's web browser could be used as the qualification kiosk. The Irresolutes
  were provided with the URLs for the primary and secondary test Master Servers.
* They could re-run, stop, or abort at any time; there was no need to run and
  pass each and every test.


2.10 Standalone Mode
-------------------

The Worry Warts were excited when their school received a standalone station for
a week for testing. It looked a little rough, but everything they needed for
test was still here.

They followed the instructions provided to power up the station, and observed
using a wi-fi phone that it was up when the expected SSID was broadcasting.

The Warts connected to the wi-fi network and entered the security settings
provided in the instructions, and were thrilled when their phone connected to
the device.

Using the QR codes provided with the instructions, they were ready to begin
testing their BRATA application.


2.10.1 Launch
-------------

Since there is no dedicated station for this challenge, the Worry Warts were able
to do everything they needed for this while working with the Unlock standalone
station they received.

When they received the Return to Earth standalone station, they were able to
continue additional cases for this challenge with it as well.


2.10.2 Docking
--------------

Since there is no dedicated station for this challenge, the Worry Warts were able
to do everything they needed for this while working with the Unlock standalone
station they received.

When they received the Return to Earth standalone station, they were able to
continue additional cases for this challenge with it as well.


2.10.3 Unlock
-------------

The Worry Warts received a station with a microphone cable and light sensor.
The instructions and QR codes provided gave them all they needed to exercise the
Launch, Docking, and Unlock challenges from the convenience of their classroom.


2.10.4 Return to Earth
----------------------

The Worry Warts received a station with a microphone cable and light sensor.
The instructions and QR codes provided gave them all they needed to exercise the
Launch, Docking, and RTE challenges from the convenience of their classroom.


3.0 Non Goals
============

This version will **not** support the following features:

* Queue management
* TODO

TODO
--------------------------------------------------------------------------------


4.0 Sequences
=============

Specific sequences are provided alongside each scenario described above.


5.0 Screen-by-Screen Specification
=================================

Reference the TODO [Mike's spec] for the screen-by-screen specification.
