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
/**
 *
 * @author Brian
 */
public class Network {
    
    boolean master;
    String ip;   
    Slave slave;
    public ServerSocket serverSocket = null;
    public Socket clientSocket = null;
    public Socket pbSocket = null;
    public int PORT_NUM = 4444;
    public PrintWriter out;
    public BufferedReader in;
    
    
    
    /**
     * 
     * @param m - if instance should be master or slave
     * @param i - IP address if slave choice given
     */
    public Network(boolean m, String i){
        master = m;
        ip = i;

        //If Slave, run Slave interface
        if(!m){
            slave = new Slave();
            slave.setVisible(true);
            System.out.println("initializing slave interface");
        }
        
        //Setup sockets based on master or slave
        try {         
            if(m){
                
                System.out.println("Creating Server");
                //initialize server side
                serverSocket = new ServerSocket(PORT_NUM);
                clientSocket = serverSocket.accept();
                out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out.println("initialize");
                
            } else if(!m) {
                
                System.out.println("creating client");
                //initialize client side
                String inputline;
                pbSocket = new Socket(ip, PORT_NUM);
		in = new BufferedReader(new InputStreamReader(pbSocket.getInputStream()));
                
                //send input string to decode
                while((inputline = in.readLine()) != null) {
                    System.out.println(inputline);
                    UpdateSlave(inputline);
                }
            }

        } catch (IOException e) {
            System.out.println("Accept failed on port: " + PORT_NUM);
            System.exit(-1);
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
        System.out.println("Sending: " + outline);
        out.println(outline);          
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
