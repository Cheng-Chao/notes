解决 pppd : EAP: unknown authentication type 26; Naking (2016-05-22 20:31:31)转载▼

标签： ppp ms-chapv2 eapunknownauthentic	分类： Linux

解决 pppd : EAP: unknown authentication type 26; Naking

Linux 下尝试连接 Windows服务器 pptp sstp的时候

报下面的错误

May 21 17:55:33 ip-172-31-7-56 pppd[10655]: EAP: unknown authentication type 26; Naking

May 21 17:55:33 ip-172-31-7-56 pppd[10655]: EAP: peer reports authentication failure

这是由于Windows不允许客户端 一个一个协议的去试，

只允许MS-CHAP[v2] ，如果客户端用其他认证方式，就会断开连接。

解决方法

      vi /etc/ppp/options

      refuse-pap
      refuse-eap
      refuse-chap
      refuse-mschap
      require-mppe

这样就可以以MS-CHAP v2连接了

==转=====================
MPPE required, but MS-CHAP[v2] auth not performed.
http://pptpclient.sourceforge.net/howto-diagnosis.phtml#mppe_bmanp

enable MSCHAP and MPPE for VPN connection
http://askubuntu.com/questions/411710/enable-mschap-and-mppe-for-vpn-connection

MS-CHAP[v2] auth, Microsoft VPN client setup with pptpclient
https://bbs.archlinux.org/viewtopic.php?id=120781

Connecting to a Windows PPTP VPN from Linux (a problem solved)
http://domwatson.codes/2015/04/connecting-to-windows-pptp-vpn-from-linux.html
