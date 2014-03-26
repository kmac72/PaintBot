/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbot;

import java.awt.Color;
import java.util.Vector;
import java.net.*;
import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JOptionPane;
/**
 *
 * @author Brian
 */
public class Network {
    
    boolean master;
    String ip;   
    Slave slave;
    ExecutorService clientProcessingPool;
    String sendLine;
    public int PORT_NUM = 4444;
      
    /**
     * 
     * @param m - if instance should be master or slave
     * @param i - IP address if slave choice given
     */
    public Network(boolean m, String i){
        master = m;
        ip = i;
        
        if(m)
            StartServer();
        else
            StartSlave();
    }
    
    /**
     * Create threads for client connections
     */
    public void StartServer(){
        clientProcessingPool = Executors.newFixedThreadPool(10);
        
        Runnable serverTask = new Runnable(){
            @Override
            public void run(){
                try{
                    ServerSocket serverSocket = new ServerSocket(PORT_NUM);
                    
                    while(true){
                        Socket clientSocket = serverSocket.accept();
                        clientProcessingPool.submit(new ClientTask(clientSocket));
                    }
                }
                catch (IOException e){
                    System.err.println("Unable to process client request");
                }
            }
        
        };
        Thread serverThread = new Thread(serverTask);
        serverThread.start();
    }
    
    /**
     * Start slave socket and interface
     */
    public void StartSlave(){
        
        slave = new Slave();
        slave.setVisible(true);
        
        Runnable slaveTask = new Runnable(){
            @Override
            public void run(){
                try{
                    //initialize client side
                    String inputline;
                    Socket pbSocket = new Socket(ip, PORT_NUM);
                    BufferedReader in = new BufferedReader(new InputStreamReader(pbSocket.getInputStream()));


                    //send input string to decode
                    while((inputline = in.readLine()) != null) {
                        System.out.println(inputline);
                        UpdateSlave(inputline);
                    }
                }
                catch (IOException e) {
                    System.out.println("Accept failed on port: " + PORT_NUM);
                    JOptionPane.showMessageDialog(null,"Cannot connect to Master. Closing program.");
                    System.exit(-1);
                }
            }
        };
        
        Thread slaveThread = new Thread(slaveTask);
        slaveThread.start();
    }
    /**
     * Handle sending data to clients
     */
    private class ClientTask implements Runnable{
        private final Socket clientSocket;
        
        private ClientTask(Socket clientSocket){
            this.clientSocket = clientSocket;
        }
        
        @Override
        public void run(){
            System.out.println("Got a connection");
            try{
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                String oldline = sendLine;
                while(true){
                    if(oldline != sendLine)
                        out.println(sendLine);
                        oldline = sendLine;
                }
            }
            catch(IOException e){
                System.out.println("Connection Terminated");
            }
        }
    }
    
    /**
     * Update from master, send to clients
     * @param xpoints - x coords of axis
     * @param ypoints - y coords of axis
     * @param paintdots - coords of painted dots
     * @param color - color for painted dots
     */
    public void MasterUpdate(double[] xpoints, double[] ypoints, Vector<Double> paintdots, Vector<Color> color){
        
        //send data to clients
        String outline = new String();
        for(int i=0; i<xpoints.length; ++i) {
            outline = outline + (String.valueOf(xpoints[i]) + "$");
        }
        for(int i=0; i<ypoints.length; ++i) {
            outline = outline + (String.valueOf(ypoints[i]) + "$"); 
        }
        for(int i=0; i<paintdots.size(); ++i) {
            outline = outline + (String.valueOf(paintdots.get(i)) + "$");
        }
        sendLine = outline;
    }
    
    /**
     * Update slave frame with coords, paint dots, and colors
     */
    private void UpdateSlave(String inputline){
           
        if(inputline.equals("initialize"))
            return;
        
        double[] xpoints;
        xpoints = new double[4];
        double[] ypoints;
        ypoints = new double[4];
        
        Vector<Double> paintdots = new Vector();
        Vector<Color> color = new Vector();
        
        if(inputline.equals("")) {
            System.out.println("EMPTY INPUT");
            return;
        }
        
        inputline = inputline.substring(0, inputline.length()-1);
        String[] data = inputline.split("\\$");
        
        for(int i=0; i<4; ++i) {
            xpoints[i] = Double.valueOf(data[i]);
        }
        for(int i=0; i<4; ++i) {
            ypoints[i] = Double.valueOf(data[i+4]);
        }
        for(int i=0; i<(data.length-8); ++i) {
            paintdots.add(Double.valueOf(data[i+8]));
        }
        color.add(Color.black);
        
        slave.Update(xpoints, ypoints, paintdots, color);
    }
}
