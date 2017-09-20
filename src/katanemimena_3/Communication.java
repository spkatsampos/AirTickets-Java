package katanemimena_3;

import java.io.Serializable;


public class Communication implements Serializable{
private String day1;
private String month1;
private String day2;
private String month2;
private String from;
private String to;
private int num_seats;

private int num_flight;
private int price;
private String time;

public Communication(String day1,String month1,String day2,String month2,int num_seats,String from,String to){
this.day1=day1;
this.day2=day2;
this.month1=month1;
this.month2=month2;
this.num_seats=num_seats;
this.from=from;
this.to=to;

}

public void setday1(String d1){this.day1=d1;}
public String getday1(){return day1;}


public void setmonth1(String m1){this.month1=m1;}
public String getmonth1(){return month1;}

public void setday2(String d2){this.day2=d2;}
public String getday2(){return day2;}

public void setmonth2(String m2){this.month2=m2;}
public String getmonth2(){return month2;}

public void settime(String t){this.time=t;}
public String gettime(){return time;}


public void setfrom(String f){this.from=f;}
public String getfrom(){return from;}

public void setto(String t){this.from=t;}
public String getto(){return to;}

public void setnum_flight(int nf){this.num_flight=nf;}
public int getnum_flight(){return num_flight;}

public void setnum_seats(int ns){this.num_seats=ns;}
public int getnum_seats(){return num_seats;}

public void setprice(int p){this.price=p;}
public int getprice(){return price;}

}
