# Introduction #

Ellery's configuration instructions.  (This is a summary.  The full original instructions are below.)


# Prepare SD Card #

Need an 8 GB SD card.

Use Win32DiskImager (Windows) or dd (Linux) to write the image onto the SD card.

# Configuration #

hostname [from cts06 to whatever](change.md):
> /etc/hosts
> /etc/hostname
> /etc/hostapd/hostapd.conf
> (check /etc/network/interfaces too)

Host name should be:
> cts##
> hmb##
> cpa##

/etc/init/brata\_station.conf:
> localhost:80 -> [$MS\_IP\_ADDR]:80

[maybe](maybe.md) set wifi channel number--not needed for community mode

[maybe](maybe.md) to allow future repository updates:

> $ cd /opt/designchallenge2015
> $ rm -rf brata.station.old
> $ mv brata.station brata.station.old
> $ git clone http://...



---

## Last-minute changes: ##
The night before competition, the WiFi in the competition area was unreliable.
The main symptom was that stations would go autistic for a period of time, or
gradually degrade in their network response time.  So we switched to a hard-wired
network, and the problems went away.  It was never determined whether the problem
was poor communication with the WiFi access point or some problem with the network stack on the Raspberry Pi's.  Some of the system images did not have the special manufacturer's build of the Realtek wifi dongle driver, and some did.


These changes were made at the last minute:

/etc/host{s,name}
connection.py - change wlan0 to eth0
/etc/init/brata\_station - change MS to 192.168.1.1
> - HMB - redirect stdout to /dev/null, stderr to stdout
/etc/networking/interfaces - change to static IP address


iface eth0 inet static
> address 192.168.1.xxx
> netmask 255.255.255.0
> > broadcast 192.168.1.255

remove wifi dongle


---

# Ellery's Original Instructions #
<pre>
Instructions for putting a system image onto an SD card:<br>
<br>
The system images are stored in .img files. Each image is for an 8 GB<br>
SD card. I have also included the Win32DiskImager tool that can be used<br>
in Windows to copy the image onto the card. I believe you can also use<br>
Linux dd to copy the image to the card, but I have not tried it.<br>
<br>
<br>
Steps:<br>
Unpack the .img.rar archive with WinRAR or unrar to get the .img file.<br>
Install and run Win32DiskImager.<br>
Specify the .img file.<br>
Choose the SD card device.  Be careful to get the right drive letter!!<br>
Click Write to write the image to the device.<br>
<br>
Once the card is copied, you need to edit a small number of files to uniquify<br>
(is that a word?) the station.  Mostly you have to set the hostname, and the<br>
WiFi channel number.  The station type is determined from the hostname.  If you<br>
call the station hmb01, it will come up as an HMB station.  I think by default<br>
it comes up as cts01.<br>
<br>
See the specific instructions (below) for the image you are cloning.<br>
<br>
<br>
----------------------------------------------------------------------<br>
Steps to configure Access Point master system image<br>
standalone_master_school_ready_cts_2015-02-06_2.img:<br>
<br>
This image can be configured to run as a CPA, CTS, or HMB station, along<br>
with a colocated MasterServer.  This configuration is intended for standalone<br>
use for testing Brata software running on a client device.<br>
<br>
The WiFi hotspot SSID is also the same as the hostname.  With this configuration,<br>
the Pi is configured as a WiFi hotspot in infrastructure mode, and will bridge<br>
the WiFi traffic to the ethernet network if it is connected.  The Pi will get an<br>
address of 192.168.1.1 on the WiFi network, so you can connect your laptop to<br>
the hotspot (cts01 by default until you configure it) and connect with ssh:<br>
<br>
> ssh pi@192.168.1.1<br>
<br>
Configuration steps:<br>
<br>
set hostname:<br>
/etc/hostapd/hostapd.conf (also change channel, see below)<br>
/etc/hosts<br>
/etc/hostname<br>
(check /etc/network/interfaces, too)<br>
<br>
Hostname should be (where ## is a 2-digit integer):<br>
cts##<br>
cpa##<br>
hmb##<br>
(ms##  not used in this configuration)<br>
<br>
set wifi channel in /etc/hostapd/hostapd.conf and/or /etc/network/interfaces:<br>
cpa: channel 1<br>
cts: channel 2<br>
hmb: channel 3<br>
(ms : channel 9  not used in this configuration)<br>
<br>
Pi configured only as a MS should not run the brata.station software:<br>
The brata.station software is launched on boot-up by the file /etc/init/brata_station.conf<br>
(For MS, remove it or rename it to brata_station.conf.x)<br>
<br>
/etc/init/brata_station.conf<br>
To avoid a race condition, the brata_station.conf script waits for the Apache server before<br>
launching the station application.  This is so the Apache server is ready to receive<br>
the station's join message.<br>
/etc/init/brata_hostapd.conf<br>
This script launches the hostapd daemon to provide wireless access point behavior.<br>
<br>
Remember to connect to the MS and Reset Database to populate it.<br>
First time with no data<br>
Second time with long data<br>
<br>
If you want to update the brata.station or brata.masterserver<br>
(in /opt/designchallenge2015), you should initially delete or rename the existing<br>
version, then git clone the new version, like this:<br>
<br>
> cd /opt/designchallenge2015<br>
> rm -rf brata.station.old<br>
> mv brata.station brata.station.old<br>
> git clone <pathname or url of repository><br>
<br>
You should clone the repository (rather than just copy it) so your clone will get<br>
a unique ID, in case you want to push any changes later.  Mods from different<br>
repositories with the same ID could confuse Git. Having said that, it can be tricky<br>
to get the repository onto the Pi if you are not hardwired to an Internet network.<br>
If you cannot conveniently connect the Pi to the Internet, you can clone the<br>
repository onto a USB stick on your laptop, then clone the repository from the<br>
USB stick plugged into the Pi onto the SD card.<br>
<br>
<br>
----------------------------------------------------------------------<br>
Steps to configure MS01 image with normal subnet networking and static IP<br>
HSDCnet_ms_master_2015-02-18.img:<br>
<br>
This image connects to the HSDCnet with a static IP address of 172.27.164.9,<br>
and is intended to be the MasterServer used for the live competition.<br>
<br>
The Pi will get an address of 172.27.164.9 on the WiFi network, so you can connect<br>
to the Pi over WiFi on the HSDCnet network with ssh like this:<br>
<br>
> ssh pi@172.27.164.9<br>
<br>
If you connect to the Ethernet port with a cable, you should give your network interface an<br>
address of 192.168.1.2.  You can ssh over the Ethernet interface like this:<br>
<br>
> ssh pi@192.168.1.1<br>
<br>
wlan0 connects to SSID: HSDCnet<br>
wlan0 static IP address: 172.27.164.9<br>
eth0 static IP address: 192.168.1.1<br>
hostname:  ms01<br>
<br>
This configuration does not run:<br>
hostapd<br>
dhcpd (isc-dhcp-server)<br>
brata.station<br>
<br>
Hostname is already set to ms01 in:<br>
/etc/hosts<br>
/etc/hostname<br>
<br>
Hostname should be (where ## is a 2-digit integer):<br>
ms##<br>
<br>
Static IP address is already set in:<br>
/etc/hosts<br>
/etc/network/interfaces<br>
<br>
SSID and password for HSDCnet are already set in:<br>
/etc/network/interfaces<br>
<br>
Quirky networking behavior:<br>
The configuration appears not to connect to the WiFi network until something wakes<br>
up the wlan0 interface.  wlan0 is advertised as being UP, but pings to 172.27.164.9<br>
from other machines will fail.  However, after a ping from the Pi to 172.27.164.1,<br>
then the address is pingable from outside.  I don't know why this happens, but have<br>
implemented the following workaround:<br>
<br>
I added a "post-up ping 172.27.164.1" to the interfaces file.  This runs a ping command<br>
after the interface comes up, and appears to have the desired result of making the<br>
interface accessible.  Perhaps it is a routing issue.<br>
<br>
Pi configured only as a MS should not run the brata.station software:<br>
(The brata.station software is launched on boot-up by the file /etc/init/brata_station.conf)<br>
<br>
Startup services deactivated:<br>
/etc/init/brata_station.conf is renamed to /etc/init/brata_station.conf.x<br>
/etc/init/brata_hostapd.conf is renamed to /etc/init/brata_hostapd.conf.x<br>
DHCP server turned off with:  sudo update-rc.d isc-dhcp-server disable<br>
<br>
To turn this configuration into a brata.station for the competition, you would need to:<br>
update the hostname in:<br>
/etc/hosts<br>
/etc/hostname<br>
rename /etc/init/brata_station.conf.x to /etc/init/brata_station.conf<br>
change the MasterServer IP address in /etc/init/brata_station.conf<br>
so the station can connect to the competition MS<br>
<br>
If you need DHCP for some reason re-enable with:<br>
sudo update-rc.d isc-dhcp-server enable<br>
sudo reboot<br>
<br>
If you want to update the brata.station or brata.masterserver<br>
(in /opt/designchallenge2015), you should initially delete or rename the existing<br>
version, then git clone the new version, like this:<br>
<br>
> cd /opt/designchallenge2015<br>
> rm -rf brata.station.old<br>
> mv brata.station brata.station.old<br>
> git clone <pathname or url of repository><br>
<br>
You should clone the repository (rather than just copy it) so your clone will get<br>
a unique ID, in case you want to push any changes later.  Mods from different<br>
repositories with the same ID could confuse Git. Having said that, it can be tricky<br>
to get the repository onto the Pi if you are not hardwired to an Internet network.<br>
If you cannot conveniently connect the Pi to the Internet, you can clone the<br>
repository onto a USB stick on your laptop, then clone the repository from the<br>
USB stick plugged into the Pi onto the SD card.<br>
</pre>