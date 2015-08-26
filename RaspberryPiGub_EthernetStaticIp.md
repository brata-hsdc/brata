NOTE: This is an auto-generated document. DO NOT EDIT!

#summary The ground-up build procedure for setting up each Raspbian Pi
#labels Phase-Deploy

# Introduction #

This documents the ground-up build (GUB) procedure for setting up a Raspberry Pi device in one or more of the following configurations:
  * Master Server (MS)
  * Challenge station
    * HMB challenge station
    * CTS challenge station

Each device will be configured to run headless from the start, meaning no keyboard/video/mouse is needed to interact with the device even during the build unless desired.

The steps below call out specific configurations at certain places during the steps. Only include the steps in these sections if configuring your device for those configurations.

Multiple simultaneous configurations are generally allowed. For example, a single Raspberry Pi device can be configured to host both a Master Server instance and a challenge station instance.

Certain configurations cannot coexist on the same device. These configuration conflicts are noted below.

TODO: Also: Raspberry Pi ad-hoc networking wi-fi access point
EW-7811Un: http://spin.atomicobject.com/2013/04/22/raspberry-pi-wireless-communication


# Known Conflicts #

  * **HMB challenge station** and **CTS challenge station** cannot coexist on the same device due to hardware limitations. The HMB uses a Pibrella whereas the CTS uses a TODO LCD+keypad.


# Hardware Configuration #

  * [Raspberry Pi Model B](http://www.raspberrypi.org/products/model-b/)




# Software Configuration #

  * Raspbian 7.6


# Gather Master Server Configuration Settings #

<pre>
MySQL Root Password: ____________________ (e.g. raspberry)<br>
$MYSQL_ROOT_PASSWORD<br>
<br>
Database Name: ____________________ (e.g. m)<br>
$DB_NAME<br>
</pre>


# Gather Laptop Network Settings #

For development ease, this document currently assumes that the device under development will be directly connected to a laptop's Ethernet port, and then the laptop will act as a bridge to provide the device with network connectivity.

(NOTE: Deprecate appropriate portions of this document when the devices are outfitted with wi-fi adapters.)

<pre>
Wi-Fi IP Address: ____________________ (e.g. 192.168.1.11)<br>
$WIFI_IP_ADDR<br>
<br>
Current Wired NIC Settings: [ ] DHCP  [ ] Static IP Address<br>
<br>
Desired Wired NIC Settings: [ ] DHCP  [x] Static IP Address<br>
<br>
Wired IP Address: ____________________ (e.g. 192.168.0.1)<br>
$NIC_IP_ADDR<br>
<br>
Wired Network Mask: ____________________ (e.g. 255.255.255.0)<br>
$PI_NETMASK<br>
<br>
Wired Network: ____________________ (e.g. 192.168.0.0)<br>
$PI_NETWORK<br>
<br>
Broadcast Address: ____________________ (e.g. 192.168.0.255)<br>
$PI_BROADCAST<br>
<br>
Desired Device IP Address: ____________________ (e.g. 192.168.0.2)<br>
$PI_IP_ADDR<br>
<br>
Log Server Host Name/IP Address: ____________________ (e.g. 192.168.0.201)<br>
$LOG_SERVER<br>
</pre>



# Set Laptop Network Settings #

Edit the laptop's network settings and modify the wired NIC settings to the values defined above.


# Install Raspbian #

1. Go to http://www.raspberrypi.org/downloads.

2. Click Download Zip for the Raspbian (Debian Wheezy) link directly--not NOOBS.

3. Save the 788 MB zip file.

4. When downloaded, verify the SHA1 checksum.

5. After verification, unzip the Zip file to obtain the raw SD card image.

6. Insert the SD card and follow OS steps to load the SD card image onto the media.

Under Linux:

6a. Insert the SD card and determine its device.

<pre>
Device: _________________ (e.g. /dev/sdb)<br>
$DEVICE<br>
</pre>

6b. Unmount all partitions automatically mounted on the SD card.

6c. Use dd to write the raw image onto the SD card.

**CAUTION:** Specifying the wrong device in the following command can overwrite the hard drive of the host device, i.e. you can wipe out your laptop if you're not careful!

<pre>
$ sudo dd if=/path/to/2014-06-20-wheezy-raspbian.img of=$DEVICE bs=4M<br>
$ sudo sync<br>
</pre>

7. Mount the newly-written SD card to get to the Raspbian file system from the laptop, and go to the root partition.

On Linux, this happens automatically these days:

<pre>
$ cd /media/user/12345678-9abc-def0-1234-56789abcdef0<br>
</pre>

8. Edit the interfaces file to set the device to the desired fixed IP address:

<pre>
$ cd etc/network<br>
$ sudo cp interfaces interfaces.bak<br>
$ sudo gedit interfaces<br>
</pre>


8a. Comment out the eth0/DHCP line and replace with the following, noting to replace "$PI\_IP\_ADDR", "$PI\_NETMASK", and the others with their actual values:

<pre>
#iface eth0 inet dhcp<br>
iface eth0 inet static<br>
address $PI_IP_ADDR<br>
netmask $PI_NETMASK<br>
network $PI_NETWORK<br>
broadcast $PI_BROADCAST<br>
gateway $WIFI_IP_ADDR<br>
</pre>

An example of a modified /etc/network/interfaces file:

<pre>
#iface eth0 inet dhcp<br>
iface eth0 inet static<br>
address 192.168.0.2<br>
netmask 255.255.255.0<br>
network 192.168.0.0<br>
broadcast 192.168.98.255<br>
gateway 192.168.0.1<br>
</pre>




9. Save and exit. Don't unmount and eject the SD card yet; additional configuration still needs to be done.

<pre>
$ cd ../..<br>
</pre>


# Additional Configuration #


3. If this station is not the central log server, then set up rsyslog to redirect logs to the central log server for persistence.

<pre>
$ sudo gedit etc/rsyslog.conf<br>
</pre>

4. Find the following area of the file and add the bold text:

<pre>
###############<br>
#### RULES ####<br>
###############<br>
*.*                             @$LOG_SERVER<br>
#<br>
# First some standard log files.  Log by facility.<br>
#<br>
</pre>

Save and exit.

5. For all devices except the central log server, move frequently-written directories to RAM if desired to extend the life of the SD card. (Reference http://www.zdnet.com/raspberry-pi-extending-the-life-of-the-sd-card-7000025556/)

Note that this moves logs to RAM, meaning log files will not persist across reboots. This means any relevant logs must be moved off of the device prior to shutdown/reboot, or the device should be configured as described above to forward logs to a central log server for persistence.

<pre>
$ sudo gedit etc/fstab<br>
</pre>

6. Append the following:

<pre>
#tmpfs /var/log tmpfs defaults,noatime,nodev,nosuid,mode=0755,size=50M 0 0<br>
tmpfs    /tmp    tmpfs    defaults,noatime,nosuid,size=100m    0 0<br>
tmpfs    /var/tmp    tmpfs    defaults,noatime,nosuid,size=30m    0 0<br>
tmpfs    /var/log    tmpfs    defaults,noatime,nosuid,mode=0755,size=100m    0 0<br>
tmpfs    /var/run    tmpfs    defaults,noatime,nosuid,mode=0755,size=2m    0 0<br>
tmpfs    /var/spool/mqueue    tmpfs    defaults,noatime,nosuid,mode=0700,gid=12,size=30m    0 0<br>
</pre>

Save and exit.

Create directories as needed:

<pre>
$ sudo mkdir -p var/spool/mqueue var/log/apache2<br>
</pre>

8. Unmount and eject the SD card.


# Boot Device #


3. Insert the SD card into the device and boot-up. Wait 30-60 seconds.


6. Log-in using the default Raspbian user name/password combination.

<pre>
localhost$ ssh pi@192.168.0.2<br>
Password: *********<br>
</pre>

7. Initial configuration: Run the configuration tool that normally runs when booting the first time from the console:

<pre>
$ sudo raspi-config<br>
</pre>

8. Select the following if desired:

  * Expand filesystem
  * Enable Boot to Desktop/Scratch
  * Desktop log in as user 'pi' at the graphical desktop


# Install Packages #

1. Upgrade packages to the latest available versions:

<pre>
$ sudo apt-get update<br>
$ sudo apt-get upgrade<br>
</pre>



5. Install additional packages if desired for development:

<pre>
$ sudo apt-get install python-mock xrdp<br>
</pre>

6. Install NTP client daemon:

<pre>
$ sudo apt-get install ntp<br>
</pre>






# Finishing Up #

Clean-up install archives if desired:

<pre>
$ sudo apt-get clean<br>
</pre>


# Bridge Set-Up #

Bridge the wireless and Ethernet connections on the laptop to give the device access to the Internet through a wi-fi capable laptop if a wi-fi adapter is not available for the device directly. On a Windows computer, this can be done by right-clicking the Wireless Network Connection and going to Properties, and on the Sharing tab, enable the checkbox to Allow other network users to connect through this computer's Internet connection.

This fixed the Local Area Connection IP address to $NIC\_IP\_ADDR.


# Remote Desktop Connection #

Thanks to the xrdp package optionally installed above, the developer can RDP from the laptop at $NIC\_IP\_ADDR to the device at $PI\_IP\_ADDR with a full GUI desktop available to him/her.


# Download Source Code #

For ease of development, a standard directory structure is assumed for development. In the case of the Station, there is no installation, so the steps above assume code from the Git repository was placed in a specific location.

1. Create directory with proper permissions:

<pre>
$ cd /opt<br>
$ sudo mkdir designchallenge2015<br>
$ sudo chown pi:pi designchallenge2015<br>
$ cd designchallenge2015<br>
</pre>

2. Download appropriate source code:

<pre>
$ git clone ....brata.masterserver<br>
$ git clone ....brata.station<br>
</pre>

Not all repositories are necessary for development; if desired, only download the code for the repository of interest.

3. Refer to the repositories' README files for further instructions.


TODO: Clean-up or move to the right document...

All I had last night was a Raspberry Pi Model B (not B+) with what I believe is LCD+Keypad Kit (http://www.adafruit.com/product/1109) installed on the GPIO pins plugged into a 1A Samsung cell phone wall adapter and networking available via Ethernet cable (no wi-fi adapter). No keyboard/mouse, but yes HDMI out going out to a monitor.

No additional hardware; no Pibrella. In fact, the Pibrella and this LCD keypad can't be used simultaneously since they both plug-in over the same GPIO pins.

Eventually when we run, there’s the runstation script in the bin folder that uses values from the runstation.conf file. Currently, the conf file is set up for the HMB station with the real hardware stubbed out so that we can develop other parts of the application on laptops and non-Raspbery Pi units or without the real hardware available, so to run CTS with the real hardware, you’ll need to edit your runstation.conf file and make the following changes:


  * Disable this line:
    * s.StationType = 'station.types.hmb'
  * Enable this line:
    * #s.StationType = 'station.types.cts'
  * Disable this line:
    * s.HardwareModuleName = 'station.console'
  * Enable this line:
    * #s.HardwareModuleName = 'station.hw'


FYI if you use station.console, you can run on anything without hardware—even on a laptop; all you’ll get are log messages in /var/log/syslog or /var/log/messages to see what’s going on, and you can use the keyboard keys I, J, K, M, and Enter to simulate the keypad buttons for CTS, but if you switch to station.hw, it’s going to try to use the real hardware defined in the hw.py file.
Currently the hw.py file supports the Pibrella stuff; I don’t think I’ve gotten around to making it support either/or or both.
So I believe the runstation script launches something in main.py, which sets things up and then starts running code in one of {hmb.py, cts.py, or cpa.py} depending on the configuration. The bulk of cts.py should be coded, so as you press I/J/K/M, you should see your combo changing in the log messages.

No extra hardware needed; just what I wrote above.
I’ve generally been running with four terminal windows open. The steps below are from memory, so they might need some tweaking to work:

  * Window 1
    * tail -f /var/log/messages
  * Window 2
    * cd /opt/wiremock
    * grep jar ../designchallenge2015/brata.station/wiremock/README.txt
    * Run the “java” command that gets printed out. This will simulate the Master Server receiving messages from the station.
  * Window 3
    * grep curl /opt/designchallenge2015/brata.station/bin/runstation.conf
    * The output should give you the various messages to which the station currently responds. I generally just copy/paste each message into this window, then hit the Up Arrow to repeat the message(s) I want to send as-needed.
  * Window 4
    * sudo /opt/designchallenge2015/brata.station/bin/runstation
    * This runs the application with possibly some output; between this and what’s in the logs, you should get a picture of what’s going on in the mind of the station.