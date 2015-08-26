# Introduction #

This document serves as a user manual on how to use stations in standalone mode. Each station in standalone mode will have a Master Server (MS) installed and will be in one of the following configurations:
  * Crack the Safe (CTS)
  * Hypermutation Bomb (HMB)
  * Capture Professor Aardvark (CPA)

# Required Hardware/Software/Materials #

  * Standalone station hardware (provided)
    * Power cord
    * Wi-Fi dongle
    * Raspberry Pi Station
      * **HMB:**
        * 3 Energy Pulsator platforms
        * Hypermutation bomb (Optional)
      * **CTS:**
        * Adafruit LED screen interface (should be permanently attached to station)
        * Safe prop
      * **CPA:**
        * LED strip
        * "Laser" Detector
        * PWM board
        * Cable A and Cable B (for wiring boards)
  * Power outlet
  * Smart Phone running Android OS w/ Wi-Fi capability
  * Secret Agent Tool Application
  * QR Codes (provided)

# Setting Up the Station #

<p><b>HMB</b></p>
<p>To connect the Energy Pulsator platforms: Place wires in pin locations E, F, and G. The polarity does not matter for these connections.</p>
<p>To connect the bomb: Place the wires in pin location H. Here the polarity does matter and the wires will be labeled + and - accordingly. Use the following diagram to wire the station where <i>Pibrella</i> is the station:</p>
<p><img src='http://wiki.brata.googlecode.com/git/images/HMB%20Diagram.png' /></p>

<p><b>CPA</b></p>
<p>When setting up the CPA, connect the main components to the station using two main cables (cable A and cable B). Use the following diagram to wire the station where <i>Pibrella</i> is the station:</p>
<p><img src='http://wiki.brata.googlecode.com/git/images/CPA_Cable_Diagram%20-%202.png' /></p>

# Powering Up the Station #

<p>Plug in the station into a power outlet. The station will begin to power up. Note that you will have to give the station time to finish booting up for the web interface to come up. It is best to wait 3 minutes. The station will be ready when it broadcasts its SSID.</p>

# Connecting to the Station #

<p>When the station is up and running, it should broadcast an SSID unique to the station (ex. hmb01). Your phone should pick up this SSID, and you connect to it with your phone like any normal Wi-Fi hotspot. Go to your Wi-Fi menu, look for the SSID that matches the station name you are attempting to connect to (ex. hmb01), and select it (you may have to select connect/login).</p>

# Using the Station #

<p>The station will be ready to use after connecting. Scan the QR code to register, start the challenge, and submit your answers using your version of the Secret Agent Tool.</p>

# Register #
<p>Each school will be provided 2 team ID numbers to use when registering with the MS.</p>
<p><img src='http://wiki.brata.googlecode.com/git/images/StandAloneTeamIds.png' /></p>
<p>The even numbered team ID will be encoded, so that you may test that you can decode messages from the server.</p>
<p>The odd  numbered team ID will be unencoded, so that you may see the return message from the server. This is useful in case you need to connect to the server while unable to decode the server messages, or for debugging your decoding code.</p>
<p>Before testing with each individual station the team must scan the QR Code below and provide their team number to register.</p>
<p><img src='http://wiki.brata.googlecode.com/git/images/StandAloneRegister.png' /></p>


<p><b>FSL Standalone Usage</b></p>
<p>After connecting the phone to your mobile data carrier service scan the FSL start challenge QR code below.  Note based on your team ID the waypoints to scan for each of the following locations are provided below. </p>
<p>Each school is a mini course with a fixed way point each and lab except for Holy Trinity for this weeks open to all test sessions and will be a full course.  To use the Holy Trinity full course use one of the HT team ids or one of the following: 95284, 54166, 31778, 49968, 26008.<br>
Note only one team can use one of these test ids at a time or you will destroy each other's progress so work together to ensure only one team is using a particular test id at a time.</p>

For individual school short courses (see maps previously provided with location mappings):
<p><table>
<tr>
<blockquote><td>School</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>A1</td>
<td align='center'>B1</td>
<td align='center'>C1</td>
<td align='center'>L1</td>
</blockquote><blockquote></tr>
<tr>
<blockquote><td>Bayside</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fstart_challenge%2Ffsl01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FBSA1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FB1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FC1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FL1&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>School</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>A1</td>
<td align='center'>B1</td>
<td align='center'>C1</td>
<td align='center'>L1</td>
</blockquote></tr>
<tr>
<blockquote><td>Edgewood</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fstart_challenge%2Ffsl01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FEWA1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FB1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FC1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FL1&nonsense=ends-with.png' /></td>
</blockquote></tr></blockquote>

<tr>
<blockquote><td>School</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>A1</td>
<td align='center'>B1</td>
<td align='center'>C1</td>
<td align='center'>L1</td>
</blockquote><blockquote></tr>  <tr>
<blockquote><td>Melbourne</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fstart_challenge%2Ffsl01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FMA1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FB1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FC1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FL1&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>School</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>A1</td>
<td align='center'>B1</td>
<td align='center'>C1</td>
<td align='center'>L1</td>
</blockquote></tr>
<tr>
<blockquote><td>Palm Bay</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fstart_challenge%2Ffsl01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FPBA1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FB1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FC1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FL1&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>School</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>A1</td>
<td align='center'>B1</td>
<td align='center'>C1</td>
<td align='center'>L1</td>
</blockquote></tr>  <tr>
<blockquote><td>Titusville</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fstart_challenge%2Ffsl01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FTA1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FB1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FC1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FL1&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>School</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>A1</td>
<td align='center'>B1</td>
<td align='center'>C1</td>
<td align='center'>L1</td>
</blockquote></tr>
<tr>
<blockquote><td>West Shore</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fstart_challenge%2Ffsl01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FWSA1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FB1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FC1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FL1&nonsense=ends-with.png' /></td>
</blockquote></tr>
</table>
</p></blockquote>

For the Holy Trinity full course use:
<p><table>
<blockquote><tr>
<blockquote><td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'></td>
</blockquote></tr>
<tr>
<blockquote><td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fstart_challenge%2Ffsl01&nonsense=ends-with.png' /></td>
<td> </td>
</blockquote></tr>
<tr>
<blockquote><td align='center'>A1</td>
<td align='center'>A2</td>
<td align='center'>A3</td>
</blockquote></tr>
<tr>
<blockquote><td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FHTA1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FHTA2&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FHTA3&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td align='center'>B1</td>
<td align='center'>B2</td>
<td align='center'>B3</td>
</blockquote></tr>
<tr>
<blockquote><td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FB1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FB2&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FB3&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td align='center'>C1</td>
<td align='center'>C2</td>
<td align='center'>C3</td>
</blockquote></tr>
<tr>
<blockquote><td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FC1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FC2&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FC3&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td align='center'>L1</td>
<td align='center'>L2</td>
<td align='center'>L3</td>
</blockquote></tr>
<tr>
<blockquote><td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FL1&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FL2&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F162.206.18.32%3A80%2Fm%2Fbrata%2Fat_waypoint%2FL3&nonsense=ends-with.png' /></td>
</blockquote></tr>
</table>
</p></blockquote>

<p><b>CTS Standalone Usage</b></p>
<p>After connecting the phone to SSID cts##, and scanning the registration code you will need to scan the start challenge QR code for the corresponding station ID from the table below.  For convenience Register is provided as well so that a team working with a particular station can repeat tests quickly starting with the left most QR Code and working their way across for each step of the challenge.</p>
<p>After submitting the combo successfully or three failed attempts they will scan the final submit QR Code.</p>

<p><table>
<blockquote><tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CTS01</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcts01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcts01&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CTS02</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcts02&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcts02&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CTS03</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcts03&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcts03&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CTS04</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcts04&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcts04&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CTS05</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcts05&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcts05&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CTS06</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcts06&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcts06&nonsense=ends-with.png' /></td>
</blockquote></tr>
</table></p></blockquote>

<p><b>HMB Standalone Usage</b></p>
<p>After connecting the phone to SSID hmb##, and scanning the registration code you will need to scan the start challenge QR code for the corresponding station ID from the table below.  For convenience Register is provided as well so that a team working with a particular station can repeat tests quickly starting with the left most QR Code and working their way across for each step of the challenge.</p>
<p>After measuring and establishing the period teams submit their answer scanning the Submit QR Code.</p>

<p><table>
<blockquote><tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>HMB01</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fhmb01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fhmb01&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>HMB02</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fhmb02&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fhmb02&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>HMB03</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fhmb03&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fhmb03&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>HMB04</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fhmb04&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fhmb04&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>HMB05</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fhmb05&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fhmb05&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>HMB06</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fhmb06&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fhmb06&nonsense=ends-with.png' /></td>
</blockquote></tr>
</table></p></blockquote>



<p><b>CPA Standalone Usage</b></p>
<p>After connecting the phone to SSID cpa##, and scanning the registration code you will need to scan the Measure QR code.  For testing in standalone mode this only tests that you can successfully retrieve the direction of what lines of tape to measure that represent the fence and building distances.  Testing your ability to measure those distances is left up to you.  For the standalone station assume the distances are 80 ft for the fence and 20 ft for the building. Then scan the start challenge QR code for the corresponding station ID from the table below.  For convenience Register is provided as well so that a team working with a particular station can repeat tests quickly starting with the left most QR Code and working their way across for each step of the challenge.</p>
<p>After hitting PA or missing three times the Submit QR Code is scanned for the final result.</p>
<p><table>
<blockquote><tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Measure</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CPA01</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2FcpaMeasure%2Fcpa01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcpa01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcpa01&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Measure</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CPA02</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2FcpaMeasure%2Fcpa02&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcpa02&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcpa02&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Measure</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CPA03</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2FcpaMeasure%2Fcpa03&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcpa03&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcpa03&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Measure</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CPA04</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2FcpaMeasure%2Fcpa04&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcpa04&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcpa04&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Measure</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CPA05</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2FcpaMeasure%2Fcpa05&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcpa05&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcpa05&nonsense=ends-with.png' /></td>
</blockquote></tr>
<tr>
<blockquote><td>Station ID</td>
<td align='center'>Register</td>
<td align='center'>Measure</td>
<td align='center'>Start Challenge</td>
<td align='center'>Submit</td>
</blockquote></tr>
<tr>
<blockquote><td>CPA06</td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fregister%2Freg01&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2FcpaMeasure%2Fcpa06&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fstart_challenge%2Fcpa06&nonsense=ends-with.png' /></td>
<td><img src='http://zxing.org/w/chart?cht=qr&chs=350x350&chld=L&choe=UTF-8&chl=http%3A%2F%2F192.168.1.1%3A80%2Fm%2Fbrata%2Fsubmit%2Fcpa06&nonsense=ends-with.png' /></td>
</blockquote></tr>
</table></p></blockquote>

# Common Issues and "Gotchas" #

<p><b>Issues connecting to server</b></p>
<p>Make sure to move away from other Wi-Fi hotspots, or move other Wi-Fi hotspots such as other tethering smartphones away from the device. Real developer story: "We suspect the reason I couldn't connect to the HMB Pi on 2/1 was because my tethering smartphone was right next to the Pi; when it was moved to the other side of the room, the Pi connected to the Wi-Fi network without any trouble."</p>
<p>When you change from one station type to another station type, you have to switch to the new station's SSID.<br>
<p> <b>Note:</b> <i>During the real competition, you will <b>not</b> be connecting to SSIDs between stations. This is only used in the standalone setup.</i></p>