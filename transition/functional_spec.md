Overview
========

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


Scenarios
=========


Registration
------------

The members of Team Awesome Aardvark (or AA) arrived at the HSDC competition.
Upon arrival, they were presented with a **team card** that had QR code printed
along with the following information:

* Team name: Awesome Aardvark
* Team number: 97531

Team AA was asked not to share their team card with anyone, as the five-digit
team number is unique to their team and is used to associate them with all
activity, including associating them with their scoring.

> **Technical Note:** Assuming less than 200 teams, the team number was
> generated to be sufficiently different from all other team numbers in use
> in order to reduce the likelihood of a team inadvertently entering another
> team's number.

Harry started to pull out his Samsung Galaxy S6, but Sally thought here iPhone 6
Plus was the best thing since sliced bread, so she took the team card from Harry,
launched her BRATA application, entered the **Registration** tool, scanned the QR
code on the team card, and began entering the team information when prompted.
_(E1)_

Harry just rolled his eyes and waited for Sally's battery to drain.

Once Sally entered the case-insensitive team name and team number, she was
greeted with a welcome message confirming her team had completed the registration
and may begin the challenge when instructed. _(A1)_

TODO: Sequence diagram


### A1. Alternate Clients

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

Sally just sat and sulked thinking about her inability to check Snapchat for the
remainder of the day.

TODO: Sequence diagram


### E1. Error Entering Registration Information

Sally carelessly tapped meaningless digits for her team number thinking her
iPhone's auto-correct can and should read her mind.

Since Sally entered the wrong team number, her BRATA application responded that
her registration failed.

TODO: Sequence diagram


Launch
------

At long last, it was time to begin the challenges! After waiting in line for
what seemed like an eternity waiting in line, the Three Bits were escorted
outside to survey and mark the lasers and launch location.

Joel was looking forward to touching the neat-looking Raspberry Pi stations,
so he was disappointed when he learned this challenge had no station with it.

Joel and his team were escorted first to the welcome marker for the challenge,
which displayed a QR code for them to scan. Joel scanned the QR code, and
breathed a sigh of relief when his phone successfully displayed the Master
Server's properly-deciphered response message. _(E2)_

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
response after scanning the fourth QR code. _(A2, E2)_

> **Note:** Scanning the final correct marker also stopped the clock for the
> team.

After completing the challenge, the team was escorted back inside to continue
with the remaining challenges.

TODO: Sequence diagram


### A2. Incorrect Point

As Joel feared, his latest changes did not fix the location problem. As the Bits
scanned the marker they believed was correct, their BRATA reported a message back
stating their selection was incorrect. So much for getting a perfect score.

At least Joel didn't feel too bad. He knew they would lose points for each incorrect selection, but at least they could still continue trying for this
challenge without worrying about losing the round after a fixed number of tries.

TODO: Sequence diagram


### E2. Application Crash

Joel's worst fear was realized when he saw his BRATA application crash after
scanning the first QR code. The Bits thought it might just be a fluke, so they
launched the application again on the same phone.

Since the Bits chose to persisted the team information in their BRATA, they did
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

TODO: Sequence diagram


Docking
-------

The Shuttle Pilots were ready for this challenge. They tested, rehearsed, and
practiced for weeks to get through the competition and were sure they were
going to get through everything easily.

When it was their turn to begin the Docking challenge, they noticed there were
several other teams' members measuring different lengths of tape on the floor,
each having a different identifying tape number.

They began by scanning the welcome QR code for the challenge. Their BRATA
responded by giving them instructions to measure one of the tape lengths on the
floor that ranged from 5-20 meters. The instructions specified exactly which
tape to measure by providing and identification number.

They knew their time started, so they quickly moved to measure the tape using
their BRATA tools.

Once they completed their measurement, they scanned the next QR code to submit
their measurement. Their BRATA responded providing three data:

* fuel allocation (kg)
* fore thruster impulse rate (m/s<sup>2</sup>)
* aft thruster impulse (m/s<sup>2</sup>)

The Pilots proceeded to use their tools to compute the correct answer. _(A3)_

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
that the maneuver completed successfully, just as the Pilots predicted. _(A4)_

> **TODO:** Since we have had difficulty with unsolicited messages from the
> Master Server to BRATA, should we work around it this time by taking advantage
> of the mobile scoreboard? (See below.)

> **TODO:** Need to decide whether to display the simulation on a screen
> attached to the station, or display on the team's phone. (I believe the
> current consensus is on the screen.

> **Technical Note:** Four simulations will be displayed--one for each of four
> stations--on a single screen divided into four regions in a 2x2 layout. (TODO
> four regions in a 2x2 layout, or six regions in a 2x3 layout?)

TODO [Proposed] During the simulation, the Shuttle Pilots monitored the docking
status on the Mobile Scoreboard. As the simulation completed on the display, the
Mobile Scoreboard reported that the maneuver completed successfully, just as the
Pilots predicted. _(A4)_

TODO: Sequence diagram


### A3. Incorrect Measurement

The Shuttle Pilots scanned the QR code to submit their measurement, which was
incorrect. The purpose of this submission was to complete this portion of the
activity.

Even though the measurement was incorrect, the Pilots' BRATA responded providing
the same three data and waiting for the Pilots to submit their final three
values the same way as the measurement being correct.

TODO: Sequence diagram


### A4. Incorrect Response

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

TODO: Sequence diagram


Unlock
------

TODO


Return to Earth
---------------

TODO

